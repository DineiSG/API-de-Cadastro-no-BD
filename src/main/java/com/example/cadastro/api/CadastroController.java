package com.example.cadastro.api;

import com.example.cadastro.domain.Cadastro;
import com.example.cadastro.domain.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/cadastro")
public class CadastroController {
    @Autowired
    private CadastroService service;

    @GetMapping()
    public Iterable<Cadastro> getCadastro(){
        return service.getCadastro();

    }
    @GetMapping("/{id}")
    public Optional<Cadastro> get(@PathVariable("id") Long id){
        return service.getCadastroById(id);

    }
    @GetMapping("/nome/{nome}")
    public Iterable<Cadastro> get(@PathVariable("nome") String nome) {
        return service.getCadastroByNome(nome);
    }
    @PostMapping
    public String post(@RequestBody Cadastro cadastro){
        Cadastro c =service.save(cadastro);

        return "Cadastro realizado com sucesso" + c.getId();
    }
    @PutMapping("/{id}")
    public String put(@PathVariable ("id") Long id, @RequestBody Cadastro cadastro){
        Cadastro c =service.update(cadastro, id);

        return "Cadastro atualizado com sucesso" + c.getId();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "Cadastro removido com sucesso";
    }


}
