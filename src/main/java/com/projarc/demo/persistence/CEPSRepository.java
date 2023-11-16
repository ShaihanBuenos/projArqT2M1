package com.projarc.demo.persistence;

import com.projarc.demo.domain.CEP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CEPSRepository extends JpaRepository<CEP, Long> {

    Optional<CEP> findByNumero(String cep);
}
