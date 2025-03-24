package com.srmasset.api.formulas;

public interface ConversaoFormulaStrategy {
	double calcularConversao(double valorBase, double taxaCambio, double ajuste);
}
