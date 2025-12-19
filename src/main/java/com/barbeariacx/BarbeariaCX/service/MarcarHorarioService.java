package com.barbeariacx.BarbeariaCX.service;

import com.barbeariacx.BarbeariaCX.model.MarcarHorario;
import com.barbeariacx.BarbeariaCX.repository.MarcarHorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcarHorarioService {

    private final MarcarHorarioRepository marcarHorarioRepository;

    public MarcarHorarioService(MarcarHorarioRepository marcarHorarioRepository) {
        this.marcarHorarioRepository = marcarHorarioRepository;
    }

    public MarcarHorario salvar(MarcarHorario marcarHorario) {
        return marcarHorarioRepository.save(marcarHorario);
    }

    public List<MarcarHorario> listar() {
        return marcarHorarioRepository.findAll();
    }

    public void deletar(Long id) {
        MarcarHorario marcarHorario = marcarHorarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Nenhum horário encontrado"));
        marcarHorarioRepository.delete(marcarHorario);
    }

    public MarcarHorario atualizar(Long id, MarcarHorario dadosNovos) {
        MarcarHorario marcarHorario = marcarHorarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Nenhum funcionário encontrado para atualizar!")
        );

        marcarHorario.setNomeCliente(dadosNovos.getNomeCliente());
        marcarHorario.setNomeBarbeiro(dadosNovos.getNomeBarbeiro());
        marcarHorario.setDescricaoCorte(dadosNovos.getDescricaoCorte());
        marcarHorario.setHorario(dadosNovos.getHorario());
        marcarHorario.setDataCorte(dadosNovos.getDataCorte());

        return marcarHorarioRepository.save(marcarHorario);
    }
}
