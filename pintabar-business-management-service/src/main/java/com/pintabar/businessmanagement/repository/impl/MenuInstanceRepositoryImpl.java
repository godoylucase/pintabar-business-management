package com.pintabar.businessmanagement.repository.impl;


import com.pintabar.businessmanagement.entity.MenuInstance;
import com.pintabar.businessmanagement.entity.QMenuInstance;
import com.pintabar.businessmanagement.repository.custom.CustomMenuInstanceRepository;
import com.pintabar.businessmanagement.repository.querydsl.MenuInstancePredicates;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by lucasgodoy on 21/06/17.
 */
@Component
public class MenuInstanceRepositoryImpl implements CustomMenuInstanceRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<MenuInstance> findAllMenuInstancesByBusinessUuid(String businessUuid, Boolean isDeleted) {
		JPAQuery<MenuInstance> query = new JPAQuery<MenuInstance>(em);
		QMenuInstance qMenuInstance = QMenuInstance.menuInstance;
		BooleanExpression searchPredicate = MenuInstancePredicates.whereBusiness(qMenuInstance, businessUuid);

		if (isDeleted != null) {
			searchPredicate = searchPredicate.and(MenuInstancePredicates.deletedMenuInstance(qMenuInstance, isDeleted));
		}

		return query.from(qMenuInstance).where(searchPredicate).fetch();
	}

	@Override
	public Optional<MenuInstance> findMenuInstanceByUuidAndBusinessUuid(String menuInstanceUuid, String businessUuid) {
		JPAQuery<MenuInstance> query = new JPAQuery<MenuInstance>(em);
		QMenuInstance qMenuInstance = QMenuInstance.menuInstance;
		BooleanExpression searchPredicate = MenuInstancePredicates.whereMenuInstanceWithUuidAndBusinessUuid(qMenuInstance, menuInstanceUuid, businessUuid);

		return Optional.ofNullable(query.from(qMenuInstance).where(searchPredicate).fetchOne());
	}


}
