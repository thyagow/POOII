package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excecoes.excecoesMovimento.ExcecaoMovimento;
import modelo.cenarios.Menu;

public class JanelaMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Menu menu;
	private JButton botaoSair;
	private JButton botaoRankings;
	private JButton botaoCenario1, botaoCenario2, botaoCenario3;
	
	public JanelaMenu(Menu menu) {
		this.menu = menu;
		this.setLayout(null);
		this.setTitle("Caça-Objetos - Menu Inicial");
		this.criaBotaoSair();
		this.criaBotaoRankings();
		this.criaBotoesCenarios();
		this.configuraJanela();
	}	
	private void criaBotoesCenarios() {
		criaBotaoCenario1();
		criaBotaoCenario2();
		criaBotaoCenario3();
	}
	private void criaBotaoCenario3() {
		botaoCenario3 = new JButton("Cenário 3");
		botaoCenario3.setSize(100, 50);
		botaoCenario3.setLocation(300, 400);
		getContentPane().add(botaoCenario3);
		tratadorBotaoCenario3();
	}
	private void tratadorBotaoCenario3() {
		botaoCenario3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					menu.getJogador().irParaCenario3();
					dispose();
				} catch (ExcecaoMovimento e) {					
					e.printStackTrace();
				}				
			}
		});
	}
	private void criaBotaoCenario2() {
		botaoCenario2 = new JButton("Cenário 2");
		botaoCenario2.setSize(100, 50);
		botaoCenario2.setLocation(400, 200);
		getContentPane().add(botaoCenario2);
		tratadorBotaoCenario2();		
	}
	private void tratadorBotaoCenario2() {
		botaoCenario2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					menu.getJogador().irParaCenario2();
					dispose();
				} catch (ExcecaoMovimento e) {					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO");
				}				
			}
		});
	}
	private void criaBotaoCenario1() {
		botaoCenario1 = new JButton("Cenário 1");
		botaoCenario1.setSize(100, 50);
		botaoCenario1.setLocation(200, 200);
		getContentPane().add(botaoCenario1);
		tratadorBotaoCenario1();
	}
	private void tratadorBotaoCenario1() {
		botaoCenario1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					menu.getJogador().irParaCenario1();
					dispose();
				} catch (ExcecaoMovimento e) {					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO");
				}				
			}
		});
	}
	private void criaBotaoRankings() {
		botaoRankings = new JButton("Ver Rankings");
		botaoRankings.setSize(200, 50);
		botaoRankings.setLocation(700, 200);
		getContentPane().add(botaoRankings);
		tratadorBotaoRankings();			
	}
	private void tratadorBotaoRankings() {
		botaoRankings.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					menu.getJogador().irParaRankings();
					dispose();
				} catch (ExcecaoMovimento e) {					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO");
				}				
			}		
		});
	}
	private void criaBotaoSair() {
		botaoSair = new JButton("Sair do Jogo");
		botaoSair.setSize(200, 50);
		botaoSair.setLocation(700, 600);
		getContentPane().add(botaoSair);
		tratadorBotaoDeSair();		
	}
	private void tratadorBotaoDeSair() {
		botaoSair.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
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
