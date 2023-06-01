public class Lagrange {
    private Polynome poly; // Результирующий полином
    private double[] xArray;  // Массив аргументов
    private double[] yArray;  // Массив значений

    // Конструктор, на вход сетка значений
    public Lagrange(Grid grid) {
        xArray = grid.getArgs();
        yArray = grid.getVals();
        poly = new Polynome();
        interpolate(); // Метод интерполяции
    }

    // Метод с помощью значений полученных из сетки вычисляет полином
    private void interpolate() {
        poly = new Polynome();

        //Вспомогательный полином x^1
        Polynome x = new Polynome(1, 1);
        //Множители элементарных функций
        Polynome[] multipliers = new Polynome[xArray.length];
        for (int i = 0; i < xArray.length; i++) {
            multipliers[i] = x.sum(new Polynome(-1 * xArray[i], 0));
        }

        for (int i = 0; i < xArray.length; i++) {
            poly = poly.sum(elementaryFunction(i, multipliers));
        }
    }

    //Вовзвращает коэффициент элементарной функции
    private double coef_el(int i, int j) {
        return 1 / (xArray[i] - xArray[j]);
    }

    //Элементарная функция для одного значения сетки
    private Polynome elementaryFunction(int ind, Polynome[] multipliers) {
        Polynome result = new Polynome(yArray[ind], 0);

        // Умножение до текущего индекса
        for (int i = 0; i < ind; i++) {
            //Умножение полинома на новый множитель
            multipliers[i].multiply(coef_el(ind, i));
            result = result.multiply(multipliers[i]);
        }

        // Умножения после текущего индекса
        for (int i = ind + 1; i < xArray.length; i++) {
            //Умножение полинома на новый множитель
            multipliers[i].multiply(coef_el(ind, i));
            result = result.multiply(multipliers[i]);
        }

        return result;
    }

    //Возвращает значение полинома в точке x
    public double value(double x) {
        return poly.value(x);
    }

    //Печататет полином
    public void print() {
        poly.print();
    }

    public Polynome getPoly() {
        return poly;
    }
}

