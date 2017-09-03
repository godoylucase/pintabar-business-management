package com.pintabar.businessmanagement.repository.impl;

import com.pintabar.businessmanagement.entity.MenuItemInstance;
import com.pintabar.businessmanagement.entity.QMenuItemInstance;
import com.pintabar.businessmanagement.repository.custom.CustomMenuItemInstanceRepository;
import com.pintabar.businessmanagement.repository.querydsl.MenuItemInstancePredicates;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * @author Lucas.Godoy on 3/09/17.
 */
public class MenuItemInstanceRepositoryImpl implements CustomMenuItemInstanceRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<MenuItemInstance> findMenuItemInstanceByUuidAndBusinessUuid(String menuItemInstanceUuid, String businessUuid) {
		JPAQuery<MenuItemInstance> query = new JPAQuery<>();
		QMenuItemInstance qMenuItemInstance = QMenuItemInstance.menuItemInstance;
		BooleanExpression searchPredicate = MenuItemInstancePredicates.whereMenuItemInstanceWithUuidAndBusinessUuid(qMenuItemInstance,
				menuItemInstanceUuid, businessUuid);

		return Optional.ofNullable(query.from(qMenuItemInstance).where(searchPredicate).fetchOne());
	}
}
