package com.barbeariacx.BarbeariaCX.service;

import com.barbeariacx.BarbeariaCX.model.Cliente;
import com.barbeariacx.BarbeariaCX.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public void deletar(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Cliente não encontrado"
                )
        );
        clienteRepository.delete(cliente);
    }

    public Cliente atualizar (Long id, Cliente dadosNovos) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Nenhum cliente encontrado para atualizar"));

        cliente.setNome(dadosNovos.getNome());
        cliente.setSobrenome(dadosNovos.getSobrenome());
        cliente.setTelefone(dadosNovos.getTelefone());
        cliente.setCpf(dadosNovos.getCpf());
        cliente.setEndereco(dadosNovos.getEndereco());
        cliente.setCep(dadosNovos.getCep());

        return clienteRepository.save(cliente);
    }
}
