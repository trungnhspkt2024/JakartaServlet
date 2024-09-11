package vn.iotstar.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Userss")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Username")
	private String username;

	@Column(name="Active")
	private boolean active;

	@Column(name="Admin")
	private boolean admin;

	@Column(name="Email")
	private String email;
	
	@Column(name="Phone")
	private String phone;


	@Column(name="Fullname")
	private String fullname;

	@Column(name="Password")
	private String password;
	
	@Column(name="Images")
	private String images;

	

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}