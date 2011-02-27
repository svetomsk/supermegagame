package cama;
public class Texts {
    static public String GREETING = "Добро пожаловать в игру \"Пешки 3х3\"!\nДля того, чтобы сделать ход, выберите\nкоординаты пешки, поставьте тире\nи выберите координаты места, куда\nхотите поставить пешку. Удачи!\n";
    static public String BlWin = "Черные выиграли!";
    static public String WhWin = "Белые выиграли!";
    static public String DO_STEP (String name){
        return name+" ходит: \r\n";
    }
    static public String NAME = "\r\n"+"Введите ваши имена: ";
    static public String TRY = "Попробуйте снова!\r\n";
    static public String Er_TEXT = "Вы написали текст, загляните в правила и попробуйте еще раз!";
    static public String OUT_OF_BOUNDS = "Вы зашли за границы таблицы! Попробуйте еще раз!";
    static public String EMPTY = "Вы хотите передвинуть пустое место!\r\n";
    static public String YOUR_CELL = "Вы хотите срубить свою же пешку!";
    static public String Er_Xod = "Вы неправильно походили пешкой!\r\n";
    static public String NOT_YOUR_CELL = "Это не ваша пешка!\r\n";
    static public String IOException = "Ошибка ввода-вывода!";
    static public String CHOISE = "Если выхотите играть с другим человеком - нажмите 1, если с компьютером - нажмите 2";
    static public String Wh = "o";
    static public String Bl = "•";
    static public String Em = "▫";
    static public int W = 1;
    static public int B = 2;
    static public int E = 0;
}
