package it.polito.tdp.food.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	FoodDao dao;
	Graph<String, DefaultWeightedEdge> grafo;
	//Map <Integer, Portion> idMap;
	
	
	public Model () {
		this.dao = new FoodDao();
		this.grafo = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		//this.idMap = new HashMap<Integer, Portion>();
	}
	
	public void creaGrafo () {
		
	}
	
	public List <String> getTipoPorzione () {
		return dao.getTipoPorzione();
	}
}
