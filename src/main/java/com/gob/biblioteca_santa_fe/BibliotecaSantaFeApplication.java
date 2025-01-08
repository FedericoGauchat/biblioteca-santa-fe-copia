package com.gob.biblioteca_santa_fe;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;

import com.gob.biblioteca_santa_fe.model.Libro;
import com.gob.biblioteca_santa_fe.repository.postgres.LibroRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BibliotecaSantaFeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaSantaFeApplication.class, args);
	}

	// @Autowired
	// @Qualifier("mysqlDatasource")
	// DataSource mysqlDS;

	// @Qualifier("mysqlEMF")
	// @Autowired
	// private EntityManager mysqlEM;

	

	// @Autowired
	// private LibroRepository libroRepository;


	// @Autowired
	// @Qualifier("postgreSqlEMF")
	// private EntityManager postgeSqlEM;

	// @Autowired
	// @Qualifier("postgresqlDataSource")
	// private DataSource postgresqlDS;

	// @Override

	// @Transactional(value = "posrtgresSqlTrxManager")
	// public void run(String... args) throws Exception {
	// 	postgreSqlTest();
	// }


	
	// public void postgreSqlTest() throws Exception{
	// 	Libro libroEntity = new Libro();
	// 	libroEntity.setNombre("nombre libro");
	// 	libroEntity.setAutor("Federico");

	// 	postgeSqlEM.persist(libroEntity);

	// 	for(Libro libro: libroRepository.findAll()){
	// 		System.out.println(libro.getAutor());
	// 		System.out.println(libro.getNombre());
	// 	}
	// }

	// @Transactional("mysqlTrxManager")
	// public void mysqlTest() throws Exception{
	// 	Libro libroEntity = new Libro();
	// 	libroEntity.setNombre("nombre libro");
	// 	libroEntity.setAutor("Federico");

	// 	libroRepository.save(libroEntity);

	// 	for(Libro libro: libroRepository.findAll()){
	// 		System.out.println(libro.getAutor());
	// 		System.out.println(libro.getNombre());
	// 	}
	// }
	


}
