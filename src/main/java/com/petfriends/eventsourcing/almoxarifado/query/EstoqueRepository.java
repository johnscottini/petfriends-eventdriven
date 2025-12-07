package com.petfriends.eventsourcing.almoxarifado.query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, String> {
}