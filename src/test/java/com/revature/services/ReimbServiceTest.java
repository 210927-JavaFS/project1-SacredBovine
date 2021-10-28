package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.models.UserRole;


public class ReimbServiceTest {
	public static Logger log = LoggerFactory.getLogger(ReimbServiceTest.class);
	
	public static ReimbService reimbService;
	public static Reimb reimb;
	public static User user;
	public static UserRole role;
	public static ReimbStatus status;
	public static ReimbType type;
	
	@BeforeAll
	public static void setService() {
		reimbService = new ReimbService();
	}
	
	@BeforeEach
	public void setValues() {
		role = new UserRole(1,"employee");
		user = new User(1,"employee","password","Mike","Tython","knockYou@out.com", role);
		status = new ReimbStatus(1,"pending");
		type = new ReimbType(1,"lodging");
		reimb = new Reimb(2,10,"testing",status,type);
	}

}
