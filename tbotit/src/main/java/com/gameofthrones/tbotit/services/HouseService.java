package com.gameofthrones.tbotit.services;

import com.gameofthrones.tbotit.controller.DTO.HouseDTO;
import com.gameofthrones.tbotit.domain.entity.model.HouseModel;
import com.gameofthrones.tbotit.domain.entity.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    HouseRepository houseRepository;

    public HouseModel salvarHouse(HouseModel houseModel){
        return houseRepository.save(houseModel);
    }

    public Optional<HouseModel> getHouseById (Long houseId){
        return houseRepository.findById(houseId);
    }

    public List<HouseModel> getAllHouses() {
        return houseRepository.findAll();
    }

    public HouseModel updateHouse(Long houseId, HouseModel houseDetails) {
        return houseRepository.findById(houseId).map(house -> {
            houseDetails.setName(house.getName());
            houseDetails.setSeatOfPower(house.getSeatOfPower());
            houseDetails.setSigils(house.getSigils());
            houseDetails.setWords(house.getWords());
            houseDetails.setArmySize(house.getArmySize());
            houseDetails.setWealth(house.getWealth());
            houseDetails.setAllies(house.getAllies());
            houseDetails.setEnemies(house.getEnemies());
            houseDetails.setCharacters(house.getCharacters());
            return houseRepository.save(house);
        }).orElseThrow(() -> new RuntimeException("House not found"));
    }

    public void deleteHouseBtyId(Long housId) {
        houseRepository.deleteById(housId);
    }



}
