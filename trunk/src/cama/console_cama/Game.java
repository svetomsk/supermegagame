package cama.console_cama;
import java.io.*;
import cama.core.IPlayer;
import cama.core.Judge;
import cama.core.Console;
import cama.core.MPlayer;

public class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Judge judge = new Judge();
        Console console = new Console(judge);
        IPlayer h1 = null;
        IPlayer h2 = null;
        String str= "";
        String name= "";
        judge.start();
    //    w.write("\r\n"+Texts.CHOISE);
    //    w.flush();
   //     while(!str.equals("1")&&!str.equals("2")){
   //          str = r.readLine();
  //           if(str.equals("exit")) System.exit(0);
  //           if(str.equals("1")){

		h1 = new HPlayer(judge);
//		h1 = new MPlayer(jd, false);
		h2 = new HPlayer(judge);

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
                console.printDoStep(h1);
                h1.doStep(true);
                console.printField();
                if(judge.check(true)){
                    break;
                }
                i = 1;
            }else{
                console.printDoStep(h2);
                h2.doStep(false);
                console.printField();
                if(judge.check(false)==true){
                    break;
                }
                i = 0;
            }   
         }
        judge.finish();
    }
}