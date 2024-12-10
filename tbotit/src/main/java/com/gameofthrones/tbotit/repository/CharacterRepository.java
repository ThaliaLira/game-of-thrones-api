package com.gameofthrones.tbotit.repository;

import com.gameofthrones.tbotit.domain.entity.model.CharacterModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacterRepository extends JpaRepository<CharacterModel, Long> {
}
