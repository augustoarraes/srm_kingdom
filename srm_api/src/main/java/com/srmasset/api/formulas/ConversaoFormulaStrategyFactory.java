package com.srmasset.api.formulas;

public class ConversaoFormulaStrategyFactory {
	
	public static ConversaoFormulaStrategy getStrategy(String acao) {
        switch (acao) {
            case "PERCENTUAL":
                return new ConversaoPercentual();
            case "FIXO":
                return new ConversaoFixa();
            default:
                return new ConversaoFixa();
        }
    }

}
