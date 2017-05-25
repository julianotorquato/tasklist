package com.julianotorquato07.tasklist.dao.repository;

import java.util.List;
import com.julianotorquato07.tasklist.model.Tarefa;

public interface TarefaRepository {

    public void salvar(Tarefa tarefa) throws Exception;
    
    public List<Tarefa> getAllAtivos() throws Exception;
    
    public Tarefa getById(Long idTarefa) throws Exception;
    
    public void remover(Tarefa tarefa) throws Exception;
    
    public Tarefa atualizar(Tarefa tarefa) throws Exception;
    
}
