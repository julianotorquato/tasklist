/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julianotorquato07.tasklist.dao;




import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Juliano Torquato
 * @param <T>
 * @param <I>
 */
public abstract class GenericDao<T, I extends Serializable> {
    @Inject
    protected EntityManager em;
    
    public void salvar(T entity){
        try {
            em.persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T atualizar(T entity){
        try {
            System.out.println("PARAMETROS: ["+entity.toString()+"]");
            return em.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }       
    }
    
    public void remover(T entity){
        try {
            entity = em.merge(entity);
            em.remove(entity);
            System.out.println("PARAMETROS: ["+entity.toString()+"]");
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
       
    public T getById(Class<T> classe, I id){
        T entity = null;
        try {
           entity = em.find(classe, id);
           System.out.println("PARAMETROS: ["+id.toString()+"]");
        } catch (NoResultException e) {
            return null;
        }
        return entity;
    }
    
    public List<T> getAll(Class<T> classe){
         try {
           return em.createQuery("select o from "+ classe.getSimpleName() + " o").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
