package org.pilus.service;

import static com.mongodb.client.model.Filters.eq;

import org.pilus.pojos.PruebaPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaService {

	@Autowired
	private DBConnection dbconnection;

	public PruebaPOJO getByID() {
		return dbconnection.CollectionSelection().find(eq("_id", "10051164")).first();
	}

}
