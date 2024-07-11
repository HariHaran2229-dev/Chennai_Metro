import java.util.*;
import java.io.*;

public class Dijkstra{
    List<String> stations;
    int intermediate;
    public Dijkstra(List<String> a){
        this.stations=new ArrayList<>(a);
    }
    public Dijkstra(){

    }
    private static Dijkstra shortestPath(String src,String des,Graph_M g){
        Queue<Dijkstra> q=new LinkedList<>();
        List<String> cur=new ArrayList<>();
        cur.add(src);
        q.add(new Dijkstra(cur));
        Set<String> visited=new HashSet<>();
        visited.add(src);
        List<String> ans=new ArrayList<>();
        while(!q.isEmpty()){
            Dijkstra obj=q.remove();
            String cur_station=obj.stations.get(obj.stations.size()-1);
            if(cur_station.equals(des)){
                for(String s:obj.stations) ans.add(s);
                break;
            }
            visited.add(cur_station);
            Graph_M.Vertex neighbours=g.vtces.get(cur_station);
            for(String next:neighbours.nbrs.keySet()){
                if(!visited.contains(next)){
                    List<String> prev_stations=new ArrayList<>(obj.stations);
                    prev_stations.add(next);
                    q.add(new Dijkstra(prev_stations));
                }
            }
        }
        Dijkstra path=new Dijkstra(ans);
        return path;
    }
    public static String features(String a, String b, int n, Graph_M g){
        Dijkstra route=shortestPath(a,b,g);
        String solution_path=new String();
        solution_path+=route.stations.get(0);
        solution_path+="->";
        List<String> res=route.stations;
        int count = 0;
        for(int i=1;i<res.size()-1;i++){
            int index = res.get(i).indexOf('~');
            String s = res.get(i).substring(index+1);
            if(s.length()==2){
                String prev = res.get(i-1).substring(res.get(i-1).indexOf('~')+1);
                String next = res.get(i+1).substring(res.get(i+1).indexOf('~')+1);

                if(prev.equals(next)){
                    solution_path+= res.get(i);
                    solution_path+="->";
                }
                else{
                    solution_path+=res.get(i);
                    solution_path+=" ==> ";
                }
            }
            else{
                solution_path+= res.get(i);
                solution_path+="->";
            }
        }
        solution_path+=b;
        if(n==0) return solution_path;
        else if(n==1){
            int time=route.stations.size()-1;
            time=4*time;
            solution_path+="\t";
            solution_path+=time;
            return solution_path;
        }
        else if(n==2){
            int cost=0;
            int intermediate=route.stations.size()-2;
            if(intermediate<0) cost=0;
            else if(intermediate==0) cost=10;
            else if(intermediate<=2) cost=20;
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