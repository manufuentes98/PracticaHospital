package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.plaf.ComboBoxUI;

import modelo.Paciente;
import vista.UI;

public class ParaUI extends UI {

	private Control control;

	public ParaUI() {
		super();
		this.control = new Control();
		listener();
	}

	private void listener() {

		getAltaPaciente().getBtnAceptar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.getAltaPaciente(getAltaPaciente().getInfoPaciente());
			}
		});

		getAltaMedico().getBtnAceptar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		getModificarPaciente().getBtnModificar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = getModificarPaciente().getComboBoxID().getSelectedItem().toString();
//				String nombre = getModificarPaciente().getComboBoxNombre().getSelectedItem().toString();
				String nuevaDireccion = getModificarPaciente().getDireccion();
				String nuevaTelefono = getModificarPaciente().getTelefono();
				if (id != null)
					control.getModificarPaciente(id, "", nuevaDireccion, nuevaTelefono);
			}
		});

		getModificarPaciente().getComboBoxID().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getModificarPaciente().getComboBoxID().getSelectedItem().toString() != null) {
					String id = getModificarPaciente().getComboBoxID().getSelectedItem().toString();
					getModificarPaciente().rellenarCampos(control.getPaciente(id));
				}
			}
		});
		// Para actualizar jcombo
		getItem1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("altaPaciente");
			}
		});

		getItem2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("citaOperacion");
			}
		});

		getItem3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("bajaPaciente");
			}
		});

		getItem4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("altaMedico");
			}
		});

		getItem5().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("consultaMedico");
			}
		});

		getItem6().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("verHistorial");
			}
		});
		getItem7().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("cerrarOperacion");
			}
		});
		getItem8().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Paciente> list = control.getMapPaciente();
				getModificarPaciente().getComboBoxID().removeAllItems();
				getModificarPaciente().getComboBoxNombre().removeAllItems();
				for (Paciente paciente : list.values()) {
					getModificarPaciente().getComboBoxID().addItem(paciente.getId());
					getModificarPaciente().getComboBoxNombre().addItem(paciente.getNombre());
				}
				asociarPanel("modificarPaciente");
			}
		});

	}

}
