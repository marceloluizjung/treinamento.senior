package br.com.senior.treinamento.demo.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.treinamento.demo.entidades.PedidoEntity;
import br.com.senior.treinamento.demo.entidades.PedidoItemEntity;
import br.com.senior.treinamento.demo.service.PedidoItemService;
import br.com.senior.treinamento.demo.service.PedidoService;

@RestController
@RequestMapping("/api")

public class PedidoItemController {

	// @Autowired
	private PedidoItemService pedidoItemService;
	
	public PedidoItemController(PedidoItemService pedidoItemService) {
		this.pedidoItemService = pedidoItemService;
	}
	
	@PostMapping("/pedidoItem")
	public ResponseEntity<String> criar(@RequestBody PedidoItemEntity pedidoItem) {
		System.out.println("Criando Pedido Item");
		pedidoItem = pedidoItemService.salvar(pedidoItem);
		return new ResponseEntity<String>("Deu boa", HttpStatus.CREATED);
	}
	
	@PutMapping("/pedidoItem")
	public ResponseEntity<Void> alterar(@RequestBody PedidoItemEntity pedidoItem) {
		System.out.println("Pedido Alterado");
		if (!pedidoItemService.buscarPorId(pedidoItem.getId()).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		pedidoItemService.salvar(pedidoItem);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}
	
	@DeleteMapping("/pedidoItem/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		System.out.println("Deletando pedido com sucesso");
		if (!pedidoItemService.buscarPorId(id).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		pedidoItemService.deletar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/pedidoItem/{id}")
	public ResponseEntity<PedidoItemEntity> buscarPedido(@PathVariable Long id) {
		System.out.println("Buscando pedido");
		Optional<PedidoItemEntity> pedido = pedidoItemService.buscarPorId(id);
		if(pedido.isPresent()) {
		return new ResponseEntity<PedidoItemEntity>(pedido.get(), HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/pedidoItem/buscar")
	public ResponseEntity<List<PedidoItemEntity>> buscarPedido(@PathParam(value = "nome")String nome) {
		 System.out.println("Buscando pedidos"); 
		 //TODO: Falta implementação
	   	 return null;
	}

	
}
