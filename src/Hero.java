import java.util.Random;

public class Hero extends Sprite{
    private int hp=30;
    private int id=new Random().nextInt(10);
    public Hero(int coordinate) {
        super(Symbol.HERO, coordinate);
    }

    @Override
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
                ", id=" + id +
                ", symbol=" + symbol +
                ", coordinate=" + coordinate +
                '}';
    }
}
