package com.example.cadastro.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CadastroRepository extends CrudRepository <Cadastro, Long> {

    Iterable<Cadastro> findByNome(String nome);
}
