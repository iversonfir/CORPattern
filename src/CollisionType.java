

public abstract class CollisionType {

    protected CollisionType next;

    public CollisionType(CollisionType next) {
        this.next = next;
    }

    /**
     * 主動撞擊如果是(火球、水球) 撞到就結束、如果是是hero 死掉才結束
     */
    public void collisionHandle(Sprite collider, Sprite collided) {
        if (match(collider, collided)) {
            doHandling(collider, collided);
        } else {
            next.collisionHandle(collider, collided);
        }
    }

    public abstract boolean match(Sprite collider, Sprite collided);

    public abstract void doHandling(Sprite collider, Sprite collided);

}
