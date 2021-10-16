CREATE TABLE ers_user_roles (
	ers_user_role_id INTEGER PRIMARY KEY,
	user_role VARCHAR(10) NOT NULL
	);

CREATE TABLE ers_users (
	ers_user_id INTEGER PRIMARY KEY,
	ers_username VARCHAR(29) UNIQUE NOT NULL,
	ers_password VARCHAR(50) NOT NULL,
	user_first_name VARCHAR(100) NOT NULL,
	user_last_name VARCHAR(20) NOT NULL,
	user_email VARCHAR(150) UNIQUE NOT NULL,
	user_role_id INTEGER REFERENCES ers_user_roles(ers_user_role_id)
	);
	
CREATE TABLE ers_reimbursement_status (
	reimb_status_id INTEGER PRIMARY KEY,
	reimb_status VARCHAR(10)
	);
	
CREATE TABLE ers_reimbursement_type (
	reimb_type_id INTEGER PRIMARY KEY,
	reimb_type VARCHAR(20)
	);
	
CREATE TABLE ers_reimbursement (
	reimb_id INTEGER PRIMARY KEY,
	reimb_amount INTEGER NOT NULL,
	reimb_submitted TIMESTAMP,
	reimb_resolved TIMESTAMP,
	reimb_description VARCHAR(250),
	--reimb_receipt BLOB,
	reimb_author INTEGER REFERENCES ers_users(ers_user_id),
	reimb_resolver INTEGER REFERENCES ers_users(ers_user_id),
	reimb_status_id INTEGER REFERENCES ers_reimbursement_status(reimb_status_id),
	reimb_type_id INTEGER REFERENCES ers_reimbursement_type(reimb_type_id)
	);
	
/*	
DROP TABLE ers_user_roles CASCADE;
DROP TABLE ers_users CASCADE;
DROP TABLE ers_reimbursement_status CASCADE;
DROP TABLE ers_reimbursement_type CASCADE;
*/
	