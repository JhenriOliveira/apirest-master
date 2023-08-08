package br.com.jhsoft.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.jhsoft.dto.ItemPedidoDTO;
import br.com.jhsoft.dto.PedidoDTO;
import br.com.jhsoft.entity.Cliente;
import br.com.jhsoft.entity.ItemPedido;
import br.com.jhsoft.entity.Pedido;
import br.com.jhsoft.entity.Produto;
import br.com.jhsoft.exception.RegraNegocioException;
import br.com.jhsoft.repository.Clientes;
import br.com.jhsoft.repository.ItensPedido;
import br.com.jhsoft.repository.Pedidos;
import br.com.jhsoft.repository.Produtos;
import br.com.jhsoft.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	private Pedidos pedidoRepository;
	private Clientes clienteRepository;
	private Produtos produtosRepository;
	private ItensPedido itensPedidoRepository;

	public PedidoServiceImpl(Pedidos pedidoRepository, Clientes clienteRepository, 
								Produtos produtosRepository, ItensPedido itensPedidoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
		this.produtosRepository = produtosRepository;
		this.itensPedidoRepository = itensPedidoRepository;
	}
	
	@Override
	@Transactional
	public Pedido salvar(PedidoDTO dto) {
		Integer idCliente = dto.getCliente();
		
		Cliente cliente = clienteRepository
				.findById(idCliente)
				.orElseThrow(() -> new RegraNegocioException("Código de Cliente Inválido!"));
		
		Pedido pedido = new Pedido();
		pedido.setTotal(dto.getTotal());
		pedido.setDataPedido(LocalDate.now());
		pedido.setCliente(cliente);
		
		List<ItemPedido> itensPedido = converterItens(pedido, dto.getItens());
		pedidoRepository.save(pedido);
		itensPedidoRepository.saveAll(itensPedido);
		pedido.setItens(itensPedido);
		
		return pedido;
	}
	
	private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens) {
		if(itens.isEmpty()) {
			throw new RegraNegocioException("Não é Possivel Realizar um Pedido sem Itens!");
		}
		
		return itens
				.stream()
				.map(dto -> { 
					Integer idProduto = dto.getProduto();
					Produto produto = produtosRepository
						.findById(idProduto)
						.orElseThrow(
								() -> new RegraNegocioException("Código do Item Inválido!"));
						
						
						ItemPedido itemPedido = new ItemPedido();
						itemPedido.setQuantidade(dto.getQuantidade());
						itemPedido.setPedido(pedido);
						itemPedido.setProduto(produto);
						return itemPedido;
					    }).collect(Collectors.toList());
	}
}
