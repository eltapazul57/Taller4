package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class MostrarTop10 
{
	public MostrarTop10(VentanaJuego vJuego) {
		JFrame popUp = new JFrame();
		popUp.setTitle("Top 10 Mejores Jugadores");
		
		
		Collection<RegistroTop10> registros = vJuego.darTop10().darRegistros();
		
		JList listaTop10 = new JList();
		
		DefaultListModel modelo = new DefaultListModel();
		
		int h=1;
		for (RegistroTop10 registro : registros) {
			modelo.addElement(h+"  "+registro.darNombre()+"  "+registro.darPuntos());
			h++;
		}
	
		listaTop10.setModel(modelo);
		
	    JDialog jd = new JDialog(popUp);
	
	    jd.setLayout(new FlowLayout());
	
	    jd.setBounds(500, 300, 400, 300);
		    
	    JButton jButton = new JButton("Cerrar");
	    jButton.addActionListener((ActionListener) new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            jd.setVisible(false);
	        }
	    });
	
	    jd.add(listaTop10);
	    jd.add(jButton);
	    jd.setVisible(true);
	}
}
