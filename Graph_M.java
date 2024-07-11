import java.util.*;


public class Graph_M
{
    public class Vertex
    {
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    static HashMap<String, Vertex> vtces;

    public Graph_M()
    {
        vtces = new HashMap<>();
    }

    public int numVetex()
    {
        return this.vtces.size();
    }

    public boolean containsVertex(String vname)
    {
        return this.vtces.containsKey(vname);
    }

    public void addVertex(String vname)
    {
        Vertex vtx = new Vertex();
        vtces.put(vname, vtx);
    }

    public void removeVertex(String vname)
    {
        Vertex vtx = vtces.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

        for (String key : keys)
        {
            Vertex nbrVtx = vtces.get(key);
            nbrVtx.nbrs.remove(vname);
        }

        vtces.remove(vname);
    }

    public int numEdges()
    {
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        int count = 0;

        for (String key : keys)
        {
            Vertex vtx = vtces.get(key);
            count = count + vtx.nbrs.size();
        }

        return count / 2;
    }

    public boolean containsEdge(String vname1, String vname2)
    {
        Vertex vtx1 = vtces.get(vname1);
        Vertex vtx2 = vtces.get(vname2);

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
            return false;
        }

        return true;
    }

    public void addEdge(String vname1, String vname2, int value)
    {
        Vertex vtx1 = vtces.get(vname1);
        Vertex vtx2 = vtces.get(vname2);

        if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
            return;
        }

        vtx1.nbrs.put(vname2, value);
        vtx2.nbrs.put(vname1, value);
    }

    public void removeEdge(String vname1, String vname2)
    {
        Vertex vtx1 = vtces.get(vname1);
        Vertex vtx2 = vtces.get(vname2);

        //check if the vertices given or the edge between these vertices exist or not
        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
            return;
        }

        vtx1.nbrs.remove(vname2);
        vtx2.nbrs.remove(vname1);
    }
    public void Create_Metro_Map()
    {
        addVertex("WASHERMENPET METRO~R");
        addVertex("MANNADI~R");
        addVertex("HIGH COURT~R");
        addVertex("CENTRAL METRO~RB");
        addVertex("EGMORE METRO~B");
        addVertex("NEHRU PARK~B");
        addVertex("KILPAUK~B");
        addVertex("PACHAIYAPPAS COLLEGE~B");
        addVertex("SHENOY NAGAR~B");
        addVertex("ANNA NAGAR EAST~B");
        addVertex("ANNA NAGAR TOWER~B");
        addVertex("THIRUMANGALAM~B");
        addVertex("KOYAMBEDU~B");
        addVertex("CMBT~B");
        addVertex("ARUMBAKKAM~B");
        addVertex("VADAPALANI~B");
        addVertex("ASHOK NAGAR~B");
        addVertex("EKKATTUTHANGAL~B");
        addVertex("ALANDUR~RB");
        addVertex("ST.THOMAS MOUNT METRO~B");
        addVertex("GOVERNMENT ESTATE~R");
        addVertex("LIC~R");
        addVertex("THOUSAND LIGHTS~R");
        addVertex("AG-DMS~R");
        addVertex("TEYNAMPET~R");
        addVertex("NANDANAM~R");
        addVertex("SAIDAPET METRO~R");
        addVertex("LITTLE MOUNT~R");
        addVertex("GUINDY METRO~R");
        addVertex("NANGANALLUR ROAD~R");
        addVertex("MEENAMBAKKAM METRO~R");
        addVertex("AIRPORT~R");

        addEdge("WASHERMENPET METRO~R", "MANNADI~R", 10);
        addEdge("MANNADI~R", "HIGH COURT~R", 10);
        addEdge("HIGH COURT~R", "CENTRAL METRO~RB", 10);
        addEdge("CENTRAL METRO~RB", "EGMORE METRO~B", 10);
        addEdge("CENTRAL METRO~RB", "GOVERNMENT ESTATE~R", 10);
        addEdge("GOVERNMENT ESTATE~R", "LIC~R", 10);
        addEdge("LIC~R", "THOUSAND LIGHTS~R", 10);
        addEdge("THOUSAND LIGHTS~R", "AG-DMS~R", 10);
        addEdge("AG-DMS~R", "TEYNAMPET~R", 10);
        addEdge("TEYNAMPET~R", "NANDANAM~R", 10);
        addEdge("NANDANAM~R", "SAIDAPET METRO~R", 10);
        addEdge("SAIDAPET METRO~R", "LITTLE MOUNT~R", 10);
        addEdge("LITTLE MOUNT~R", "GUINDY METRO~R", 10);
        addEdge("GUINDY METRO~R", "ALANDUR~RB", 10);
        addEdge("ALANDUR~RB", "NANGANALLUR ROAD~R", 10);
        addEdge("NANGANALLUR ROAD~R", "MEENAMBAKKAM METRO~R", 10);
        addEdge("MEENAMBAKKAM METRO~R", "AIRPORT~R", 10);
        addEdge("EGMORE METRO~B", "NEHRU PARK~B", 10);
        addEdge("NEHRU PARK~B", "KILPAUK~B", 10);
        addEdge("KILPAUK~B", "PACHAIYAPPAS COLLEGE~B", 10);
        addEdge("PACHAIYAPPAS COLLEGE~B", "SHENOY NAGAR~B", 10);
        addEdge("SHENOY NAGAR~B", "ANNA NAGAR EAST~B", 10);
        addEdge("ANNA NAGAR EAST~B", "ANNA NAGAR TOWER~B", 10);
        addEdge("ANNA NAGAR TOWER~B", "THIRUMANGALAM~B", 10);
        addEdge("THIRUMANGALAM~B", "KOYAMBEDU~B", 10);
        addEdge("KOYAMBEDU~B", "CMBT~B", 10);
        addEdge("CMBT~B","ARUMBAKKAM~B", 10);
        addEdge("ARUMBAKKAM~B", "VADAPALANI~B", 10);
        addEdge("VADAPALANI~B", "ASHOK NAGAR~B", 10);
        addEdge("ASHOK NAGAR~B", "EKKATTUTHANGAL~B", 10);
        addEdge("EKKATTUTHANGAL~B", "ALANDUR~RB", 10);
        addEdge("ALANDUR~RB", "ST.THOMAS MOUNT METRO~B", 10);
    }


    public void display_Stations()
    {
        System.out.println("\n***********************************************************************\n");
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        int i=1;
        for(String key : keys)
        {
            System.out.println(i + ". " + key);
            i++;
        }
        System.out.println("\n***********************************************************************\n");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed)
    {
        // DIR EDGE
        if (containsEdge(vname1, vname2)) {
            return true;
        }

        //MARK AS DONE
        processed.put(vname1, true);

        Vertex vtx = vtces.get(vname1);
        ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

        //TRAVERSE THE NBRS OF THE VERTEX
        for (String nbr : nbrs)
        {

            if (!processed.containsKey(nbr))
                if (hasPath(nbr, vname2, processed))
                    return true;
        }

        return false;
    }

}