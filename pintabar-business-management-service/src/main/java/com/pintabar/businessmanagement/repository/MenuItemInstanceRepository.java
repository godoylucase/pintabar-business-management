package com.pintabar.businessmanagement.repository;

import com.pintabar.businessmanagement.entity.MenuItemInstance;
import com.pintabar.repositories.GenericJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucasgodoy on 23/06/17.
 */
@Transactional
public interface MenuItemInstanceRepository extends GenericJpaRepository<MenuItemInstance, Long> {
}
