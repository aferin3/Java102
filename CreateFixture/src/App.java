import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> teams = new ArrayList<>();

        teams.add("Galatasaray");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Trabzonspor");
        teams.add("Genlerbirliği");
        teams.add("Hatayspor");
        teams.add("Karagümrük");
        teams.add("Eskişehirspor");
        
        
        CreateFixture createFixture = new CreateFixture(teams);
        
        List<String> fixtures = createFixture.generateFixtures();
        int j =0;
        for (int i = 0; i < fixtures.size(); i+=(teams.size()/2)) {
            if(j==0) System.out.println("\n================ Session 1 ================\n");
            else if(j == teams.size()-1) System.out.println("\n================ Session 2 ================\n");
            System.out.println("\n\t---> Week: "+(j+1) + " <---\n");
            for(int k = 0; k<teams.size()/2;k++){
                System.out.println("\t"+fixtures.get(i+k)); 
            }
        
            j++;
        }
        
      
        
        


    }
}
