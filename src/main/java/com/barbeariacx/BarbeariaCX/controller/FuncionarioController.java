package com.barbeariacx.BarbeariaCX.controller;

import com.barbeariacx.BarbeariaCX.model.Funcionario;
import com.barbeariacx.BarbeariaCX.service.ClienteService;
import com.barbeariacx.BarbeariaCX.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/formulario")
    public String abrirFormulario() {
        return "cadastroFuncionario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionario/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("funcionarios", funcionarioService.listar());
        return "listarFuncionarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return "redirect:/funcionario/listar";
    }

}
