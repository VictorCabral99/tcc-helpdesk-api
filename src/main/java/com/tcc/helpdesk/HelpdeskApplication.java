package com.tcc.helpdesk;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.helpdesk.domain.Usuario;
import com.tcc.helpdesk.domain.enums.PerfilUsuario;
import com.tcc.helpdesk.domain.enums.StatusUsuario;
import com.tcc.helpdesk.repositories.ChamadoRepository;
import com.tcc.helpdesk.repositories.UsuarioRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date init = new Date();
		Date fim = new Date();
		
		/*
		Chamado chamado1 = new Chamado(null,"Problemas de memória",init,fim);
		Chamado chamado2 = new Chamado(null,"Tela Azul",init,fim);
		Chamado chamado3 = new Chamado(null,"Impressora não funciona",init,fim);
		Chamado chamado4 = new Chamado(null,"Mouse quebrou",init,fim);
		Chamado chamado5 = new Chamado(null,"Mancha na tela",init,fim);
		Chamado chamado6 = new Chamado(null,"Sem som",init,fim);
		
		chamadoRepository.saveAll(Arrays.asList(chamado1,chamado2,chamado3,chamado4,chamado5,chamado6));
		*/
		
		Usuario user1 = new Usuario(null,"vyctorcabral@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.ADMIN);
		Usuario user2 = new Usuario(null,"igorrocha@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.GERENTE);
		Usuario user3 = new Usuario(null,"luiznunes@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.ANALIST2);
		Usuario user4 = new Usuario(null,"isaqueamaral@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.ANALIST1);
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
		
	}
}
