package fr.eql.ai109.ibusiness;

import fr.eql.ai109.tontapatt.entity.User;

public interface UserIBusiness extends GenericIBusiness<User> {

	Boolean verifyIfUserExists(String email);

	User connection(String email, String password);
	
	Boolean verifyDuplicateEmailOnUpdate(Integer id, String email);
	
	User updatePassword(User user);
	
}
