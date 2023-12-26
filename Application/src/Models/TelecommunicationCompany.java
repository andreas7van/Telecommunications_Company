package Models;

public class TelecommunicationCompany {
		
	private int _Id;
	private String _Name; 
	private String _Telephone;
	private String _Email;
	
	public void setId(int newId) {
		this._Id = newId;
	}
	
	public int getId() {
		return _Id;
	}
	
	public void setName(String newName) {
		this._Name = newName;
	}
	
	public String getName() {
		return _Name;
	}
	
	public void setTelephone(String newTelephone) {
		this._Telephone = newTelephone;
	}
	
	public String getTelephone() {
		return _Telephone;
	}
	
	public void setEmail(String newEmail) {
		this._Email = newEmail;
	}
	
	public String getEmail() {
		return _Email;
	}
	
	public TelecommunicationCompany(int Id, String Name, String Telephone, String Email) {
		this.setId(Id);
		this.setName(Name);
		this.setTelephone(Telephone);
		this.setEmail(Email);
	}
	
}
