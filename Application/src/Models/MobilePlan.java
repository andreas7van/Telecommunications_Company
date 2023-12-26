package Models;

public class MobilePlan extends Plan {

	private int _FreeSMS;
	private int _FreeGB;
	
	public void setFreeSMS(int newFreeSMS) {
		this._FreeSMS = newFreeSMS;
	}
	
	public int getFreeSMS() {
		return _FreeSMS;
	}
	
	public void setFreeGB(int newFreeGB) {
		this._FreeGB = newFreeGB;
	}
	
	public int getFreeGB() {
		return _FreeGB;
	}
	
	public MobilePlan(int Id, int TelecommunicationCompanyId, int FreeCallTime, int Cost, int FreeSMS, int FreeGB) {
		super(Id, TelecommunicationCompanyId, FreeCallTime, Cost);
		
		this.setFreeGB(FreeGB);
		this.setFreeSMS(FreeSMS);
		
	}

}
