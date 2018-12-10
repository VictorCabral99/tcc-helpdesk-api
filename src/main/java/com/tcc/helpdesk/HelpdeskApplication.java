package com.tcc.helpdesk;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.helpdesk.domain.Chamado;
import com.tcc.helpdesk.domain.Cliente;
import com.tcc.helpdesk.domain.Usuario;
import com.tcc.helpdesk.domain.enums.PerfilUsuario;
import com.tcc.helpdesk.domain.enums.StatusUsuario;
import com.tcc.helpdesk.repositories.ChamadoRepository;
import com.tcc.helpdesk.repositories.ClienteRepository;
import com.tcc.helpdesk.repositories.UsuarioRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date init = new Date();
		Date fim = new Date();
		
		Usuario user1 = new Usuario(null,"vyctorcabral@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.ADMIN);
		Usuario user2 = new Usuario(null,"igorrocha@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.GERENTE);
		Usuario user3 = new Usuario(null,"luiznunes@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.ANALIST2);
		Usuario user4 = new Usuario(null,"isaqueamaral@gmail.com","Teste123#",init,StatusUsuario.ACTIVE,PerfilUsuario.ANALIST1);
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date nascimento = sdf.parse("27/07/2006");
		
		Cliente customer1 = new Cliente(null,"cliente","1", "469.410.248-60", 1, nascimento, "06332-130", "Rua Cataguá", "345", "Casa 14A", "Jardim Santa Tereza", "Carapicuiba", "SP", init, user4);
		Cliente customer2 = new Cliente(null,"cliente","2", "148.089.568-70", 1, nascimento, "05365-150", "Rua Cataguá", "345", "Casa 14A", "Jardim Santa Tereza", "Carapicuiba", "SP", init, user4);
		clienteRepository.saveAll(Arrays.asList(customer1,customer2));
		
		Chamado chamado1 = new Chamado(null, customer1, 1, 1, user4,user3, "Como fechar o word?","Abri o word e agora não sei como fechar, vocês poderiam me explicar como fazer isso? ", init, fim);
		Chamado chamado2 = new Chamado(null, customer2, 2, 2, user4,user3, "Precisando de um monitor melhor","Quando uso o Photoshop a tela está horrivel em questão de resolução, preciso de uma tela melhor.", init, fim);
		Chamado chamado3 = new Chamado(null, customer1, 3, 3, user4,user2, "Teclado parou de funcionar","Meu teclado parou, poderia me arranjar um novo", init, fim);
		Chamado chamado4 = new Chamado(null, customer2, 3, 4, user4,user4, "Tela Azul","quando estou mexendo no computador ele do nada da tela azul, vocês poderiam me ajudar?", init, fim);
		chamadoRepository.saveAll(Arrays.asList(chamado1,chamado2,chamado3,chamado4));
	}
}
