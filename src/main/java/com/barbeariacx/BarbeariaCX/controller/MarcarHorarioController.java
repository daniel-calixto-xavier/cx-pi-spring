package com.barbeariacx.BarbeariaCX.controller;

import com.barbeariacx.BarbeariaCX.model.MarcarHorario;
import com.barbeariacx.BarbeariaCX.service.MarcarHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/horario")
public class MarcarHorarioController {

    @Autowired
    MarcarHorarioService marcarHorarioService;

    @GetMapping("/formulario")
    public String marcarHorario() {
        return "marcarHorario";
    }

    @PostMapping("/marcar")
    public String salvarHorario (@ModelAttribute MarcarHorario marcarHorario) {
        marcarHorarioService.salvar(marcarHorario);
        return "redirect:/horario/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        marcarHorarioService.deletar(id);
        return "redirect:/horario/listar";
    }

    @GetMapping("/listar")
    public String listarHorario (Model model) {
        model.addAttribute("horarios", marcarHorarioService.listar());
        return "consultarHorario";
    }
}
