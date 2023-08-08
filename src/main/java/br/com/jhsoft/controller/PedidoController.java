package br.com.jhsoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.jhsoft.dto.PedidoDTO;
import br.com.jhsoft.entity.Pedido;
import br.com.jhsoft.service.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	private PedidoService service;

	public PedidoController(PedidoService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save(@RequestBody PedidoDTO dto) {
		Pedido pedido = service.salvar(dto);
		return pedido.getId();
	}
	
	

}
