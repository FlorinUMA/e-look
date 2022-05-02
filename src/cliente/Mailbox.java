package cliente;

import java.util.LinkedList;

public class Mailbox {
	private TipoFiltro elFiltro;
	protected LinkedList<Email> buzon = new LinkedList<>();

	public void setBefore(TipoFiltro e) {
		elFiltro = e;
	}

	private boolean before(Email m1, Email m2) {
		return elFiltro.before(m1, m2);
	}

	private void sort() {
		int tamanyo = buzon.size();
		for (int i = 0; i < tamanyo; i++) {
			for (int j = tamanyo - 1; j > i; j--) {
				if (before(buzon.get(j), buzon.get(j - 1))) {
					Email e2 = buzon.get(j - 1);
					buzon.set(j - 1, buzon.get(j));
					buzon.set(j, e2);
				}
			}
		}

	}

	public void show() {
		sort();
	}
}
