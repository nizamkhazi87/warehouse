package com.assignment.warehouse.util;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.assignment.warehouse.exception.WarehouseException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WarehouseUtil {

	public static <T> T convertJsonToObject(final String jsonFileName, final Class<T> clazz) {

		T jsonObject = null;
		InputStream inputJson = null;
		try {
			inputJson = WarehouseUtil.class.getResourceAsStream("/file/" + jsonFileName);
			final ObjectMapper mapper = new ObjectMapper();
			
			jsonObject = mapper.readValue(inputJson, clazz);
		} catch (Exception e) {
			throw new WarehouseException("BAD_REQUEST", "Bad Request exception");

		} finally {
			if (inputJson != null) {
				try {
					inputJson.close();
				} catch (IOException e) {
					throw new WarehouseException("BAD_REQUEST", "Bad Request exception");
				}
			}
		}

		return jsonObject;
	}
	
}
