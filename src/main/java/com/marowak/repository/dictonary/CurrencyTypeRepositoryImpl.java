package com.marowak.repository.dictonary;

import com.marowak.entity.dictonary.CurrencyType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyTypeRepositoryImpl implements DictonaryCustomRepository<CurrencyType> {

    private final CurrencyTypeRepository currencyTypeRepository;

    public CurrencyTypeRepositoryImpl(CurrencyTypeRepository currencyTypeRepository) {
        this.currencyTypeRepository = currencyTypeRepository;
    }

    @Override
    public CurrencyType findOneByName(String name) {
        List<CurrencyType> type = currencyTypeRepository.findByName(name);
        if (type != null && !type.isEmpty()) {
            return type.get(0);
        }

        return null;
    }
}
