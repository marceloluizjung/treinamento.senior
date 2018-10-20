package br.com.senior.treinamento.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senior.treinamento.demo.entidades.ClienteEntity;
import br.com.senior.treinamento.demo.entidades.PedidoEntity;
import br.com.senior.treinamento.demo.entidades.PedidoItemEntity;
import br.com.senior.treinamento.demo.repository.ClienteRepository;
import br.com.senior.treinamento.demo.repository.PedidoItemRepository;
import br.com.senior.treinamento.demo.repository.PedidoRepository;

@Service
public class PedidoItemService {

	private PedidoItemRepository pedidoItemRepository;

	public PedidoItemService(PedidoItemRepository pedidoItemRepository) {
		this.pedidoItemRepository = pedidoItemRepository;
	}

	public PedidoItemEntity salvar(PedidoItemEntity pedido) {
		return pedidoItemRepository.save(pedido);
	}

	public Optional<PedidoItemEntity> buscarPorId(Long id) {
		return pedidoItemRepository.findById(id);
	}
	
	public void deletar(Long id) { 
		pedidoItemRepository.deleteById(id);
	}

	public List<PedidoItemEntity> buscarPedidos() {
		return pedidoItemRepository.findAll();
	}


	
}
