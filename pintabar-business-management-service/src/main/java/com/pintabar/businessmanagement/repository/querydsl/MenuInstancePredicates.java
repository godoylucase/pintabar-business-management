package com.pintabar.businessmanagement.repository.querydsl;

import com.pintabar.businessmanagement.entity.QMenuInstance;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * Created by lucasgodoy on 18/06/17.
 */
public class MenuInstancePredicates {

	public static BooleanExpression whereBusiness(QMenuInstance qMenuInstance, String uuid) {
		return qMenuInstance.menu.business.uuid.eq(uuid);
	}

	public static BooleanExpression deletedMenuInstance(QMenuInstance qMenuInstance, Boolean isDeleted) {
		if (isDeleted != null && !isDeleted) {
			return qMenuInstance.menu.deleted.isFalse();
		}
		return qMenuInstance.menu.deleted.isTrue();
	}

	public static BooleanExpression whereMenuInstanceWithUuidAndBusinessUuid(
			QMenuInstance qMenuInstance, String menuInstanceUuid, String businessUuid) {
		return qMenuInstance.uuid.eq(menuInstanceUuid)
				.and(qMenuInstance.menu.business.uuid.eq(businessUuid));
	}
}
