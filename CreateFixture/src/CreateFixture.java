import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CreateFixture {
    private List<String> teams;
    private List<String> fixtures;

    public CreateFixture(List<String> teams) {
        this.teams = teams;
        this.fixtures = new ArrayList<>();
    }

    public List<String> generateFixtures() {
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        Collections.shuffle(teams); // Shuffle teams randomly

        int numWeeks = teams.size() - 1;
        int numMatchesPerWeek = teams.size() / 2;

        List<String> homeTeams = new ArrayList<>(teams.subList(0, numMatchesPerWeek));
        List<String> awayTeams = new ArrayList<>(teams.subList(numMatchesPerWeek, teams.size()));
        Collections.reverse(awayTeams); // Reverse away teams list for each week
        
        for (int week = 0; week < numWeeks; week++) {
            for (int match = 0; match < numMatchesPerWeek; match++) {
                String fixture = homeTeams.get(match) + " vs " + awayTeams.get(match);
                fixtures.add(fixture);
            }
            rotateTeams(homeTeams, awayTeams);
        }
       
        for (int week = 0; week < numWeeks; week++) {
            for (int match = 0; match < numMatchesPerWeek; match++) {
                String fixture = awayTeams.get(match) + " vs " + homeTeams.get(match);
                fixtures.add(fixture);
            }
            rotateTeams(homeTeams, awayTeams);
        }

        return fixtures;
    }

    private void rotateTeams(List<String> homeTeams, List<String> awayTeams) {
        // Rotate teams for next week's fixtures
        String lastHomeTeam = homeTeams.remove(homeTeams.size() - 1);
        String firstAwayTeam = awayTeams.remove(0);
        awayTeams.add(lastHomeTeam);
        homeTeams.add(1, firstAwayTeam);
    }

    public List<String> getTeams() {
        return teams;
    }
    
    
}
