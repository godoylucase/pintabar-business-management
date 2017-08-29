package com.pintabar.businessmanagement.dtomapper;

import com.pintabar.businessmanagement.dto.MenuItemDTO;
import com.pintabar.businessmanagement.entity.MenuItem;
import com.pintabar.dtomappers.GenericDTOMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by lucasgodoy on 15/06/17.
 */
@Component
public class MenuItemDTOMapper implements GenericDTOMapper<MenuItem, MenuItemDTO> {

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<MenuItemDTO> mapToDTO(MenuItem entity) {
		MenuItemDTO dto = null;
		if (entity != null) {
			dto = new MenuItemDTO();
			dto.setName(entity.getName());
			dto.setDescription(entity.getDescription());
			dto.setDeleted(entity.isDeleted());
			if (entity.getBusiness() != null) {
				dto.setBusinessUuid(entity.getBusiness().getUuid());
			}
			if (entity.getMenuItemInstance() != null) {
				dto.setMenuItemInstanceUuid(entity.getMenuItemInstance().getUuid());
			}
			dto.setUuid(entity.getUuid());
			dto.setCreatedOn(entity.getCreatedOn());
			dto.setUpdatedOn(entity.getUpdatedOn());
		}
		return Optional.ofNullable(dto);
	}
}
