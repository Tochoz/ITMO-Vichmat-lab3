public class Lagrange {
    private Polynome poly; // �������������� �������
    private double[] xArray;  // ������ ����������
    private double[] yArray;  // ������ ��������

    // �����������, �� ���� ����� ��������
    public Lagrange(Grid grid) {
        xArray = grid.getArgs();
        yArray = grid.getVals();
        poly = new Polynome();
        interpolate(); // ����� ������������
    }

    // ����� � ������� �������� ���������� �� ����� ��������� �������
    private void interpolate() {
        poly = new Polynome();

        //��������������� ������� x^1
        Polynome x = new Polynome(1, 1);
        //��������� ������������ �������
        Polynome[] multipliers = new Polynome[xArray.length];
        for (int i = 0; i < xArray.length; i++) {
            multipliers[i] = x.sum(new Polynome(-1 * xArray[i], 0));
        }

        for (int i = 0; i < xArray.length; i++) {
            poly = poly.sum(elementaryFunction(i, multipliers));
        }
    }

    //����������� ����������� ������������ �������
    private double coef_el(int i, int j) {
        return 1 / (xArray[i] - xArray[j]);
    }

    //������������ ������� ��� ������ �������� �����
    private Polynome elementaryFunction(int ind, Polynome[] multipliers) {
        Polynome result = new Polynome(yArray[ind], 0);

        // ��������� �� �������� �������
        for (int i = 0; i < ind; i++) {
            //��������� �������� �� ����� ���������
            multipliers[i].multiply(coef_el(ind, i));
            result = result.multiply(multipliers[i]);
        }

        // ��������� ����� �������� �������
        for (int i = ind + 1; i < xArray.length; i++) {
            //��������� �������� �� ����� ���������
            multipliers[i].multiply(coef_el(ind, i));
            result = result.multiply(multipliers[i]);
        }

        return result;
    }

    //���������� �������� �������� � ����� x
    public double value(double x) {
        return poly.value(x);
    }

    //��������� �������
    public void print() {
        poly.print();
    }

    public Polynome getPoly() {
        return poly;
    }
}

