import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class World {
    private List<Sprite> sprites = new ArrayList<>();
    private List<Sprite> collisionSprites = new ArrayList<>();
    private static final int INIT_SPRITE_NUM = 10;

    public World() {
        sprites.addAll(Sprite.creates(INIT_SPRITE_NUM));
        printAllSprites();
    }

    public void move(Sprite sprite, int x2) {
        getCollisionSprites(sprite.getCoordinate(), x2);
        printCollisionSprites();

        for (int i = 0; i < collisionSprites.size(); i++) {
            if(!sprite.collide(this, collisionSprites.get(i))) break;
        }


        System.out.println("---------");
        printAllSprites();
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
    }

    public List<Sprite> getSprites() {
        return sprites;
    }
}
