package br.sistemaEleitoral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Testes {

    @Test
    void test(){
        SistemaEleitoralMap sistema = new SistemaEleitoralMap();
        boolean cadastro1 = sistema.cadastraEleitores("Gustavo", "191919");
        assertTrue(cadastro1);
        boolean cadastro2 = sistema.cadastraEleitores("Gustavo", "191919");
        assertFalse(cadastro2);
        assertEquals(false, cadastro2);

        boolean cadastro3 = sistema.cadastraCandidato("Luiz", 13, Partido.Partio1);
        boolean cadastro4 = sistema.cadastraCandidato("Dilma", 14, Partido.Partio1);
        assertTrue(cadastro3);

        try{
            Candidato c = sistema.obterDadosDoCandidato("Dilma");
            assertEquals(14, c.getNumbero());

        }catch ( CandidatoInexistenteException e){
            fail("Não era pra chegar aqui");
        }

        try{
            assertEquals(0 , sistema.contarVotosParaCandidato(14));
            sistema.votar("191919", 14);
            sistema.votar("191919", 14);
            assertEquals(2, sistema.contarVotosParaCandidato(14));
        }catch (TituloInexistenteException e){
            fail("Erro. Existe título, mas algo deu errado");
        }

    }
}
