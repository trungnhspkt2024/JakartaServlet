package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectSQL;

import vn.iotstar.dao.IUserDao;

import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao {
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql ="select * from users";
		List<UserModel> list = new ArrayList<>(); //Tạo 1 List để truyền dữ liệu
		try {
			conn = new DBConnectSQL().getConnection(); //kết nối database 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next() /*Next từng DÒNG tới cuối bảng*/) {
                list.add(new UserModel(
                		rs.getInt("id"), 
                		rs.getString("username"), 
                		rs.getString("password"), 
                		rs.getString("email"), 
                		rs.getString("phone"),
                		rs.getString("images"),
                		rs.getString("fullname"),
                		rs.getInt("roleid"),
                		rs.getDate("createDate")        		                		
                		)); //Add vào
            }
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public UserModel findOne(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {

		String sql = "INSERT INTO users(id, username, password, images, fullname) VALUES (?, ?, ?, ?, ?)";
			
		try {
			//conn = new DBConnectSQL().getConnection(); //kết nối database 
			ps = conn.prepareStatement(sql);//ném câu sql vào cho thực thi
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getImages());
			ps.setString(5, user.getFullname());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 public static void main(String[] args) {
		 	
	        IUserDao userDao = new UserDaoImpl();
	        System.out.println(userDao.findByUsername("trungnh"));
	        //List<UserModel> list = userDao.findAll();
	       // for (UserModel user : list) {
	       //     System.out.println(user);
	       // }
	    }

	
}
