package com.example.cadastro.domain;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository rep;
    public Optional<Cadastro> getCadastroById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Cadastro> getCadastroByNome(String nome) {
        return rep.findByNome(nome);
    }

    public Iterable<Cadastro> getCadastro(){
        return rep.findAll();
    }


    public Cadastro save(Cadastro cadastro) {
        return rep.save(cadastro);

    }

    public Cadastro update(@NotNull Cadastro cadastro, Long id){
        Assert.notNull(id, "Não foi Possivel inserir o registro !");

        Optional <Cadastro> optional= rep.findById(id);
        if(optional.isPresent()){
            Cadastro db=optional.get();

            db.setNome(cadastro.getNome());
            db.setSexo(cadastro.getSexo());
            db.setEmail(cadastro.getEmail());
            db.setSenha(cadastro.getSenha());
            System.out.println("Cadastro id" + db.getId());

            rep.save(db);
            return db;

        }else{
            throw new RuntimeException("Não  foi possivel atualizar o cadastro");
        }
    }
    public void delete(Long id){
        if(getCadastroById(id).isPresent()){
            rep.deleteById(id);
        }
    }
}
