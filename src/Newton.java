public class Newton {
    private Polynome poly; // �������������� �������

    // �����������, �� ���� ����� ��������
    public Newton(Grid grid) {
        interpolate(grid.getArgs(), grid.getVals()); // ����� ������������
    }

    // ����� � ������� �������� ���������� �� ����� ��������� �������
    private void interpolate(double[] xArray, double[] yArray) {
        poly = new Polynome(yArray[0], 0); // �������� ������� �������� � ������ ��������� �������

        //����������� ��������
        double[] divDifferences = new double[xArray.length];
        for (int i = 0; i < xArray.length; i++) { // ���������� ���������� ��������������� �������� �������
            divDifferences[i] = yArray[i];
        }

        //��������������� ������� x^1, � ���� ����� �������� ��������� ����
        Polynome x = new Polynome(1, 1);
        //��������������� ������� - ���������
        Polynome multiplier = new Polynome(1, 0);

        // ���� �� ������ �����������
        for (int i = 0; i < xArray.length - 1; i++) {
            // ��� ������ ����������� ������� ������ ���������� ��������� ����� �����
            for (int j = 0; j < xArray.length - i - 1; j++)
                divDifferences[j] = dividedDifference(divDifferences[j], divDifferences[j + 1], xArray[j], xArray[j + i + 1]);
            // ��������� �� ������� ������ �������, ������ ��������� ���� � ��������
            x.change(-1 * xArray[i]);
            multiplier.multiply(x);

            // ���������� ��������, ��������� �� ��������������� �������
            poly.sum(multiplier.multiply(divDifferences[0]));
        }
    }

    //���������� ����������� �������� ���������� �������
    private double dividedDifference(double a, double b, double x1, double x2) {
        return (a - b) / (x1 - x2);
    }

    public Polynome getPoly(){
        return poly;
    }

}
