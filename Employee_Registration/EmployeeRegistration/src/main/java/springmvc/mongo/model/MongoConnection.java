package springmvc.mongo.model;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoConnection {
	
	  private static Logger logger = Logger.getLogger(MongoConnection.class);
		 
	    private static Mongo mongo;
	 
	    // Returns a mongo instance.
	    public static Mongo getMongo() {
	        int port_no = 27017;
	        String hostname = "192.168.10.204";      
	        if (mongo == null) {
	            try {
	                mongo = new Mongo(hostname, port_no); 
	                logger.info("mongo connection is:"+mongo);
	            } catch (MongoException ex) {
	                logger.error(ex);
	            }
	        }
	        return mongo;
	    }
	 
	    //Fetches database 
	    public static DB getDB(String db_name) {
	    	logger.info("Name of database is:"+db_name);
	        return getMongo().getDB(db_name);
	    }
	 
	    // Fetches the collection from the mongo database.
	    public static DBCollection getCollection(String db_name, String db_collection) {
	        return getDB(db_name).getCollection(db_collection);
	    }
	
	

}
