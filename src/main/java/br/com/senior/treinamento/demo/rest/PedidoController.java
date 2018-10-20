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

import br.com.senior.treinamento.demo.entidades.ClienteEntity;
import br.com.senior.treinamento.demo.entidades.PedidoEntity;
import br.com.senior.treinamento.demo.service.ClienteService;
import br.com.senior.treinamento.demo.service.PedidoService;



@RestController
@RequestMapping("/api")

public class PedidoController {


	// @Autowired
	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@PostMapping("/pedidos")
	public ResponseEntity<String> criar(@RequestBody PedidoEntity pedido) {
		System.out.println("Criando Pedido");
		pedido = pedidoService.salvar(pedido);
		return new ResponseEntity<String>("Deu boa", HttpStatus.CREATED);
	}
	
	@PutMapping("/pedidos")
	public ResponseEntity<Void> alterar(@RequestBody PedidoEntity pedido) {
		System.out.println("Pedido Alterado");
		if (!pedidoService.buscarPorId(pedido.getId()).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		pedidoService.salvar(pedido);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		System.out.println("Deletando com sucesso");
		if (!pedidoService.buscarPorId(id).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		pedidoService.deletar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<PedidoEntity> buscarPedido(@PathVariable Long id) {
		System.out.println("Buscando pedido");
		Optional<PedidoEntity> pedido = pedidoService.buscarPorId(id);
		if(pedido.isPresent()) {
		return new ResponseEntity<PedidoEntity>(pedido.get(), HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/pedido/buscar")
	public ResponseEntity<List<PedidoEntity>> buscarPedido(@PathParam(value = "nome")String nome) {
		 System.out.println("Buscando pedidos"); 
		 //TODO: Falta implementação
	   	 return null;
	}
	
}
