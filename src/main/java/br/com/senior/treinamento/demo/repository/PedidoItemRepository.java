package br.com.senior.treinamento.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senior.treinamento.demo.entidades.PedidoItemEntity;

public interface PedidoItemRepository extends JpaRepository<PedidoItemEntity, Long> {

}
