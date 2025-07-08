package server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.taikhoan;

public class server_tk {
	// Hiển thị tất cả thông tin tài khoản
	public ArrayList<taikhoan> laythongtin() throws ClassNotFoundException, SQLException {
		DungChung mChung = new DungChung();
		mChung.ketnoi();
		String sqlString = "SELECT * FROM taikhoan";
		PreparedStatement p = mChung.cnn.prepareStatement(sqlString); // Truyền câu lệnh sql
		ResultSet kq = p.executeQuery(); // Nhân kết quả

		ArrayList<taikhoan> list = new ArrayList<taikhoan>();
		while (kq.next()) {
			String stk = kq.getString("SoTaiKhoan");
			String HoTen = kq.getString("HoTen");
			int SoTien = kq.getInt("SoTien");
			String MatKhau = kq.getString("MatKhau");
			list.add(new taikhoan(stk, HoTen, SoTien, MatKhau));
		}
		return list;
	}

	public String suaTK(String stk, String HoTen, int SoTien, String MatKhau)
			throws ClassNotFoundException, SQLException {
		DungChung mChung = new DungChung();
		mChung.ketnoi();
		String sql = "UPDATE taikhoan SET HoTen=?,SoTien=?,MatKhau=? where SoTaiKhoan=?";
		PreparedStatement p = mChung.cnn.prepareStatement(sql);
		p.setString(1, HoTen);
		p.setInt(2, SoTien);
		p.setString(3, MatKhau);
		p.setString(4, stk);
		int kq = p.executeUpdate(); // lưu thông tin vào sql nếu kq>0 sửa thành công ngược lại sửa thất bại
		if (kq > 0) {
			return "Sửa thông tin tk thành công";
		} else {
			return "Số tk ko tồn tại";
		}
	}

	public String XoaTK(String stk) throws ClassNotFoundException, SQLException {
		DungChung mChung = new DungChung();
		mChung.ketnoi();
		String sql = "DELETE FROM taikhoan where SoTaiKhoan=?";
		PreparedStatement A = mChung.cnn.prepareStatement(sql);
		A.setString(1, stk);
		int kt = A.executeUpdate();
		if (kt > 0) {
			return "Xóa tài khoản thành công";
		} else {

			return "Xóa tài khoản thất bại ";
		}
	}
	public String themTK(String stk,String HoTen,int SoTien,String mk) throws ClassNotFoundException, SQLException {
		DungChung mChung = new DungChung();
		mChung.ketnoi();
		String sql ="INSERT INTO taikhoan VALUES(?,?,?,?)";
		PreparedStatement P = mChung.cnn.prepareStatement(sql);
		P.setString(1, stk);
		P.setString(2, HoTen);
		P.setInt(3, SoTien);
		P.setString(4, mk);
		P.executeUpdate();
		
		return "Thêm tk thành công";
		
	
	
}
	public ArrayList<taikhoan> sx() throws ClassNotFoundException, SQLException{
		DungChung mChung=new DungChung();
		mChung.ketnoi();
		String sql ="SELECT * FROM taikhoan ORDER BY SoTien ASC";
		PreparedStatement P=mChung.cnn.prepareStatement(sql);
		ResultSet kq=P.executeQuery();
		ArrayList<taikhoan> list =new ArrayList<taikhoan>();
		while(kq.next()){
			String stk=kq.getString("SoTaiKhoan");
			String HT=kq.getString("HoTen");
			int ST=kq.getInt("SoTien");
			String mk=kq.getString("MatKhau");
			list.add(new taikhoan(stk, HT, ST, mk));
		}
		
		return list;
		
	}
}
