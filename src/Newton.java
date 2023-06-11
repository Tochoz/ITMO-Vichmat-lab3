public class Newton {
    private Polynome poly; // Результирующий полином

    // Конструктор, на вход сетка значений
    public Newton(Grid grid) {
        interpolate(grid.getArgs(), grid.getVals()); // Метод интерполяции
    }

    // Метод с помощью значений полученных из сетки вычисляет полином
    private void interpolate(double[] xArray, double[] yArray) {
        poly = new Polynome(yArray[0], 0); // Создание объекта полинома с первым значением функции

        //Разделенные разности
        double[] divDifferences = new double[xArray.length];
        for (int i = 0; i < xArray.length; i++) { // Записываем изначально соответствующие значения функции
            divDifferences[i] = yArray[i];
        }

        //Вспомогательный полином x^1, у него будем изменять свободный член
        Polynome x = new Polynome(1, 1);
        //Вспомогательный полином - множитель
        Polynome multiplier = new Polynome(1, 0);

        // Цикл по каждой неизвестной
        for (int i = 0; i < xArray.length - 1; i++) {
            // Для каждой неизвестной считаем строку разделённых разностей через метод
            for (int j = 0; j < xArray.length - i - 1; j++)
                divDifferences[j] = dividedDifference(divDifferences[j], divDifferences[j + 1], xArray[j], xArray[j + i + 1]);
            // Умножение на полином первой степени, меняем свободный член и умножаем
            x.change(-1 * xArray[i]);
            multiplier.multiply(x);

            // Прибавляем разность, умноженую на вспомогательный полином
            poly.sum(multiplier.multiply(divDifferences[0]));
        }
    }

    //Возвращает разделенную разность следующего порядка
    private double dividedDifference(double a, double b, double x1, double x2) {
        return (a - b) / (x1 - x2);
    }

    public Polynome getPoly(){
        return poly;
    }

}
