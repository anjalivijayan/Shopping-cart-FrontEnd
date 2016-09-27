package com.niit.shoppingcart.handler;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.niit.shoppingcart.model.UserDetails;
@Component
public class RegistrationHandler {

	public UserDetails getInstance(){
		return new UserDetails();
	}
	
	public String validateDetails(UserDetails userDetails,MessageContext messageContext) {
		String status="success";
		
		if(userDetails.getId().isEmpty()) {
			 messageContext.addMessage(new MessageBuilder().error().source("id").defaultText("UserId cannot be empty").build());
			 status="failure";
		}
		if(userDetails.getName().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("name").defaultText("Name cannot be empty").build());
			status="failure";
		}
		if(userDetails.getPassword().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("password").defaultText("Password cannot be empty").build());
			status="failure";
		}
		if(userDetails.getContact().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("contact").defaultText("Mobile Number cannot be empty").build());
			status="failure";
		}
	
		if(userDetails.getMail().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("mail").defaultText("MailId cannot be empty").build());
			status="failure";
		}
		if(userDetails.getAddress().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("address").defaultText("Address cannot be empty").build());
			status="failure";
		}
		
		
		
		return status;
	}
	
	public void addUser(RequestContext context, UserDetails userDetails){
	    HttpSession session = ((HttpServletRequest)context.getExternalContext().getNativeRequest()).getSession();
	              session.setAttribute("user",userDetails);
	       }
}
	
	
	
