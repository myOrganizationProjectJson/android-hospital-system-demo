package test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.hospital.daoimpl.UserDaoImpl;
import com.hospital.model.User;

public class JsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> list = userDaoImpl.getAll();
		Gson jsonArray = new Gson();
		String s = jsonArray.toJson(list);

	}

}
