package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	//inserire tipo di dao
		private PremierLeagueDAO dao;
		
		//scelta valore mappa
		private Map<Integer,Match> idMap;
		
		//scelta tipo valori lista
		private List<Match> vertex;
		
		//scelta tra uno dei due edges
		private List<Adiacenza> edges;
		
		//scelta tipo vertici e tipo archi
		private Graph<Match,DefaultEdge> graph;
		

		
		
		public Model() {
			
			//inserire tipo dao
			dao  = new PremierLeagueDAO();
			//inserire tipo values
			idMap = new HashMap<Integer,Match>();
			dao.listAllMatches(idMap);
		}
		
		public void creaGrafo(Integer minuti, Integer mese) {
			
			//scelta tipo vertici e archi
			graph = new SimpleWeightedGraph<Match,DefaultEdge>(DefaultEdge.class);
			
			//scelta tipo valori lista
			vertex = new ArrayList<Match>(dao.getVertex(mese, idMap));
			Graphs.addAllVertices(graph,vertex);
			
			edges = new ArrayList<Adiacenza>(dao.getEdges(minuti));
			
			for(Adiacenza a : edges) {
				
				
				Match source = idMap.get(a.getId1());
				Match target = idMap.get(a.getId2());
				double peso = a.getPeso();
				
				if(peso!=0 && graph.containsVertex(source) && graph.containsVertex(target) && !source.equals(target))
				{Graphs.addEdge(graph,source,target,peso);
				System.out.println("AGGIUNTO ARCO TRA: "+source.toString()+" e "+target.toString());}
				
			}
			
			System.out.println("#vertici: "+graph.vertexSet().size());
			System.out.println("#archi: "+graph.edgeSet().size());
			
		}

		public List<Integer> getMese() {
			List<Integer> mesi = new ArrayList<Integer>();
			int i;
			for (i=1; i<=12; i++)
			{
				mesi.add(i);
			}
			return mesi;
		}

		public List<Massimo> getConnMax() {
			List<Massimo> ris= new ArrayList<Massimo>();
			double max=0;
			for( DefaultEdge e : graph.edgeSet())
			{
				if (graph.getEdgeWeight(e)>max)
					{max=graph.getEdgeWeight(e);}
			}
			
			for (DefaultEdge e : graph.edgeSet())
			{
				if(graph.getEdgeWeight(e)==max)
				{	Massimo m= new Massimo(graph.getEdgeSource(e), graph.getEdgeTarget(e), graph.getEdgeWeight(e));
				
					ris.add(m);}
			}
			
			return ris;
		}
	
}
