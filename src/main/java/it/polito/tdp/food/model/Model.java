package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	FoodDao dao;
	Graph<String, DefaultWeightedEdge> grafo;
	List<String> vertici ;
	List <Arco> archi;
	
	public Model () {
		this.dao = new FoodDao();
		this.grafo = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		this.vertici = new LinkedList<String>();
		this.archi = new ArrayList<Arco>();
	}
	
	public void creaGrafo (Integer cal) {
		this.vertici = dao.getTipoPorzione(cal);
		this.archi = dao.getArchi();
		
		Graphs.addAllVertices(this.grafo, vertici);
		
		for (Arco a : archi) {
			//SE NON C'E' AGGIUNGO 
			if (grafo.getEdge(a.getPorzione1(), a.getPorzione2()) == null) {
				Graphs.addEdge(this.grafo, a.getPorzione1(), a.getPorzione2(), a.getPeso());
			}
		}
	}
	
	public List <String> getTipoPorzione (Integer cal) {
		return dao.getTipoPorzione(cal);
	}
	
	public int nVertici() {
		return grafo.vertexSet().size();
	}
	
	public int nArchi () {
		return grafo.edgeSet().size();
	}
}
