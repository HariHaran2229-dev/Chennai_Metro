import java.util.*;
import java.io.*;

public Dijkstra{
    String station_name;
    List<String> stations;
    int cost;
    public Dijkstra(String s,List<String> a,int c){
        this.stations=a;
        this.station_name=s;
        this.cost=c;
    }
    public shortestPath(String src,String des){
        Vertex neighbours=vtces.get(src);
        PriorityQueue<Dijkstra> q=new PriorityQueue<>((a,b)->a.stations.size()-b.stations.size());
        q.add(new Dijkstra(src,
    }
}
