package cliente;

public class BeforePorPrioridad implements TipoFiltro{

	@Override
	public boolean before(Email m1, Email m2) {
		return (m1.priority.ordinal() < m2.priority.ordinal());
	}

}
