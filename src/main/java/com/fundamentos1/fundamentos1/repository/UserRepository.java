package com.fundamentos1.fundamentos1.repository;

import com.fundamentos1.fundamentos1.dto.UserDto;
import com.fundamentos1.fundamentos1.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {//recibe dos parametros, la identidad y el tipo de datos del id de esa identidad

   @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    List<User> findByName(String name);

   Optional<User> findByEmailAndName(String email,String name);

   List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name,String email);

    List<User> findByBirthDateBetween(LocalDate begin,LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

   /* @Query("select new UserDto (u.id,u.name,u.birthDate) "+
    "from User u"  +
    "where u.birthDate=:parametroFecha"+
    "and u.email=:parametroEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                                @Param("parametroEmail") String email);*/

    List<User> findAll();
}
