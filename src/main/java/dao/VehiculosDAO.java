package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

import bd.MongoDB;
import controller.Gestion;
import eventos.DetallesEvent;
import model.Vehiculo;

public class VehiculosDAO {

	public boolean createVehiculo(Gestion g) {
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");

		Vehiculo v = g.addVehiculo();
		Gson gson = new Gson();
		String json = gson.toJson(v);
		Document document = Document.parse(json);
		
		ArrayList<String> lista = findVehiculoByMatricula(v.getMatricula().toUpperCase());
		
		if(!lista.isEmpty()) {
			return false;
		}
		
		for (Entry<String, String> entry : DetallesEvent.hm.entrySet()) {
            document.append(entry.getKey(), entry.getValue());
        }

		try {
			collection.insertOne(document);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteVehiculo(Gestion g) {
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");

		String matricula = g.deleteVehiculo();

		ArrayList<String> vehiculos = findVehiculoByMatricula(matricula);

		if (vehiculos == null) {
			return false;
		}

		collection.deleteOne(Filters.eq("matricula", matricula));

		return true;
	}

	public ArrayList<String> findIdsVehiculos() {
		ArrayList<String> ids = new ArrayList<String>();
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");

		Bson projectionFields = Projections.fields(Projections.include("_id"));

		MongoCursor<Document> cursor = collection.find().projection(projectionFields).iterator();

		while (cursor.hasNext()) {
			ids.add(cursor.next().toJson());
		}

		cursor.close();
		return ids;
	}

	public ArrayList<String> findMatriculas() {
		ArrayList<String> matriculas = new ArrayList<String>();
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");

		Bson projectionFields = Projections.fields(Projections.excludeId(), Projections.include("matricula"));

		MongoCursor<Document> cursor = collection.find().projection(projectionFields).iterator();

		while (cursor.hasNext()) {
			matriculas.add(cursor.next().toJson());
		}

		cursor.close();
		return matriculas;
	}

	public ArrayList<String> findTipos() {
		ArrayList<String> tipos = new ArrayList<String>();
		Set<String> tiposSet = new HashSet<String>();
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");

		Bson projectionFields = Projections.fields(Projections.excludeId(), Projections.include("tipo"));

		MongoCursor<Document> cursor = collection.find().projection(projectionFields).iterator();

		while (cursor.hasNext()) {
			Document document = cursor.next();
			String tipo = document.getString("tipo");

			tiposSet.add(tipo);
		}

		cursor.close();

		tipos.addAll(tiposSet);
		return tipos;
	}

	public ArrayList<String> findAllVehiculos(Gestion g) {
		ArrayList<String> vehiculos = new ArrayList<String>();
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");
		Bson projectionFields = Projections.fields(Projections.excludeId());
		MongoCursor<Document> cursor = collection.find().projection(projectionFields).iterator();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		while (cursor.hasNext()) {
			String prettyJson = gson.toJson(cursor.next());
			vehiculos.add(prettyJson);
		}
		cursor.close();
		return vehiculos;
	}

	public Document findVehiculoById(String id) {
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");

		Bson projectionFields = Projections.fields(Projections.include("_id"));

		ObjectId objectId = new ObjectId(id);

		Document doc = collection.find(Filters.eq("_id", objectId)).projection(projectionFields).first();

		return doc;
	}

	public ArrayList<String> findVehiculoByMatricula(String matricula) {
		ArrayList<String> vehiculos = new ArrayList<String>();
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");
		Bson projectionFields = Projections.fields(Projections.excludeId());
		MongoCursor<Document> cursor = collection.find(Filters.eq("matricula", matricula)).projection(projectionFields).iterator();

		Gson gson = new GsonBuilder().create();
		
		while(cursor.hasNext()) {
			String prettyJson = gson.toJson(cursor.next());
			vehiculos.add(prettyJson);
		}
		return vehiculos;
	}
	
	public ArrayList<String> findVehiculoByMatriculaPretty(String matricula) {
		ArrayList<String> vehiculos = new ArrayList<String>();
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");
		Bson projectionFields = Projections.fields(Projections.excludeId());
		MongoCursor<Document> cursor = collection.find(Filters.eq("matricula", matricula)).projection(projectionFields).iterator();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		while(cursor.hasNext()) {
			String prettyJson = gson.toJson(cursor.next());
			vehiculos.add(prettyJson);
		}
		return vehiculos;
	}

	public ArrayList<String> findVehiculoByTipo(String tipo) {
		ArrayList<String> vehiculos = new ArrayList<String>();
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");
		Bson projectionFields = Projections.fields(Projections.excludeId());
		MongoCursor<Document> cursor = collection.find(Filters.eq("tipo", tipo)).projection(projectionFields).iterator();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		while(cursor.hasNext()) {
			String prettyJson = gson.toJson(cursor.next());
			vehiculos.add(prettyJson);
		}
		return vehiculos;
	}
	
	public boolean updateVehiculo(Gestion g) {
		MongoClient mc = MongoDB.getClient();
		MongoDatabase db = mc.getDatabase("proyecto_concesionario");
		MongoCollection<Document> collection = db.getCollection("vehiculos");

		String matricula = g.obtenerMatricula();

		ArrayList<String> vehiculos = findVehiculoByMatricula(matricula);

		if (vehiculos == null) {
			return false;
		}

		collection.deleteOne(Filters.eq("matricula", matricula));
		
		Vehiculo v = g.obtenerVehiculo();
		Gson gson = new Gson();
		String json = gson.toJson(v);
		Document document = Document.parse(json);

		try {
			collection.insertOne(document);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}