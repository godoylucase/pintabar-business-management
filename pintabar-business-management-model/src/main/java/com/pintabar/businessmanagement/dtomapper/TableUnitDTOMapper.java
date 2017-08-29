package com.pintabar.businessmanagement.dtomapper;

import com.pintabar.businessmanagement.dto.TableUnitDTO;
import com.pintabar.businessmanagement.entity.TableUnit;
import com.pintabar.dtomappers.GenericDTOMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Created by lucasgodoy on 14/06/17.
 */
@Component
public class TableUnitDTOMapper implements GenericDTOMapper<TableUnit, TableUnitDTO> {

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<TableUnitDTO> mapToDTO(@Nullable TableUnit tableUnit) {
		TableUnitDTO tableDTO = null;
		if (tableUnit != null) {
			tableDTO = new TableUnitDTO();
			if (tableUnit.getBusiness() != null) {
				tableDTO.setBusinessUuid(tableUnit.getBusiness().getUuid());
			}
			if (tableUnit.getInternalNumber() != null) {
				tableDTO.setInternalNumber(tableUnit.getInternalNumber());
			}
			tableDTO.setUuid(tableUnit.getUuid());
			tableDTO.setCreatedOn(tableUnit.getCreatedOn());
			tableDTO.setUpdatedOn(tableUnit.getUpdatedOn());
		}
		return Optional.ofNullable(tableDTO);
	}
}
