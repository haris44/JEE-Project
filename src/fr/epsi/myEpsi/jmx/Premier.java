package fr.epsi.myEpsi.jmx;

public class Premier implements PremierMBean {

	private static String name = "Premier MBEAN";
			private int valeur = 1000;
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getValue() {
		return valeur;
	}

	@Override
	public void setValue(int valeur) {
		this.valeur = valeur;
		
	}

	@Override
	public void refresh() {
		System.out.println("Refresh");
		
	}

}
