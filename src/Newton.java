public class Newton {

    private Polynome poly; // Результирующий полином
    private double[] newtonArray;
    private double[] xArray;  // Массив аргументов
    private double[] yArray;  // Массив значений

    // Конструктор, на вход сетка значений
    public Newton(Grid grid) {
        xArray = grid.getArgs();
        yArray = grid.getVals();
        newtonArray = new double[xArray.length];
        poly = new Polynome(0, yArray[0]);

        interpolate(); // Метод интерполяции
    }

    // Метод с помощью значений полученных из сетки вычисляет полином
    private void interpolate() {
    }
}
