package com.tomjr.crud.repo;

import com.tomjr.crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {
        List<Pessoa> findAllByGerenteIsTrue();
}
