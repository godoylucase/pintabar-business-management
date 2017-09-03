package com.pintabar.businessmanagement.repository.custom;

import com.pintabar.businessmanagement.entity.MenuInstance;

import java.util.List;
import java.util.Optional;

/**
 * Created by lucasgodoy on 21/06/17.
 */
public interface CustomMenuInstanceRepository {

	List<MenuInstance> findAllMenuInstancesByBusinessUuid(String businessUuid, Boolean isDeleted);

	Optional<MenuInstance> findMenuInstanceByUuidAndBusinessUuid(String menuInstanceUuid, String businessUuid);
}
