package uni.fmi.bachelors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private HashMap<String, Node> graph =  new HashMap<>();
    
    private  List<Vertex> nodes;
    private  List<Link> edges;
    
    public Graph() {
    }
    
    public Graph(List<Vertex> nodes, List<Link> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return nodes;
    }

    public List<Link> getEdges() {
        return edges;
    }
    
    public void addNode (Node node)
    {
        if (null == node)
        { System.err.println("Не може да вкараме празен възел");
        return;
        }
        
        if (!graph.containsKey(node.name))
        	graph.put(node.name, node);
        
        else 
            System.err.println("Опит за добавяне на съществуващ възел");
    }
    
    public Node getNode(String name){  // изгражда самите връзки
        return graph.get(name);
    }

    public void addLink (String nodeNameFrom, String nodeNameTo, boolean isBiDirectional){
        Node node1= graph.get(nodeNameFrom);
        Node node2 = graph.get(nodeNameTo);

        if(node1 == null || node2 == null)
        {
            System.err.println("Липсващи нодове");
        return;
        }

        try {
   
        	node1.addLink(new Link(node2));

        } catch (MyCustomException e)

        {
   
        	e.printStackTrace();

        } catch (Exception e){


        }finally {
    
        	System.out.println("Опит за добавяне на линк");

        }
        
        if (isBiDirectional)
            try {
                node2.addLink(new Link (node1));
            }catch (MyCustomException e){
                e.printStackTrace();
            }

    }

    public void addLink (String nodeNameFrom, String nodeNameTo, boolean isBiDirectional, double length)
    {
        Node node1= graph.get(nodeNameFrom);
        Node node2 = graph.get(nodeNameTo);

        if(node1 == null || node2 == null)
        {
            System.err.println("Липсващи нодове");
            return;
        }

        try {
    
        	node1.addLink(new Link (node2,length));
    
        	if (isBiDirectional)
        
        		node2.addLink(new Link (node1));

        }catch (MyCustomException e){
  
        	e.printStackTrace();

        }


    }

    public void resetGraph() {
		
		for(Map.Entry<String, Node> keyValuePair : graph.entrySet()) {
			keyValuePair.getValue().isTested = false;
			keyValuePair.getValue().depth = -1;
		}
	}
}
