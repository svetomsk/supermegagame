package cama.console_cama;
import java.io.*;
import cama.core.IPlayer;
import cama.core.Judge;
import cama.core.MPlayer;

public class Game
{
    static public void main(String[]args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Judge judge = new Judge();
        Console console = new Console(judge);
        IPlayer player1 = null;
        IPlayer player2 = null;
        String str= "";
        String name= "";

        judge.start();
    //    w.write("\r\n"+Texts.CHOISE);
    //    w.flush();
   //     while(!str.equals("1")&&!str.equals("2")){
   //          str = r.readLine();
  //           if(str.equals("exit")) System.exit(0);
  //           if(str.equals("1")){

		player1 = new HPlayer(judge, new ConsoleTextSource(bw, br));
//		player1 = new MPlayer(jd, false);
		player2 = new HPlayer(judge, new ConsoleTextSource(bw, br));

  //              w.write(Texts.NAME1);
  //             w.flush();
   //             name=r.readLine();
 //               if(name.equals("exit")) System.exit(0);
                  player1.setName("CPU");
                  player2.setName("not_cpu");
//              }else if(str.equals("2")){
     //           player1 = new HPlayer(ks);
     //          player2 = new HPlayer(ks);

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

 //              player1.setName(s[0]);
  //              player2.setName(s[1]);
    //      }else{
   //            w.write(Texts.TRY);
   //             w.flush();
  //          }
  //      }
     //   w.close();
    //    r.close();



         ConsoleApp app = new ConsoleApp(judge, console, player1, player2);
         app.run();
    }
}