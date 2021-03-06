package com.pintabar.businessmanagement.service;

import com.pintabar.businessmanagement.dto.MenuInstanceDTO;
import com.pintabar.commons.exceptions.business.InvalidBusinessException;
import com.pintabar.commons.exceptions.general.DataNotFoundException;

import java.util.List;

/**
 * @author Lucas.Godoy on 29/08/17.
 */
public interface BusinessManagementService {

	List<MenuInstanceDTO> getMenuInstances(String businessUuid);

	List<MenuInstanceDTO> getMenuInstances(String businessUuid, Boolean isDeleted);

	Boolean validateTableUnit(String businessUuid, String tableUnitUuid) throws DataNotFoundException;

	Boolean validateMenuInstance(String businessUuid, String menuInstanceUuid) throws DataNotFoundException;

	Boolean validateMenuItemInstance(String businessUuid, String menuItemInstanceUuid) throws DataNotFoundException;
}
