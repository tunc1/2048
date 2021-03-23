import java.util.Scanner;

class MapView
{
    private Scanner scanner;
    public MapView()
    {
        scanner=new Scanner(System.in);
    }
    public void show(Map map)
    {
        String s="";
        for(int y=0;y<map.getHeigth();y++)
        {
            for(int x=0;x<map.getWidth();x++)
            {
                int value=map.get(x,y);
                s+="[";
                if(value==0)
                    s+=" ";
                else
                    s+=value;
                s+="]";
            }
            s+="\n";
        }
        message(s);
    }
    public char getInput()
    {
        return scanner.nextLine().charAt(0);
    }
    public void message(String message)
    {
        System.out.println(message);
    }
}