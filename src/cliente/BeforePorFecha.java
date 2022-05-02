package cliente;

public class BeforePorFecha implements TipoFiltro{

	@Override
	public boolean before(Email m1, Email m2) {
		return (m1.date.after(m2.date));
	}

}
