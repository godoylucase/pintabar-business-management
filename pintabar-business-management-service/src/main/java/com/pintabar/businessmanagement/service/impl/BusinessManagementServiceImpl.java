package com.pintabar.businessmanagement.service.impl;

import com.google.common.base.Preconditions;
import com.pintabar.businessmanagement.dto.MenuInstanceDTO;
import com.pintabar.businessmanagement.dtomapper.MenuInstanceDTOMapper;
import com.pintabar.businessmanagement.repository.BusinessRepository;
import com.pintabar.businessmanagement.repository.MenuInstanceRepository;
import com.pintabar.businessmanagement.repository.MenuItemInstanceRepository;
import com.pintabar.businessmanagement.repository.TableUnitRepository;
import com.pintabar.businessmanagement.service.BusinessManagementService;
import com.pintabar.commons.exceptions.ErrorCode;
import com.pintabar.commons.exceptions.general.DataNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lucas.Godoy on 29/08/17.
 */
@Component
public class BusinessManagementServiceImpl implements BusinessManagementService {

	private final BusinessRepository businessRepository;
	private final TableUnitRepository tableUnitRepository;
	private final MenuInstanceRepository menuInstanceRepository;
	private final MenuItemInstanceRepository menuItemInstanceRepository;
	private final MenuInstanceDTOMapper menuInstanceDTOMapper;

	public BusinessManagementServiceImpl(BusinessRepository businessRepository, TableUnitRepository tableUnitRepository,
										 MenuInstanceRepository menuInstanceRepository, MenuItemInstanceRepository menuItemInstanceRepository, MenuInstanceDTOMapper menuInstanceDTOMapper) {
		this.businessRepository = businessRepository;
		this.tableUnitRepository = tableUnitRepository;
		this.menuInstanceRepository = menuInstanceRepository;
		this.menuItemInstanceRepository = menuItemInstanceRepository;
		this.menuInstanceDTOMapper = menuInstanceDTOMapper;
	}


	@Override
	@Transactional
	public List<MenuInstanceDTO> getMenuInstances(String businessUuid) {
		return getMenuInstances(businessUuid, null);
	}

	@Override
	@Transactional
	public List<MenuInstanceDTO> getMenuInstances(String businessUuid, Boolean isDeleted) {
		Preconditions.checkNotNull(businessUuid);
		return menuInstanceRepository.findAllMenuInstancesByBusinessUuid(businessUuid, isDeleted)
				.stream()
				.map(menuInstance -> menuInstanceDTOMapper.mapToDTO(menuInstance).orElse(null))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Boolean validateTableUnit(String businessUuid, String tableUnitUuid) throws DataNotFoundException {
		return isValidBusiness(businessUuid) && isValidTableUnit(businessUuid, tableUnitUuid);
	}

	@Override
	@Transactional
	public Boolean validateMenuInstance(String businessUuid, String menuInstanceUuid) throws DataNotFoundException {
		return isValidBusiness(businessUuid) && isValidMenuInstance(menuInstanceUuid, businessUuid);
	}

	@Override
	@Transactional
	public Boolean validateMenuItemInstance(String businessUuid, String menuItemInstanceUuid) throws DataNotFoundException {
		return isValidBusiness(businessUuid) && isValidMenuItemInstance(menuItemInstanceUuid, businessUuid);
	}

	private boolean isValidMenuItemInstance(String menuItemInstanceUuid, String businessUuid) throws DataNotFoundException {
		return menuItemInstanceRepository.findMenuItemInstanceByUuidAndBusinessUuid(menuItemInstanceUuid, businessUuid)
				.orElseThrow(() -> new DataNotFoundException(ErrorCode.MENU_ITEM_INSTANCE_NOT_FOUND)).isFullAvailable();
	}

	private boolean isValidMenuInstance(String menuInstanceUuid, String businessUuid) throws DataNotFoundException {
		return menuInstanceRepository.findMenuInstanceByUuidAndBusinessUuid(menuInstanceUuid, businessUuid)
				.orElseThrow(() -> new DataNotFoundException(ErrorCode.MENU_INSTANCE_NOT_FOUND)).isFullAvailable();
	}

	private boolean isValidTableUnit(String businessUuid, String tableUnitUuid) throws DataNotFoundException {
		return tableUnitRepository.findTableUnitByUuidAndBusinessUuid(tableUnitUuid, businessUuid)
				.orElseThrow(() -> new DataNotFoundException(ErrorCode.TABLE_UNIT_NOT_FOUND)) != null;
	}

	private boolean isValidBusiness(String businessUuid) throws DataNotFoundException {
		return businessRepository.findByUuid(businessUuid)
				.orElseThrow(() -> new DataNotFoundException(ErrorCode.BUSINESS_NOT_FOUND)).isValid();
	}

}
