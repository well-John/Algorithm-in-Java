package leetcode.S1263;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    private boolean[][] flag;
    private boolean[][] flag1;
    private boolean mark;
    private int[] dx= {0,0,1,-1};
    private int[] dy= {1,-1,0,0};
    private boolean[][][] dp;

    class node{
        int x,y,xx,yy,step;

        public node(int x,int y,int xx,int yy,int step) {
            this.x=x;
            this.y=y;
            this.xx=xx;
            this.yy=yy;
            this.step=step;
        }
    }

    public int minPushBox(char[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        flag=new boolean[m][n];
        flag1=new boolean[m][n];
        dp=new boolean[4][m][n];

        int st1x=0,enx=0,st1y=0,eny=0,st2x=0,st2y=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='S') {st1x=i;st1y=j;}
                else if(grid[i][j]=='B') {st2x=i;st2y=j;}
                else if(grid[i][j]=='T') {enx=i;eny=j;}
                if(grid[i][j]=='#') flag[i][j]=true;
            }

        Queue<node> q=new LinkedList<>();
        q.add(new node(st1x,st1y,st2x,st2y,0));
        while(!q.isEmpty()) {
            node now=q.poll();
            if(now.xx==enx && now.yy==eny)
                return now.step;
            for(int i=0;i<4;i++) {
                int xx=now.xx+dx[i];
                int yy=now.yy+dy[i];
                if(xx<0 || xx>=m || yy<0 || yy>=n || flag[xx][yy] || dp[i][now.xx][now.yy])
                    continue;
                mark=false;
                flag1[now.x][now.y]=true;
                flag[now.xx][now.yy]=true;
                if(i==0) {
                    dfs2(grid,now.x,now.y,now.xx,now.yy-1,m,n);
                    flag1[now.x][now.y]=false;
                    flag[now.xx][now.yy]=false;
                    if(mark) q.add(new node(now.xx,now.yy,xx,yy,now.step+1));
                }
                else if(i==1) {
                    dfs2(grid,now.x,now.y,now.xx,now.yy+1,m,n);
                    flag1[now.x][now.y]=false;
                    flag[now.xx][now.yy]=false;
                    if(mark) q.add(new node(now.xx,now.yy,xx,yy,now.step+1));
                }
                else if(i==2) {
                    dfs2(grid,now.x,now.y,now.xx-1,now.yy,m,n);
                    flag1[now.x][now.y]=false;
                    flag[now.xx][now.yy]=false;
                    if(mark) q.add(new node(now.xx,now.yy,xx,yy,now.step+1));
                }
                else{
                    dfs2(grid,now.x,now.y,now.xx+1,now.yy,m,n);
                    flag1[now.x][now.y]=false;
                    flag[now.xx][now.yy]=false;
                    if(mark) q.add(new node(now.xx,now.yy,xx,yy,now.step+1));
                }
                if(mark) dp[i][now.xx][now.yy]=true;
                mark=false;
                for(int ii=0;ii<m;ii++)
                    for(int j=0;j<n;j++)
                        flag1[ii][j]=false;
            }
        }

        return -1;
    }


    private void dfs2(char[][] grid,int nowpx,int nowpy,int nowx,int nowy,int m,int n) {

        if(nowx<0 || nowx>=m || nowy<0 || nowy>=n || mark) return;

        if(nowpx==nowx && nowpy==nowy) mark=true;

        for(int i=0;i<4;i++) {
            if(mark) return;
            int xx=nowpx+dx[i];
            int yy=nowpy+dy[i];
            if(xx<0 || xx>=m || yy<0 || yy>=n || flag[xx][yy] || flag1[xx][yy])
                continue;
            flag1[xx][yy]=true;
            dfs2(grid,xx,yy,nowx,nowy,m,n);
        }
    }
}
