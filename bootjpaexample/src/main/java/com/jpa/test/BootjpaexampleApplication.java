package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

    private final UserRepository userRepository;

    BootjpaexampleApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public static void main(String[] args) {
		System.out.println("Start!");
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		
		//perform CRUD operation:
		
		
		
//		//CREATE: 
//		User user1=new User();
//		user1.setName("abc");
//		user1.setCity("mumbai");
//		user1.setProfile("teacher");
//		
//		User user2=new User();
//		user2.setName("xyz");
//		user2.setCity("kolkata");
//		user2.setProfile("doctor");
//		
//		User user3=new User();
//		user3.setName("diya");
//		user3.setCity("delhi");
//		user3.setProfile("frontent");
//		
//		User user4=new User();
//		user4.setName("charu");
//		user4.setCity("kolkata");
//		user4.setProfile("java developer");
//		
//		//create a list:
//		List<User> users=List.of(user1,user2,user2,user3);
//		Iterable<User> result=userRepository.saveAll(users);
//	    result.forEach(element->{
//	    	System.out.println(element);
//	    });	
//		System.out.println("=======================================");
		
		
//		//UPDATE:
//		//before updating
//		Iterable<User> itr= userRepository.findAll();
//		System.out.println("==============================================================================");
//		itr.forEach(element->{
//    	System.out.println(element);
//        });	
//		System.out.println("==============================================================================");
//		
//		Optional<User> optional= userRepository.findById(304);
//		User user=optional.get();
//		user.setProfile("backend");
//		User user1=userRepository.save(user);
//		//after updating 
//		Iterable<User> itr1= userRepository.findAll();
//		System.out.println("==============================================================================");
//		itr1.forEach(element->{
//    	System.out.println(element);
//        });	
		
//		//READ:
//		//single element-
//		Optional<User> optional=userRepository.findById(102);
//		User user=optional.get();
//		System.out.println(user);
//		System.out.println("=======================================");
//		System.out.println("=======================================");
//		
//		
//		//multiple elements-
//		Iterable<User> itr= userRepository.findAll();
//		Iterator iterator=itr.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//		System.out.println("=======================================");
//		itr.forEach(new Consumer<User>() {
//
//			@Override
//			public void accept(User t) {
//				System.out.println(t);
//				
//			}
//			
//		});
//		System.out.println("=======================================");
//		itr.forEach(element->{
//	    	System.out.println(element);
//	    });	
		
		
//		//DELETE:
//		//before deleting
//		Iterable<User> itr= userRepository.findAll();
//		System.out.println("==============================================================================");
//		itr.forEach(element->{
//    	System.out.println(element);
//        });	
//		System.out.println("==============================================================================");
//		
//		
//		
//		userRepository.deleteAll(itr);
//		
//		//after deleting
//		Iterable<User> itr1= userRepository.findAll();
//		System.out.println("==============================================================================");
//		itr1.forEach(element->{
//    	System.out.println(element);
//        });	
//		System.out.println("==============================================================================");		
//		
//		
//		System.out.println("End!");
		
		
		
		//List<User> list=userRepository.findByName("diya");
//		List<User> list=userRepository.getAll();
		List<User> list=userRepository.findByNameCity("diya", "delhi");
		list.forEach(new Consumer<User>() {

			@Override
			public void accept(User t) {
			System.out.println(t);
				
			}
			
		});
		
		
		
		
		
		
	}

}
