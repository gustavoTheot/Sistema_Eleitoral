package br.sistemaEleitoral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaEleitoralMap implements SistemaEleitoralInterface{
    private Map<String, Candidato> candidatos;
    private Map<String, Eleitor> eleitores;
    private List<Voto> votos;

    public SistemaEleitoralMap(Map<String, Candidato> candidatos, Map<String, Eleitor> eleitores, List<Voto> votos) {
        this.candidatos = candidatos;
        this.eleitores = eleitores;
        this.votos = votos;
    }

    public SistemaEleitoralMap(){
        this.candidatos = new HashMap<>();
        this.eleitores = new HashMap<>();
        this.votos = new ArrayList<>();
    }


    public void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException{
        boolean existeEleitor = false;
        for(Eleitor e : this.eleitores.values()){
            if(e.getTitulo().equals(numTitulo)){
                existeEleitor = true;
                break;
            }
        }

        if(existeEleitor){
            for(Candidato c : this.candidatos.values()){
                if(c.getNumbero() == numeroVotado){
                    Voto v = new Voto(numeroVotado);
                    this.votos.add(v);
                }
            }
        }else{
            throw new TituloInexistenteException("Não existe eleito com esse título");
        }

    }

    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException {
        Candidato candidato = this.candidatos.get(nome);

        if(candidato == null){
            throw new CandidatoInexistenteException("Candidato não existe");
        }

        return candidato;
    }

    public int contarVotosParaCandidato(int numero){
        int count = 0;

        for(Voto v : this.votos){
            if(v.getNumeroVotado() == numero){
                count++;
            }
        }

        return count;
    }

    public boolean cadastraCandidato(String nome, int numero, Partido partido) {
        if(candidatos.containsKey(nome)){
            return false;
        }else{
            Candidato c = new Candidato(nome, numero, partido);
            this.candidatos.put(nome, c);
            return true;
        }
    }

    public boolean cadastraEleitores(String nome, String titulo){
        if(eleitores.containsKey(nome)){
            return false;
        }else{
            Eleitor e = new Eleitor(nome, titulo);
            this.eleitores.put(nome, e);
            return true;
        }
    }

    public void tseResultados(){
        for(Candidato c : this.candidatos.values()){
            System.out.println(c + "\nVotos: " + contarVotosParaCandidato(c.getNumbero()) + "\n");
        }
    }
}
