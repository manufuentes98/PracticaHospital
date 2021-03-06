package listener.combobox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import modelo.Paciente;

public class CitaOperacionNombre implements ActionListener {

	private ParaUI paraUI;

	public CitaOperacionNombre(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String fullNombre = "";
		if (this.paraUI.getCitaOperacion().getComboPaciente().getSelectedItem() != null) {
			fullNombre = this.paraUI.getCitaOperacion().getComboPaciente().getSelectedItem().toString();
			if (fullNombre != null) {
				Paciente paciente = this.paraUI.getControl().getPacienteFullNombre(fullNombre);
				this.paraUI.getCitaOperacion().getComboID().setSelectedItem(paciente.getId());
			}
		}
	}

}
