import javax.sound.midi.SysexMessage;
import javax.swing.plaf.synth.SynthStyle;
import java.io.*;
import java.util.*;
class Pair{
    int i;
    int j;
    char c;
    Pair(int i,int j,char c)
    {
        this.i=i;
        this.j=j;
        this.c=c;
    }
}
public class Labyrinth {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine(). split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        int di[]={-1,0,1,0};
        int dj[]={0,1,0,-1};
        char c[]={'U','R','D','L'};
        boolean b[][]=new boolean[n][];
        int start_i=-1;
        int start_j=-1;
        int end_i=-1;
        int end_j=-1;
        for(int i=0;i<n;i++)
        {
            b[i]=new boolean[m];
            String s1=br.readLine();
            for(int j=0;j<m;j++)
            {
                if(s1.charAt(j)=='.')
                    b[i][j]=true;
                else if(s1.charAt(j)=='A')
                {
                    start_i=i;
                    start_j=j;
                }
                else if(s1.charAt(j)=='B')
                {
                    end_i=i;
                    end_j=j;
                    b[i][j]=true;
                }
            }
        }
        int count=0;
        LinkedList<Pair> a=new LinkedList<>();
        a.add(new Pair(start_i,start_j,'n'));
        int i=0;
        b[start_i][start_j]=false;
        while(i<a.size())
        {
            Pair p=a.get(i);
            if(p.i==end_i&&p.j==end_j)
                break;
            int i1=p.i;
            int j1=p.j;
            for(int k=0;k<4;k++)
            {
                try{
                    if(b[i1+di[k]][j1+dj[k]])
                    {
                        b[i1+di[k]][j1+dj[k]]=false;
                        a.add(new Pair(i1+di[k],j1+dj[k],c[k]));
                    }
                }
                catch (Exception e)
                {

                }
            }
            i++;
        }
        Stack<Character> ans=new Stack<>();
        while(true)
        {
            Pair x=a.removeLast();
            if(x.i==end_i&&end_j==x.j)
                break;
        }
        int pi=-1;
        int pj=-1;


        System.out.println(count);
    }

}