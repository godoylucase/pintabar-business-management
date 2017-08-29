package com.pintabar.businessmanagement.dtomapper;

import com.pintabar.businessmanagement.dto.MenuInstanceDTO;
import com.pintabar.businessmanagement.entity.MenuInstance;
import com.pintabar.dtomappers.GenericDTOMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Lucas.Godoy on 12/07/17.
 */
@Component
public class MenuInstanceDTOMapper implements GenericDTOMapper<MenuInstance, MenuInstanceDTO> {

	private final MenuDTOMapper menuDTOMapper;
	private final MenuCategoryInstanceDTOMapper menuCategoryInstanceDTOMapper;

	public MenuInstanceDTOMapper(MenuDTOMapper menuDTOMapper, MenuCategoryInstanceDTOMapper menuCategoryInstanceDTOMapper) {
		this.menuDTOMapper = menuDTOMapper;
		this.menuCategoryInstanceDTOMapper = menuCategoryInstanceDTOMapper;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<MenuInstanceDTO> mapToDTO(MenuInstance entity) {
		MenuInstanceDTO dto = null;
		if (entity != null) {
			dto = new MenuInstanceDTO();
			dto.setAvailable(entity.isAvailable());
			dto.setMenu(menuDTOMapper.mapToDTO(entity.getMenu()).orElse(null));
			dto.getMenuCategoryInstances().addAll(
					entity.getMenuCategoryInstances()
							.stream()
							.map(mci -> menuCategoryInstanceDTOMapper.mapToDTO(mci).orElse(null))
							.collect(Collectors.toSet()));
			dto.setId(entity.getId());
			dto.setUuid(entity.getUuid());
			dto.setCreatedOn(entity.getCreatedOn());
			dto.setUpdatedOn(entity.getUpdatedOn());
		}
		return Optional.ofNullable(dto);
	}
}
