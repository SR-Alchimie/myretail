package com.myretail.resource;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class Messages.
 */
@Component
public class Messages {

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The accessor. */
	private MessageSourceAccessor accessor;

	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init() {
		accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
	}

	/**
	 * Gets the.
	 *
	 * @param code the code
	 * @return the string
	 */
	public String get(String code) {
		return accessor.getMessage(code);
	}

}