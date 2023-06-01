public class Grid {

    private class Point { // ����� ����� �������, �������� ��������
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point[] points; // ������ ����� �����

    // ������ �����, �������� ������ ������� �� n ����� ������� ��������� (l - ����� �������, r - ������); ������� f
    public Grid(int n, double l, double r) {
        points = new Point[n];
        points[0] = new Point(l, f(l)); // ����� ������� ��������
        double delta = (r - l) / (double) (n - 1); // ������ �������
        for (int i = 1; i < n - 1; i++) {
            l += delta;
            points[i] = new Point(l, f(l));
        }
        points[n - 1] = new Point(r, f(r)); // ������ ������� ��������
    }

    // ��������� ������� ����������
    public double[] getArgs() { // x
        double[] result = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            result[i] = points[i].x;
        }
        return result;
    }

    // ��������� ������� ��������
    public double[] getVals() { // y
        double[] result = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            result[i] = points[i].y;
        }
        return result;
    }

    public double f(double x) {
        return Math.sin(x); // ����� �������
    }
}