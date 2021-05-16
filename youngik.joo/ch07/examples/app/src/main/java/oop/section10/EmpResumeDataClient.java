package oop.section10;

import java.util.ArrayList;
import java.util.Arrays;

public class EmpResumeDataClient extends EmpReportHTTPFacade {
    @Override
    public ArrayList<String> getEmpReportData() {
        return new ArrayList<>(Arrays.asList("empresumedataclient_1", "empresumedataclient_2"));
    }
}
