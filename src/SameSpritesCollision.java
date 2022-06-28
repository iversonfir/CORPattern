public class SameSpritesCollision extends CollisionType {
    public SameSpritesCollision(CollisionType next) {
        super(next);
    }

    @Override
    public boolean match(Sprite collider, Sprite collided) {
        return  collider.symbol.equals(collided.symbol);
    }

    @Override
    public void doHandling(Sprite collider, Sprite collided) {
    }
}
