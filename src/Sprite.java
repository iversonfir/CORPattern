import java.util.*;

public class Sprite {
    protected  Symbol symbol;
    protected  int coordinate;

    private static final Random random=new Random();


    public Sprite(Symbol symbol, int coordinate) {
        this.symbol = symbol;
        this.coordinate = coordinate;
    }

    public static List<Sprite> creates(int initSpriteNum) {
        List<Sprite> sprites=new ArrayList<>();

        Set<Integer> coordinates=new HashSet<Integer>();

        while (true){
            if(coordinates.size()>=initSpriteNum)break;
            coordinates.add(random.nextInt(30));
        }

        for (Integer coordinate : coordinates) {
            sprites.add(create(coordinate));
        }
        return sprites;
    }

    private static Sprite create(int coordinate){
         Symbol [] symbols=Symbol.values();
         int i=random.nextInt(3);
        Sprite sprite=null;
         if(i==1){
             sprite=new Hero(coordinate);
         }
         else if(i==2){
             sprite= new Water(coordinate);
         }
         else {
             sprite=new Fire(coordinate);
         }

        return sprite;
    }


    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }


    public boolean isDead() {
        return this.coordinate<0?true:false;
    }
}
