package com.pintabar.businessmanagement.repository.querydsl;

import com.pintabar.businessmanagement.entity.QTableUnit;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author Lucas.Godoy on 30/08/17.
 */
public class TableUnitPredicates {

	public static BooleanExpression whereTableUnitWithUuidAndBusinessUuid(String tableUnitUuid, String businessUuid) {
		QTableUnit qTableUnit = QTableUnit.tableUnit;
		return qTableUnit.uuid.eq(tableUnitUuid).and(qTableUnit.business.uuid.eq(businessUuid));
	}

}
