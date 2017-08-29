package com.pintabar.businessmanagement.repository;


import com.pintabar.businessmanagement.entity.MenuInstance;
import com.pintabar.businessmanagement.repository.custom.CustomMenuInstanceRepository;
import com.pintabar.repositories.GenericJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lucas.Godoy on 9/07/17.
 */
@Transactional
public interface MenuInstanceRepository extends GenericJpaRepository<MenuInstance, Long>,
		CustomMenuInstanceRepository {
}
