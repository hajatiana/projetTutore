package entreprise;

//Lylia
@Entity
public class Personne {
	
	private long key;	// clef primaire
	private int age;
	private String nom;
	
	@Id
	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}