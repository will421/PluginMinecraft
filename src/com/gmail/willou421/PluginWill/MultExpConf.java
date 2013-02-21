package com.gmail.willou421.PluginWill;

import org.w3c.dom.Element;

public class MultExpConf {

	
	public MultExpConf(Element el){
		
		coeff = Integer.parseInt(el.getElementsByTagName("coeff").item(0).getTextContent());
	}
	
	private int coeff;

	public int getCoeff() {
		return coeff;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	
}
