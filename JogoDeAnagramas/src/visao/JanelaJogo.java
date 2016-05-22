package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;




import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Palavra;
import modelo.PalavraCom3Letras;
import modelo.PalavraCom4Letras;
import modelo.PalavraCom5Letras;
import modelo.PalavraCom6Letras;

public class JanelaJogo extends JFrame {
	
	private JTextField putChute, put;
	private List<JTextField> listaDeEspacos;
	private JButton chute;
	private JLabel texto;
	private List<Palavra> palavras;
	
	public JanelaJogo(int numPalavras, List<Palavra> palavras) {				
		this.palavras = new ArrayList<Palavra>(palavras);
		listaDeEspacos = new ArrayList<JTextField>();
		setLayout(null);
		criaBotoes();
		criaEtiqueta(palavras);
		criaAreasDeTextoNaoDigitavel();
		criaCaixaDeTexto();		
		configuraJanela();
	}
	
	private void criaEtiqueta(List<Palavra> palavras) {
		texto = new JLabel("Tente acertar todas as palavras para ganhar o jogo!");
		texto.setSize(300, 30);
		texto.setLocation(50, 20);
		getContentPane().add(texto);
		criaEtiquetaComLetras(palavras);
	}
	
	private void criaEtiquetaComLetras(List<Palavra> palavras) {
		String Aux = "";
		String letras = "";
		
		for(Palavra word : palavras){
			if(word instanceof PalavraCom6Letras){
				Aux = word.getPalavra();
				break;
			}
		}
		letras = criaLetrasDica(Aux);
		texto = new JLabel("as letras que devem ser usadas são:  "+letras);
		texto.setSize(450, 30);
		texto.setLocation(30, 50);
		getContentPane().add(texto);
	}
	
	private String criaLetrasDica(String palavra) {
		List<String> letras = Arrays.asList(palavra.split(""));
		Collections.shuffle(letras);
		StringBuilder builder = new StringBuilder(palavra.length());		
		for(String Aux : letras)
			builder.append(" { "+Aux+" } ");			
		return builder.toString();
	}
	
	private void criaAreasDeTextoNaoDigitavel() {
		int AuxH = 150;		
		criaAreasEsquerda(AuxH);		
		criaAreasDireita(AuxH);	
		criaTracos();
	}

	private void criaTracos(){
		for (int j = 0; j < palavras.size(); j++) {
			Palavra word = palavras.get(j);
			put = listaDeEspacos.get(j);
			
			if(word instanceof PalavraCom6Letras)
				put.setText("_ _ _ _ _ _");
			if(word instanceof PalavraCom5Letras)
				put.setText("_ _ _ _ _");
			if(word instanceof PalavraCom4Letras)
				put.setText("_ _ _ _");
			if(word instanceof PalavraCom3Letras)
				put.setText("_ _ _");
		}
	}
	
	private void criaAreasDireita(int AuxH) {
		for (int j = 0; j < palavras.size() / 2; j++) {
			AuxH += 50;
			put = new JTextField();
			put.setSize(100, 30);
			put.setLocation(320, AuxH);
			put.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			put.setEditable(false);
			getContentPane().add(put);
			listaDeEspacos.add(put);
		}		
	}

	private void criaAreasEsquerda(int AuxH) {
		for (int j = 0; j < palavras.size() / 2; j++) {
			AuxH += 50;
			put = new JTextField();
			put.setSize(100, 30);
			put.setLocation(120, AuxH);
			put.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			put.setEditable(false);
			getContentPane().add(put);
			listaDeEspacos.add(put);
		}		
	}
	
	public void respostaBotaoChute(boolean resp) {
		if(getContentPane().getComponentAt(220, 800) == texto)
			getContentPane().remove(texto);
		
		acertouOChute(resp);
		errouOChute(resp);
	}

	private void acertouOChute(boolean resp) {
		if(resp == true){
			texto = new JLabel("Você Acertou! Continue Assim!");
			texto.setSize(150, 30);
			texto.setLocation(220, 800);
			getContentPane().add(texto);
		}
	}

	private void errouOChute(boolean resp) {
		if(resp == false){
			texto = new JLabel("Você Errou. Continue Tentando!");
			texto.setSize(150, 30);
			texto.setLocation(220, 800);
			getContentPane().add(texto);
		}
	}
	
	private void criaBotoes() {
		chute = new JButton("Chutar");
		chute.setSize(80, 30);
		chute.setLocation(240, 100);
		getContentPane().add(chute);
		chute.addActionListener(new TrataBotaoDeChute());
	}
	
	private void criaCaixaDeTexto() {
		putChute = new JTextField();
		putChute.setSize(100, 30);
		putChute.setLocation(120, 100);		
		getContentPane().add(putChute);		
	}
	
	private void configuraJanela() {		
		this.setTitle("Jogo de Anagramas");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setSize(550, 800);			
		this.setVisible(true);		
	}

	public String getChute() {
		return putChute.getText();
	}
	
	
}
