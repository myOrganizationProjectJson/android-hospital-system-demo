package test;

import com.hospital.daoimpl.DoctorDaoImpl;
import com.hospital.daoimpl.UserDaoImpl;
import com.hospital.model.Doctor;
import com.hospital.model.User;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
		Doctor d = doctorDaoImpl.get(1);
		d.setInfo("123");
		d.setName("123");
		d.setType("123");
		doctorDaoImpl.update(d);
		

	}

}
