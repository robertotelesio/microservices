package com.store.pizzaServices.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<E,M> {
    E save(E entity);

    List<E> save(List<E> entities);

    void deleteByid(M id);

    Optional<E> findById(M id);

    E update(E entity, M id);
}
