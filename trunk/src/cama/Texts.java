package cama;
public class Texts {
    static public String GREETING = "Добро пожаловать в игру \"Пешки 3х3\"!\nДля того, чтобы сделать ход, выберите\nкоординаты пешки, поставьте тире\nи выберите координаты места, куда\nхотите поставить пешку. Удачи!\n";
    static public String BlWin = "Черные выиграли!";
    static public String WhWin = "Белые выиграли!";
    static public String NAME = "Введите ваши имена: ";
    static public String NAME1 = "Введите ваше имя: ";
    static public String TRY = "Попробуйте снова!\r\n";
    static public String EMPTY = "Вы хотите передвинуть пустое место!";
    static public String ER_STEP = "Вы неправильно походили!";
    static public String ER_TEXT = "Вы написали текст, загляните в правила и попробуйте еще раз!";
    static public String OUT_OF_BOUNDS = "Вы зашли за границы таблицы! Попробуйте еще раз!";
    static public String EMPTY_LN = "Вы хотите передвинуть пустое место!\r\n";
    static public String YOUR_CELL = "Вы хотите срубить свою же пешку!";
    static public String Er_Xod = "Вы неправильно походили пешкой!\r\n";
    static public String NOT_YOUR_CELL_LN = "Это не ваша пешка!\r\n";
    static public String NOT_YOUR_CELL = "        Это не ваша пешка!     ";
    static public String IOException = "Ошибка ввода-вывода!";
    static public String CHOISE = "Игра с компьютером - 1\r\nДва игрока - 2\r\n";
    static public String CHEAT1 = "Поздравляем господин Кудык!!!! Вы выиграли!!";
    static public String START =  " a b c\r\n1 o o o\r\n2 ▫ ▫ ▫\r\n3 • • •\r\nПример: a1-a2\r\nДля выхода введите exit";
    static public String Wh = "o";
    static public String Bl = "•";
    static public String Em = "▫";

    static public String HTML_GREETING = "<html>          Добро пожаловать в игру \"Пешки 3х3\"!<br><br>"
                + "Для того, чтобы сделать ход, выберите<br>"
                + "координаты пешки, поставьте тире<br>"
                + "и выберите координаты "
                + "места, куда<br> хотите поставить пешку. Удачи!";
    static public String HTML_ER_TEXT = "<html>Вы написали текст загляните<br>"
            + " в правила и попробуйте еще раз!";
    static public String HTML_OUT_OF_BOUNDS = "<html>Вы зашли за границы таблицы!<br> Попробуйте еще раз!";
    
    static public String DO_STEP (String name){
        return name+" ходит: \r\n";
    }
}
