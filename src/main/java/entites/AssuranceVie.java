package entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte{
	private Date datefin;
	private double taux;
	
	/**
	 * @return the datefin
	 */
	public Date getDatefin() {
		return datefin;
	}
	/**
	 * @param datefin the datefin to set
	 */
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}
	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
}
