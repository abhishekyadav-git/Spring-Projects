package com.example.demo;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.Config;
import com.example.demo.model.Comment;
import com.example.demo.services.CommentService;

@SpringBootApplication
public class SpringAopApplication {
	
	private static Logger log = Logger.getLogger(SpringAopApplication.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(Config.class);
		
		CommentService serviceBean = config.getBean(CommentService.class);
		
		Comment comm = new Comment();
		comm.setText("Demo Cmment");
		
		String status = serviceBean.publishComment(comm);
		
		log.info("Final Status = "+status);
		
		
	}

}
