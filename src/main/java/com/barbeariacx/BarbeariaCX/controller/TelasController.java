package com.barbeariacx.BarbeariaCX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/telaInicial")
public class TelasController {
    @GetMapping("/pagina")
    public String pagina() {
        return "telaCliente";
    }

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return"cadastro";
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return"consultarUsuarios";
    }

    @GetMapping("/consultarHorario")
    public String consultarHorario() {
        return"consultarHorario";
    }

    @GetMapping("/marcarHorario")
    public String marcarHorario() {
        return"marcarHorario";
    }

}
