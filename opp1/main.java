public class Main {
    public static void main(String[] args) {
        SportsClub club1 = new SportsClub("Astana Warriors", "Astana");
        SportsClub club2 = new SportsClub("Almaty Tigers", "Almaty");

        Player player1 = new Player("Altai", 25, "Football", club1);
        Player player2 = new Player("Aslan", 22, "Basketball", club2);
        Player player3 = new Player("Almas", 27, "Football", club1);

        club1.printInfo();
        club2.printInfo();

        player1.printInfo();
        player2.printInfo();
        player3.printInfo();


        System.out.println("Are the two clubs the same? " + club1.equals(club2))
        System.out.println("Does " + player1.getName() + " belong to the same club as " + player3.getName() + "? " + player1.getSportsClub().equals(player3.getSportsClub()));
    }
}

class SportsClub {
    private String name;
    private String location;

    public SportsClub(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void printInfo() {
        System.out.println("Sports Club: " + this.name);
        System.out.println("Location: " + this.location);
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SportsClub that = (SportsClub) obj;
        return this.name.equals(that.name) && this.location.equals(that.location);
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

    public void printInfo() {
        System.out.println("Player: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Sport: " + this.sport);
        System.out.println("Sports Club: " + this.sportsClub.getName());
        System.out.println();
    }
}

