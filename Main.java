import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Graph_M g = new Graph_M();
        g.Create_Metro_Map();

        System.out.println("\n\t\t\t****WELCOME TO THE METRO APP*****");

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        //STARTING SWITCH CASE
        while(true)
        {
            System.out.println("\t\t\t\t~~LIST OF ACTIONS~~\n\n");
            System.out.println("1. LIST ALL THE STATIONS IN THE MAP");
            System.out.println("2. GET SHORTEST PATH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
            System.out.println("3. GET SHORTEST TIME TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
            System.out.println("4. GET LOWEST COST TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
            System.out.println("5. EXIT THE MENU");
            System.out.print("\nENTER YOUR CHOICE FROM THE ABOVE LIST (1 to 5) : ");
            int choice = -1;
            try {
                choice = Integer.parseInt(inp.readLine());
            } catch(Exception e) {
                // default will handle
            }
            System.out.print("\n***********************************************************\n");
            if(choice == 5)
            {
                System.exit(0);
            }
            switch(choice)
            {
                case 1:
                    g.display_Stations();
                    break;

                case 2:
                    String st1 = "", st2 = "";
                    System.out.println("ENTER THE SOURCE AND DESTINATION STATIONS");
                    st1 = (inp.readLine()).toUpperCase();
                    st2 = (inp.readLine()).toUpperCase();
                    HashMap<String, Boolean> processed = new HashMap<>();
                    if(!g.containsVertex(st1) || !g.containsVertex(st2) || !g.hasPath(st1, st2, processed))
                        System.out.println("THE INPUTS ARE INVALID");
                    else
                        System.out.println("SHORTEST DISTANCE FROM "+st1+" TO "+st2+" IS "+Dijkstra.features(st1, st2,0,g));
                    break;

                case 3:
                    System.out.print("ENTER THE SOURCE STATION: ");
                    String sat1 = (inp.readLine()).toUpperCase();
                    System.out.print("ENTER THE DESTINATION STATION: ");
                    String sat2 = (inp.readLine()).toUpperCase();

                    HashMap<String, Boolean> processed1= new HashMap<>();
                    if(!g.containsVertex(sat1) || !g.containsVertex(sat2) || !g.hasPath(sat1, sat2, processed1))
                        System.out.println("THE INPUTS ARE INVALID");
                    else System.out.println("SHORTEST TIME FROM ("+sat1+") TO ("+sat2+") IS "+Dijkstra.features(sat1, sat2,1,g)+" Minutes ");
                    break;

                case 4:
                    System.out.print("ENTER THE SOURCE STATION: ");
                    String sat3 = (inp.readLine()).toUpperCase();
                    System.out.print("ENTER THE DESTINATION STATION: ");
                    String sat4 = (inp.readLine()).toUpperCase();

                    HashMap<String, Boolean> processed2= new HashMap<>();
                    if(!g.containsVertex(sat3) || !g.containsVertex(sat4) || !g.hasPath(sat3, sat4, processed2))
                        System.out.println("THE INPUTS ARE INVALID");
                    else System.out.println("LOWEST COST FROM ("+sat3+") TO ("+sat4+") IS "+Dijkstra.features(sat3, sat4,2,g)+" Rs ");
                    break;

                default:  //If switch expression does not match with any case,
                    //default statements are executed by the program.
                    //No break is needed in the default case
                    System.out.println("Please enter a valid option! ");
                    System.out.println("The options you can choose are from 1 to 6. ");

            }
        }

    }
}