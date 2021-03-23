import java.util.Random;

class MapController
{
    private Random random;
    private Map map;
    private MapView view;
    public MapController(Map map,MapView view)
    {
        this.map=map;
        this.view=view;
        random=new Random();
    }
    private void createRandom()
    {
        int x=random.nextInt(map.getWidth());
        int y=random.nextInt(map.getHeigth());
        while(!map.isEmpty(x,y))
        {
            x=random.nextInt(map.getWidth());
            y=random.nextInt(map.getHeigth());
        }
        map.set(x,y,2);
    }
    public void start()
    {
        for(int i=0;i<2;i++)
            createRandom();
        view.show(map);
        view.message("e:Exit, w:Up, s:Down, a:Left, d:Right");
        char input=view.getInput();
        while(input!='e')
        {
            int[][] array=map.array();
            switch(input)
            {
                case 'w':
                    moveUp();
                break;
                case 's':
                    moveDown();
                break;
                case 'a':
                    moveLeft();
                break;
                case 'd':
                    moveRight();
                break;
                default:
                    view.message("Invalid Input");
                break;
            }
            if(compare(array,map.array()))
                createRandom();
            view.show(map);
            view.message("e:Exit, w:Up, s:Down, a:Left, d:Right");
            input=view.getInput();
        }
    }
    private boolean compare(int[][] array1,int[][] array2)
    {
        for(int i=0;i<array1.length;i++)
        {
            for(int j=0;j<array1[0].length;j++)
            {
                if(array1[i][j]!=array2[i][j])
                    return true;
            }
        }
        return false;
    }
    private void moveLeft()
    {
        for(int y=0;y<map.getHeigth();y++)
        {
            int empties=0;
            for(int x=0;x<map.getWidth();x++)
            {
                if(map.isEmpty(x,y))
                    empties++;
            }
            int[] tmp=new int[map.getWidth()-empties];
            int counter=0;
            for(int x=0;x<map.getWidth();x++)
            {
                if(!map.isEmpty(x,y))
                    tmp[counter++]=map.get(x,y);
            }
            for(int i=0;i<tmp.length-1;i++)
            {
                if(tmp[i]==tmp[i+1])
                {
                    tmp[i]*=2;
                    tmp[i+1]=0;
                }
            }
            for(int i=0;i<tmp.length-1;i++)
            {
                if(tmp[i]==0&&tmp[i+1]!=0)
                {
                    tmp[i]=tmp[i+1];
                    tmp[i+1]=0;
                }
            }
            int x=0;
            for(;x<tmp.length;x++)
                map.set(x,y,tmp[x]);
            for(;x<map.getWidth();x++)
                map.set(x,y,0);
        }
    }
    private void moveRight()
    {
        for(int y=0;y<map.getHeigth();y++)
        {
            int empties=0;
            for(int x=0;x<map.getWidth();x++)
            {
                if(map.isEmpty(x,y))
                    empties++;
            }
            int[] tmp=new int[map.getHeigth()-empties];
            int counter=0;
            for(int x=0;x<map.getWidth();x++)
            {
                if(!map.isEmpty(x,y))
                    tmp[counter++]=map.get(x,y);
            }
            for(int i=tmp.length-1;i>0;i--)
            {
                if(tmp[i]==tmp[i-1])
                {
                    tmp[i]*=2;
                    tmp[i-1]=0;
                }
            }
            for(int i=tmp.length-1;i>0;i--)
            {
                if(tmp[i]==0&&tmp[i-1]!=0)
                {
                    tmp[i]=tmp[i-1];
                    tmp[i-1]=0;
                }
            }
            int x=0;
            for(;x<empties;x++)
                map.set(x,y,0);
            for(;x<map.getWidth();x++)
                map.set(x,y,tmp[x-empties]);
        }
    }
    private void moveUp()
    {
        for(int x=0;x<map.getWidth();x++)
        {
            int empties=0;
            for(int y=0;y<map.getHeigth();y++)
            {
                if(map.isEmpty(x,y))
                    empties++;
            }
            int[] tmp=new int[map.getHeigth()-empties];
            int counter=0;
            for(int y=0;y<map.getHeigth();y++)
            {
                if(!map.isEmpty(x,y))
                    tmp[counter++]=map.get(x,y);
            }
            for(int i=0;i<tmp.length-1;i++)
            {
                if(tmp[i]==tmp[i+1])
                {
                    tmp[i]*=2;
                    tmp[i+1]=0;
                }
            }
            for(int i=0;i<tmp.length-1;i++)
            {
                if(tmp[i]==0&&tmp[i+1]!=0)
                {
                    tmp[i]=tmp[i+1];
                    tmp[i+1]=0;
                }
            }
            int y=0;
            for(;y<tmp.length;y++)
                map.set(x,y,tmp[y]);
            for(;y<map.getHeigth();y++)
                map.set(x,y,0);
        }
    }
    private void moveDown()
    {
        for(int x=0;x<map.getWidth();x++)
        {
            int empties=0;
            for(int y=0;y<map.getHeigth();y++)
            {
                if(map.isEmpty(x,y))
                    empties++;
            }
            int[] tmp=new int[map.getHeigth()-empties];
            int counter=0;
            for(int y=0;y<map.getHeigth();y++)
            {
                if(!map.isEmpty(x,y))
                    tmp[counter++]=map.get(x,y);
            }
            for(int i=tmp.length-1;i>0;i--)
            {
                if(tmp[i]==tmp[i-1])
                {
                    tmp[i]*=2;
                    tmp[i-1]=0;
                }
            }
            for(int i=tmp.length-1;i>0;i--)
            {
                if(tmp[i]==0&&tmp[i-1]!=0)
                {
                    tmp[i]=tmp[i-1];
                    tmp[i-1]=0;
                }
            }
            int y=0;
            for(;y<empties;y++)
                map.set(x,y,0);
            for(;y<map.getHeigth();y++)
                map.set(x,y,tmp[y-empties]);
        }
    }
}