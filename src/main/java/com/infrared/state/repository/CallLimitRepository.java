package com.infrared.state.repository;

import com.infrared.state.entity.CallLimitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallLimitRepository extends JpaRepository<CallLimitEntity, String> {
}
