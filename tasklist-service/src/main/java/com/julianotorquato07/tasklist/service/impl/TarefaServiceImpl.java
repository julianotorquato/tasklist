package com.julianotorquato07.tasklist.service.impl;

import java.util.Date;
import javax.inject.Inject;
import com.julianotorquato07.tasklist.dao.repository.TarefaRepository;
import com.julianotorquato07.tasklist.model.Tarefa;
import com.julianotorquato07.tasklist.service.TarefaService;
import com.julianotorquato07.tasklist.util.jpa.Transactional;

public class TarefaServiceImpl implements TarefaService{

    private static final long serialVersionUID = 1L;

    @Inject
    private TarefaRepository tarefaRepository;
    
    @Transactional
    public void salvar(Tarefa tarefa) {
        if (tarefa.isNovo()) {
            tarefa.setDtCriacao(new Date());
        }
        
        try {
            tarefaRepository.salvar(tarefa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
