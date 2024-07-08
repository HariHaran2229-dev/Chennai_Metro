import java.util.*;
import java.io.*;

public class Dijkstra{
    List<String> stations;
    int intermediate;
    public Dijkstra(List<String> a){
        this.stations=new ArrayList<>(a);
    }
    public dDjkstra(){
            
    }
    private Dijkstra shortestPath(String src,String des,Graph vtces){
        Queue<Dijkstra> q=new LinkedList<>();
        List<String> cur=new ArrayList<>();
        cur.add(src);
        int[] quickPath=new int[vtces.size()];
        Arrays.fill(quickPath,Integer.MAX_VALUE);
        q.add(new Dijkstra(cur));
        Set<String> visited=new HashSet<>();
        visited.add(src);
        Dijkstra path=new Dijkstra();
        while(!q.isEmpty()){
            Dijkstra obj=q.remove();
            String cur_station=obj.stations.get(obj.stations.size()-1);
            if(cur_station==des){
                path=obj;
                break;
            }
            visited.add(cur_station);
            Vertex neighbours=vtces.get(cur_station);
            for(String next:neighbours.nbrs.getkeySet()){
                if(!visited.contains(next)){
                    List<String> prev_stations=obj.stations;
                    prev_stations.add(next);
                    q.add(new Dijkstra(prev_stations));
                }
            }
        }
        return path;
    }
    public String features(String a,String b,int n,Graph vtces){
        Dijkstra path=shortestPath(a,b,vtces);
        String solution_path=new String();
        solution_path+=path.stations.get(0);
        for(int i=1;i<path.stations.size();i++){
            solution_path+="->"
            solution_path+=path.stations.get(i);    
        }
        if(n==0) return solution_path;
        else if(n==1){
            int time=path.stations.size()-1;
            time=4*time;
            solution_path+="\t";
            solution_path+=time;
            return solution_path;
        }
        else if(n==2){
            int cost=0;
            int intermediate=path.stations.size()-2;
            if(intermediate<0) cost=0;
            else if(intermediate==0) cost=10;
            else if(intermediate<=2) cost=20
            else if(intermediate<=4) cost=30;
            else if(intermediate<=6) cost=40;
            else cost=50;
            solution_path+="\t";
            solution_path+=cost;
            return solution_path;
        }
        return new String("Invalid");
    }
}
