package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.repositorio.JogadorRepositorio;

@Service
public class JogadorService {

	@Autowired
	JogadorRepositorio repo;
	
	public Jogador salvarJogador(String nome, int idade){
		Jogador j = new Jogador();
		j.setIdade(idade);
		j.setNome(nome);
		repo.save(j);
		return j;
	}
	
	public List<Jogador> getTodosJogadores(){
		return repo.findAll();
	}
	
	public List<Jogador> getJogadoresSemTime(){
		return repo.buscarJogadoresSemTime();
	}
	
	public void removerJogador(Integer id){
		repo.delete(id);
	}
}
