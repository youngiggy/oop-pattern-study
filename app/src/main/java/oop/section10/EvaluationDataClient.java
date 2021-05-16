package oop.section10;

import java.util.ArrayList;
import java.util.Arrays;

public class EvaluationDataClient extends EmpReportHTTPFacade {
    @Override
    public ArrayList<String> getEmpReportData() {
        return new ArrayList<>(Arrays.asList("evaluationdataclient_1", "evaluationdataclient_2"));
    }
}
