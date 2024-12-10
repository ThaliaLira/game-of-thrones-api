package com.gameofthrones.tbotit.services;

import com.gameofthrones.tbotit.domain.entity.model.HouseModel;
import com.gameofthrones.tbotit.repository.HouseRepository;
import com.gameofthrones.tbotit.domain.exception.DomainException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    HouseRepository houseRepository;

    @Transactional
    public HouseModel salvarHouse(HouseModel houseModel){
        boolean houseInUse = houseRepository.findByName(houseModel.getName())
                .filter(h -> !h.equals(houseModel))
                .isPresent();

        if(houseInUse){
            throw new DomainException("Já existe uma casa cadastrada com este nome");
        }
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
