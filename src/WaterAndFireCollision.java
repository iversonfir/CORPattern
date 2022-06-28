public class WaterAndFireCollision extends CollisionType {
    public WaterAndFireCollision(CollisionType next) {
        super(next);
    }

    @Override
    public boolean match(Sprite collider, Sprite collided) {
        return collider.symbol.equals(Symbol.WATER) && collided.symbol.equals(Symbol.FIRE)||
                collider.symbol.equals(Symbol.FIRE) && collided.symbol.equals(Symbol.WATER);
    }

    @Override
    public void doHandling(Sprite collider, Sprite collided) {
            collider.setCoordinate(-1);
            collided.setCoordinate(-1);
    }
}
