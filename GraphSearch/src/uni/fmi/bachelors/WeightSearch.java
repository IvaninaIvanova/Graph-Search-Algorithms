package uni.fmi.bachelors;

import java.util.ArrayList;

public class WeightSearch implements SearchAlgorithm {

    private Graph graph;
    private double destinationX;
	private double destinationY;
	ArrayList<Node> queue = new ArrayList<>();
	public int count;
	
    public WeightSearch (Graph graph) //Конструктор, който да вкарва графа
    {
        this.graph=graph;
    }

    @Override
    public boolean search(String from, String to) {
    	graph.resetGraph();
    	
    	Node startNode = graph.getNode(from); //начален елемент
        Node endNode= graph.getNode(to);//краен елемент
        
        if(startNode == null || endNode == null) { //ако стартовия или крайния нод не са част от графа (==null)
        	return false;
        }

        destinationX = endNode.x;
		destinationY = endNode.y;
		
        
        count++;
        startNode.depth=0;
        queue.add(startNode);
        
        while(!queue.isEmpty())//докато има нещо във списъка въртим
            {
                Node testNode= queue.remove(0);//взимаме първие елемент и след това го прмахваме

                System.out.println(testNode.name);//изписваме през кои елементи сме минали

                if(testNode.name == endNode.name){ //проверяваме дали името на тестовия нод не същото като името, което търсим

                   

                    return true;//ако е същото връща true;
                }

                testNode.isTested=true; //маркираме нода, че е тестван

                ArrayList<Node> relatedNodes =  testNode.getRelatedNodes();//взимаме всичките връзки на нода
                for(Node el : relatedNodes){
                    if (el.depth==-1)  //trqbva li da gi ima
                        el.depth =testNode.depth+1;
                                addNodeToQueue(queue,el);
                                count++;
                }
                
            }
        
            return false;
    }

    
    private void addNodeToQueue(ArrayList<Node> queue, Node placingNode) {
        
    	if(placingNode.isTested || queue.contains(placingNode))//ако елемента е тестван и опшката съсдържа елемента
            return;//да прекрати изпълнението  на метода

    	placingNode.distanceToEnd = calculateDistenceToEnd(placingNode.weight, placingNode.x, placingNode.y);
    	
    	for (int i=0;i<queue.size();i++){
            if (placingNode.distanceToEnd < queue.get(i).distanceToEnd){ //ако тежеста на елемента, на който търсим място е по-малка от тежеста на текущия елемента, сме намерили място на ел
                queue.add(i,placingNode);//добавяме го на конкретната позиция
                return;//Използваме return, не break,защото при break става преповтаряне на алементи
            }
        }

    	queue.add(placingNode);
    }
 
    private double calculateDistenceToEnd(double weight, double x, double y) {
		
		double a = Math.abs(x - destinationX);
		double b = Math.abs(y - destinationY);
		
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		double d =  c*0.8 + weight*0.6 ;
		
		return d;
	
 }
}
