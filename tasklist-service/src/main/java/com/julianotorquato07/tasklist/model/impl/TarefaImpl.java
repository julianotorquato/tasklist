package com.julianotorquato07.tasklist.model.impl;


public abstract class TarefaImpl {

    public abstract Long getIdTarefa();
    
    public Boolean isNovo(){
        return getIdTarefa() == null;
    }
}
