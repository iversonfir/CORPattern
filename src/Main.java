public class Main {
    public static void main(String[] args) {
        World world=new World(new HeroAndFireCollision(new HeroAndWaterCollision(new WaterAndFireCollision(new SameSpritesCollision(null)))));
        Demo demo = new Demo(world);
        demo.start();
    }
}
