package com.petfriends.eventsourcing.transporte.query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<EntregaEntity, String> {

    EntregaEntity findByPedidoId(String pedidoId);
}