package com.provaRhyan.demo;

import com.provaRhyan.demo.controller.ContatoController;
import com.provaRhyan.demo.models.Contato;
import com.provaRhyan.demo.repositories.RepositoryContato;
import com.provaRhyan.demo.service.contatoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RepositoryContato repositoryContato;
	@Autowired
	private com.provaRhyan.demo.service.contatoService contatoService;

	@Test
	void ChecaExistenciaDados() {
		Contato contato1 = repositoryContato.save(new Contato(1L,"Rhyan", "rhyanfelipepw@hotmail.com", "45999742472"));
		Assertions.assertThat(repositoryContato.findByEmail(contato1.getEmail())).isPresent();
		Assertions.assertThat(repositoryContato.findByTelefone(contato1.getTelefone())).isPresent();
	}

	@Test
	void ChecaExistenciaDadosApi(){
		Contato contato1 = repositoryContato.save(new Contato(1L,"Rhyan", "rhyanfelipepw@hotmail.com", "45999742472"));
		String teste = contatoService.criaContato(contato1);
		Assertions.assertThat(teste).isEqualTo("O numero informado já está em uso");
	}


	@Test
	void registraUsuario(){

		Contato contato1 = repositoryContato.save(new Contato(1L,"Rhyan", "rhyanfelipepw@hotmail.com", "45999742472"));
		Assert.notNull(repositoryContato.getById(contato1.getId()));
	}
	@Test
	void deletaUsuario(){
		Contato contato1 = repositoryContato.save(new Contato(1l, "Rhyan", "rhyanfelipepw@hotmail.com", "45999742472"));
		repositoryContato.delete(contato1);
		Assertions.assertThat(repositoryContato.findById(contato1.getId())).isEmpty();
	}

	@Test
	void editaUsuario(){
		Contato contato1 = repositoryContato.save(new Contato(1l, "Rhyan", "rhyanfelipepw@hotmail.com", "45999742472"));
		contato1.setTelefone("41999742472");
		Contato contato3 = repositoryContato.save(contato1);
		Assertions.assertThat(contato3).isNotEqualTo(contato1);
	}
}
