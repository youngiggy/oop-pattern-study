package oop.section10;

import java.util.ArrayList;
import java.util.Arrays;

public class EmpDao extends EmpReportDaoFacade {
    @Override
    public ArrayList<String> getEmpReportData() {
        return new ArrayList<>(Arrays.asList("empdao_1", "empdao_2", "empdao_3"));
    }
}
