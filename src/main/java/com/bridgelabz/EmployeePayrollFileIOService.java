package com.bridgelabz;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static String PAYROLL_FILE_NAME="Pay_role.txt";
    public void writeData(List<EmployeePayRoleData> employeePayrollList) {
       StringBuffer employeeBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            employeeBuffer.append(employeeDataString);
        });
           try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), employeeBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public long countEntries(List<EmployeePayRoleData> employeePayrollList) {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
}

