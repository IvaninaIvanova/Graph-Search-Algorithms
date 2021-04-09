package uni.fmi.bachelors;

import java.util.ArrayList;

public class Node {
    public String name; // име на Нода
    public double weight; //тежест на Нода (колко трудно се минава през даден нод)
    public double x;// x-координати
    public double y; //y - координати
    public boolean isTested; //маркира дали са взели децата не елемента
    public int depth=-1;//дълбочина
	public double distanceToEnd;

    ArrayList<Link> links; //списък с връзките на нода
   
    public Node (String name) //конструктор който иска само име
    {
        this.name=name;
        links = new ArrayList <>();
    }
    
    public Node (String name, double weight, double x, double y) {
    	this(name);
        this.weight=weight;
        this.x=x;
        this.y=y;
    }

    public Node (String name, double x, double y)//конструктор, който иска координати
    {
        this.name=name;
        links = new ArrayList <>();
        this.x=x;
        this.y=y;
    }

    public Node (String name, double weight)//конструктор, който иска тежест
    {
        this(name);
        this.weight=weight;
    }

    public void addLink(Link link) throws MyCustomException//не връща нищо само добавя връзка в списъка
    {
        if (link==null)
        {
            throw new MyCustomException("Не съществуващ линк");
        }
        links.add(link);
    }

    public ArrayList<Node> getRelatedNodes (){ //взима свързани възели
        ArrayList<Node> nodes = new ArrayList<> ();
        for (Link link: links) {
            if (!nodes.contains(link.relatedNode))
                nodes.add(link.relatedNode);
        }
        return nodes;
    }



}
