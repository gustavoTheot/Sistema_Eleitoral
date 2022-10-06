package br.sistemaEleitoral;

public class TesteSistemaEleitoral {

    public static void main(String[] args) {
        SistemaEleitoralMap sem = new SistemaEleitoralMap();

        try{
            sem.cadastraEleitores("Gustavo", "191919");

            sem.cadastraEleitores("Gustavo", "191919");
            sem.cadastraEleitores("Eduarda", "202020");
            sem.cadastraEleitores("Pablo", "101010");


            sem.cadastraCandidato("Luiz Inacio Lula da Silva", 13, Partido.Partio1);
            sem.cadastraCandidato("Ciro Gomes", 12, Partido.Partido2);

            System.out.println(sem.obterDadosDoCandidato("Ciro Gomes"));
            System.out.println("");
            System.out.println(sem.obterDadosDoCandidato("Luiz Inacio Lula da Silva"));

            System.out.println("");
            sem.votar("191919", 13);
            sem.votar("202020", 13);
            sem.votar("101010", 12);


            System.out.println();
            sem.tseResultados();
        }catch (CandidatoInexistenteException | TituloInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
}
