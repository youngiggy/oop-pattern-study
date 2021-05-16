package oop.section10;

public class XmlReporter implements Display {
    private final EmpReportFacade dataLoader;

    public XmlReporter(EmpReportFacade dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public void display() {
        System.out.println(this.getClass().getName() + " : " + dataLoader.getEmpReportData());
    }
}
