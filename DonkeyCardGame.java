/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author sajin
 */

public class DonkeyCardGame {
   /**
     
     */
    public static int pos,m1,m2,plr,nextplayer=10,cardtype,mod,card=113,dngr,status=1,countplr,cntrl=1,nru=0;
    public static  int p[][]=new int[10][52]; 
    public static int ply[][]=new int[52][2];
    public static int cardind[]=new int[52];
    public static int dc[]=new int[52];
    public static int s[]={101,102,103,104,105,106,107,108,109,110,111,112,113,201,202,203,204,205,206,
        207,208,209,210,211,212,213,301,302,303,304,305,306,307,308,309,310,311,312,313,401,
        402,403,404,405,406,407,408,409,410,411,412,413};
   public static int temparray[]={101,102,103,104,105,106,107,108,109,110,111,112,113,201,202,203,204,205,206,
        207,208,209,210,211,212,213,301,302,303,304,305,306,307,308,309,310,311,312,313,401,
        402,403,404,405,406,407,408,409,410,411,412,413};
    public static int plrpoint[]=new int[10];
    public static void main(String[] args) {
    System.out.println("             Welcome To The Game......           ");
    System.out.println("                               ");
    System.out.println("                  DONKEY                      ");
    System.out.println("                               ");
    System.out.println("This is a Game of FUN" );     
    System.out.println("           Game of LUCK");
    System.out.println("            Game of MEMMORY");
    System.out.println("    And      Game of INTELIGENCE");
    System.out.println("                               ");
    System.out.println("Before start the game lets familiarise with the rules of DONKEY...");
    System.out.println();
    System.out.println("1. Cards are represented by 3 digit number,there is tottal 52 cards . ");
    System.out.println("   there is 4 types of cards, each type having cards with value 1 to 13");
    System.out.println("   first digit represnt the card type and second two digits represent its value");
    System.out.println("2. Game starts by the player who got the card 113, he must play that card");
    System.out.println("3. you have to play the same card type that first player of round plays");
    System.out.println("4. if you dont have the card of current type,play any card you have in your hand");
    System.out.println("5. if all payers have the card of current cardtype,then that cards are round away");
    System.out.println("   player who played the big card have to start the next round");
    System.out.println("6. if you are the starting player you can play any cards that you have,");
    System.out.println("   but think well before play the card ") ;
    System.out.println("7. if any player break the play(he dont have the card) player who played");
    System.out.println("   biggest card  must collect all the cards including the breaking card and he must start next round");
    System.out.println("8. at the end of the game one player must have cards in his hands,he lose the game");
    System.out.println("   he is  called DONKEY....!! ");
    System.out.println("9. position of each card is shown just below the card, you can choose");
    System.out.println("   any card by its corresponding position");
    System.out.println("10.so focus the game and avoid being DONKEY");  
    System.out.println("                                                                 ");
    System.out.println(".........Lets Play  DONKEY     ");
    System.out.println("                                                      ");         
    System.out.println("                                                      ");  
    
    
    
    
    
      
     
     intplay();
    
    
    
    } 
 public static void intplay()
 {
     intialise();
     for(int i=0;i<10;i++)
     { 
         plrpoint[i]=0;
     }
     Scanner in=new Scanner(System.in);
    System.out.println("Enter the number of players");
    plr=in.nextInt();
    while(plr>9||plr<2)
    {
        System.out.println("Maximum number of players is 9 and minimum number is 2");
        System.out.println("Enter the number of players");
        plr=in.nextInt();
    }
    System.out.println("Choose your playing position");
    pos=in.nextInt();
    while(pos>plr||pos<1)
    {
        System.out.println("Enter the relevant position");
        System.out.println("Choose your playing position");
        pos=in.nextInt();
        
    }
    if(plr<5)
        mod=1;
    if(plr>4&&plr<7)
        mod=2;
    if(plr>6)
        mod=3;
    pos=pos-1;
    m1=52/plr;
    m2=52%plr;
  mainctrl();
 }
 public static void mainctrl()
 {
    intialise();
    int i,j,n=52,d,fp=0;
    shuffle(s,plr);
    dist(p,s,plr);
    sort(p,plr,m1,m2);
    System.out.println("Intial states of card are");
    display(p,plr,m1,m2);
    d= fchkcard(p,ply,m1,m2,plr,pos);
    if(d==0)
    {
        fplay(p,ply,m1,m2,pos);
        System.out.println("Starting player is"+(pos+1));
        fp=pos;
         
    }
    
    if(d!=0)
    {
     System.out.println("Starting player is " +(d));
     fp=d-1;
     
    }
    froundplay(p,ply,m1,m2,plr,fp,pos,1);
    System.out.println("Card in this round was  " +cardtype);
    pcards();
    bigplayer();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("Next player is player "+(nextplayer+1));
    sort(p,plr,m1,m2);
    display(p,plr,m1,m2);
    thinkinglogic();
    System.out.println("Final states of card are");
   
     
    
    display(p,plr,m1,m2);
   
 }
 
  
  public static void pcards()
  {
    System.out.println("Cards played in previous round was");
    for(int i=0;i<plr;i++)
    {
        
      System.out.println("player"+(i+1)+"  "+ply[i][1]);      
    
    }
  }
  public static void display( int[][] a,int p,int m,int n){ 
    for(int i=0;i<p;i++)    
    {
     for(int j=0;j<52;j++)
     {
       if(a[i][j]!=0)
         System.out.print(a[i][j]+" ");
     }
    System.out.println();
    }
    
  }
  
     

public static void shuffle( int[] a,int p){
  
    
    int x,temp,l,m=52,mu;
    mu=10+(int)(Math.random()*11);
    l=(10-p)+mu;
    for(int i=0;i<l;i++)
    {
       
        for(int j=0;j<m;j++)
        {
            x=(int)(Math.random()*m);
            temp=a[j];
            a[j]=a[x];
            a[x]=temp;
              
        }
       
    }
 }   
   
public static void dist(int[][] a,int[] b, int p)
{
  int i,j,k=0,r;
   m1=52/p;
   m2=52%p;
    for(i=0;i<p;i++)
    {
        for(j=0;j<m1;j++)
        {
            a[i][j]=b[k];
            k++;
        }
    }
    j=m1;
    for(i=0;i<m2;i++)
    {
        r=(int)(Math.random()*p);
        if(a[r][j]==0)
        {
        a[r][j]=b[k];
        k++;
        }  
        else
            i=i-1;
            
             
    }
    
}
 public static void sort(int[][] a,int p,int m,int n)
{
int temp;
    for(int i=0;i<p;i++)
        {
            
            for(int j=0;j<52;j++)
            {
             for(int t=0;t<52;t++)
             {
             
             
                 if(a[i][j]<a[i][t]&&a[i][t]!=0&&a[i][j]!=0)
             {
               
                 
                 temp=a[i][j];
            
                 a[i][j]=a[i][t];
            
                a[i][t]=temp;
               
             
           
             }
            } 
        }
            
        }     
}

public static int fchkcard( int[][] a,int[][] ply,int m,int n,int p,int ps)
{
int k=0,b=0;
 for(int i=0;i<p;i++)
 {
   for(int j=0;j<m+n;j++)
   {
     if((a[i][j]==113)&&(i!=ps))
     {
       k=1;
       System.out.println("Player"+(i+1)+" start the game with card "+(a[i][j]));
       play(ply,i,a[i][j]);
       cardtype=a[i][j]/100;
       a[i][j]=0;
       b=i+1;
       break;
     }
     
      
   }
 }
 return k*b;
}

public static void fplay(int[][] a,int[][] ply,int m,int n,int p)
{
   int c;
   System.out.println("You have the starting card 113..play the card(enter 113)");
   Scanner in=new Scanner(System.in);
   c=in.nextInt();
   while(c!=113)
   {
       System.out.println("Play the correct card ( 113) ");
   
       c=in.nextInt();
   
   }
for(int i=0;i<m+n;i++)
{
    if(a[p][i]==113)
    {   
        a[p][i]=0;
            break;
}    }  
    
cardtype=c/100;
System.out.println("You played the card  "+c);
play(ply,p,c);
}

public static void froundplay(int[][] a,int[][] ply,int m, int n,int p,int f,int ps,int g)
        
{
  int big=0,k=0,l=0,c=0,st,d=0,r;
  int i,temp;
  c=p;
 
  
  if(g==1)
  {
      p=p-1;
      
  }
       
  i=f;
  
 
  
      while(p!=0)
  {
     
    
      d=0;
     big=0; 
      i++;
      i=i%c;
      p--;
      
      if(i==pos)
  {
      st=myplay(a,ply,ps,m,n,c);
      if(st==0)
          break;
      continue;
  }
     if(i!=pos&&i==nextplayer&&dngr==1)
     {
         findsmallcard();
         continue;
     }
     int crd,ck;
     if(i!=pos&&i!=nextplayer&&dngr==1)
     {
      sort(a,plr,m1,m2);
      crd=bigcard();
      ck=findsmallc(i,crd);
      if(ck==1)
          continue;
      ck=findbigc(i,crd);
      if(ck==1)
          continue;
     }
     k=i;
      int j=0;
      d=0;
      big=0;
      if(a[i][j]/100==cardtype&&i!=pos)
          big=a[i][j]%100;
       for(j=0;j<52;j++)
       {
         if(a[i][j]%100>=big&&a[i][j]/100==cardtype&&(i!=pos))
         {
             big=a[i][j]%100;
             l=j;
             d=1;
         }
         
       
       
       }
     if(i==f+1&&d!=1&&k!=pos&&card!=113) 
     {
         i--;
         p--;
         cardtype++;
         cardtype=cardtype%5;
         if(cardtype==0)
             cardtype++;
     cardindex();
     }
    
     r=0;
     if(d!=1&&k!=pos)
     {
         System.out.println("Player " +(i+1)+ " does not have the card ");
         dcard(i);
         r=findbig(a,ply,i,m,n,c);
         if(r==1)
             continue;
         break;
     }
     if(i!=pos&&a[k][l]!=0&&big!=0)
     {
     play(ply,i,a[k][l]);
    System.out.println("Player "+ (i+1)+ " played "+ a[k][l]);
     System.out.println();
     if(a[k][l]%100<2&&a[k][l]!=0&&a[k][l]!=9&&status==1)
     {
         dcard(i);
     }
         a[k][l]=0;
     } 
  
  
  }

 cardindex();
   

}
public static int myplay(int[][] d,int[][] ply,int f,int o,int p,int plr)             
{
int c=0,cd=0,big,g,i;
i=f;

cd=0;
big=0;
 g=0; 

     for(int j=0;j<52;j++)
       {
           if(big<=d[pos][j]%100&&d[pos][j]!=9&&d[pos][j]!=0)
         {
             
             big=d[pos][j]%100;
             
             g=1;
         }
       
       
     }
if(g==0)
{
    cd=1;
    return cd;
  
}
System.out.println(" its your tuurn....(player"+(i+1)+")your cards are");
cd=0;
for(int j=0;j<52;j++)
{
    if(d[pos][j]/100==cardtype)
    {
        cd=1;
    }
     if(d[pos][j]!=0)   
    {
    System.out.print(d[pos][j]+"  ");
    }
    
    
}    

System.out.println("Card positions are");
for(int j=0;j<52;j++)
{
    
     if(d[i][j]!=0)   
    {
    if(j<10)
        System.out.print((j+1)+"    ");
    else
    System.out.print((j+1)+"   ");
    }
    
    
}    

Scanner in=new Scanner(System.in);
if(cd!=1&&pos!=nextplayer)
{
 dcard(pos);
 System.out.println("You dont have the card you can play any card" );
}
System.out.println("Give the card position");
c=in.nextInt();
c=c-1;
while(c<0||c>52||d[pos][c]==0)
{
    System.out.println("Enter the correct position");
    c=in.nextInt();
    c=c-1;
}

if(pos==nextplayer&&d[i][c]!=0&&card!=113&&d[i][c]!=9)
{
    cardtype=d[i][c]/100;
    cd=1;
}   
while((d[i][c]/100!=cardtype&&cd==1)||d[i][c]==0||d[i][c]==9)
{
    System.out.println("Play the correct card");
    c=in.nextInt();
    c=c-1;
    
}



System.out.println("You(player"+(i+1)+") played the card " +d[i][c]);
if(d[i][c]%100<2&&cd==1&&d[i][c]!=0&&status==1)
  dcard(i);
play(ply,f,d[i][c]);
d[i][c]=0;
if(cd!=1&&pos!=nextplayer) 
{
    addup(ply,d,plr,o,p);
    
}


   

return cd;
}
public static int findbig(int[][] e,int[][] ply,int ps,int o,int p,int plr) 
{
int j=0,big,i,k,l,t,b=0,f=0;

i=ps;
k=i;
l=0;
j=0; 
big=0;
 f=0; 

     for(j=0;j<52;j++)
       {
           if(big<=e[i][j]%100&&e[i][j]!=9&&e[i][j]!=0)
         {
             
             big=e[i][j]%100;
             k=i;
             l=j;
             f=1;
         }
       
       
     }
 
b=0;
 if(f==1)
 {
 System.out.println("Player "+ (ps+1)+ " played "+ e[ps][l]);
 System.out.println();
 
 play(ply,ps,e[ps][l]);
 addup(ply,e,plr,o,p);
 e[k][l]=0;
 } 
 if(f==0)
   {
    b=1;
    }
 
 return b;
}
public static void play(int[][] p,int plr,int card)
{
p[plr][0]=plr;
p[plr][1]=card;


}
public static void plyintial(int[][] p)
{
    for(int i=0;i<52;i++)
    {
        for(int j=0;j<2;j++)
        {
            p[i][j]=0;
        }
    }
}


public static void addup(int[][] pl,int[][] a,int p,int m,int n)
{


int temp,k=0,i,t;
bigplayer();

k= nextplayer;
if(k==pos)
{
    System.out.println("You (playr"+(k+1)+")have to collect he cards");
}
    else
{
    System.out.println("Player"+(k+1)+" have to collect he cards");
}
i=k;
t=0;
for(int j=0;j<52;j++)
{
    if(a[i][j]==0)
    {
        a[i][j]=pl[t][1];
        t++;
    
   
    } 
   
}

int c=0;
for(int j=0;j<52;j++)
{
    if(pl[j][1]/100!=cardtype&&pl[j][1]!=0)
    {
       c=pl[j][1]/100;
       break;
   
    }
}
for(int j=0;j<52;j++)
{
    if(dc[j]%10==k&&dc[j]/10==c)
      dc[j]=0;
   }
}
public static void bigplayer()
{


int temp,k=0,i;
temp=0;
 
for(i=0;i<plr;i++)
{
    if(ply[i][1]%100>=temp&&ply[i][1]/100==cardtype&&ply[i][1]!=0&&p[i][0]!=9)
    {
     temp=ply[i][1]%100;   
      k=i;  
      }
  

}
nextplayer=k;

}
public static void thinkinglogic()
{
card=0;
    if(mod==1)
{
     highprob();
     mediumprob();
     lessprob();   
}
if(mod==2)
{
  mediumprob();
  lessprob();   
}  
if(mod==3)
{
 lessprob(); 
}
}
 
public static void highprob()
{       
    status=1;
    int i,d=0;
    int m,c=0;
    m=0;
   
    
    
    do  
    {
    if(cntrl==1)
    {
    Scanner in=new Scanner(System.in); 
   System.out.println("press enter to continue...");
   String y = in.nextLine();  
   while(!"".equals(y))
   {
    System.out.println("press enter to continue...");
    y = in.nextLine();
   
   }  
   } 
   dngr=0;
    sort(p,plr,m1,m2);  
    plyintial(ply);
    c= cardtypecheck();  
    if(c!=1)
    {
    i=nextplayer-1;
     plyintial(ply);
    
    froundplay(p,ply,m1,m2,plr,i,pos,m);
    
    pcards();
    
    playerstatus();
    
    bigplayer();
    
    System.out.println();
    System.out.println("Next player is "+(nextplayer+1));
    System.out.println();
    sort(p,plr,m1,m2);
    display( p,plr,m1,m2);
   int z;
    Scanner in=new Scanner(System.in);
   if(p[pos][0]==9&&nru==0)
    {
    nru=1;
     System.out.println("you finished your cards you can simulte or watch rest of the game");
     System.out.println("1.watch");
     System.out.println("2.simulate");
     System.out.println("Enter your choice");
     z=in.nextInt();
    while(z!=1&&z!=2)
    {
        System.out.println("Enter correct choice");
        z=in.nextInt();
    }
    cntrl=z;
    }
    }
    }while(c!=1);
    }
public static void mediumprob()
{
    status=2;
    int i,m=0,d=0,limit=0;
    if(plr==2)
        limit=12;
    if(plr==3)
        limit=4;
    if(plr==4)
        limit=1;
    if(plr==5||plr==6)
        limit=1;
    
    do{
    if(cntrl==1)
    {
   Scanner in=new Scanner(System.in); 
   System.out.println("press enter to continue...");
   String y = in.nextLine();  
   while(!"".equals(y))
   {
    System.out.println("press enter to continue...");
    y = in.nextLine();
   
   }  
   }
   sort(p,plr,m1,m2);
    cardindex_intial();
    plyintial(ply);
    cardcount();
    
    i=nextplayer-1;
    froundplay(p,ply,m1,m2,plr,i,pos,m);
   
    pcards();
    playerstatus();
    bigplayer();
    System.out.println();
    System.out.println("Next player is "+(nextplayer+1));
    System.out.println();
    sort(p,plr,m1,m2);
    display(p,plr,m1,m2);  
    
    int z;
    Scanner in=new Scanner(System.in);
   if(p[pos][0]==9&&nru==0)
    {
     nru=1;
     System.out.println("you finished your cards you can simulte or watch rest of the game");
     System.out.println("1.watch");
     System.out.println("2.simulate");
     System.out.println("Enter your choice");
     z=in.nextInt();
    while(z!=1&&z!=2)
    {
        System.out.println("Enter correct choice");
        z=in.nextInt();
    }
    cntrl=z;
    }
    
    d++;
    }while(d!=limit);
}   
public static void lessprob()
{ 
    status=2;
    int i,m=0,d=0;

    
    do{
   if(cntrl==1)
   {
   Scanner in=new Scanner(System.in); 
   System.out.println("press enter to continue...");
   String y = in.nextLine();  
   while(!"".equals(y))
   {
    System.out.println("press enter to continue...");
    y = in.nextLine();
   
   }  
   } 
   plyintial(ply);
    cardindex_intial();
    sort(p,plr,m1,m2);
   
    
    dngr=1;
    i=nextplayer-1;
    
    froundplay(p,ply,m1,m2,plr,i,pos,m);
    
    pcards();
    playerstatus();
    bigplayer();
    
    
    System.out.println();
    System.out.println("Next player is "+(nextplayer+1));
    System.out.println();
    sort(p,plr,m1,m2);
    display(p,plr,m1,m2);  
    
    int z;
    Scanner in=new Scanner(System.in);
   if(p[pos][0]==9&&nru==0)
    {
     nru=1;
     System.out.println("you finished your cards you can simulte or watch rest of the game");
     System.out.println("1.watch");
     System.out.println("2.simulate");
     System.out.println("Enter your choice");
     z=in.nextInt();
    while(z!=1&&z!=2)
    {
        System.out.println("Enter correct choice");
        z=in.nextInt();
    }
    cntrl=z;
    }
    
    
    d++;
    }while(d!=200);
    
 }
public static void cardindex()
        
{
cardind[0]=1;
    for(int i=1;i<52;i++)
    {
    if(cardind[i]==0)
    {
        cardind[i]=cardtype;
        break;
    }

     }           
}
public static int cardtypecheck()
{
int d=0;
for(int i=1;i<5;i++)
{
    d=0;
    for(int j=0;j<52;j++)
    {
        if(i==cardind[j]&&cardind[j]!=0)
        
        d=1;
        
    } 
            
if(d==0)
{
  
    cardtype=i;
     
    break;
}            

}
return d;
}
public static void cardindex_intial()
{
for(int i=0;i<52;i++)
{
    cardind[i]=0;
    
 }           
}
public static void playerstatus()
{
  int f=0,k=0;
  countplr=0;
  for(int i=0;i<plr;i++)
  {
     k=i;
      f=0;
      for(int j=0;j<52;j++)
      {
      if(p[i][j]!=0&&p[i][j]!=9)
      {
       f=1;
       break;
      }
    }    
    if(f==0)  
      {
        
        System.out.println("Player "+(k+1)+" finished his cards");
        p[k][0]=9;
        
      for(int j=0;j<52;j++)
      {
          if(dc[j]%10==k&&dc[j]!=0)
             dc[j]=0;
       }
      
      }
    
  }    
     
     

  k=0;                   
  countplr=0;       
for(int i=0;i<plr;i++)
  {
     
      
      if(p[i][0]!=9)
      {
       
       k=i;
       countplr++;
      } 
  
  }   
   int dcion;
    Scanner in=new Scanner(System.in);
   if(countplr==1&&k!=pos)  
     { 
      
      System.out.println("..........PLAYER "+(k+1)+"........LOSS THE GAME..!!!!.........");
      System.out.println("..........PLAYER "+(k+1)+" IS....DONKEY!!!!........."); 
      System.out.println("Final states of cards are");    
      display(p,plr,m1,m2); 
      System.out.println();
      printpointtable();
      System.out.println();
      System.out.println("choose one option below ");
      System.out.println("1.Play again");
      System.out.println("2.New game");
      System.out.println("3.Exit");
      System.out.println("Enter your choice");
      dcion=in.nextInt();
      while(dcion!=1&&dcion!=2&&dcion!=3)
      {
        System.out.println("Enter correct choice");
        dcion=in.nextInt();
      }
      if(dcion==1)
        mainctrl();
      if(dcion==2)
        intplay();
      if(dcion==3)
        System.exit(0);
     }

   if(countplr==1&&k==pos)
   {
       System.out.println("...........YOU(PLAYER "+(k+1)+")........LOSS THE GAME..!!!!.........");
       System.out.println("...........YOU ARE.....DONKEY!!!.........");
       System.out.println("Final states of cards are");    
       display(p,plr,m1,m2);
      System.out.println();
      printpointtable();
      System.out.println();
      System.out.println("choose one option below ");
      System.out.println("1.play again");
      System.out.println("2.New game");
      System.out.println("3.Exit");
      System.out.println("Enter your choice");
      dcion=in.nextInt();
      while(dcion!=1&&dcion!=2&&dcion!=3)
      {
        System.out.println("Enter correct choice");
        dcion=in.nextInt();
      }
      if(dcion==1)
        mainctrl();
      if(dcion==2)
        intplay();
      if(dcion==3)
        System.exit(0);
       
   
   }  
   
}
public static void cardcount()
{
int k,count,c=52,pl=1,temp,l=0,d=0,st;
int cnt[]=new int[5];
k=nextplayer;
d=0;


for(int i=1;i<=4;i++)
{
    count=0;
    for(int j=0;j<52;j++)
    {
       if(p[k][j]/100==i)
        count++;
    
    }

  cnt[i]=count;
 

}
do{
 
 
temp=52;
for(int i=1;i<5;i++)
{
    if(cnt[i]<=temp&&cnt[i]!=0)
    {
    temp=cnt[i];
    l=i;
    }
    
}

st=0;

st=chk_dcard(l);
if(st==1)
    cnt[l]=0;
 if(st==0)
 {
 cardtype=l;
 break;
 }
 d++;
}while(st!=0&&d!=5);

if(d==5)
 {
    dngr=1;
    
    
 }


}
public static void dcard(int m)
{
for(int i=0;i<52;i++)
{
   if(dc[i]==0)
   {
       dc[i]=cardtype*10+m;       
       break;
     }
 }

}
public static int findsmallc(int pno,int cd)
{
    int f,i,k,temp=0,l=0;
    k=pno;
    f=0;
    for(i=0;i<52;i++)
    {
        if(p[k][i]%100<cd%100&&p[k][i]/100==cardtype&&p[k][i]!=0&&p[k][i]!=9)
        {
          temp=p[k][i];
          f=1;
          l=i;
        }
    } 
if(f==1)
{
   play(ply,k,temp);
   System.out.println("player "+ (k+1)+ " played "+ temp);
   System.out.println(); 
   p[k][l]=0;
}
 return f;
}
        
public static int findbigc(int pno,int cd)
{
    int f,i,k,temp=0,l=0,temp2=0,m=0;
    k=pno;
    f=0;
    for(i=0;i<52;i++)
    {
        if(p[k][i]%100>cd%100&&p[k][i]/100==cardtype&&p[k][i]!=0&&p[k][i]!=9&&(p[k][i]%100-temp%100==1||p[k][i]-temp==p[k][i]))
        {
          temp=p[k][i];
          f=1;
          l=i;
        }
    } 
for(i=0;i<52;i++)
    {
        if(p[k][i]%100>cd%100&&p[k][i]/100==cardtype&&p[k][i]!=0&&p[k][i]!=9)
        {
          temp2=p[k][i];
          f=1;
          m=i;
        }
    } 

    
    
    
if(f==1&&countplr==2)
{
 play(ply,k,temp2);
 System.out.println("Player "+ (k+1)+ " played "+ temp2);
 System.out.println(); 
 p[k][m]=0;   
}
if(f==1&&countplr!=2)
{
  play(ply,k,temp);
  System.out.println("Player "+ (k+1)+ " played "+ temp);
  System.out.println(); 
  p[k][l]=0;
}
return f;
}
public static int bigcard()
{
  int temp,k=0,i,bg;
temp=0;
for(i=0;i<plr;i++)
{
    if(ply[i][1]%100>=temp&&ply[i][1]/100==cardtype&&ply[i][1]!=0)
    {
     temp=ply[i][1]%100;   
      k=i;  
      }
} 
bg=ply[k][1];
return bg;
}


public static int chk_dcard(int a)
{
int f=0;
for(int i=0;i<52;i++)
{
    if(dc[i]/10==a&&dc[i]!=0&&dc[i]!=9)
    {
      f=1;
      break;

    }
}     
return f;
}
public static int chekcd(int m)
{
    int k=nextplayer;
    int f=0,i;
    for(i=0;i<52;i++)
    {
     if(p[k][i]==m)    
      {
      f=1;
       break;
        
       }
    }
return f;
}
public static void  findsmallcard()
{
int small=524,i,j=1,m=1,ck=0;
int k=nextplayer;    
int l=0,temp,st=0;
 int sml[]=new int[5];
sort(p,plr,m1,m2);
int q=0;
m=1;
 
for(j=1;j<=4;j++)
{
q=0;
for(i=0;i<52;i++)
{
    if(q==1)
        continue;
    
    if(p[k][i]/100==j&&p[k][i]!=0&&p[k][i]!=9)
    {
    sml[m]=p[k][i];
    m++;
    q=1;
    }
} 
        

}


m=0;
for(i=1;i<=4;i++)
{
 ck=0;
 m=sml[i]/100;
 ck=chk_dcardplr(m);
 if(ck==1)
    sml[i]=0; 
  
}


m=0;
for(i=1;i<=4;i++)
{
 if(sml[i]!=0&&sml[i]!=9)
 {
 m=1;
 break;
 }
}
int g=0;
small=534;
if(m==0)
{
  for(i=0;i<52;i++)
{
    if(p[k][i]!=0&&p[k][i]!=9&&p[k][i]!=534)
    {
    g=i;
    break;
    }

}  
small=p[k][g];
}

for(i=1;i<=4;i++)
{
    if(small%100>=sml[i]%100&&sml[i]!=0&&sml[i]!=9&&sml[i]!=534&&m!=0)
        small=sml[i];
}   

temp=small;
st=chekcd(temp);
while(st==1)
{
    st=0;
    temp++;
    st=chekcd(temp);
    if(st==0)   
    {
        temp--;
        break;
        
        
    }
   }


cardtype=temp/100;     
    play(ply,k,temp);
    System.out.println("Player "+ (k+1)+ " played "+ temp);
    System.out.println();
    
    for(i=0;i<52;i++)
    {
        if(p[k][i]==temp)
        {
            p[k][i]=0;
            break;
    
        }
    }      
}
public static int chk_dcardplr(int a)
{
  int f=0, pl,pr,j;
pr=plr;
j=nextplayer;
while(pr!=0)
{
    j++;
    j=j%plr;
    if(p[j][0]!=9)
        break;
  pr--;  
}
pl=j;

f=0;
for(int i=0;i<52;i++)
{
    if(dc[i]/10==a&&dc[i]!=0&&dc[i]%10==pl)
    {
      f=1;
      break;

    }
}      
return f;
}  
public static void intialise()
{
 
  
   nextplayer=10;
   cardtype=0;
   
   card=113;
   dngr=0;
   status=1;
   countplr=0;
   cntrl=1;
   nru=0;
 
 
 
  for(int i=0;i<10;i++)
  {
      for(int j=0;j<52;j++)
      {
          p[i][j]=0;
      }
  }
 
 
   plyintial(ply);
   cardindex_intial();
 
    
    for(int i=0;i<52;i++)
    {
        dc[i]=0;
    }
    System.arraycopy(temparray, 0, s, 0, 52);
    
   

}

public static void printpointtable()
{
     for(int i=0;i<plr;i++)
     {
         if(p[i][0]==9)
             plrpoint[i]=plrpoint[i]+2;
         else
            plrpoint[i]=plrpoint[i]-2; 
     }
      
      System.out.println("POINT TABLE");
      System.out.println("------------");
      System.out.println();
      System.out.println("   PLAYER          POINT");
      System.out.println("   ======          =====");
      for(int i=0;i<plr;i++)
      {
         
          System.out.println("   player"+(i+1)+"            "+plrpoint[i]);
      }
}
}
 