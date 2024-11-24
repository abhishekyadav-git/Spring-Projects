package com.example.demo.services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.demo.custom_annotation.LogAnnotation.ToLog;
import com.example.demo.model.Comment;

@Service
public class CommentService {
	
	private Logger log = Logger.getLogger(CommentService.class.getName());
	
	@ToLog
	public String publishComment(Comment comment) {
		log.info("Hey there , see my comment " + comment.getText());
		
		return "SUCCESS";
	}
}
