public class Newton {

    private Polynome poly; // �������������� �������
    private double[] newtonArray;
    private double[] xArray;  // ������ ����������
    private double[] yArray;  // ������ ��������

    // �����������, �� ���� ����� ��������
    public Newton(Grid grid) {
        xArray = grid.getArgs();
        yArray = grid.getVals();
        newtonArray = new double[xArray.length];
        poly = new Polynome(0, yArray[0]);

        interpolate(); // ����� ������������
    }

    // ����� � ������� �������� ���������� �� ����� ��������� �������
    private void interpolate() {
    }
}
