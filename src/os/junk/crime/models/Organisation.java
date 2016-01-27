package os.junk.crime.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CRIME_ORGANISATION")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long org_id;
    @Column(length = 30)
    protected String org_name;
    @Column(length = 30)
    protected String description;
    @Column
    protected float setup_cost;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organisation")
    protected List<Gangster> gangsters;
    @OneToOne
    protected Gangster boss;

    public Organisation() {
    }

    public Organisation(String org_name, String description) {
        this.org_name = org_name;
        this.description = description;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSetup_cost() {
        return setup_cost;
    }

    public void setSetup_cost(float setup_cost) {
        this.setup_cost = setup_cost;
    }

    public List<Gangster> getGangsters() {
        return gangsters;
    }

    public void setGangsters(List<Gangster> gangsters) {
        this.gangsters = gangsters;
    }

    public Gangster getBoss() {
        return boss;
    }

    public void setBoss(Gangster boss) {
        this.boss = boss;
    }

    public void addGangster(Gangster gangster) {
        this.gangsters.add(gangster);
    }

    public void removeGangster(Gangster gangster) {
        this.gangsters.remove(gangster);
    }
}
