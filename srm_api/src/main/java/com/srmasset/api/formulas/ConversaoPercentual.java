package com.srmasset.api.formulas;

public class ConversaoPercentual implements ConversaoFormulaStrategy{
	
	@Override
    public double calcularConversao(double valorBase, double taxaCambio, double ajuste) {
        return valorBase * taxaCambio * (1 + ajuste / 100);
    }
	
}
