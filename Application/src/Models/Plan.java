package Models;

public class Plan {

	private int _Id;
	private int _TelecommunicationCompanyId;
	private int _FreeCallTime;
	private int _Cost;
	
	public void setId(int newId) {
		this._Id = newId;
	}
	
	public int getId() {
		return _Id;
	}
	
	public void setTelecommunicationCompanyId(int newTelecommunicationCompanyId) {
		this._TelecommunicationCompanyId = newTelecommunicationCompanyId;
	}
	
	public int getTelecommunicationCompanyId() {
		return _TelecommunicationCompanyId;
	}
	
	public void setFreeCallTime(int newFreeCallTime) {
		this._FreeCallTime = newFreeCallTime;
	}
	
	public int getFreeCallTime() {
		return _FreeCallTime;
	}
	
	public void setCost(int newCost) {
		this._Cost = newCost;
	}
	
	public int getCost() {
		return _Cost;
	}
	
	public Plan(int Id, int TelecommunicationCompanyId, int FreeCallTime, int Cost) {
		this.setId(Id);
		this.setTelecommunicationCompanyId(TelecommunicationCompanyId);
		this.setFreeCallTime(FreeCallTime);
		this.setCost(Cost);
	}
	
}
