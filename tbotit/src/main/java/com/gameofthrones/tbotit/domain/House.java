package com.gameofthrones.tbotit.domain;

import com.gameofthrones.tbotit.enums.Sigils;
import com.gameofthrones.tbotit.enums.Words;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House {

    Integer id;
    String name;
    Double seatOfPower;
    Sigils sigils;
    Words words;
    Double armySize;
    Double wealth;
    List<Integer> allies;
    List<Integer> enemies;

}
