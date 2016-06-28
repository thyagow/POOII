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

public class JanelaCenario1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel botaoObjeto;
	private JLabel label;
	private JLabel imagemDeFundo;
	private JLabel botaoRegresso;
	private List<Objeto> listaDeObjetos;
	private List<JLabel> listaDeBotoes;
	private List<Objeto> listaDeObjetosEncontrados;
	private Objeto obj;
	private TrocaDeCenarios cenario1;
	
	
	public JanelaCenario1(List<Objeto> objs, TrocaDeCenarios cenario1) {
		imagemDeFundo = new JLabel();
		this.cenario1 = cenario1;
		this.listaDeObjetos = objs;
		this.listaDeBotoes = new ArrayList<>();
		this.listaDeObjetosEncontrados = new ArrayList<>();
		this.setLayout(null);
		this.setTitle("Caça-Objetos - Cenário 1");
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
		imagemDeFundo.setIcon(new ImageIcon("resources" + File.separator + "cenario1edited.jpg"));
		imagemDeFundo.setSize(1064, 800);
		getContentPane().add(imagemDeFundo);
	}
	private void criaEtiquetaObjetosEncontrados() {		
		label = new JLabel("Objetos encontrados: "+listaDeObjetosEncontrados.size());
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setSize(500, 50);
		label.setLocation(700, 700);
		getContentPane().add(label);
	}
	private void criaBotaoObjeto(int aux) {		
		botaoObjeto = new JLabel("<html><font color = FFFFFF>" + obj.getNome() + "</font></html>");
		botaoObjeto.setSize(100, 50);
		botaoObjeto.setLocation(200, aux);
		listaDeBotoes.add(botaoObjeto);	
		getContentPane().add(botaoObjeto);
		botaoObjeto.addMouseListener(new TrataLabelsCenario1());		
	}	
	private void criaBotaoRegresso() {
		botaoRegresso = new JLabel("<html><font color = FFFFFF>" + "Sair" + "</font></html>");
		botaoRegresso.setFont(new Font("Arial", Font.BOLD, 20));
		botaoRegresso.setSize(100, 50);
		botaoRegresso.setLocation(50, 745);
		getContentPane().add(botaoRegresso);
		tratadorBotaoRegresso();
	}
	private void tratadorBotaoRegresso() {
		botaoRegresso.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					cenario1.getJogador().irParaMenu();
					dispose();		
				} catch (ExcecaoMovimento e) {				
					e.printStackTrace();
				}						
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}			
		});
	}
private class TrataLabelsCenario1 implements MouseListener {
		
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
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
	public void verificaObjetoLigadoAoBotaoPressionado() throws ExcecaoEstado {
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
		this.setSize(1070, 828);
		//this.setLocation(220, 50);
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
	}
}
