package com.pintabar.businessmanagement.service.impl;

import com.google.common.base.Preconditions;
import com.pintabar.businessmanagement.dto.MenuInstanceDTO;
import com.pintabar.businessmanagement.dtomapper.MenuInstanceDTOMapper;
import com.pintabar.businessmanagement.entity.Business;
import com.pintabar.businessmanagement.entity.MenuInstance;
import com.pintabar.businessmanagement.repository.BusinessRepository;
import com.pintabar.businessmanagement.repository.MenuInstanceRepository;
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
	private final MenuInstanceDTOMapper menuInstanceDTOMapper;

	public BusinessManagementServiceImpl(BusinessRepository businessRepository, TableUnitRepository tableUnitRepository,
										 MenuInstanceRepository menuInstanceRepository, MenuInstanceDTOMapper menuInstanceDTOMapper) {
		this.businessRepository = businessRepository;
		this.tableUnitRepository = tableUnitRepository;
		this.menuInstanceRepository = menuInstanceRepository;
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
	public Boolean validateMenuInstance(String businessUuid, String menuInstanceUuid) throws DataNotFoundException {
		return isValidBusiness(businessUuid) && isValidMenuInstance(menuInstanceUuid);
	}

	private boolean isValidMenuInstance(String menuInstanceUuid) throws DataNotFoundException {
		return menuInstanceRepository.findByUuid(menuInstanceUuid)
				.orElseThrow(() -> new DataNotFoundException(ErrorCode.MENU_ITEM_NOT_FOUND)).isFullyAvailable();
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
