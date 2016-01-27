package os.junk.crime.models;

import javax.persistence.*;

@Entity
@Table(name = "CRIME_POLICIER")
public class Policier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long policier_id;
    @Column(length = 30)
    protected String nom;
    @Column(length = 30)
    protected String prenom;
    @Column(length = 30)
    protected String grade;

    public Policier() {
    }

    public Policier(String nom, String prenom, String grade) {
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }

    public Long getPolicier_id() {
        return policier_id;
    }

    public void setPolicier_id(Long policier_id) {
        this.policier_id = policier_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
