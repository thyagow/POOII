package visao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Palavra;
import modelo.PalavraCom3Letras;
import modelo.PalavraCom4Letras;
import modelo.PalavraCom5Letras;
import modelo.PalavraCom6Letras;

public class JanelaJogo extends JFrame {
	
	private JTextField put;
	
	public JanelaJogo(int numPalavras, List<Palavra> palavras) {				
		
				
		criaCaixaDeTexto();
		configuraJanela();
	}
	
	
	

	
	private void criaCaixaDeTexto() {
		put = new JTextField();
		put.setSize(70, 30);
		put.setLocation(250, 50);
		getContentPane().add(put);
		
	}


	private void configuraJanela() {		
		
		this.setTitle("Jogo de Anagramas");		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setSize(400, 800);			
		this.setVisible(true);
		
	}
}
