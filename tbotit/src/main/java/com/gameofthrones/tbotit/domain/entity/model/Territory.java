package com.gameofthrones.tbotit.domain.entity.model;

import com.gameofthrones.tbotit.domain.enums.StrategicValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Territory {

    Integer id;
    String name;
    List<Integer> currentlyRulingHouseId;
    Double wealth;
    StrategicValue strategicValue;

}
