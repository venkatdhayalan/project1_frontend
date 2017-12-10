package com.sports.dao;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.model.Authorities;
import com.sports.model.Cart;
import com.sports.model.Customer;
import com.sports.model.User;


@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		
		Authorities authorities=new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUser(customer.getUser());//FK column in authorities table
		
		customer.getUser().setAuthorities(authorities);
		customer.getUser().setEnabled(true);
		
		Cart cart=new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		
		
		session.save(customer);
		
	}
	public boolean isEmailValid(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from customer where email=? and username=?");
		query.setString(0, email);
		Customer customer=(Customer)query.uniqueResult();
		if(customer!=null)
			return false;
		else
			return true;
		
	}
	public boolean isUsernameValid(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		if(user!=null)
		return false;
		else
			return true;
	}

}
