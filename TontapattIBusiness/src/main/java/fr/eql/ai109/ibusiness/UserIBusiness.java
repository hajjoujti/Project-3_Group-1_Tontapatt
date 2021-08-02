package fr.eql.ai109.ibusiness;

import fr.eql.ai109.tontapatt.entity.User;

public interface UserIBusiness extends GenericIBusiness<User> {

	User connection(String email, String password);
	Boolean verifyIfUserExists(String email);

}
