import java.util.Scanner;

public class Demo {
    private final World world;
    public Demo(World world) {
        this.world = world;
    }


    public void start(){
        while (true){
            if(world.spritesSize()==0)break;
            move();
        }
    }

    private void move() {
        world.move();
    }


}
