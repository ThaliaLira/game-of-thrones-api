package com.gameofthrones.tbotit.controller.DTO;

import com.gameofthrones.tbotit.domain.enums.Status;
import com.gameofthrones.tbotit.domain.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {

    private Integer id;

    private HouseDTO houseDTOId;

    private String name;

    private Title title;

    private Double loyalty;

    private Double militarySkills;

    private Double politicalSkills;

    private Status status;

}
