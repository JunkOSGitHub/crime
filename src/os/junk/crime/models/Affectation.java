package os.junk.crime.models;

import javax.persistence.*;

@Entity
@Table(name = "CRIME_AFFECTATION")
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long affect_id;
    @Column
    protected int salary;
    @ManyToOne
    protected Job job;
    @ManyToOne Gangster gangster;

    public Affectation() {
    }

    public Affectation(int salary, Job job, Gangster gangster) {
        this.salary = salary;
        this.job = job;
        this.gangster = gangster;
    }

    public Long getAffect_id() {
        return affect_id;
    }

    public void setAffect_id(Long affect_id) {
        this.affect_id = affect_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Gangster getGangster() {
        return gangster;
    }

    public void setGangster(Gangster gangster) {
        this.gangster = gangster;
    }
}
