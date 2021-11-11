package com.provaRhyan.demo;

import com.provaRhyan.demo.models.Contato;
import com.provaRhyan.demo.repositories.RepositoryContato;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RepositoryContato repositoryContato;

	@Test
	void ChecaExistenciaDados() {
		Contato contato = new Contato(1L,"Rhyan", "rhyanfelipepw@hotmail.com", "45999742472");
		Optional<Contato> contatoTeste = repositoryContato.findByEmail(contato.getEmail());
		Optional<Contato> contatoTeste2 = repositoryContato.findByTelefone(contato.getNrTelefone());


		Assert.isTrue(contatoTeste.isEmpty() && contatoTeste2.isEmpty());
	}

	@Test
	void registraUsuario(){
		Contato contato = new Contato(1L,"Rhyan", "rhyanfelipepw@hotmail.com", "45999742472");
		Contato contato1 = repositoryContato.save(contato);
		Assert.notNull(repositoryContato.getById(contato1.getId()));
	}

}
