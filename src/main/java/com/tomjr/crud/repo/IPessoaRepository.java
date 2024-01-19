package com.tomjr.crud.repo;

import com.tomjr.crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {
        List<Pessoa> findAllByGerenteIsTrue();
        Optional<Pessoa> findByCpfIs(String cpf);
}
