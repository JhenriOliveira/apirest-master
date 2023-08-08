package br.com.jhsoft.service;

import br.com.jhsoft.dto.PedidoDTO;
import br.com.jhsoft.entity.Pedido;

public interface PedidoService {
	Pedido salvar(PedidoDTO dto);

}
