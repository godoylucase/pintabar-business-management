package com.pintabar.businessmanagement.service.impl;

import com.google.common.base.Preconditions;
import com.pintabar.businessmanagement.dto.MenuInstanceDTO;
import com.pintabar.businessmanagement.dtomapper.MenuInstanceDTOMapper;
import com.pintabar.businessmanagement.repository.MenuInstanceRepository;
import com.pintabar.businessmanagement.service.BusinessManagementService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lucas.Godoy on 29/08/17.
 */
@Component
public class BusinessManagementServiceImpl implements BusinessManagementService {

	private final MenuInstanceRepository menuInstanceRepository;
	private final MenuInstanceDTOMapper menuInstanceDTOMapper;

	public BusinessManagementServiceImpl(MenuInstanceRepository menuInstanceRepository, MenuInstanceDTOMapper menuInstanceDTOMapper) {
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

}
