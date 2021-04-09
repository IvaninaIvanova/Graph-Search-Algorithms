package uni.fmi.bachelors;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	public static String start;
	public static String end;
	private static List<Vertex> nodes;
	private static List<Link> edges;
	static Graph graph = new Graph();
	
    JPanel Panel= new JPanel();

    JLabel addNode_Label= new JLabel("Въведете елемент:");
    JTextField addNode_Text1 = new JTextField();
    JLabel addNode_Label1= new JLabel("Въведете тежест:");
    JTextField addNode_Text2 = new JTextField();
    JLabel addNode_Label2= new JLabel("Въведете Х:");
    JTextField addNode_Text = new JTextField();
    JButton add_Button = new JButton("Добави:");
    JLabel addNode_Label5= new JLabel("");
    JButton add_Button4 = new JButton("Добави:");
    JLabel addNode_Label3= new JLabel("Въведете У:");
    JTextField addNode_Text3 = new JTextField();
    JLabel addNode_Label4= new JLabel("");

    //String[] nodeList={};// да се пълни от първия текст бокс

    JLabel addNodeR_Label= new JLabel("Добави връзка:");
    //JComboBox<String> relationship_Combo = new JComboBox<>(nodeList);
    JTextField text = new JTextField();
    JButton addR_Button = new JButton("Добави връзка:");
    JButton addR_Button1 = new JButton("");
    JLabel method_Label = new JLabel("Маркирай метод за търсене");
    static String[] typeList = {"1", "2"};
	static JComboBox<String> typeCombo = new JComboBox<>(typeList);
	 JButton searchButton1 = new JButton("Създай");
    JLabel chooseNode_Label = new JLabel ("Изберете между кои точки да търси път:");
    //JComboBox<String> node1S_Combo = new JComboBox<>(nodeList);
    //JComboBox<String> node2S_Combo = new JComboBox<>(nodeList);
    static JTextField startLabel = new JTextField();
    static JTextField endLabel = new JTextField();
    JLabel empty_Label = new JLabel();
    JButton searchButton = new JButton("Търси");

    public MyFrame(){
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(1, 1));
        this.add(Panel);

        
        Panel.setLayout(new GridLayout(12,2));
        Panel.add(method_Label);
        Panel.add(typeCombo);
        Panel.add(empty_Label);
        Panel.add(searchButton1);
        searchButton1.addActionListener(new ImplementGraphs());
        
        Panel.add(addNode_Label);
        Panel.add(addNode_Text);
  
        Panel.add(addNode_Label1);
        Panel.add(addNode_Text1);
        Panel.add(addNode_Label2);
        Panel.add(addNode_Text2);
        Panel.add(addNode_Label3);
        Panel.add(addNode_Text3);
        Panel.add(addNode_Label4);
        Panel.add(add_Button);
        add_Button.addActionListener(new AddNodes());
        Panel.add(addNodeR_Label);
        Panel.add(text);
        Panel.add(addNode_Label5);
        Panel.add(add_Button4);
        add_Button4.addActionListener(new AddEdge());
        
        Panel.add(chooseNode_Label);
        Panel.add(startLabel);
        Panel.add(endLabel);
        Panel.add(searchButton);
        searchButton.addActionListener(new SearchBetweenTwoNode());

        this.setVisible(true);
    }

    static class ImplementGraphs implements ActionListener{
    	
    	public static void init(Graph graph) {
			
    		graph.addNode(new Node("A", 6, 0, 0));
	        graph.addNode(new Node("B", 8, 1, 3));
			graph.addNode(new Node("C", 7, 5, 0));
			graph.addNode(new Node("D", 6, 5, 3));
			graph.addNode(new Node("E", 5, 9, 0));
			graph.addNode(new Node("F", 4, 12, 0));
			graph.addNode(new Node("G", 6, 5 ,6));
			graph.addNode(new Node("H", 3, 5, 8));
			graph.addNode(new Node("I", 8, 9, 6));
	       
	       
			graph.addLink("A", "B", true, 1);
	        graph.addLink("A", "D", true, 1);
	        graph.addLink("A", "C", true, 1);
	        
			graph.addLink("B", "G", true, 1);
			
	        graph.addLink("C", "D", true, 1);
	        graph.addLink("C", "E", true, 1);
	               
	        graph.addLink("D", "G", true, 1);
	        
	        graph.addLink("E", "H", true, 1);
	        graph.addLink("E", "F", true, 1);
	       
	        graph.addLink("F", "I", true, 1);
	        
	        graph.addLink("G", "B", true, 1);//
	        graph.addLink("G", "D", true, 1);//
	       
	        graph.addLink("H", "I", true, 1);
	        
	        graph.addLink("I", "H", true, 1);//
	        graph.addLink("I", "F", true, 1);//
	      
			
		}	
		
    	public static void init2() {
    		nodes = new ArrayList<Vertex>();
			edges = new ArrayList<Link>();
			
		
			nodes.add(new Vertex("A","0"));
			nodes.add(new Vertex("B","1"));
			nodes.add(new Vertex("C", "2"));
			nodes.add(new Vertex("D","3"));
			nodes.add(new Vertex("E", "4"));
			nodes.add(new Vertex("F", "5"));
			nodes.add(new Vertex("G", "6"));
			nodes.add(new Vertex("H", "7"));
			nodes.add(new Vertex("I", "8"));
			
			
			SearchBetweenTwoNode.addLane("Edge_0", 0, 1, 1);
			SearchBetweenTwoNode.addLane("Edge_1", 0, 3, 1);
			SearchBetweenTwoNode.addLane("Edge_2", 0, 2, 1);
			
			SearchBetweenTwoNode.addLane("Edge_3", 1, 6, 1);
			
			SearchBetweenTwoNode.addLane("Edge_4", 2, 3, 1);
			SearchBetweenTwoNode.addLane("Edge_5", 2, 4, 1);
			
			SearchBetweenTwoNode.addLane("Edge_6", 3, 6, 1);
			
			SearchBetweenTwoNode.addLane("Edge_7", 4, 7, 1);
			SearchBetweenTwoNode.addLane("Edge_8", 4, 5, 1);
			
			SearchBetweenTwoNode.addLane("Edge_9", 5, 8, 1);
			
			SearchBetweenTwoNode.addLane("Edge_10", 6, 3, 1);
			
			SearchBetweenTwoNode.addLane("Edge_11", 7, 8, 1);
			
			SearchBetweenTwoNode.addLane("Edge_3", 8, 7, 1);
			SearchBetweenTwoNode.addLane("Edge_4", 8, 5, 1);
    	}
    	
    	@Override
		public void actionPerformed(ActionEvent e) {
			if(typeCombo.getSelectedItem() == "1") {
				init(graph);
			}else {
				init2();
			}
			
		}
    	
    }
    
    class AddEdge implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(typeCombo.getSelectedItem() == "1") {
				String node = addNode_Text.getText();
				String edge = text.getText();
		        graph.addLink(edge, node, true, 1);
		        System.out.println("Добавихте Edge.");
			}else {
				int node = Integer.parseInt(addNode_Text.getText());
				int edge = Integer.parseInt(text.getText());
				SearchBetweenTwoNode.addLane("Edge_14", node, edge, 1);
		        System.out.println("Добавихте Edge.");
			}
			
		}
    }
    
    class AddNodes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			
	        if(typeCombo.getSelectedItem() == "1") {
		
	        	String node = addNode_Text.getText();
		        int weight = Integer.parseInt(addNode_Text1.getText());
		        int x = Integer.parseInt(addNode_Text2.getText());
		        int y = Integer.parseInt(addNode_Text3.getText());
		        graph.addNode(new Node(node, weight,x,y));

		        System.out.println("Добавихте Node.");
				
			}else {
				int node = Integer.parseInt(addNode_Text.getText());
				
				Vertex location = new Vertex("Node_" + node, "Node_" + node);
				nodes.add(location);

		        System.out.println("Добавихте Node.");
			
			}
		}
    	
    }

	static class SearchBetweenTwoNode implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			start = startLabel.getText();
			end = endLabel.getText();
			
			if(typeCombo.getSelectedItem() == "1") {
			
				WeightSearch algorithm = new WeightSearch(graph);
			
			
				if(algorithm.search(start, end)) {
					//System.out.println("Count Node: "+algorithm.queue.size());
					System.out.println("Преминати точка: "+algorithm.count);
				}else {
					System.out.println("nqma pyt!");
				}
			
			}else {
				
				
				
				int start2 = Integer.parseInt(startLabel.getText());
				int end2 = Integer.parseInt(endLabel.getText());

				// Lets check from location Loc_1 to Loc_10
				Graph graph = new Graph(nodes, edges);
				ShortestWayAlgorithm dijkstra = new ShortestWayAlgorithm(graph);
				dijkstra.execute(nodes.get(start2));
				LinkedList<Vertex> path = dijkstra.getPath(nodes.get(end2));


				System.out.println("Брой: " + path.size());
				
				for (Vertex vertex : path) {
					System.out.println(vertex);
				}
				

			}
		}
		public static void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
			Link lane = new Link(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
			Link lane2 = new Link(laneId, nodes.get(destLocNo), nodes.get(sourceLocNo), duration);
			edges.add(lane);
			edges.add(lane2);
		}
		

	}


	
}	
