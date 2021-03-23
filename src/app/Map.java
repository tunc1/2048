class Map
{
    private int array[][];
    private int height=4,width=4;
    public Map(int height,int width)
    {
        this.height=height;
        this.width=width;
        array=new int[height][width];
    }
    public boolean isEmpty(int x,int y)
    {
        return get(x,y)==0;
    }
    public int get(int x,int y)
    {
        return array[y][x];
    }
    public int get(int[] xy)
    {
        return get(xy[0],xy[1]);
    }
    public void set(int x,int y,int number)
    {
        array[y][x]=number;
    }
    public void set(int[] xy,int number)
    {
        set(xy[0],xy[1],number);
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeigth()
    {
        return height;
    }
    public int[][] array()
    {
        int[][] tmp=new int[height][width];
        for(int y=0;y<height;y++)
            tmp[y]=array[y].clone();
        return tmp;
    }
}