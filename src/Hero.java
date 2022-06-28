import java.util.Random;
import java.util.UUID;

public class Hero extends Sprite{
    private int hp=30;

    public Hero(int coordinate) {
        super(Symbol.HERO, coordinate);
    }


    public boolean isDead(){
        return hp<=0?true:false;
    }

    public int getHp() {
        return hp;
    }
    public  void  injured(int hp){
        this.hp=this.hp-hp;
    }
    public  void  heal(int hp){
        this.hp=this.hp+hp;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "hp=" + hp +
                ", symbol=" + symbol +
                ", coordinate=" + coordinate +
                '}';
    }
}
