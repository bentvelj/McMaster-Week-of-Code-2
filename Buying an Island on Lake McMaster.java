import java.util.*;

import java.io.*;
public class LakeMcMaster {
    
    static boolean g[][] = new boolean[2501][2501];
    static int N,M,C;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String in[] = br.readLine().split(" ");
        
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        C = Integer.parseInt(in[2]);
        
        for(int i = 0; i < N;i++) {
            in = br.readLine().split(" ");        
            for(int j = 0; j < M;j++) {
                g[i][j] = in[j].equals("L");
            }
        }
        int p,max = 0;
        for(int i = 0; i < M;i++) {    
            for(int j = 0; j < N;j++) {
                if(g[i][j]) {
                    p = bfs(new Point(i,j));
                    if( p > max && p <= C) max = p;
                }
            }
        }
        
        System.out.println(max == 0 ? -1 : max);
    }
    
    public static int bfs(Point s) {
        int c = 1;
        Queue<Point> todo = new LinkedList<Point>();
        todo.add(s);
        g[s.x][s.y] = false;
        while(!todo.isEmpty()) {
            s = todo.poll();
            
            if(in(s.x + 1,s.y) && g[s.x +1][s.y]) { //Right
                g[s.x+1][s.y] = false;
                c++;
                todo.add(new Point(s.x + 1,s.y));
            }
            
            if(in(s.x - 1,s.y) && g[s.x - 1][s.y]) { //Left
                g[s.x - 1][s.y] = false;
                c++;
                todo.add(new Point(s.x - 1,s.y));
            }
            
            if(in(s.x,s.y - 1) && g[s.x][s.y - 1]) { //Up
                g[s.x][s.y - 1] = false;
                c++;
                todo.add(new Point(s.x,s.y - 1));
            }
            
            if(in(s.x,s.y + 1) && g[s.x][s.y + 1]) { //Down
                g[s.x][s.y + 1] = false;
                c++;
                todo.add(new Point(s.x,s.y + 1));
            }
        }
        
        return c;
        
    }
    
    public static boolean in(int x,int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
    
    public static class Point{
        int x,y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

}
