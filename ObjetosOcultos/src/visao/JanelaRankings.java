package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import excecoes.excecoesMovimento.ExcecaoMovimento;
import modelo.cenarios.Rankings;

public class JanelaRankings extends JFrame {

	private static final long serialVersionUID = 1L;
	private Rankings rankings;
	private JButton botaoRegresso;
	
	public JanelaRankings(Rankings rankings) {
		this.rankings = rankings;
		this.setLayout(null);
		this.setTitle("Caça-Objetos - TOP 10 Fodinhas");
		this.criaBotaoRegresso();
		this.configuraJanela();
	}
	private void criaBotaoRegresso() {
		botaoRegresso = new JButton("Voltar");
		botaoRegresso.setSize(100, 50);
		botaoRegresso.setLocation(700, 600);
		getContentPane().add(botaoRegresso);
		tratadorBotaoRegresso();
	}
	private void tratadorBotaoRegresso() {
		botaoRegresso.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					rankings.getJogador().irParaMenu();
					dispose();
				} catch (ExcecaoMovimento e) {				
					e.printStackTrace();
				}				
			}
		});
	}
	private void configuraJanela() {
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setSize(1064, 800);
		this.setLocation(220, 50);
		this.setVisible(true);		
	}
}
