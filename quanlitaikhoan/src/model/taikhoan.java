package model;

public class taikhoan {
	String SoTaiKhoan;
	String hoTenString;
	int SoTien;
	String matKhauString;
	public String getSoTaiKhoan() {
		return SoTaiKhoan;
	}
	public void setSoTaiKhoan(String soTaiKhoan) {
		SoTaiKhoan = soTaiKhoan;
	}
	public String getHoTenString() {
		return hoTenString;
	}
	public void setHoTenString(String hoTenString) {
		this.hoTenString = hoTenString;
	}
	public int getSoTien() {
		return SoTien;
	}
	public void setSoTien(int soTien) {
		SoTien = soTien;
	}
	public String getMatKhauString() {
		return matKhauString;
	}
	public void setMatKhauString(String matKhauString) {
		this.matKhauString = matKhauString;
	}
	public taikhoan(String soTaiKhoan, String hoTenString, int soTien, String matKhauString) {
		super();
		SoTaiKhoan = soTaiKhoan;
		this.hoTenString = hoTenString;
		SoTien = soTien;
		this.matKhauString = matKhauString;
	}
	
}
