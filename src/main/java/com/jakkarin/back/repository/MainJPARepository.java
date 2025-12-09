package com.jakkarin.back.repository;

import com.jakkarin.back.entity.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainJPARepository extends JpaRepository<MainEntity,Integer> {
}
