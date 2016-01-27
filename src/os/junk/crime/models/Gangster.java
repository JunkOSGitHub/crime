package os.junk.crime.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CRIME_GANGSTER")
public class Gangster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long gangster_id;
    @Column(length = 30)
    protected String gname;
    @Column(length = 30)
    protected String nickname;
    @Column
    protected int badness;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gangster")
    protected List<Affectation> affectations;
    @ManyToOne
    protected Organisation organisation;

    public Gangster() {
    }

    public Gangster(String gname, String nickname, int badness) {
        this.gname = gname;
        this.nickname = nickname;
        this.badness = badness;
    }

    public Long getGangster_id() {
        return gangster_id;
    }

    public void setGangster_id(Long gangster_id) {
        this.gangster_id = gangster_id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getBadness() {
        return badness;
    }

    public void setBadness(int badness) {
        this.badness = badness;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public void addAffectation(Affectation affectation) {
        this.affectations.add(affectation);
    }
}
