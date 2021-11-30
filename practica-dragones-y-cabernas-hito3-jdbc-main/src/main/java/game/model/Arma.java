package game.model;

public class Arma {


    private String name;
    private int damage;
    private int weight;
    private String role;

    public Arma(String name, int damage, int weight, String role){
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getWeight(){
        return weight;
    }

    public String getRole(){
        return role;
    }

}
