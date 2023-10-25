package entites;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "virement")
public class Virement extends Operation{
	private String benificiaire;

	/**
	 * @return the benificiaire
	 */
	public String getBenificiaire() {
		return benificiaire;
	}

	/**
	 * @param benificiaire the benificiaire to set
	 */
	public void setBenificiaire(String benificiaire) {
		this.benificiaire = benificiaire;
	}
}
