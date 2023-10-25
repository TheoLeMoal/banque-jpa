package entites;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte{
	private double taux;

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
