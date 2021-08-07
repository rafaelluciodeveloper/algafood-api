package com.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroController {

	private AtivacaoClienteService ativacaoClienteService;

	public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
		super();
		this.ativacaoClienteService = ativacaoClienteService;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente rafael = new Cliente("Rafael", "rafeal@mail.com", "8299769999");

		ativacaoClienteService.ativar(rafael);

		return "Hello World";
	}

}
