package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.*;
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
	public static Reimb reimb1;
	public static Reimb reimb2;
	public static User user;
	public static UserRole role;
	public static ReimbStatus status1;
	public static ReimbStatus status2;
	public static ReimbType type;
	public static List<Reimb> reimbs;

	@BeforeAll
	public static void setService() {
		reimbService = new ReimbService();
	}
	
	@BeforeEach
	public void setValues() {
		role = new UserRole(2,"manager");
		user = new User(3,"test user","-1145958493","Tester","Testington","test@test.com", role);
		status1 = new ReimbStatus(1,"pending");
		status2 = new ReimbStatus(2,"approved");
		type = new ReimbType(1,"lodging");
		reimb1 = new Reimb(42.00,"test case",user, status1, type);
		reimb2 = new Reimb();
		reimbs = null;
	}
	
	@Test
	public void test1AddReimb() {
		assertTrue(reimbService.addReimb(reimb1));
	}
	
	@Test
	public void test2FindByUser() {
		reimbs = reimbService.findByUser(user.getErsUserId());
		reimb2 = reimbService.findByUser(user.getErsUserId()).get(0);
		assertEquals(reimbs.get(0),reimb2);		
	}
	@Test
	public void test3FindAll() {
		reimbs = reimbService.findAll();
		assertTrue(reimbs.size()>0);
	}
	@Test
	public void test4FindByOpen() {
		reimbs = reimbService.findByOpen();
		assertTrue(reimbs.size()>0 && reimbs.get(0).getReimbStatus().getStatusId()==1);		
	}
	@Test
	public void test5FindById() {
		reimb2 = reimbService.findByUser(user.getErsUserId()).get(0);
		reimb1 = reimbService.findById(reimb2.getReimbId());
		assertEquals(reimb1,reimb2);
	}
	@Test	
	public void test6UpdateReimb() {
		reimb2 = reimbService.findByUser(user.getErsUserId()).get(0);
		reimb1.setReimbId(reimb2.getReimbId());
		reimb2.setReimbStatus(status2);
		assertTrue(reimbService.updateReimb(reimb2));
		assertTrue(!(reimb1==reimbService.findById(reimb1.getReimbId())));
	}
	
}