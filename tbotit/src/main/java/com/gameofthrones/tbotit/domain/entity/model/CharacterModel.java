package com.gameofthrones.tbotit.domain.entity.model;


import com.gameofthrones.tbotit.domain.enums.Status;
import com.gameofthrones.tbotit.domain.enums.Title;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="character")
@Getter
@Setter

public class CharacterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    HouseModel house;
    @Column(name = "character_name")
    String name;
    @Column
    Title title;
    @Column
    Double loyalty;
    @Column
    Double militarySkills;
    @Column
    Double politicalSkills;
    @Column(name = "lifes_status")
    Status status;

}
