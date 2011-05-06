package cama;
import java.io.*;
class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Konsol ks = new Konsol();
        IPlayer h1 = null;
        IPlayer h2 = null;
        String str= "";
        String name= "";
        ks.start();
    //    w.write("\r\n"+Texts.CHOISE);
    //    w.flush();
   //     while(!str.equals("1")&&!str.equals("2")){
   //          str = r.readLine();
  //           if(str.equals("exit")) System.exit(0);
  //           if(str.equals("1")){
                h1 = new HPlayer(ks);
                h2 = new HPlayer(ks);

  //              w.write(Texts.NAME1);
  //             w.flush();
   //             name=r.readLine();
 //               if(name.equals("exit")) System.exit(0);
                  h1.setName("CPU");
                  h2.setName("not_cpu");
//              }else if(str.equals("2")){
     //           h1 = new HPlayer(ks);
     //          h2 = new HPlayer(ks);

   //            w.write(Texts.NAME);
  //              w.flush();
  //              name=r.readLine();
  //              if(name.equals("exit")) System.exit(0);
  //              String s[] = str.split(" ");
  //              if(s.length!=2){
  //                  while(s.length!=2){
    //                   w.write(Texts.TRY);
    //                   w.flush();
   //                    s = r.readLine().split(" ");
    //                }
    //            }

 //              h1.setName(s[0]);
  //              h2.setName(s[1]);
    //      }else{
   //            w.write(Texts.TRY);
   //             w.flush();
  //          }
  //      }
     //   w.close();
    //    r.close();
        
        int i = 0;
        for(;;){
            if(i == 0){
                ks.who(h1);
                h1.xod(true);
                if(ks.check(true)){
                    break;
                }
                i = 1;
            }else{
                ks.who(h2);
                h2.xod(false);
                if(ks.check(false)==true){
                    break;
                }
                i = 0;
            }   
         }
        ks.finish();
    }
}

