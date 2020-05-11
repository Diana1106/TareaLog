package com.diana.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dianaE.model.TbUsu;

public class UsuaDao {
	
public List<TbUsu> ingresoUsuario(TbUsu usu){
		List<TbUsu> usuario = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("JPA-HIBERNATE-DianaLog");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			usuario = em.createQuery("FROM TbUsu as u where u.usuario = '"+usu.getUsuario()+"' and u.pass ='"+usu.getPass()+"' ").getResultList();
			
			em.getTransaction().commit();
			
			for(TbUsu datosids:usuario) {
				
				usu.setId_usu(datosids.getId_usu());	
				}
			
		} catch (Exception e) {
			System.out.println(e+"Error");
		}
		return usuario;
	}

}
