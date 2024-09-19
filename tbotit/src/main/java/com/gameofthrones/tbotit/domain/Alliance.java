package com.gameofthrones.tbotit.domain;


import com.gameofthrones.tbotit.enums.TermsOfAlliance;
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

public class Alliance {

    Integer id;
    List<Integer> idHouse1;
    List<Integer> idHouse2;
    Date allianceStartDate;
    Date allianceEndDate;
    TermsOfAlliance termsOfAlliance;

}
