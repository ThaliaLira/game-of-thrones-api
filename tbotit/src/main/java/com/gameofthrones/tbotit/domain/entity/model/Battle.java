package com.gameofthrones.tbotit.domain.entity.model;

import com.gameofthrones.tbotit.domain.enums.BattleResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="battle")

public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "battle_name")
    String name;

    @ManyToMany
    @JoinTable(
            name = "enemies",
            joinColumns = @JoinColumn(name = "enemies_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    List<HouseModel> attackingHouseId;

    @ManyToMany
    @JoinTable(
            name = "enemies",
            joinColumns = @JoinColumn(name = "enemies_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    List<HouseModel> deffendingHouseId;

    @Column(name = "start_battle")
    Date battleDate;

    String locale;
    BattleResult battleResult;
}
