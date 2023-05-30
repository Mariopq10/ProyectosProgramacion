package interfaces;

import javax.swing.JPanel;

import clases.Cliente;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

public class ElementoListaUsuario extends JPanel {
	Ventana ventana;
	Cliente usuarioActual;

	public ElementoListaUsuario(Ventana v, Cliente c) {
		this.ventana = v;
		this.usuarioActual = c;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 64, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelEmail = new JLabel("" + usuarioActual.getEmail());
		labelEmail.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 0;
		add(labelEmail, gbc_labelEmail);

		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel labelUsuario = new JLabel("" + usuarioActual.getNombre());
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 1;
		add(labelUsuario, gbc_labelUsuario);

	}

}
