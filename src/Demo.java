import java.util.Scanner;

public class Demo {
    private  World world=new World();



    public void start(){


            move();

    }

    private void move() {
        Scanner in =new Scanner(System.in);
        System.out.println("請輸入兩個數字，用空白分開");
        String input=in.nextLine();
        String res[]=input.split(" ");
        int x1=Integer.valueOf(res[0]);
        int x2=Integer.valueOf(res[1]);
        System.out.println(""+x1+" "+x2);
        Sprite sprite=world.querySprite(x1);
        if(sprite==null){
            move();
            return;
        }
        System.out.println(sprite.toString());
        System.out.println("--------");
        world.move(sprite,x2);
    }


}
