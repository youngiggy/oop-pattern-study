package oop.section10;

public class GUIViewer implements Display {
    private final EmpReportFacade dataLoader;

    public GUIViewer(EmpReportFacade dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public void display() {
        System.out.println(this.getClass().getName() + " : " + dataLoader.getEmpReportData());
    }
}
