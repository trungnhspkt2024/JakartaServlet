package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	 UserModel login(String username, String password);
	 UserModel findByUsername(String username);
}
