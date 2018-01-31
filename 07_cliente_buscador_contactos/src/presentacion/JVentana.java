package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import beans.Contacto;
import modelo.GestorContacto;
import presentacion.adaptadores.AdaptadorTabla;

public class JVentana extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTable tbContactos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVentana frame = new JVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(42, 33, 46, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(108, 30, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorContacto busquedas=new GestorContacto();
				List<Contacto> contactos=busquedas.listContacto(tfNombre.getText());
				AdaptadorTabla adp=new AdaptadorTabla(contactos);
				tbContactos.setModel(adp);
			}
		});
		btnBuscar.setBounds(105, 61, 89, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 107, 341, 124);
		contentPane.add(scrollPane);
		
		tbContactos = new JTable();
		scrollPane.setViewportView(tbContactos);
	}
}
