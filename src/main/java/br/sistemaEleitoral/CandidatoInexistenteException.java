package br.sistemaEleitoral;

public class CandidatoInexistenteException extends Exception{
    public CandidatoInexistenteException(String msg){
        super(msg);
    }
}
