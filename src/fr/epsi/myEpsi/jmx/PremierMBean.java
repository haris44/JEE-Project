package fr.epsi.myEpsi.jmx;

import fr.epsi.myEpsi.beans.Message;

public interface PremierMBean {

	public String getName();
	public int getValue();
	public void setValue(int valeur);
	public void refresh();
	public Integer getNumberFfMessage();
	public void pushAdminMessage(String messageContenu);
}
