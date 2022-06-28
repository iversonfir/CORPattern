public class HeroAndFireCollision extends CollisionType {
    public HeroAndFireCollision(CollisionType next) {
        super(next);
    }


    @Override
    public boolean match(Sprite collider, Sprite collided) {
        return Symbol.HERO.equals(collider.symbol) && Symbol.FIRE.equals(collided.symbol) ||
                Symbol.FIRE.equals(collider.symbol) && Symbol.HERO.equals(collided.symbol);
    }

    @Override
    public void doHandling(Sprite collider, Sprite collided) {

        if (Symbol.HERO.equals(collider.symbol) && Symbol.FIRE.equals(collided.symbol)) {
            Hero hero = (Hero) collider;
            hero.injured(10);
            hero.setCoordinate(collided.getCoordinate());
            collided.setCoordinate(-1);

        } else if (Symbol.FIRE.equals(collider.symbol) && Symbol.HERO.equals(collided.symbol)) {
            collider.setCoordinate(-1);
            Hero hero = (Hero) collided;
            hero.injured(10);
        }

    }
}
