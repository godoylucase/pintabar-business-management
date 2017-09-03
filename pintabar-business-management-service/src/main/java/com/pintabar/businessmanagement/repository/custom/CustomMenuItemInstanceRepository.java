package com.pintabar.businessmanagement.repository.custom;

import com.pintabar.businessmanagement.entity.MenuItemInstance;

import java.util.Optional;

/**
 * @author Lucas.Godoy on 3/09/17.
 */
public interface CustomMenuItemInstanceRepository {

	Optional<MenuItemInstance> findMenuItemInstanceByUuidAndBusinessUuid(String menuItemInstanceUuid, String businessUuid);

}
