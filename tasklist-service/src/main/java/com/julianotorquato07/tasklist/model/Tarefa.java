package com.julianotorquato07.tasklist.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.julianotorquato07.tasklist.model.impl.TarefaImpl;

@Entity
@Table(name="tarefa")
public class Tarefa extends TarefaImpl implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long idTarefa;
    private String titulo;
    private String descricao;
    private Boolean status = Boolean.FALSE;
    private Date dtCriacao;
    private Date dtRemocao;
    private Date dtEdicao;
    private Date dtConclusao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    public Long getIdTarefa() {
        return idTarefa;
    }
    
    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }
    
    @Column(length = 50)
    public String getTitulo() {
        return titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    @Column(name="status_concluido")
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_criacao")
    public Date getDtCriacao() {
        return dtCriacao;
    }
    
    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_remocao")
    public Date getDtRemocao() {
        return dtRemocao;
    }
    
    public void setDtRemocao(Date dtRemocao) {
        this.dtRemocao = dtRemocao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_edicao")
    public Date getDtEdicao() {
        return dtEdicao;
    }
    
    public void setDtEdicao(Date dtEdicao) {
        this.dtEdicao = dtEdicao;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_conclusao")
    public Date getDtConclusao() {
        return dtConclusao;
    }
    
    public void setDtConclusao(Date dtConclusao) {
        this.dtConclusao = dtConclusao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTarefa == null) ? 0 : idTarefa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        if (idTarefa == null) {
            if (other.idTarefa != null)
                return false;
        } else if (!idTarefa.equals(other.idTarefa))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Tarefa [idTarefa=" + idTarefa + ", titulo=" + titulo + ", status=" + status + ", dtCriacao=" + dtCriacao + ", dtRemocao="
                + dtRemocao + ", dtEdicao=" + dtEdicao + ", dtConclusao=" + dtConclusao + "]";
    }    
}
