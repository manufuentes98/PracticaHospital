package control;

import java.util.HashMap;

import javax.swing.JComboBox;

import listener.btn.ActionAltaMedico;
import listener.btn.ActionAltaPaciente;
import listener.btn.ActionBajaPaciente;
import listener.btn.ActionModificarPaciente;
import listener.combobox.BajaPacienteID;
import listener.combobox.ConsultaMedicoID;
import listener.combobox.ConsultarPacienteID;
import listener.combobox.ModificarPacientesID;
import listener.item.ActionItemAltaPaciente;
import listener.item.ActionItemCitaOperacion;
import listener.item.ActionItemBajaPaciente;
import listener.item.ActionItemConsultaMedico;
import listener.item.ActionItemAltaMedico;
import listener.item.ActionItemVerHistorial;
import listener.item.ActionItemCerrarOperacion;
import listener.item.ActionItemModificarPaciente;
import listener.item.ActionItemConsultaPaciente;
import listener.item.ActionItemCitaEspecialista;
import listener.item.ActionItemAtenderCita;
import listener.item.ActionItemCitaPrimaria;
import modelo.Medico;
import modelo.Paciente;

import vista.UI;

public class ParaUI extends UI {

	private Control control;
	public ParaUI() {
		super();
		this.control = new Control();
		// actionlistener cambiar pesta�a
		getItemAltaPaciente().addActionListener(new ActionItemAltaPaciente(this));
		getItemCitaOperacion().addActionListener(new ActionItemCitaOperacion(this));
		getItemBajaPaciente().addActionListener(new ActionItemBajaPaciente(this));
		getItemConsultaMedico().addActionListener(new ActionItemConsultaMedico(this));
		getItemAltaMedico().addActionListener(new ActionItemAltaMedico(this));
		getItemVerHistorial().addActionListener(new ActionItemVerHistorial(this));
		getItemCerrarOperacion().addActionListener(new ActionItemCerrarOperacion(this));
		getItemModificarPaciente().addActionListener(new ActionItemModificarPaciente(this));
		getItemConsultaPaciente().addActionListener(new ActionItemConsultaPaciente(this));
		getItemCitaEspecialista().addActionListener(new ActionItemCitaEspecialista(this));
		getItemAtenderCita().addActionListener(new ActionItemAtenderCita(this));
		getItemCitaPrimaria().addActionListener(new ActionItemCitaPrimaria(this));
		// actionlistener botones
		getAltaPaciente().getBtnAceptar().addActionListener(new ActionAltaPaciente(this));
		getModificarPaciente().getBtnModificar().addActionListener(new ActionModificarPaciente(this));
		getAltaMedico().getBtnAceptar().addActionListener(new ActionAltaMedico(this));
		getBajaPaciente().getBtnAceptar().addActionListener(new ActionBajaPaciente(this));
		// actionlistener combobox
		getModificarPaciente().getComboBoxID().addActionListener(new ModificarPacientesID(this));
<<<<<<< HEAD
		getConsultaMedico().getComboId().addActionListener(new ConsultaMedicoID(this));

=======
		getConsultaMedico().getComboBoxID().addActionListener(new ConsultaMedicoID(this));
		getBajaPaciente().getComboBoxID().addActionListener(new BajaPacienteID(this));
		getConsultaPaciente().getComboBoxID().addActionListener(new ConsultarPacienteID(this));
>>>>>>> branch 'master' of https://github.com/powerswitchsa/PracticaHospital.git
	}

	public void rellenarComboBoxPaciente(JComboBox id, JComboBox nombre) {
		nombre.removeAllItems();
		id.removeAllItems();
		HashMap<String, Paciente> list = getControl().getMapPaciente();
		for (Paciente paciente : list.values()) {
			id.addItem(paciente.getId());
			nombre.addItem(paciente.getFullName());
		}
	}

	public void rellenarComboBoxMedico(JComboBox id, JComboBox nombre) {
		nombre.removeAllItems();
		id.removeAllItems();
		HashMap<String, Medico> list = getControl().getMapMedico();
		for (Medico medico : list.values()) {
			id.addItem(medico.getId());
			nombre.addItem(medico.getNombre());
		}
	}

	public Control getControl() {
		return control;
	}
}
