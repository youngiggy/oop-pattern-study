package oop.section10;

import java.util.ArrayList;
import java.util.Arrays;

public class ResumeDao extends EmpReportDaoFacade {
    @Override
    public ArrayList<String> getEmpReportData() {
        return new ArrayList<>(Arrays.asList("resumedao_1", "resumedao_2", "resumedao_3"));
    }
}
