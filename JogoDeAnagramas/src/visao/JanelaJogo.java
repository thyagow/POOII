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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Palavra;
import modelo.PalavraCom3Letras;
import modelo.PalavraCom4Letras;
import modelo.PalavraCom5Letras;
import modelo.PalavraCom6Letras;

public class JanelaJogo extends JFrame {
	
	private JTextField put;
	private JTextField putChute;
	private List<JTextField> listaDeEspacos;
	private List<JButton> listaDeBotoes;
	private JButton chute;
	private JLabel texto;
	private List<Palavra> palavras;
	private boolean resp;
	
	public JanelaJogo(int numPalavras, List<Palavra> palavras) {				
		this.palavras = new ArrayList<Palavra>(palavras);
		listaDeEspacos = new ArrayList<JTextField>();
		listaDeBotoes = new ArrayList<JButton>();
	}
	
	public void criaJanelaBotoesEstrategia() {
		setLayout(null);
		criaBotoes();
		configuraJanela();
	}

	private void criaBotoes() {	
		botao1();
		botao2();
		botao3();
		botao4();
		botao5();
		botao6();
		botao7();
		botao8();
		botao9();
	}

	private void botao9() {
		chute = new JButton("Jogo 9");
		chute.setSize(100, 50);
		chute.setLocation(290, 650);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);
	}

	private void botao8() {
		chute = new JButton("Jogo 8");
		chute.setSize(100, 50);
		chute.setLocation(290, 450);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	private void botao7() {
		chute = new JButton("Jogo 7");
		chute.setSize(100, 50);
		chute.setLocation(290, 250);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	private void botao6() {
		chute = new JButton("Jogo 6");
		chute.setSize(100, 50);
		chute.setLocation(290, 50);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	private void botao5() {
		chute = new JButton("Jogo 5");
		chute.setSize(100, 50);
		chute.setLocation(110, 650);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	private void botao4() {
		chute = new JButton("Jogo 4");
		chute.setSize(100, 50);
		chute.setLocation(110, 450);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	private void botao3() {
		chute = new JButton("Jogo 3");
		chute.setSize(100, 50);
		chute.setLocation(110, 250);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	private void botao2() {
		chute = new JButton("Jogo 2");
		chute.setSize(100, 50);
		chute.setLocation(110, 50);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	private void botao1() {
		chute = new JButton("Jogo 1");
		chute.setSize(100, 50);
		chute.setLocation(200, 350);
		listaDeBotoes.add(chute);
		getContentPane().add(chute);		
	}

	public void criaJanelaJogo(List<Palavra> palavras) {
		setLayout(null);		
		criaEtiqueta(palavras);
		criaAreasDeTextoNaoDigitavel();
		criaCaixaDeTexto();		
		configuraJanela();
	}
	
	private void criaEtiqueta(List<Palavra> palavras) {
		texto = new JLabel("- Tente acertar todas as palavras para ganhar o jogo!");
		texto.setSize(300, 30);
		texto.setLocation(80, 20);
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
		texto = new JLabel("- As letras que devem ser usadas são:  "+letras);
		texto.setSize(450, 30);
		texto.setLocation(80, 50);
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
			put.setLocation(290, AuxH);
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
			put.setLocation(90, AuxH);
			put.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			put.setEditable(false);
			getContentPane().add(put);
			listaDeEspacos.add(put);
		}		
	}
	
private class TrataBotaoDeChute implements ActionListener {		
	
	public void actionPerformed(ActionEvent e) {			
		for (int i = 0; i < palavras.size(); i++) {
			resp = false;			
			if(palavras.get(i).equals(putChute.getText())){
				listaDeEspacos.get(i).setText(putChute.getText());
				resp = true;
				break;
			}
		}	
		if(getContentPane().getComponentAt(220, 150) == texto)
			getContentPane().remove(texto);
	
		if(resp == false){
			JOptionPane.showMessageDialog(null, "Você Errou. Continue Tentando!");
		}
	}
}

	private void criaCaixaDeTexto() {
		putChute = new JTextField();
		putChute.setSize(100, 30);
		putChute.setLocation(190, 100);		
		getContentPane().add(putChute);
		putChute.addActionListener(new TrataBotaoDeChute());
	}
	
	private void configuraJanela() {		
		this.setTitle("Jogo de Anagramas");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setSize(500, 800);
		this.setLocation(420, 50);
		this.setVisible(true);		
	}
}
