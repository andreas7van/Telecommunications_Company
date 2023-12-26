package Models;

import java.time.LocalDate;

public class Contract {
	
	private String _Code;
	private String _Phone;
	private String _ClientVatNumber;
	private int _PlanId;
	private LocalDate _EnableDate;
	private String _Duration;
	private double _Discount;
	private double _Cost;
	private String _Type;
	private String _PaymentMethod;
	private double _CancellationFee;
	private boolean _IsEnabled;
	
	public void setCode(String newCode) {
		this._Code = newCode;
	}
	
	public String getCode() {
		return _Code;
	}
	
	public void setPhone(String newPhone) {
		this._Phone = newPhone;
	}
	
	public String getPhone() {
		return _Phone;
	}
	
	public void setClientVatNumber(String newClientVatNumber) {
		this._ClientVatNumber = newClientVatNumber;
	}
	
	public String getClientVatNumber() {
		return _ClientVatNumber;
	}
	
	public void setPlanId(int newPlanId) {
		this._PlanId = newPlanId;
	}
	
	public int getPlanId() {
		return _PlanId;
	}
	
	public void setEnableDate(LocalDate newEnableDate) {
		this._EnableDate = newEnableDate;
	}
	
	public LocalDate getEnableDate() {
		return _EnableDate;
	}
	
	public void setDuration(String newDuration) {
		this._Duration = newDuration;
	}
	
	public String getDuration() {
		return _Duration;
	}
	
	public void setDiscount(double newDiscount) {
		this._Discount = newDiscount;
	}
	
	public double getDiscount() {
		return _Discount;
	}
	
	public void setCost(double newCost) {
		this._Cost = newCost;
	}
	
	public double getCost() {
		return _Cost;
	}
	
	public void setType(String newType) {
		this._Type = newType;
	}
	
	public String getType() {
		return _Type;
	}
	
	public void setPaymentMethod(String newPaymentMethod) {
		this._PaymentMethod = newPaymentMethod;
	}
	
	public String getPaymentMethod() {
		return _PaymentMethod;
	}
	
	public void setCancellationFee(double newCancellationFee) {
		this._CancellationFee = newCancellationFee;
	}
	
	public double getCancellationFee() {
		return _CancellationFee;
	}
	
	public void setIsEnabled(boolean newIsEnabled) {
		this._IsEnabled = newIsEnabled;
	}
	
	public boolean getIsEnabled() {
		return _IsEnabled;
	}
	
	public Contract( String Code, String Phone, String ClientVatNumber, int PlanId,
			LocalDate EnableDate, String Duration, double Discount, double Cost,
					 String Type, String PaymentMethod, double CancellationFee, boolean IsEnabled) {
		this.setCode(Code);
		this.setPhone(Phone);
		this.setClientVatNumber(ClientVatNumber);
		this.setPlanId(PlanId);
		this.setEnableDate(EnableDate);
		this.setDuration(Duration);
		this.setDiscount(Discount);
		this.setCost(Cost);
		this.setType(Type);
		this.setPaymentMethod(PaymentMethod);
		this.setCancellationFee(CancellationFee);
		this.setIsEnabled(IsEnabled);
		
	}
	
}
