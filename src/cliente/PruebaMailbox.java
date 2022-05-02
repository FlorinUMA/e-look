package cliente;

import java.util.Date;
import java.util.LinkedList;
import org.junit.jupiter.api.*;

class PruebaMailbox {
	private static Mailbox correoElectronico;
	private static LinkedList<Email> losCorreos;

	@BeforeAll
	public static void inciarCorreo() {
		losCorreos = new LinkedList<>();
		correoElectronico = new Mailbox();
	}
	
	/**
	 * Generamos para cada test un buzon desordenado
	 */
	@BeforeEach
	void init() {
		losCorreos = generadorCorreos();
	}
	@Test
	void testOrdenacionPorPrioridad() {
		
		correoElectronico.setBefore(new BeforePorPrioridad());
		correoElectronico.show();
		Assertions.assertEquals(buzonOrdenado(new BeforePorPrioridad(), losCorreos), correoElectronico.buzon);
	}

	@Test
	void testOrdenacionPorFecha() {

		correoElectronico.setBefore(new BeforePorFecha());
		correoElectronico.show();
		Assertions.assertEquals(buzonOrdenado(new BeforePorFecha(), losCorreos), correoElectronico.buzon);
	}

	/**
	 * Genera un conjunto de emails para el Mailbox
	 * @return Un clon de la lista de emails de Mailbox
	 */
	private static LinkedList<Email> generadorCorreos() {
		correoElectronico.buzon.add(new Email("Nick", "Compra de codigo", new Date(121, 10, 11), Priority.NORMAL,
				"Te pago un millon de euros por el codigo"));
		correoElectronico.buzon.add(new Email("Carmen", "Invitacion boda", new Date(121, 10, 12), Priority.ALTA, "Te invito a mi boda"));
		correoElectronico.buzon.add(new Email("Karen", "Te voy a demandar", new Date(122, 12, 11), Priority.BAJA,
				"Te voy a demandar por ser tan generoso"));
		correoElectronico.buzon.add(new Email("Florin", "A ver si funciona como debe", new Date(), Priority.NORMAL, "Hellow"));
		return (LinkedList<Email>) correoElectronico.buzon.clone();
	}
	
	/**
	 * Ordena el buzon dado con el criterio especificado
	 * @param filtro El filtro deseado
	 * @param buzon Lista de emails sobre la que actuar
	 * @return Lista de emails ordenada
	 */
	private LinkedList<Email> buzonOrdenado(TipoFiltro filtro, LinkedList<Email> buzon) {
		int tamanyo = buzon.size();
		for (int i = 0; i < tamanyo; i++) {
			for (int j = tamanyo - 1; j > i; j--) {
				if (filtro.before(buzon.get(j), buzon.get(j - 1))) {
					Email e2 = buzon.get(j - 1);
					buzon.set(j - 1, buzon.get(j));
					buzon.set(j, e2);
				}
			}
		}
		return buzon;
	}
}
