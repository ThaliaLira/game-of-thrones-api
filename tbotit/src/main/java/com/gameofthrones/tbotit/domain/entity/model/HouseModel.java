package com.gameofthrones.tbotit.domain.entity.model;

import com.gameofthrones.tbotit.domain.enums.Allies;
import com.gameofthrones.tbotit.domain.enums.Enemies;
import com.gameofthrones.tbotit.domain.enums.Sigils;
import com.gameofthrones.tbotit.domain.enums.Words;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "houses_got")
public class HouseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long houseId;
    @Column(name = "house_name")
    String name;
    @Column
    Double seatOfPower;
    @Column
    Sigils sigils;
    @Column
    Words words;
    @Column
    Double armySize;
    @Column
    Double wealth;
    @Column
    List<Allies> allies;
    @Column
    List<Enemies> enemies;
    @OneToMany(mappedBy = "house")
    List<CharacterModel> characters;
}
