package com.pintabar.businessmanagement.app.api.impl;

import com.pintabar.businessmanagement.api.BusinessManagementAPI;
import com.pintabar.businessmanagement.service.BusinessManagementService;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * @author Lucas.Godoy on 29/08/17.
 */
@Component
public class BusinessManagementAPIImpl implements BusinessManagementAPI {

	private final BusinessManagementService businessManagementService;

	public BusinessManagementAPIImpl(BusinessManagementService businessManagementService) {
		this.businessManagementService = businessManagementService;
	}

	@Override
	public Response getMenuInstances(String businessUuid, boolean isDeleted) {
		return Response.ok(businessManagementService.getMenuInstances(businessUuid, isDeleted)).build();
	}

}
