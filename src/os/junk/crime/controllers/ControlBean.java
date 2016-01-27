package os.junk.crime.controllers;

import os.junk.crime.crud.Facade;
import os.junk.crime.models.Gangster;
import os.junk.crime.models.Job;
import os.junk.crime.models.Organisation;
import os.junk.crime.models.Policier;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name ="controlBean")
@SessionScoped
public class ControlBean {
    @EJB
    Facade facade;
    Policier policier = new Policier();
    Gangster gangster = new Gangster();
    Job job = new Job();
    Organisation organisation = new Organisation();
    List<Policier> policiers = new ArrayList<>();
    String affect_org_gang_nom = "";
    String affect_org_org_nom = "";
    String diss_org_gang_nom = "";
    String diss_org_org_nom = "";
    String affect_job_gang_nom = "";
    String affect_job_job_nom = "";
    int affect_job_salaire = 0;
    String affect_org_chef_nom = "";
    String affect_org_nom = "";

    public void doCreatePolicier(){
        facade.creerPolicier(policier);
        policier = new Policier();
    }

    public void doCreateOrganisation(){
        facade.creerOrganisation(organisation);
        organisation = new Organisation();
    }

    public void doCreateGangster(){
        facade.creerGangster(gangster);
        gangster = new Gangster();
    }

    public void doCreateJob(){
        facade.creerJob(job);
        job = new Job();
    }

    public void doDeleteOrganisation(){
        facade.deleteOrganisation(organisation.getOrg_name());
        organisation = new Organisation();
    }

    public void doDeleteGangster(){
        facade.deleteGangster(gangster.getGname());
        gangster = new Gangster();
    }

    public void doAffectOrganisation(){
        facade.affectOrganisation(affect_org_gang_nom,affect_org_org_nom);
    }

    public void doDissOrganisation(){
        facade.dissocierOrganisation(diss_org_gang_nom,diss_org_org_nom);
    }

    public void doAffectJob(){
        facade.affectJob(affect_job_gang_nom,affect_job_job_nom,affect_job_salaire);
    }

    public void doAffectChefOrganisation(){
        facade.affectBoss(affect_org_chef_nom,affect_org_nom);
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Gangster getGangster() {
        return gangster;
    }

    public void setGangster(Gangster gangster) {
        this.gangster = gangster;
    }

    public Policier getPolicier() {
        return policier;
    }

    public void setPolicier(Policier policier) {
        this.policier = policier;
    }

    public List<Policier> getPoliciers() {
        policiers = facade.getPoliciers();
        return policiers;
    }

    public void setPoliciers(List<Policier> policiers) {
        this.policiers = policiers;
    }

    public String getAffect_org_gang_nom() {
        return affect_org_gang_nom;
    }

    public void setAffect_org_gang_nom(String affect_org_gang_nom) {
        this.affect_org_gang_nom = affect_org_gang_nom;
    }

    public String getAffect_org_org_nom() {
        return affect_org_org_nom;
    }

    public void setAffect_org_org_nom(String affect_org_org_nom) {
        this.affect_org_org_nom = affect_org_org_nom;
    }

    public String getDiss_org_gang_nom() {
        return diss_org_gang_nom;
    }

    public void setDiss_org_gang_nom(String diss_org_gang_nom) {
        this.diss_org_gang_nom = diss_org_gang_nom;
    }

    public String getDiss_org_org_nom() {
        return diss_org_org_nom;
    }

    public void setDiss_org_org_nom(String diss_org_org_nom) {
        this.diss_org_org_nom = diss_org_org_nom;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getAffect_job_gang_nom() {
        return affect_job_gang_nom;
    }

    public void setAffect_job_gang_nom(String affect_job_gang_nom) {
        this.affect_job_gang_nom = affect_job_gang_nom;
    }

    public String getAffect_job_job_nom() {
        return affect_job_job_nom;
    }

    public void setAffect_job_job_nom(String affect_job_job_nom) {
        this.affect_job_job_nom = affect_job_job_nom;
    }

    public void setAffect_job_salaire(int affect_job_salaire) {
        this.affect_job_salaire = affect_job_salaire;
    }

    public int getAffect_job_salaire() {
        return affect_job_salaire;
    }

    public String getAffect_org_chef_nom() {
        return affect_org_chef_nom;
    }

    public void setAffect_org_chef_nom(String affect_org_chef_nom) {
        this.affect_org_chef_nom = affect_org_chef_nom;
    }

    public String getAffect_org_nom() {
        return affect_org_nom;
    }

    public void setAffect_org_nom(String affect_org_nom) {
        this.affect_org_nom = affect_org_nom;
    }
}
