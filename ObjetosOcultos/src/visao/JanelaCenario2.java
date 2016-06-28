package visao;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excecoes.ExcecaoEstado;
import excecoes.excecoesMovimento.ExcecaoMovimento;
import interfaces.TrocaDeCenarios;
import modelo.Objeto;

public class JanelaCenario2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel botaoObjeto;
	private JLabel label;
	private JLabel imagemDeFundo;
	private JLabel botaoRegresso;
	private List<Objeto> listaDeObjetos;
	private List<JLabel> listaDeBotoes;
	private List<Objeto> listaDeObjetosEncontrados;
	private Objeto obj;
	private TrocaDeCenarios cenario2;
	
	
	public JanelaCenario2(List<Objeto> objs, TrocaDeCenarios cenario2) {
		this.imagemDeFundo = new JLabel();
		this.cenario2 = cenario2;
		this.listaDeObjetos = objs;		
		this.listaDeBotoes = new ArrayList<>();
		this.listaDeObjetosEncontrados = new ArrayList<>();
		this.setTitle("Caça-Objetos - Cenário 2");
		this.setLayout(null);	
		this.organizaJanela();
		this.configuraJanela();
	}	
	private void organizaJanela() {
		int auxiliar = 50;
		for (int i = 0; i < listaDeObjetos.size(); i++) {
			obj = listaDeObjetos.get(i);
			criaBotaoObjeto(auxiliar);
			auxiliar += 100;
		}				
		criaEtiquetaObjetosEncontrados();
		criaBotaoRegresso();
		criaImagemFundo();
	}
	private void criaImagemFundo() {
		imagemDeFundo.setIcon(new ImageIcon("resources" + File.separator + "cenario2edited.jpg"));
		imagemDeFundo.setSize(1065, 800);
		getContentPane().add(imagemDeFundo);
	}
	private void criaEtiquetaObjetosEncontrados() {		
		label = new JLabel("Objetos encontrados: "+listaDeObjetosEncontrados.size());
		label.setSize(200, 50);
		label.setLocation(150, 600);
		getContentPane().add(label);
	}	
	private void criaBotaoObjeto(int aux) {		
		botaoObjeto = new JLabel("<html><font color = FFFFFF>" + obj.getNome() + "</font></html>");
		botaoObjeto.setSize(100, 50);
		botaoObjeto.setLocation(200, aux);
		listaDeBotoes.add(botaoObjeto);	
		getContentPane().add(botaoObjeto);
		botaoObjeto.addMouseListener(new TrataLabelsCenario2());		
	}
	private void criaBotaoRegresso() {
		botaoRegresso = new JLabel("<html><font color = FFFFFF>" + "Sair" + "</font></html>");
		botaoRegresso.setFont(new Font("Arial", Font.BOLD, 20));
		botaoRegresso.setSize(100, 20);
		botaoRegresso.setLocation(650, 5);
		getContentPane().add(botaoRegresso);
		tratadorBotaoRegresso();
	}
	private void tratadorBotaoRegresso() {
		botaoRegresso.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					cenario2.getJogador().irParaMenu();
					dispose();
				} catch (ExcecaoMovimento e) {
					e.printStackTrace();
				}				
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}			
		});
	}
private class TrataLabelsCenario2 implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent arg0) {			
		botaoObjeto = (JLabel) arg0.getSource();
		botaoObjeto.setEnabled(false);
		try {
			verificaObjetoLigadoAoBotaoPressionado();
		} catch (ExcecaoEstado e) {
			JOptionPane.showMessageDialog(null, "Você já encontrou esse objeto!");
		}
		label.setText("Objetos encontrados: "+listaDeObjetosEncontrados.size());
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
	private void verificaObjetoLigadoAoBotaoPressionado() throws ExcecaoEstado {
		for (int i = 0; i < listaDeObjetos.size(); i++) {
			obj = listaDeObjetos.get(i);
			if(obj.getNome().equals(botaoObjeto.getText())){			
				obj.getEstado().encontrado();
				listaDeObjetosEncontrados.add(obj);				
			}
		}
	}	
	private void configuraJanela() {
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setSize(1071, 828);
		//this.setLocation(220, 50);
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
}
