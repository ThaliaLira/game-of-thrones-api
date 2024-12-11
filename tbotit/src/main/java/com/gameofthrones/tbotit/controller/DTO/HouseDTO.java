package com.gameofthrones.tbotit.controller.DTO;

import com.gameofthrones.tbotit.domain.entity.model.CharacterModel;
import com.gameofthrones.tbotit.domain.enums.Allies;
import com.gameofthrones.tbotit.domain.enums.Enemies;
import com.gameofthrones.tbotit.domain.enums.Sigils;
import com.gameofthrones.tbotit.domain.enums.Words;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HouseDTO {

    private String name;

    private  Double seatOfPower;

    private Sigils sigils;

    private Words words;

    private Double armySize;

    private Double wealth;

   private List<Allies> allies;

    private  List<Enemies> enemies;

    private List<CharacterModel> characters;
}
