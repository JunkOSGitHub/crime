package os.junk.crime.crud;

import os.junk.crime.models.Gangster;
import os.junk.crime.models.Organisation;
import os.junk.crime.models.Policier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CRUDManager{

    EntityManager em;

    private static class CRUDManagerSingleton {
        private final static CRUDManager INSTANCE = new CRUDManager();
    }

    public static CRUDManager getInstance(){
        return CRUDManagerSingleton.INSTANCE;
    }

    private EntityManagerFactory emf;

    private CRUDManager(){
        emf = Persistence.createEntityManagerFactory("CrimePU");
    }

    public void persist(Object obj){
        try {
            em.persist(obj);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    public void creerPolicier(Policier policier){
        em = emf.createEntityManager();
        em.getTransaction().begin();

        persist(policier);
    }

    public List<Policier> getPoliciers(){
        emf.getCache().evictAll();
        em = emf.createEntityManager();
        String req = "select p from Policier as p";
        List<Policier> policiers = new ArrayList<>();
        try {
            policiers = em.createQuery(req,Policier.class).getResultList();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return policiers;
    }

    public Organisation getOrganisation(String org_name){
        em = emf.createEntityManager();
        String req = "select m from Organisation as m where m.org_name = '"+org_name+"'";
        Organisation organisation = new Organisation();
        try {
            organisation = em.createQuery(req,Organisation.class).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return organisation;
    }

    public void creerOrganisation(Organisation organisation){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        persist(organisation);
    }

    public void deleteOrganisation(String org_name){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        String req = "select m from Organisation as m where m.org_name = '"+org_name+"'";
        try {
            Organisation organisation = em.createQuery(req,Organisation.class).getSingleResult();
            em.remove(organisation);
            em.flush();
            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    public Gangster getGangster(String gangster_name){
        em = emf.createEntityManager();
        String req = "select m from Gangster as m where m.gname = '"+gangster_name+"'";
        Gangster gangster = new Gangster();
        try {
            gangster = em.createQuery(req,Gangster.class).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return gangster;
    }

    public void creerGangster(Gangster gangster){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        persist(gangster);
    }

    public void deleteGangster(String gangster_name){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        String req = "select m from Gangster as m where m.gname = '"+gangster_name+"'";
        try {
            Gangster gangster = em.createQuery(req,Gangster.class).getSingleResult();
            em.remove(gangster);
            em.flush();
            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}

