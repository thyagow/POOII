package visao;

import java.awt.Font;
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

import modelo.Objeto;
import excecoes.ExcecaoEstado;
import excecoes.excecoesMovimento.ExcecaoMovimento;
import interfaces.TrocaDeCenarios;

public class JanelaCenario3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel botaoObjeto;
	private JLabel label;
	private JLabel imagemDeFundo;
	private JLabel botaoRegresso;
	private List<Objeto> listaDeObjetos;
	private List<JLabel> listaDeBotoes;
	private List<Objeto> listaDeObjetosEncontrados;
	private Objeto obj;
	private TrocaDeCenarios cenario3;
	
	
	public JanelaCenario3(List<Objeto> objs, TrocaDeCenarios cenario3) {
		this.imagemDeFundo = new JLabel();
		this.cenario3 = cenario3;
		this.listaDeObjetos = objs;		
		this.listaDeBotoes = new ArrayList<>();
		this.listaDeObjetosEncontrados = new ArrayList<>();
		this.setTitle("Ca�a-Objetos - Cen�rio 3");
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
		imagemDeFundo.setIcon(new ImageIcon("resources" + File.separator + "cenario3edited.jpg"));
		imagemDeFundo.setSize(1066, 800);
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
		botaoObjeto.addMouseListener(new TrataLabelsCenario3());		
	}
	private void criaBotaoRegresso() {
		botaoRegresso = new JLabel("<html><font color = FFFFFF>" + "Sair" + "</font></html>");
		botaoRegresso.setFont(new Font("Arial", Font.BOLD, 15));
		botaoRegresso.setSize(50, 20);
		botaoRegresso.setLocation(1023, 25);
		getContentPane().add(botaoRegresso);
		tratadorBotaoRegresso();
	}
	private void tratadorBotaoRegresso() {
		botaoRegresso.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cenario3.getJogador().irParaMenu();
					dispose();
				} catch (ExcecaoMovimento e1) {					
					e1.printStackTrace();
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
private class TrataLabelsCenario3 implements MouseListener {	
	@Override
	public void mouseClicked(MouseEvent arg0) {			
		botaoObjeto = (JLabel) arg0.getSource();
		botaoObjeto.setEnabled(false);
		try {
			verificaObjetoLigadoAoBotaoPressionado();
		} catch (ExcecaoEstado e) {
			JOptionPane.showMessageDialog(null, "Voc� j� encontrou esse objeto!");
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
		this.setSize(1072, 828);
		//this.setLocation(220, 50);
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
	}
}
