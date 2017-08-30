package com.pintabar.businessmanagement.repository.impl;

import com.pintabar.businessmanagement.entity.QTableUnit;
import com.pintabar.businessmanagement.entity.TableUnit;
import com.pintabar.businessmanagement.repository.custom.CustomTableUnitRepository;
import com.pintabar.businessmanagement.repository.querydsl.TableUnitPredicates;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * @author Lucas.Godoy on 30/08/17.
 */
@Component
public class TableUnitRepositoryImpl implements CustomTableUnitRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<TableUnit> findTableUnitByUuidAndBusinessUuid(String tableUnitUuid, String businessUuid) {
		JPAQuery<TableUnit> query = new JPAQuery<>(em);
		QTableUnit qTableUnit = QTableUnit.tableUnit;
		BooleanExpression searchPredicate = TableUnitPredicates.whereTableUnitWithUuidAndBusinessUuid(tableUnitUuid, businessUuid);
		return Optional.ofNullable(query.from(qTableUnit).where(searchPredicate).fetchOne());
	}
}
