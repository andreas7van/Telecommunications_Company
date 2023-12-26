package Models;

public class LandlinePlan extends Plan{
	
	private String _LineSpeed;
	private String _LineType;
	
	public void setLineSpeed(String newLineSpeed) {
		this._LineSpeed = newLineSpeed;
	}
	
	public String getLineSpeed() {
		return _LineSpeed;
	}
	
	public void setLineType(String newLineType) {
		this._LineType = newLineType;
	}
	
	public String getLineType() {
		return _LineType;
	}
	
	public LandlinePlan(int Id, int TelecommunicationCompanyId, int FreeCallTime, int Cost, String LineSpeed, String LineType) {
		super(Id, TelecommunicationCompanyId, FreeCallTime, Cost);
		
		this.setLineSpeed(LineSpeed);
		this.setLineType(LineType);
		
	}
}
