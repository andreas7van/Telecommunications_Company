package Models;

public class Client {
	
	private String _IdentityNumber;
	private String _VatNumber;
	private String _Name;
	private String _ClientType;
	private String _Address;
	private String _Email;
	private String _Phone;
	
	public void setIdentityNumber(String newIdentityNumber) {
		this._IdentityNumber = newIdentityNumber;
	}
	
	public String getIdentityNumber() {
		return _IdentityNumber;
	}
	
	public void setVatNumber(String newVatNumber) {
		this._VatNumber = newVatNumber;
	}
	
	public String getVatNumber() {
		return _VatNumber;
	}
	
	public void setName(String newName) {
		this._Name = newName;
	}
	
	public String getName() {
		return _Name;
	}
	
	public void setClientType(String newClientType) {
		this._ClientType = newClientType;
	}
	
	public String getClientType() {
		return _ClientType;
	}
	
	public void setAddress(String newAddress) {
		this._Address = newAddress;
	}
	
	public String getAddress() {
		return _Address;
	}
	
	public void setEmail(String newEmail) {
		this._Email = newEmail;
	}
	
	public String getEmail() {
		return _Email;
	}
	
	public void setPhone(String newPhone) {
		this._Phone = newPhone;
	}
	
	public String getPhone() {
		return _Phone;
	}
	
	public Client(String IdentityNumber, String VatNumber, String Name, String ClientType,
			String Address, String Email, String Phone) {
		this.setIdentityNumber(IdentityNumber);
		this.setVatNumber(VatNumber);
		this.setName(Name);
		this.setClientType(ClientType);
		this.setAddress(Address);
		this.setEmail(Email);
		this.setPhone(Phone);
	}
}
