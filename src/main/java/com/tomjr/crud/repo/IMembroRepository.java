package com.tomjr.crud.repo;

import com.tomjr.crud.model.Membros;
import com.tomjr.crud.model.MembrosKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMembroRepository extends JpaRepository<Membros, MembrosKey> {
    List<Membros> findAllByIdprojetoIs(Long idProjeto);
    List<Membros> findAllByIdpessoaIs(Long idPessoa);
    void deleteByIdpessoaIs(Long idPessoa);
    void deleteByIdprojetoIs(Long idProjeto);
}
