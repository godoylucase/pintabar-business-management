package com.pintabar.businessmanagement.repository.querydsl;

import com.pintabar.businessmanagement.entity.QMenuItemInstance;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author Lucas.Godoy on 3/09/17.
 */
public class MenuItemInstancePredicates {

	public static BooleanExpression whereMenuItemInstanceWithUuidAndBusinessUuid(
			QMenuItemInstance qMenuItemInstance, String menuItemInstanceUuid, String businessUuid) {
		return qMenuItemInstance.uuid.eq(menuItemInstanceUuid)
				.and(qMenuItemInstance.menuItem.business.uuid.eq(businessUuid));
	}
}
