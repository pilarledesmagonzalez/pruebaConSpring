package org.pilus.service;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.pilus.pojos.PruebaPOJO;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBConnection {

	public static MongoClientSettings mongoClientSettings() {
		ConnectionString connectionString = new ConnectionString(
				"mongodb+srv://admin:admin@cluster0-66t9k.mongodb.net/sample_airbnb?retryWrites=true&w=majority");

		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

		return MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry)
				.build();
	}

	public static MongoClient createMongoClient() {
		return MongoClients.create(DBConnection.mongoClientSettings());
	}

	public static MongoDatabase DBConnection() {
		return createMongoClient().getDatabase("sample_airbnb");
	}

	// Aca mapea los documentos de la coleccion listingAndReviews con la clase
	// PruebaPOJO
	public static MongoCollection<PruebaPOJO> CollectionSelection() {
		return DBConnection.DBConnection().getCollection("listingsAndReviews", PruebaPOJO.class);
	}

	public static void Connect() {
		System.out.println("Hola DB!");
		DBConnection.mongoClientSettings();
		DBConnection.createMongoClient();
	}

	public static void CloseDBConnection() {
		createMongoClient().close();
		System.out.println("Chau DB!");

	}

}
