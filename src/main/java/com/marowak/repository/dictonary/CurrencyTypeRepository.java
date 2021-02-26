package com.marowak.repository.dictonary;

import com.marowak.entity.dictonary.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Integer>, DictonaryCustomRepository<CurrencyType> {
    List<CurrencyType> findByName(String name);
}
