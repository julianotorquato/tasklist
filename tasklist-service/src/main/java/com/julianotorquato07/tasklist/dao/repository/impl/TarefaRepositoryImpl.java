package com.julianotorquato07.tasklist.dao.repository.impl;

import java.util.List;
import com.julianotorquato07.tasklist.dao.GenericDao;
import com.julianotorquato07.tasklist.dao.repository.TarefaRepository;
import com.julianotorquato07.tasklist.model.Tarefa;

public class TarefaRepositoryImpl extends GenericDao<Tarefa, Long> implements TarefaRepository{

    @Override
    public void salvar(Tarefa tarefa) {
        super.salvar(tarefa);
    }
    
    public List<Tarefa> getAll(){
        return super.getAll(Tarefa.class);
    }

    @Override
    public Tarefa getById(Long idTarefa) throws Exception {
        return super.getById(Tarefa.class, idTarefa);
    }

    @Override
    public List<Tarefa> getAllAtivos() throws Exception {
        return em.createQuery("select o from Tarefa o WHERE o.dtRemocao is null").getResultList();
    }
    
}
