import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class World {
    private List<Sprite> sprites = new ArrayList<>();
    private List<Sprite> collisionSprites = new LinkedList<>();
    private static final int INIT_SPRITE_NUM =10;
    private static final Scanner in =new Scanner(System.in);
    private CollisionType collisionType;


    public World(CollisionType collisionType) {
        this.collisionType=collisionType;
        sprites.addAll(Sprite.creates(INIT_SPRITE_NUM));
        printAllSprites();
    }

    public void move() {
        System.out.println("請輸入兩個數字，用空格分開，第一個數字必須選到生命體");
        String input=in.nextLine();
        String[] res =input.split(" ");
        int x1=Integer.parseInt(res[0]);
        int x2=Integer.parseInt(res[1]);

try {
    Sprite collider=querySprite(x1);
    if(collider==null){
        System.out.println("第一個沒有選到生命體");
        move();
    }
    System.out.println("你選到了"+collider.toString());
    System.out.println("--------");

    getCollisionSprites(collider.getCoordinate(), x2);


    for (Sprite collided:collisionSprites) {
        collisionType.collisionHandle(collider,collided);

        if(collider.symbol.equals(collided.symbol)){
            break;
        }

        if(collided.isDead()){
            this.sprites.remove(collided);
        }

        if(collider.isDead()){
            this.sprites.remove(collider);
            break;
        }else {
            collider.setCoordinate(x2);
        }
    }


    printAllSprites();
}catch (Exception e){
    System.out.println("沒有選到生命");
    move();
}

    }

    private void printAllSprites() {
        sprites.stream()
                .sorted(comparing(Sprite::getCoordinate))
                .forEach(System.out::println);
    }

    public Sprite querySprite(int x) {
        return sprites.stream()
                .filter(s -> s.getCoordinate() == x)
                .collect(Collectors.toList())
                .get(0);
    }

    private void getCollisionSprites(int x1, int x2) {

        if(x1-x2>0){
            collisionSprites = (List<Sprite>) sprites.stream()
                    .filter(s -> s.getCoordinate() <x1)
                    .filter(s ->s.getCoordinate() >= x2 )
                    .collect(Collectors.toList());
            return;
        }


        collisionSprites = (List<Sprite>) sprites.stream()
                .filter(s -> s.getCoordinate() >x1)
                .filter(s ->s.getCoordinate() <= x2 )
                .collect(Collectors.toList());
    }

    private void printCollisionSprites() {
        collisionSprites.stream()
                .sorted(comparing(Sprite::getCoordinate))
                .forEach(System.out::println);
        System.out.println("-------");
    }


    public  int spritesSize(){
        return sprites.size();
    }
}
