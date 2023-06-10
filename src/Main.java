import java.util.*;

public class Main {

    private static Grid grid;

    public static void main(String[] args) {
        grid = new Grid(6, 0, 2); // Создание сетки значений

        // Создание объектов класса и получение полиномов-результатов
        Newton newton = new Newton(grid);
        Lagrange lagrange = new Lagrange(grid);

        // Получившиеся полиномы
        Polynome lagrangeAns = lagrange.getPoly();
        Polynome newtonAns = newton.getPoly();

        // Вывод получившихся полиномов
        System.out.println();
        System.out.print("Lagrange: ");
        lagrangeAns.print();
//        System.out.print("Newton: ");
//        newtonAns.print();
//        System.out.println();

        // Метод, выводящий в виде сравнительной таблицы результаты
        printTable(lagrangeAns, newtonAns);
    }

    // Метод выводи сравнительную таблицу
    private static void printTable(Polynome lagrangeAns, Polynome newtonAns) {
        double[] xArray = grid.getArgs(); // Получение массивов аргументов и значений для удобного доступа
        double[] yArray = grid.getVals();

        System.out.println("\t\t\tx\t\t\tf(x)\t\t\tLagrange\t\t\tNewton"); // Заголовки таблицы
        for (int i = 0; i < xArray.length - 1; i++) {
            System.out.print(i + "  "); // Номер узла

            // Вывод строки значений
            System.out.printf("%15.6E\t%15.6E\t%15.6E\t%15.6E\t\n",
                    xArray[i],
                    yArray[i],
                    lagrangeAns.value(xArray[i]),
                    newtonAns.value(xArray[i]));

            // расчёт промежуточного узла и вывод строки
            double m = (xArray[i + 1] + xArray[i]) / 2;
            System.out.print(i + 0.5);
            System.out.printf("%15.6E\t%15.6E\t%15.6E\t%15.6E\t\n",
                    m,
                    grid.f(m),
                    lagrangeAns.value(m),
                    newtonAns.value(m));
        }
        // Вывод последней строки значений
        System.out.print((xArray.length-1) + "  ");
        System.out.printf("%15.6E\t%15.6E\t%15.6E\t%15.6E\t\n",
                xArray[xArray.length-1],
                yArray[xArray.length-1],
                lagrangeAns.value(xArray[xArray.length-1]),
                newtonAns.value(xArray[xArray.length-1]));
    }
}