package com.pintabar.businessmanagement.repository;

import com.pintabar.businessmanagement.entity.TableUnit;
import com.pintabar.businessmanagement.repository.custom.CustomTableUnitRepository;
import com.pintabar.repositories.GenericJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucasgodoy on 13/06/17.
 */
@Transactional
public interface TableUnitRepository extends GenericJpaRepository<TableUnit, Long>,
		CustomTableUnitRepository {
}
