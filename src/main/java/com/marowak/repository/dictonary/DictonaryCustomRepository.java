package com.marowak.repository.dictonary;

public interface DictonaryCustomRepository<T> {
    T findOneByName(String name);
}
