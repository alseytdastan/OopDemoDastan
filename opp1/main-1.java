
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        SportsClub club1 = new SportsClub("Astana Warriors", "Astana");
        SportsClub club2 = new SportsClub("Almaty Tigers", "Almaty");

        Player player1 = new Player("Almas", 25, "Football", club1);
        Player player2 = new Player("Aidar", 22, "Basketball", club2);
        Player player3 = new Player("Aslan", 27, "Football", club1);
        Player player4 = new Player("Talgat", 30, "Tennis", club2);

  
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

       
        System.out.println("Players who play Football:");
        List<Player> footballPlayers = players.stream()
                .filter(player -> "Football".equals(player.getSport()))
                .collect(Collectors.toList());
        footballPlayers.forEach(System.out::println);

      
        System.out.println("\nPlayers sorted by age:");
        List<Player> sortedPlayers = players.stream()
                .sorted(Comparator.comparingInt(Player::getAge))
                .collect(Collectors.toList());
        sortedPlayers.forEach(System.out::println);

        
        String searchName = "Jane Smith";
        System.out.println("\nSearching for player: " + searchName);
        players.stream()
                .filter(player -> searchName.equals(player.getName()))
                .forEach(System.out::println);
    }
}


abstract class Sport {
    protected String name;

    public Sport(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();
}


class SportsClub extends Sport {
    private String location;

    public SportsClub(String name, String location) {
        super(name);
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void display() {
        System.out.println("Sports Club: " + this.name + ", Location: " + this.location);
    }

    @Override
    public String toString() {
        return "SportsClub{name='" + this.name + '\'' + ", location='" + this.location + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SportsClub that = (SportsClub) obj;
        return this.name.equals(that.name) && this.location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + location.hashCode();
    }
}

class Player {
    private String name;
    private int age;
    private String sport;
    private SportsClub sportsClub;

    public Player(String name, int age, String sport, SportsClub sportsClub) {
        this.name = name;
        this.age = age;
        this.sport = sport;
        this.sportsClub = sportsClub;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSport() {
        return this.sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public SportsClub getSportsClub() {
        return this.sportsClub;
    }

    public void setSportsClub(SportsClub sportsClub) {
        this.sportsClub = sportsClub;
    }

    @Override
    public String toString() {
        return "Player{name='" + this.name + '\'' + ", age=" + this.age + ", sport='" + this.sport + '\'' + ", sportsClub=" + this.sportsClub.getName() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return this.age == player.age && this.name.equals(player.name) && this.sport.equals(player.sport) && this.sportsClub.equals(player.sportsClub);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age + sport.hashCode() + sportsClub.hashCode();
    }
}

