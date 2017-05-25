package com.julianotorquato07.tasklist.common.properties;

public enum PropertiesKey {
	
	MESSAGE_ERRO_IMPOSSIVEL_EXECUTAR_ACAO("message.erro.impossivelExecutar"),
    MESSAGE_ERRO_PARAMETROS_ENTRADA_INVALIDOS("message.erro.parametrosEntradaIncorretos");

	private String descricao;

	private PropertiesKey(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}