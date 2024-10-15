package com.gameofthrones.tbotit.domain.entity.repository;

import com.gameofthrones.tbotit.domain.entity.model.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<HouseModel, Long> {
}
