package cliente;

import java.util.Date;

public class Email {
	protected String from;
	protected String subject;
	protected Date date;
	protected Priority priority;
	private String text;

	public Email(String origen, String asunto, Date fecha, Priority prioridad, String texto) {
		from = origen;
		subject = asunto;
		date = fecha;
		priority = prioridad;
		text = texto;
	}

	@Override
	public String toString() {
		return ("Asunto: " + subject + ". \n" + "Prioridad: " + priority + ". \n" + "De: " + from + ". \n" + "Fecha: "
				+ date + "\n" + "Mensaje: \n" + text);
	}

	@Override
	public boolean equals(Object o) {
		Email elEmail = (o instanceof Email) ? (Email) o : null;
		return (elEmail.from.equalsIgnoreCase(from) && elEmail.subject.equalsIgnoreCase(subject) && elEmail.date.equals(date)
				&& elEmail.priority.equals(priority) && elEmail.text.equals(text));
	}

}
