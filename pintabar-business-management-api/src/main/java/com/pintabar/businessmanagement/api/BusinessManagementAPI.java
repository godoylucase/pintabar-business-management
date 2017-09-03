package com.pintabar.businessmanagement.api;

import com.pintabar.commons.exceptions.general.DataNotFoundException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Lucas.Godoy on 27/08/17.
 */
@Path("/business")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface BusinessManagementAPI {

	@GET
	@Path("/{businessUuid}/menuInstance")
	Response getMenuInstances(
			@PathParam("businessUuid") String businessUuid,
			@DefaultValue("false") @QueryParam("isDeleted") boolean isDeleted);

	@GET
	@Path("/{businessUuid}/menuInstance/{menuInstanceUuid}/validate")
	Response validateMenuInstance(
			@PathParam("businessUuid") String businessUuid,
			@PathParam("menuInstanceUuid") String menuInstanceUuid) throws DataNotFoundException;

	@GET
	@Path("/{businessUuid}/menuItemInstance/{menuItemInstanceUuid}/validate")
	Response validateMenuItemInstance(
			@PathParam("businessUuid") String businessUuid,
			@PathParam("menuItemInstanceUuid") String menuItemInstanceUuid) throws DataNotFoundException;

	@GET
	@Path("/{businessUuid}/tableUnit/{tableUnitUuid}/validate")
	Response validateTableUnit(
			@PathParam("businessUuid") String businessUuid,
			@PathParam("tableUnitUuid") String tableUnitUuid) throws DataNotFoundException;

}
