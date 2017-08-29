package com.pintabar.businessmanagement.service;

import com.pintabar.businessmanagement.dto.MenuInstanceDTO;

import java.util.List;

/**
 * @author Lucas.Godoy on 29/08/17.
 */
public interface BusinessManagementService {

	List<MenuInstanceDTO> getMenuInstances(String businessUuid);

	List<MenuInstanceDTO> getMenuInstances(String businessUuid, Boolean isDeleted);

}
