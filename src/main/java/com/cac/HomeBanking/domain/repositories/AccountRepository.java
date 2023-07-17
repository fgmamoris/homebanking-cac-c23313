package com.cac.HomeBanking.domain.repositories;

import com.cac.HomeBanking.domain.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /*public Optional<Account> findById(Long id);*/

    // TODO: Agregar una búsqueda por número de cuenta en la base de datos

    /*@Query(nativeQuery = true, value = "SELECT * FROM account WHERE number = :number")
    Account getAccountByNumber(@Param("number") int number);*/
}
