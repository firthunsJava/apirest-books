package com.company.books.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//public class ApirestBooksApplication implements CommandLineRunner {
@SpringBootApplication
public class ApirestBooksApplication  {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {SpringApplication.run(ApirestBooksApplication.class, args);	}

	/* 	 vamos a generar clases encriptadas, para insertarlas en la base de datos	 */
	//@Override
	//public void run(String... args) throws Exception {

		//String password = "springboot";
// nos genera 3 claves encriptadas
	//	for (int i = 0; i < 3; i++) {
		//	String passwordBcrypt = passwordEncoder.encode(password);
		//	System.out.println(passwordBcrypt);
	//	}

	//}
}
