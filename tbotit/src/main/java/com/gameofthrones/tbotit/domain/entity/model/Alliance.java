package com.gameofthrones.tbotit.domain.entity.model;


import com.gameofthrones.tbotit.domain.enums.TermsOfAlliance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="alliances")

public class Alliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToMany
    @JoinTable(
            name = "alliance_house",
            joinColumns = @JoinColumn(name = "alliance_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    List<HouseModel> idHouse1;

    @Column(name = "alliance_start_date")
    Date allianceStartDate;

    @Column(name = "alliance_end_date")
    Date allianceEndDate;

    @Column(name = "terms")
    TermsOfAlliance termsOfAlliance;

}
