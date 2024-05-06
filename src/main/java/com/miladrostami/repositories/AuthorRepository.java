package com.miladrostami.repositories;

import com.miladrostami.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> , JpaSpecificationExecutor<Author> {

    List<Author> findByNamedQuery(@Param("age") int age);

    // update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query(" update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

@Modifying
@Transactional
    void updateByNamedQuery(@Param("age") int age);


    @Modifying
    @Transactional
    @Query(" update Author a set a.age = :age")
    int updateAllAuthorsAges(int age);


 /*   @Modifying
    @Query("update  Author a set a.age = :age")
    int updateAllAuthorAges(int age);*/


  /*  @Modifying
    @Transactional
    @Query("update  Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age,int id);*/

    //select * from author where first_name = 'milad'
    List<Author> findAllByFirstName(String fn);

    //select * from author where first_name = 'mil'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //select * from author where first_name like = '%mil%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    //select * from author where first_name like = 'mil%'
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String fn);

    //select * from author where first_name like = '%mil'
    List<Author> findAllByFirstNameEndingWithIgnoreCase(String fn);

    //select * from author where first_name in = ('milad','rostami','javadev")
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);


}
