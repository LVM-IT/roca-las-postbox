package com.innoq.lvm.las.postbox.controller;

import com.innoq.lvm.las.postbox.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mjansing on 08/03/16.
 */
@Controller
@CrossOrigin
@RequestMapping("/m50000")
public class MessagesController {

	@Value("${lasRestServiceUrl}")
	private String lasRestServiceUrl;

	@Value("${lasRocaUrl}")
	private String lasRocaUrl;

	@RequestMapping(path = "/messages", method = RequestMethod.GET)
	public ModelAndView index() {
		Message[] messages = getMessagesFromService();
		return new ModelAndView("messages/index", "messages", messages);
	}

	@RequestMapping(path = "messages/{messageId}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("messageId") long messageId) {
		Message message = getMessageFromServiceByMessageId(messageId);
		return new ModelAndView("messages/show", "message", message);
	}

	private Message[] getMessagesFromService() {
		System.out.println("MessagesController.getMessagesFromService - lasRestServiceUrl: " + lasRestServiceUrl);
		RestTemplate restTemplate = new RestTemplate();
		String serviceUri = lasRestServiceUrl + "/briefkasten/m50000/";
		Message[] messages = restTemplate.getForObject(serviceUri, Message[].class);
		for (Message m : messages) {
			String newUrl = lasRocaUrl + "/partners/" + m.getPartnerId() + "/contracts/" + m.getReferenceId();
			m.setReferenceUri(newUrl);
		}
		return messages;
	}

	private Message getMessageFromServiceByMessageId(long messageId) {
		System.out.println("MessagesController.getMessageFromServiceByMessageId - lasRestServiceUrl: " + lasRestServiceUrl);
		RestTemplate restTemplate = new RestTemplate();
		String serviceUri = lasRestServiceUrl + "/briefkasten/m50000/" + messageId;
		return restTemplate.getForObject(serviceUri, Message.class);
	}
}
