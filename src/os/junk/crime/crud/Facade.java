package os.junk.crime.crud;

import os.junk.crime.models.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class Facade {

    @PersistenceContext(unitName = "CRIMEPU")
    private EntityManager em;

    public Organisation getOrganisation(String org_name) {
        return em.createQuery("select m from Organisation as m where m.org_name = '"+org_name+"'",Organisation.class).getSingleResult();
    }

    public Job getJob(String job_name) {
        return em.createQuery("select m from Job as m where m.job_name = '"+job_name+"'",Job.class).getSingleResult();
    }

    public Gangster getGangster(String gangster_name) {
        return em.createQuery("select m from Gangster as m where m.gname = '"+gangster_name+"'",Gangster.class).getSingleResult();
    }

    public List<Policier> getPoliciers(){
        return em.createQuery("select m from Policier as m",Policier.class).getResultList();
    }

    public void persist(Object obj){
        em.persist(obj);
    }

    public void creerPolicier(Policier policier){
        persist(policier);
    }

    public void creerOrganisation(Organisation organisation){
        persist(organisation);
    }

    public void creerGangster(Gangster gangster){
        persist(gangster);
    }

    public void creerJob(Job job){
        persist(job);
    }

    public void deleteOrganisation(String org_name){
        String req = "select m from Organisation as m where m.org_name = '"+org_name+"'";
        Organisation organisation = em.createQuery(req,Organisation.class).getSingleResult();
        em.remove(organisation);
        em.flush();
    }

    public void deleteGangster(String gangster_name){
        String req = "select m from Gangster as m where m.gname = '"+gangster_name+"'";
        Gangster gangster = em.createQuery(req,Gangster.class).getSingleResult();
        em.remove(gangster);
        em.flush();
    }

    public void affectOrganisation(String gansgter_name, String org_name){
        Gangster gangster = getGangster(gansgter_name);
        Organisation organisation = getOrganisation(org_name);

        gangster.setOrganisation(organisation);
        organisation.addGangster(gangster);

        em.merge(gangster);
        em.merge(organisation);
    }

    public void affectBoss(String boss_name, String org_name){
        Gangster gangster = getGangster(boss_name);
        Organisation organisation = getOrganisation(org_name);

        organisation.setBoss(gangster);

        em.merge(gangster);
        em.merge(organisation);
    }

    public void dissocierOrganisation(String gangster_name, String org_name){
        Gangster gangster = getGangster(gangster_name);
        Organisation organisation = getOrganisation(org_name);

        gangster.setOrganisation(null);
        organisation.removeGangster(gangster);

        em.merge(gangster);
        em.merge(organisation);
    }

    public void affectJob(String gangster_name, String job_name, int salaire){
        Gangster gangster = getGangster(gangster_name);
        Job job = getJob(job_name);

        Affectation affectation = new Affectation();
        affectation.setGangster(gangster);
        affectation.setJob(job);
        affectation.setSalary(salaire);

        gangster.addAffectation(affectation);
        job.addAffectation(affectation);

        em.persist(affectation);
        em.merge(gangster);
        em.merge(job);
        em.merge(affectation);
    }


}
