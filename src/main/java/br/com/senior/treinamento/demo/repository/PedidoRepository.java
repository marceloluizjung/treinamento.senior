package br.com.senior.treinamento.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senior.treinamento.demo.entidades.PedidoEntity;
import br.com.senior.treinamento.demo.entidades.PedidoItemEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	

}
