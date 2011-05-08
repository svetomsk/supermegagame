package cama;
import java.io.*;
import cama.core.IPlayer;
import cama.core.Judge;
import cama.core.Console;
import cama.gui_cama.MPlayer;

public class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Judge jd = new Judge();
        Console cs = new Console(jd);
        IPlayer h1 = null;
        IPlayer h2 = null;
        String str= "";
        String name= "";
        jd.start();
    //    w.write("\r\n"+Texts.CHOISE);
    //    w.flush();
   //     while(!str.equals("1")&&!str.equals("2")){
   //          str = r.readLine();
  //           if(str.equals("exit")) System.exit(0);
  //           if(str.equals("1")){

		h1 = new HPlayer(jd);
//		h1 = new MPlayer(jd, false);
		h2 = new HPlayer(jd);

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
                cs.who(h1);
                h1.doStep(true);
                cs.printField();
                if(jd.check(true)){
                    break;
                }
                i = 1;
            }else{
                cs.who(h2);
                h2.doStep(false);
                cs.printField();
                if(jd.check(false)==true){
                    break;
                }
                i = 0;
            }   
         }
        jd.finish();
    }
}

