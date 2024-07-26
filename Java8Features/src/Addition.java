public class Addition implements Add{
    @Override
    public void add(int x, int y) {
        int z = x+y;
        System.out.println("sum:"+z);
    }
}
