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

        //test
        sprites.add(new Hero(0));
        coordinates.remove(0);
        //test

        for (Integer coordinate : coordinates) {
            sprites.add(create(coordinate));
        }

        return sprites;
    }

    private static Sprite create(int coordinate){
         Symbol [] symbols=Symbol.values();
         int i=random.nextInt(3);
        Sprite sprite=null;
//         if(i==1){
//             sprite=new Hero(coordinate);
//         }
//         else if(i==2){
//             sprite= new Water(coordinate);
//         }
//         else {
             sprite=new Fire(coordinate);

//         }

        return sprite;
    }


    public int getCoordinate() {
        return coordinate;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    /**
     * this(火球、水球) 撞到就結束、this 是hero 死掉才結束
     * @param world
     * @param sprite
     * @return
     */
    public boolean collide(World world, Sprite sprite) {
// 相同屬性 則移動失敗
        if (this.symbol.equals(Symbol.WATER) && sprite.symbol.equals(Symbol.FIRE) ||
                this.symbol.equals(Symbol.FIRE) && sprite.symbol.equals(Symbol.WATER)) {
            world.getSprites().remove(this);
            world.getSprites().remove(sprite);
            return false;
        } else if (this.symbol.equals(Symbol.WATER) && sprite.symbol.equals(Symbol.HERO)) {
            world.getSprites().remove(this);
            Hero hero = (Hero) sprite;
            hero.heal(10);
            if (hero.isDead()) {
                world.getSprites().remove(hero);
            }
            return false;
        } else if (this.symbol.equals(Symbol.HERO) && sprite.symbol.equals(Symbol.WATER)) {
            world.getSprites().remove(sprite);
            Hero hero = (Hero) this;
            hero.heal(10);
            hero.setCoordinate(sprite.getCoordinate());
            if (hero.isDead()) {
                world.getSprites().remove(hero);
                return false;
            }
        } else if (this.symbol.equals(Symbol.FIRE) && sprite.symbol.equals(Symbol.HERO)) {
            world.getSprites().remove(this);
            Hero hero = (Hero) sprite;
            hero.injured(10);

            if (hero.isDead()) {
                world.getSprites().remove(hero);
            }
            return false;
        } else if (this.symbol.equals(Symbol.HERO) && sprite.symbol.equals(Symbol.FIRE)) {
            world.getSprites().remove(sprite);
            Hero hero = (Hero) this;
            hero.injured(10);
            hero.setCoordinate(sprite.getCoordinate());
            if (hero.isDead()) {
                world.getSprites().remove(hero);
                return false;
            }
        } else if (this.symbol.equals(sprite.symbol)) {
            //TODO move fail
            return false;
        }

        return true;
    }


    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }
}
