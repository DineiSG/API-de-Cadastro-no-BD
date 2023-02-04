package com.example.cadastro.api;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class IndexCad {
    @GetMapping()
    public String get(){
        return "Api de Cadastro";
    }

}
