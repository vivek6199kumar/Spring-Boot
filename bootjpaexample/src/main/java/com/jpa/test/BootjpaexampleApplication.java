package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.model.User;


@SpringBootApplication
public class BootjpaexampleApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		

		UserRepository userRepo = context.getBean(UserRepository.class);

		
		
		/*
		 * User user1 = new User("BHarat Kumar", "Gurgaon", "programmer");
		 * 
		 * User user2 = new User("Vivek Kumar", "Bihar", "Software Developer");
		 * 
		 * 
		 * //save single entity User resultuser = userRepo.save(user1);
		 * 
		 * 
		 * List<User> userList = List.of(user1, user2); userRepo.saveAll(userList);
		 * //Iterate list using lambda expression
		 * userList.forEach((e)->{System.out.println(e); });
		 */

		
		/*
		 * // update the user whose id=1 Optional<User> optional = userRepo.findById(1);
		 * User user = optional.get(); user.setName("Bharat Rawat"); User result
		 * =userRepo.save(user); System.out.println("Update User :" + result);
		 * System.out.println("update successfully");
		 */

		/*
		 * // how to get data Iterable<User> user = userRepo.findAll();
		 * 
		 * user.forEach(e -> { System.out.println(e); });
		 */

		/*
		 * //Delete user by id userRepo.deleteById(1);
		 * System.out.println("user of id=1 is deleted succesfully");
		 * 
		 */
		/*
		 * //Delete all Iterable<User> allUser=userRepo.findAll();
		 * allUser.forEach(e->System.out.println(e)); userRepo.deleteAll(allUser);
		 */
       
		/*
		 * //Customised Method List<User>user=userRepo.findByName("Vivek Kumar");
		 * user.forEach(e->System.out.println(e));
		 */
		
		//Get user list by name using annotation query
		/*
		 * List<User> user=userRepo.getList();
		 * user.forEach((e)->{System.out.println(e);});
		 * System.out.println("**************************************************");
		 * 
		 * List<User> user1=userRepo.getUserByName("Vivek Kumar");
		 * user1.forEach((e)->{System.out.println(e);});
		 */
	}

}
