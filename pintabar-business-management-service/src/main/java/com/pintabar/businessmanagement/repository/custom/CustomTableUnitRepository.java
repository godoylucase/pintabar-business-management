package com.pintabar.businessmanagement.repository.custom;

import com.pintabar.businessmanagement.entity.TableUnit;

import java.util.Optional;

/**
 * @author Lucas.Godoy on 30/08/17.
 */
public interface CustomTableUnitRepository {

	Optional<TableUnit> findTableUnitByUuidAndBusinessUuid(String tableUnitUuid, String businessUuid);

}
