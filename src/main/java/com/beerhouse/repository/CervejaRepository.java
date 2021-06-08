package com.beerhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beerhouse.modelo.Cerveja;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

}
