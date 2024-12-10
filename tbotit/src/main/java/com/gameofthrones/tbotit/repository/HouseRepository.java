package com.gameofthrones.tbotit.repository;

import com.gameofthrones.tbotit.domain.entity.model.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseRepository extends JpaRepository<HouseModel, Long> {

    Optional<HouseModel> findByName(String nome);
}
