package com.miladrostami;

import com.github.javafaker.Faker;
import com.miladrostami.models.Author;
import com.miladrostami.models.Video;
import com.miladrostami.models.specification.AuthorSpecification;
import com.miladrostami.repositories.AuthorRepository;
import com.miladrostami.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AuthorRepository authorRepository
			, VideoRepository videoRepository) {

		return args -> {
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();

				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
//		.email(faker.lorem().characters())
						.email(faker.name().username() + "@gmail.com")
						.age(faker.number().numberBetween(12, 45))
						.build();
				authorRepository.save(author);
			}
//update author with ID = 1
			var author = Author.builder()
					.id(1)
					.firstName("ali")
					.lastName("rostami")
					.email("miladrostami24@gmail.com")
					.age(45)
					.build();
			//	authorRepository.save(author);
			// update Author a set a.age = 22 where a.id = 1
			//	authorRepository.updateAuthor(22,1);

			//update All Authors Ages
			//	authorRepository.updateAllAuthorsAges(125);

			//find by named Query
		/*	authorRepository.findByNamedQuery(69)
					.forEach(System.out::println);*/
			//update with named query
			authorRepository.updateByNamedQuery(12);

			//specification find by first name
			Specification<Author> specification
					= Specification.where(AuthorSpecification.hasAge(35)).and(
					AuthorSpecification.firstNameContains("mi")
			);
			authorRepository.findAll(specification)
					.forEach(System.out::println);
		/*	var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);*/
// update  Author a set a.age = :22 where a.id = :1
			//		authorRepository.updateAuthor(22,1);
//			authorRepository.updateAllAuthorAges(45);

		};
	}

}
