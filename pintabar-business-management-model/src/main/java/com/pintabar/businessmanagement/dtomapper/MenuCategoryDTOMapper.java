package com.pintabar.businessmanagement.dtomapper;

import com.pintabar.businessmanagement.dto.MenuCategoryDTO;
import com.pintabar.businessmanagement.entity.MenuCategory;
import com.pintabar.dtomappers.GenericDTOMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by lucasgodoy on 18/06/17.
 */
@Component
public class MenuCategoryDTOMapper implements GenericDTOMapper<MenuCategory, MenuCategoryDTO> {

	private final MenuItemDTOMapper menuItemDTOMapper;

	public MenuCategoryDTOMapper(MenuItemDTOMapper menuItemDTOMapper) {
		this.menuItemDTOMapper = menuItemDTOMapper;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<MenuCategoryDTO> mapToDTO(MenuCategory entity) {
		MenuCategoryDTO dto = null;
		if (entity != null) {
			dto = new MenuCategoryDTO();
			dto.setDeleted(entity.isDeleted());
			dto.setName(entity.getName());
			dto.setType(entity.getType());
			dto.setDescription(entity.getDescription());
			if (entity.getBusiness() != null) {
				dto.setBusinessUuid(entity.getBusiness().getUuid());
			}
			if (entity.getMenuCategoryInstance() != null) {
				dto.setMenuCategoryInstanceUuid(entity.getMenuCategoryInstance().getUuid());
			}
			dto.setUuid(entity.getUuid());
			dto.setCreatedOn(entity.getCreatedOn());
			dto.setUpdatedOn(entity.getUpdatedOn());
		}
		return Optional.ofNullable(dto);
	}
}
