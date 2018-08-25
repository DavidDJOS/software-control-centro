package acciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Compra extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JButton botonRegresar;
	private JButton botonAceptar;

	public Compra() {
		super("Compra de material");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 600, 540);

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new TitledBorder(null, "Ingresa los datos para la compra", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelDatos.setBounds(10, 10, 565, 440);
		panelDatos.setLayout(null);
		

		JPanel panelMaterial = new JPanel();
		panelMaterial.setBorder(new TitledBorder(null, "Material", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMaterial.setBounds(15, 20, 263, 200);

		JPanel panelCantidad = new JPanel();
		panelCantidad.setBorder(new TitledBorder(null, "Cantidad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCantidad.setBounds(287, 20, 263, 200);
		
		JPanel panelListaCompra = new JPanel();
		panelListaCompra.setBorder(new TitledBorder(null, "Lista de Materiales Pesados", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelListaCompra.setBounds(15, 230, 535, 200);

		panelPrincipal.add(panelDatos);
		panelDatos.add(panelMaterial);
		panelDatos.add(panelCantidad);
		panelDatos.add(panelListaCompra);
		

		botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});
		botonRegresar.setSize(20, 40);

		botonAceptar = new JButton();
		botonAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		botonAceptar.setSize(20, 40);

		JPanel panelBotones = new JPanel();
		panelBotones.add(botonRegresar, BorderLayout.EAST);
		panelBotones.setBorder(new LineBorder(Color.CYAN));
		panelBotones.setBounds(10, 455, 565, 40);

		
		panelPrincipal.add(panelBotones);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public void Run(boolean visible) {
		new Compra().setVisible(true);
	}
}
