package br.academico.academico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminTestController {

    @GetMapping("/teste")
    public String getTeste(){
        return "teste";
    }

}
