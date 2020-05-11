package com.diana.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dianaE.model.TbHisto;

public class HistorialDao {

	public void agregarDatosHistorial(TbHisto his) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("JPA-HIBERNATE-DianaLog");
		em = emf.createEntityManager();
		em.getTransaction().begin();
    	em.persist(his);
		em.flush();
		em.getTransaction().commit();
	}
	
	public List<Object> historial(){
		List<Object> HISTO = new ArrayList();
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("JPA-HIBERNATE-DianaLog");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			HISTO = em.createQuery("SELECT his.id_histo, his.tbUsu.id_usu, his.fechaHisto, "
				                    	+ " usu.nombre_usu, usu.apellido_usu"
					                    + " FROM TbHisto AS his"
					                    + " INNER JOIN TbUsu AS usu ON usu.id_usu =  his.tbUsu.id_usu").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error"+e);
		}
		
		return HISTO;
	}
}
