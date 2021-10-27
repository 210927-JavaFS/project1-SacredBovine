DROP TABLE ers_user_roles CASCADE;
DROP TABLE ers_users CASCADE;
DROP TABLE ers_reimbursement_status CASCADE;
DROP TABLE ers_reimbursement_type CASCADE;



INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
	VALUES (1,'pending');
INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
	VALUES (2,'approved');
INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
	VALUES (3,'denied');
	
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
	VALUES (1,'lodging');
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
	VALUES (2,'travel');
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
	VALUES (3,'food');
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
	VALUES (4,'other');

INSERT INTO ers_user_roles (ers_user_role_id, user_role)
	VALUES (1,'employee');
INSERT INTO ers_user_roles (ers_user_role_id, user_role)
	VALUES (2,'manager');

INSERT INTO ers_users (ers_users_id, ers_username, ers_password, ers_first_name, ers_last_name, ers_email, roleid)
	VALUES(2,'manager', 'password', 'Erwin', 'Schrodinger', 'untilObserved@maybe.com', 2);

INSERT INTO ers_reimbursement (reimb_id,reimb_amount,reimb_description,reimb_author,reimb_status_id, reimb_type_id)
	VALUES(1,50,'Hungry',1,1,3);

DROP TABLE ers_reimbursement;
