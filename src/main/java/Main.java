import espacoDeEstados.*;
import estrategiasDeBusca.cega.*;

import java.util.concurrent.TimeUnit;

public class Main {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		//char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
//		char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );

		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);

		long startTime = System.nanoTime();
		BuscaCega busca = new BuscaEmProfundidadeLimitada();
		busca.setInicio(puzzleInicial);
		busca.setObjetivo(puzzleFinal);
		busca.buscar();
		for(Estado e : busca.getCaminhoSolucao()) {
			System.out.println(e);
		}

		long endTime = System.nanoTime();
		long timeDuration = endTime - startTime;
		long ms = TimeUnit.NANOSECONDS.toMillis(timeDuration);

		System.out.println(ms + " ms");
		System.exit(0);
	}
}
