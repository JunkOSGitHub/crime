package os.junk.crime.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CRIME_JOB")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long job_id;
    @Column(length = 30)
    protected String job_name;
    @Column
    protected int score;
    @Column
    protected float setup_cost;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job")
    protected List<Affectation> affectations;

    public Job() {
    }

    public Job(String job_name, int score, float setup_costs) {
        this.job_name = job_name;
        this.score = score;
        this.setup_cost = setup_cost;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getSetup_cost() {
        return setup_cost;
    }

    public void setSetup_cost(float setup_cost) {
        this.setup_cost = setup_cost;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    public void addAffectation(Affectation affectation) {
        this.affectations.add(affectation);
    }
}
