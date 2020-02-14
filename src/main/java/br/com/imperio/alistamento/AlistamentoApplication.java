package br.com.imperio.alistamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AlistamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlistamentoApplication.class, args);
	}

}
