package gui_cama;
public class Texts {
    static public String GREETING = "<html>          Добро пожаловать в игру \"Пешки 3х3\"!<br><br>"
                + "Для того, чтобы сделать ход, выберите<br>"
                + "координаты пешки, поставьте тире<br>"
                + "и выберите координаты "
                + "места, куда<br> хотите поставить пешку. Удачи!";
    static public String DO_STEP (String name){
        return name+" ходит: \r\n";
    }
    static public String NAME = "Введите ваши имена: ";
    static public String NAME1 = "Введите ваше имя: ";
    static public String TRY = "Попробуйте снова!\r\n";
    static public String ER_TEXT = "<html>Вы написали текст загляните<br>"
            + " в правила и попробуйте еще раз!";
    static public String OUT_OF_BOUNDS = "<html>Вы зашли за границы таблицы!<br> Попробуйте еще раз!";
    static public String EMPTY = "Вы хотите передвинуть пустое место!";
    static public String YOUR_CELL = "Вы хотите срубить свою же пешку!";
    static public String ER_STEP = "Вы неправильно походили пешкой!";
    static public String NOT_YOUR_CELL = "        Это не ваша пешка!     ";
    static public String CHOISE = "Игра с компьютером - 1\r\nДва игрока - 2\r\n";
    static public String CHEAT1 = "Поздравляем господин Кудык!!!! Вы выиграли!!";
    static public String START =  " a b c\r\n1 o o o\r\n2 ▫ ▫ ▫\r\n3 • • •\r\nПример: a1-a2\r\nДля выхода введите exit";
    static public String Wh = "o";
    static public String Bl = "•";
    static public String Em = "▫";
}
