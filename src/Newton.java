public class Newton {
    private Polynome poly; // Результирующий полином

    // Конструктор, на вход сетка значений
    public Newton(Grid grid) {
        interpolate(grid.getArgs(), grid.getVals()); // Метод интерполяции
    }

    // Метод с помощью значений полученных из сетки вычисляет полином
    private void interpolate(double[] xArray, double[] yArray) {
        poly = new Polynome(yArray[0], 0); // Создание объекта полинома с первым значением функции

        //Массив разделённых разностей для каждой неизвестной
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
            computeDividedDifference(i, divDifferences, xArray);

            // Умножение на полином первой степени, меняем свободный член и умножаем
            x.change(-1 * xArray[i]);
            multiplier.multiply(x);

            // Прибавляем разность, умноженую на вспомогательный полином
            poly.sum(multiplier.multiply(divDifferences[0]));
        }
    }

    // Метод считает разделённые разности для каждой неизвестной,
    // на вход индекс неизвестной, массив предыдущих разностей, массив аргументов функции
    private void computeDividedDifference(int i, double[] divDifferences, double[] xArray) {
        for (int j = 0; j < xArray.length - i - 1; j++)
            divDifferences[j] = (divDifferences[j] - divDifferences[j + 1]) / (xArray[j] - xArray[j + i + 1]);
    }

    public Polynome getPoly(){
        return poly;
    }

}
