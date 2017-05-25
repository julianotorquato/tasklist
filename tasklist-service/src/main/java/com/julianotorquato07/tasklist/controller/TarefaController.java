package com.julianotorquato07.tasklist.controller;

import java.util.List;
import javax.inject.Inject;
import com.commons.javase.date.DateUtils;
import com.commons.javase.object.ObjectUtils;
import com.julianotorquato07.tasklist.common.exception.ExceptionUtils;
import com.julianotorquato07.tasklist.dao.repository.TarefaRepository;
import com.julianotorquato07.tasklist.model.Tarefa;
import com.julianotorquato07.tasklist.service.TarefaService;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;

@Controller
@Path("/tasklist")
public class TarefaController extends AbstractController{
    
    @Inject private TarefaService service;
        
    @Inject private TarefaRepository repository;
    
    @Consumes("application/json")
    @Post("/save")
    public void salvar(Tarefa tarefa){
        service.salvar(tarefa);
    }

    @Get("/list")   
    public void getTarefas() {
        try {
            List<Tarefa> tarefas = repository.getAllAtivos();
            toJson(tarefas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Get("/{idTarefa}")
    public void getTarefa(Long idTarefa)throws Exception{      
        if (ObjectUtils.isZero(idTarefa)) {
            ExceptionUtils.errorParametrosInvalidos();
        }
        
        try {
            Tarefa tarefa= repository.getById(idTarefa);
            toJson(tarefa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Delete("/delete/{idTarefa}")
    public void deletar(Long idTarefa) throws Exception {
        Tarefa tarefa = repository.getById(idTarefa);
        tarefa.setDtConclusao(DateUtils.getDataAtual());
        repository.atualizar(tarefa);
    }
    
    @Consumes("application/json")
    @Put("/edit")
    public void excluirTarefa(Tarefa tarefa) throws Exception {
        if (ObjectUtils.isNuloOuBranco(tarefa) && tarefa.isNovo()) {
            ExceptionUtils.errorParametrosInvalidos();
        }
        
        repository.atualizar(tarefa);
    }
    
}
