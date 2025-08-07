package com.spring.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entidad.Alumno;
import com.spring.entidad.Auto;

@Transactional
@Service
public class AutoServiceImp implements AutoService , InitializingBean{


    @PersistenceContext
    @Qualifier(value = "entityManager")
    private EntityManager entityManager;

	


	public AutoServiceImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	public AutoServiceImp(){
		
	}
	
	public String mostrar()
    {
        return "Se cargaron las personas";
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("se inicio capa Service");		
	}


	@Override
	public List<Auto> list() {
		return entityManager.createQuery("SELECT c FROM Auto c WHERE c.id LIKE :id")
		.setParameter("id", 1)
		.setMaxResults(10)
		.getResultList();
	}

	@Override
	public void persist(Auto auto) {
		entityManager.persist(auto);
	}

	public EntityManager getEm() {
		return entityManager;
	}

	public void setEm(EntityManager em) {
		this.entityManager = em;
	}
	
	
}
