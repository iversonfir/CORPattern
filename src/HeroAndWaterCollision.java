public class HeroAndWaterCollision extends CollisionType {
    public HeroAndWaterCollision(CollisionType next) {
        super(next);
    }


    @Override
    public boolean match(Sprite collider, Sprite collided) {
        return  Symbol.HERO.equals(collider.symbol) && Symbol.WATER.equals(collided.symbol)||
                Symbol.WATER.equals(collider.symbol) && Symbol.HERO.equals(collided.symbol);
    }

    @Override
    public void doHandling(Sprite collider, Sprite collided) {

        if(Symbol.HERO.equals(collider.symbol) && Symbol.WATER.equals(collided.symbol) ){
            Hero hero = (Hero) collider;
            hero.heal(10);
            hero.setCoordinate(collided.getCoordinate());
            collided.setCoordinate(-1);

        }else if(Symbol.WATER.equals(collider.symbol) && Symbol.HERO.equals(collided.symbol) ){
            collider.setCoordinate(-1);
            Hero hero = (Hero) collided;
            hero.heal(10);
        }

    }
}
