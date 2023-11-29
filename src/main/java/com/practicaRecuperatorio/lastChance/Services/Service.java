package com.practicaRecuperatorio.lastChance.Services;

import java.util.List;

public interface Service <T,W>{
    void add(T entity);
    void update(T entity);
    T getById(W id);
    T delete(W id);
    List<T> getAll(); // getAll es siempre un listado
    }

