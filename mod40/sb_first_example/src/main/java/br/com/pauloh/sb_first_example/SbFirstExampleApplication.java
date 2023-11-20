package br.com.pauloh.sb_first_example;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.pauloh.model.Client;
import br.com.pauloh.repository.IClientRepository;


@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.pauloh.repository")
@EntityScan("br.com.pauloh.*")  
@ComponentScan(basePackages = "br.com.pauloh")
public class SbFirstExampleApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SbFirstExampleApplication.class);

	@Autowired
	private IClientRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SbFirstExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StratAplication");
		Client client = createClient();
		log.info("{}", client);
		repository.save(client);
	}

	private Client createClient() {
		return Client.builder().
				name("Paulo Henrique")
				.cpf(11111111111L)
				.phone(11999999999L)
				.email("paulo@paulo")
				.address("Rua dos Testes")
				.addres_number(123)
				.city("Teste")
				.state("Teste")
				.build();
	}
}
