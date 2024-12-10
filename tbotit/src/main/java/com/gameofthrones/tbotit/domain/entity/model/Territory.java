package com.gameofthrones.tbotit.domain.entity.model;

import com.gameofthrones.tbotit.domain.enums.StrategicValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "territory")
public class Territory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "territory_name")
    String name;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    HouseModel currentlyRulingHouseId;

    @Column(name = "wealth")
    Double wealth;

    @Column(name = "value")
    StrategicValue strategicValue;


}
