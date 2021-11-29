package game.model;

/**
 * Modela un dragón. No es necesario modificar esta clase. Pero debe crear tantas clases como entidades
 * necesite para llevar a cabo esta parte del hito 3. Inclúyalas en el paquete "game.model"
 */
public class Dragon {

    private String name;
    private int life_points;
    private String appareance;

    public Dragon(String name, int life, String appareance) {
        this.name = name;
        this.life_points = life;
        this.appareance = appareance;
    }

    public int getLife() {
        return this.life_points;
    }

    public String getName() {
        return this.name;
    }

    public String getAppareance(){return this.appareance;}
}
