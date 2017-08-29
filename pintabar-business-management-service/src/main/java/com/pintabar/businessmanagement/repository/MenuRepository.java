package com.pintabar.businessmanagement.repository;

import com.pintabar.businessmanagement.entity.Menu;
import com.pintabar.repositories.GenericJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucasgodoy on 18/06/17.
 */
@Transactional
public interface MenuRepository extends GenericJpaRepository<Menu, Long> {
}
