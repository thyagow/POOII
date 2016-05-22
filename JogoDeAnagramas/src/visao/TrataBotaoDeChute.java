package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.rules.Verifier;

import excecoes.ExcecaoPalavraErrada;
import modelo.GerenciadorDeJogos;

public class TrataBotaoDeChute implements ActionListener {
	
	private GerenciadorDeJogos gerenciador;
	private JanelaJogo janela;
	private String chute;
	private boolean resp;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 chute = janela.getChute();
		 resp = gerenciador.verificaChute(chute);
		 janela.respostaBotaoChute(resp);		 
	}

}
