package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorVistaGestionMozoAdmin;
import controlador.ControladorVistaGestionMozoOp;
import negocio.Sistema;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;

public class VistaGestionMozoAdmin extends JPanel implements ItemListener, IVistaGestionMozoAdmin {

	JComboBox comboBox;
	ActionListener actionListener = new ControladorVistaGestionMozoOp();
	JButton btnModificaMozo;
	JButton btnEstableceEstado;
	JButton btnElimina;
	JButton btnAltaMozo;

	/**
	 * Create the panel.
	 */
	public VistaGestionMozoAdmin() {
		this.actionListener = new ControladorVistaGestionMozoAdmin ();
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Gestion Mozos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(5, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAltaMozo = new JButton("Alta Mozo");
		btnAltaMozo.setActionCommand("ALTA");
		panel_1.add(btnAltaMozo);
		this.btnAltaMozo.addActionListener(actionListener);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnEstableceEstado = new JButton("Establecer estados");
		panel_2.add(btnEstableceEstado);
		btnEstableceEstado.setActionCommand("ESTABLECE");
		this.btnEstableceEstado.addActionListener(actionListener);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();

		comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.addItem(Sistema.getInstance().getMozos().get("Marti").getNyA());
		comboBox.addItem(Sistema.getInstance().getMozos().get("Valen").getNyA());
		comboBox.addItem(Sistema.getInstance().getMozos().get("Pau").getNyA());
		comboBox.addItemListener(this);

		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGap(44)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(182, Short.MAX_VALUE)));
		gl_panel_4
				.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup().addContainerGap().addComponent(comboBox,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(59, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		JLabel lblSeleccionaMozo = new JLabel("Seleccione Mozo");
		lblSeleccionaMozo.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(102).addComponent(lblSeleccionaMozo)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel_4, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(5).addComponent(panel_4, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup().addGap(19).addComponent(lblSeleccionaMozo)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		btnModificaMozo = new JButton("Modificar Mozo");
		panel_5.add(btnModificaMozo);
		btnModificaMozo.setActionCommand("MODIFICA");
		// btnModificaMozo.addActionListener(this.actionListener);
		this.btnModificaMozo.addActionListener(actionListener);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		btnElimina = new JButton("Eliminar Mozo");
		btnElimina.setActionCommand("ELIMINA");
		panel_6.add(btnElimina);
		this.btnElimina.addActionListener(actionListener);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == comboBox) {
			String seleccionado = (String) comboBox.getSelectedItem();
			// JOptionPane.showMessageDialog(null, "Ha seleccionado "+seleccionado);
			// comboBox.setSelectedItem(comboBox.getSelectedItem());
		}

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
		this.btnModificaMozo.addActionListener(actionListener);
		this.btnEstableceEstado.addActionListener(actionListener);
		this.btnAltaMozo.addActionListener(actionListener);
		this.btnElimina.addActionListener(actionListener);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	

}