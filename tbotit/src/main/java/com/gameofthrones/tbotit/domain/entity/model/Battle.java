package com.gameofthrones.tbotit.domain.entity.model;

import com.gameofthrones.tbotit.domain.enums.BattleResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Battle {

    Integer id;
    String name;
    List<Integer> attackingHouseId;
    List<Integer> defendingHoudeId;
    Date battleDate;
    String locale;
    BattleResult battleResult;
}
