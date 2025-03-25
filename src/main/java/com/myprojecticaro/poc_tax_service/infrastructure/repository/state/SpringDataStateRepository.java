package com.myprojecticaro.poc_tax_service.infrastructure.repository.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myprojecticaro.poc_tax_service.infrastructure.repository.state.entity.StateEntity;

@Repository
public interface SpringDataStateRepository  extends JpaRepository<StateEntity, Long> {
	 boolean existsByCode(String code);
}
