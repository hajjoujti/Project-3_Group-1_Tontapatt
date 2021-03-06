package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.UserCategoryIBusiness;
import fr.eql.ai109.tontapatt.entity.UserCategory;

@ManagedBean(name = "mbUserCategory")
@SessionScoped
public class UserCategoryManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserCategoryIBusiness business;
	private UserCategory userCategory;

	public List<UserCategory> allCategories() {
		return business.getAll();
	}

	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

}
