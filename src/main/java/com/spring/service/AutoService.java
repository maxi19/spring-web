package com.spring.service;

import java.util.List;

import com.spring.entidad.Alumno;
import com.spring.entidad.Auto;

public interface AutoService {

	public List<Auto> list();
	
	public void persist(Auto auto);
	
}
