package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acciones.*;
import conexion.ConexionDB;

@SuppressWarnings("serial")
public class PanelMenuPrincipal extends JFrame {

	private JButton compra;
	private JButton venta;
	private JButton modificar;
	private JButton consultar;
	private JButton cerrar;
	private JPanel panelPrincipal;
	Compra compraVista;
	ConexionDB conexionDB = new ConexionDB();

	private boolean EstablecerConexion() {
		boolean conexionEstablecida = conexionDB.conectarBaseDatos();
		return conexionEstablecida;
	}

	public PanelMenuPrincipal() {
		super("::: CENTRO DE ACOPIO ANDALECI ::: Selecciona una operacion");
		setBounds(400, 100, 600, 540);
		setVisible(true);

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		compra = new JButton("COMPRAR");
		compra.setSize(300, 200);
		compra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				compraVista = new Compra();
				compraVista.Run(true);
			}
		});

		venta = new JButton("VENTA");
		venta.setBounds(300, 0, 300, 200);
		venta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Venta ventaVista =  new Venta();
				
			}
		});

		modificar = new JButton("HACER MODIFICACIONES");
		modificar.setBounds(0, 200, 300, 200);

		consultar = new JButton("REALIZAR UNA CONSULTA");
		consultar.setBounds(300, 200, 300, 200);

		cerrar = new JButton("CERRAR");
		cerrar.setBounds(0, 400, 600, 100);
		cerrar.setBackground(Color.RED);
		cerrar.setForeground(Color.WHITE);
		cerrar.setFont(new Font("Thoma", Font.BOLD, 18));
		cerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conexionDB.setOperacionConexion(0);
				System.exit(0);
			}
		});

		panelPrincipal.add(compra);
		panelPrincipal.add(venta);
		panelPrincipal.add(modificar);
		panelPrincipal.add(consultar);
		panelPrincipal.add(cerrar);

	}

	public static void main(String[] args) {
		PanelMenuPrincipal andaleci = new PanelMenuPrincipal();
		if (andaleci.EstablecerConexion() == true) {
			andaleci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
