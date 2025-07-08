package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.taikhoan;
import server.server_tk;

public class controller_taikhoan {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		server_tk mServer_tk = new server_tk();// Tạo dối tượng để gọi hàm lấy thông tin
		ArrayList<taikhoan> list = mServer_tk.laythongtin();
		
		System.out.println("Nhập 1 in toàn bộ stk");
		System.out.println("Nhập 2 để sửa thông tin  stk");
		System.out.println("Nhập 3 để xóa thông tin stk ");
		System.out.println("Nhập 4 tìm Stk có số tiền lớn nhất ");
		System.out.println("Nhập 5 thêm thông tin tk");
		System.out.println("Nhập 6 sắp xếp tăng dần theo số tiền");
		int nhap = scanner.nextInt();

		if (nhap == 1) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getSoTaiKhoan() + " " + list.get(i).getHoTenString() + " "
						+ list.get(i).getSoTien() + " " + list.get(i).getMatKhauString());
			}
		} else if (nhap == 2) {
			scanner.nextLine();
			System.out.print("Nhập Số Tài khoản muốn sửa ");
			String stk = scanner.nextLine();
						
			scanner.nextLine();
			System.out.print("Nhập Họ Tên muốn sửa thành");
			String HoTen = scanner.nextLine();
			System.out.print("Nhập Số Tiền muốn sửa thành ");
			int SoTien = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Nhập Mật khẩu muốn sửa thành ");
			String mk = scanner.nextLine();

			String kq = mServer_tk.suaTK(stk, HoTen, SoTien, mk); // Gọi hàm
			System.out.print(kq);
		}else if(nhap==3) {
			scanner.nextLine();
			System.out.print("Nhập STK muốn xóa ");
			String stk =scanner.nextLine();
			String kq=mServer_tk.XoaTK(stk);
			System.out.print(kq);
		}else if(nhap==4) {
			int max=list.get(0).getSoTien();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getSoTien()>max) {
					max=list.get(i).getSoTien();
				}
			}
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getSoTien()==max) {
					System.out.println(list.get(i).getSoTaiKhoan()+" "+list.get(i).getHoTenString()
							+" "+list.get(i).getSoTien()+" "+list.get(i).getMatKhauString() );
				}
			}
		}else if(nhap==5) {
			scanner.nextLine();
			System.out.print("Nhập stk muốn thêm");
			String stk=scanner.nextLine();
			int kt=0;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getSoTaiKhoan().equals(stk)) {
					kt=1;
					System.out.print("thông tin tk đã tồn tại");
				}
			}
			if(kt==0) {
				System.out.print("Nhập Họ Tên");
				scanner.nextLine();
				String HT=scanner.nextLine();
				System.out.print("Nhập Số Tiền");
				int ST=scanner.nextInt();
				scanner.nextLine();
				System.out.print("Nhập mật khẩu");
				String mk=scanner.nextLine();
				
				String kq=mServer_tk.themTK(stk, HT, ST, mk);
				System.out.print(kq);
			}
			
		}else if(nhap==6) {
			ArrayList<taikhoan> list2=mServer_tk.sx();
			for(int i=0;i<list2.size();i++) {
				System.out.println(list2.get(i).getSoTaiKhoan()+" "+list2.get(i).getHoTenString()+" "+
			list2.get(i).getSoTien()+" "+list2.get(i).getMatKhauString());
			}
		}
		
		

	}

}
