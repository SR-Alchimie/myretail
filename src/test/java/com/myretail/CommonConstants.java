package com.myretail;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

public class CommonConstants {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

}
