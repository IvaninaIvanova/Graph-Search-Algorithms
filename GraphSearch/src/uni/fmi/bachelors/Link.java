package uni.fmi.bachelors;

public class Link {
    public double length; //дължина на пътя
    public String type; // типът на пътя
    public Node relatedNode; // към кой нод е свързан пътя
    
    public  String id;
    public  Vertex source;
    public  Vertex destination;
    public  int weight;

    public Link(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public Link (Node relatedNode) //конструктор само с овързания Node
    {
        this.relatedNode=relatedNode;
    }

    public Link (Node relatedNode, double pathLength) //Конструктор искащ и дължина
    {
        this(relatedNode);
        length= pathLength;
    }

    public Link (Node relatedNode, double pathLength,String type)// конструктор за дължина и тип
    {
        this(relatedNode,pathLength );
        this.type=type;
    }
    //
    public String getId() {
        return id;
    }
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }
}
