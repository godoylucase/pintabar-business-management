package com.pintabar.businessmanagement.repository;

import com.pintabar.businessmanagement.entity.Business;
import com.pintabar.repositories.GenericJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lucas.Godoy on 30/08/17.
 */
@Transactional
public interface BusinessRepository extends GenericJpaRepository<Business, Long> {

}
