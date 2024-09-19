package com.gameofthrones.tbotit.domain;


import com.gameofthrones.tbotit.enums.Status;
import com.gameofthrones.tbotit.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    Integer id;
    List<Integer> houseId;
    String name;
    Title title;
    Double loyalty;
    Double militarySkills;
    Double politicalSkills;
    Status status;




}
