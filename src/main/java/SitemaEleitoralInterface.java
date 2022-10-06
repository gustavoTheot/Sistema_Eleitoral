public interface SitemaEleitoralInterface {
    void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException;
    Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException;
    int contarVotosParaCandidato(int numero);
    boolean cadastraCandidato(String nome, int numero, Partido partido) ;
    boolean cadastraEleitores(String nome, String titulo) ;
    void tseResultados();
}
