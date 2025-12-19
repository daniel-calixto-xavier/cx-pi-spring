package com.barbeariacx.BarbeariaCX.service;

import com.barbeariacx.BarbeariaCX.model.Cliente;
import com.barbeariacx.BarbeariaCX.model.Funcionario;
import com.barbeariacx.BarbeariaCX.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    public void deletar(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        funcionarioRepository.delete(funcionario);
    }

    public Funcionario atualizar (Long id, Funcionario dadosNovos) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Nenhum funcionário encontrado para atualizar"));

        funcionario.setNome(dadosNovos.getNome());
        funcionario.setSobrenome(dadosNovos.getSobrenome());
        funcionario.setTelefone(dadosNovos.getTelefone());
        funcionario.setCpf(dadosNovos.getCpf());
        funcionario.setNascimento(dadosNovos.getNascimento());
        funcionario.setEndereco(dadosNovos.getEndereco());
        funcionario.setCep(dadosNovos.getCep());
        funcionario.setCargo(dadosNovos.getCargo());

        return funcionarioRepository.save(funcionario);
    }
}
