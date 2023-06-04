public class Polynome {
    private final double EPS = 1e-5;

    private class Monome{
        private double a;
        private int n;
        private Monome next;

        public Monome(double a, int n) {
            this.n = n;
            this.a = a;
        }

    }
    private Monome head;

    // Создание полинома 1
    public Polynome() {
        head = new Monome(1, 0);
    }
    // Конструктор копирующий, можно в него передавать не только голову но и хвост

    // Полином - моном
    public Polynome(double a, int n) {
        head = new Monome(a, n);
    }

    // Создание полинома копии
    public Polynome(Monome otherMon) {
//        this.head = new Monome(otherMon.a, otherMon.n);
//        Monome temphead = this.head;
//        while (otherMon.next != null) {
//            temphead.next = new Monome(otherMon.a, otherMon.n);
//            otherMon = otherMon.next;
//        }
        // Создание копии связного списка
    }

    // Метод вставляет моном next после cur
    private void insert(Monome cur, Monome next){
//        Monome temp = cur.next;
//        cur.next = next;
//        next.next = temp;
    }

    // Умножение текущего полинома на число
    public void multiply(double a){
        // Если число ноль, замена головы на нулевой моном
        // проход по всем коэффициентов и умножение
    }

    // Метод удаляет элемент идущей после заданного
    private void delete(Monome mon){
        mon.next = mon.next.next;
    }

    // Умножение полинома на другой полином, возвращает результат
    public Polynome multiply(Polynome pal){
        // Проверка pal.head == null head == null, вернуть новый пустой
        // Создание нового полинома-результата, res = new Polynome(pal.head.a * head.a, pal.head.n + head.n)
        // Переменные ссылки по всем трём полиномам m1 m2 m3
        // Переменная для текущей степени pow
        // Проход по элементам текущего полинома
        // while m1 != null
//            m3 = res.head;
        //    проходим по всему второму полиному
        //    while m2 != null
        //        pow = m1.n + m2.n
        //        if m3.next == null   дошли до конца, самая меньшая степень insert(m3, new Term(power, m1.a * m2.a));
        //        else if m3.next.n < power   следующее слагаемое имеет степень меньше, вставляем после текущего m3
        //        else if m3.next.n = power  Степени равны, коэффициенты складываются m3.next.n = m1.a*m2.a, если ноль, удаление
        //        else m3=m3.next Идём дальше
        //        m2 = m2.next
        //
        //    Переход к умножению на следующим множитель из первого полинома
        //    m1=m1.next
        //    m2=pal.head
        //return res
    }

    // Метод складывает текущий полином с входящим, возвращает результат
    public Polynome sum(Polynome pal){
        //Создание пустого третьего полинома
//        Polynome res = new Polynome();
//        res.head = new Monome(0, 0);
//        Monome m3 = res.head;  указатель по нему

        //Проход по спискам со сравнением степеней
//        Monome m1 = head;
//        Monome m2 = pal.head;
//        double coeff; значение коэффициента
//        while (m1 != null && m2 != null) {
//            //Если степени равны, сложить коэффициенты
//            if (m1.n == m2.n) {
//                coeff = m1.a + m2.a;
//                //Если сумма не равна нулю, добавить новое слагаемое в третий полином
//                if (Math.abs(coeff)<EPS) {
//                    insert(m3, new Monome(m1.n, coeff));
//                    m3 = m3.next;
//                }
//                //Сдвинуть ссылки
//                m1 = m1.next;
//                m2 = m2.next;


//            } else {
//                //Если степени не равны, добавить слагаемое с большей в третий полином
//                if (m1.n >= m2.n) {
//                    insert(m3, new Monome(m1));
//                    m3 = m3.next;
//                    //Сдвинуть ссылку
//                    m1 = m1.next;
//                } else {
//                    insert(m3, new Monome(m2));
//                    m3 = m3.next;
//                    //Сдвинуть ссылку
//                    m2 = m2.next;
//                }
//            }
//        }
        // Если один из полиномов нулевой, копируем другой и привязываем копию
//        if (m1 != null) {
//            m3.next = new Polynome(m1).head;
//        }
//        if (m2 != null) {
//            m3.next = new Polynome(m2).head;
//        }
//
//        res.head = res.head.next; // Сдвигаем голову на 1 вперёд
//
//        return res;
    }

    //Возвращает значение полинома в точке x по Горнеру
    public double value(double x) {
        double b = head.a;
        Monome m = head.next;
        int j;
        // Проходим в цикле, контроллируем если дошли до конца связноного списка, или до конца степеней
        for (j = head.n - 1; j > 0 && m != null; j--) {
            if (j > m.n) { // Умножаем пока есть промежуточные степени между элементами связного списка
                b *= x;
            } else { // Умножаем на значение и прибавляем коэффициент
                b = m.a + b * x;
                m = m.next;
            }
        }
        while (j > 0) { // Умножаем если j не дошла до 0
            b *= x;
            j--;
        }
        return b;
    }

    // Метод выводит строковое представление полинома в консоль
    public void print() {
        for (Monome t = head; t != null; t = t.next) { // TODO достаточно числа
            if (t.a < 0) { // Знак
                System.out.print("-");
            } else if (t.a > 0 && t != head) {
                System.out.print("+");
            }
            System.out.printf(" %.6e ", Math.abs(t.a)); // Основание
            System.out.print("* x ^");
            System.out.print(" " + t.n + " "); // Степень
        }
        System.out.println();
    }

}
