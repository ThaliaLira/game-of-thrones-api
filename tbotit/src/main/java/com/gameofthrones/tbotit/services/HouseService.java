package com.gameofthrones.tbotit.services;

import com.gameofthrones.tbotit.controller.DTO.HouseDTO;
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

    public HouseModel updateHouse(Long houseId, HouseDTO houseDTO) {
        HouseModel existentHouse = houseRepository.findById(houseId).orElseThrow(() -> new DomainException("House not found."));

        if (houseDTO.getName()!= null) {
            existentHouse.setName(houseDTO.getName());
        }

        if (houseDTO.getSeatOfPower()!= null) {
            existentHouse.setSeatOfPower(houseDTO.getSeatOfPower());
        }

        if (houseDTO.getSigils()!= null) {
            existentHouse.setSigils(houseDTO.getSigils());
        }

        if (houseDTO.getWords()!= null) {
            existentHouse.setWords(houseDTO.getWords());
        }

        if (houseDTO.getArmySize()!= null) {
            existentHouse.setArmySize(houseDTO.getArmySize());
        }

        if (houseDTO.getWealth()!= null) {
            existentHouse.setWealth(houseDTO.getWealth());
        }

        if (houseDTO.getAllies()!= null) {
            existentHouse.setAllies(houseDTO.getAllies());
        }

        if (houseDTO.getEnemies()!= null) {
            existentHouse.setEnemies(houseDTO.getEnemies());
        }

        if (houseDTO.getCharacters()!= null) {
            existentHouse.setCharacters(houseDTO.getCharacters());
        }

        return houseRepository.save(existentHouse);

//        return houseRepository.findById(houseId).map(house -> {
//            houseDetails.setName(house.getName());
//            houseDetails.setSeatOfPower(house.getSeatOfPower());
//            houseDetails.setSigils(house.getSigils());
//            houseDetails.setWords(house.getWords());
//            houseDetails.setArmySize(house.getArmySize());
//            houseDetails.setWealth(house.getWealth());
//            houseDetails.setAllies(house.getAllies());
//            houseDetails.setEnemies(house.getEnemies());
//            houseDetails.setCharacters(house.getCharacters());
//            return houseRepository.save(house);
//        }).orElseThrow(() -> new RuntimeException("House not found"));
    }

    public void deleteHouseById(Long houseId) {

        if (!houseRepository.existsById(houseId)) {
            throw new DomainException("House not found.");
        }
        houseRepository.deleteById(houseId);
    }

}