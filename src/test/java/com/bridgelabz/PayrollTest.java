package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
@SuppressWarnings("deprecation")
public class PayrollTest {
    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeesEntries() {
        EmployeePayRoleData[] arrayOfEmps = { new EmployeePayRoleData(1, "Pavithra", 123456.00),
                new EmployeePayRoleData(2, "jaya", 123467.00),
                new EmployeePayRoleData(3, "abi", 56423.00) };
        EmployeePayRoleService payrollService;
        payrollService = new EmployeePayRoleService(Arrays.asList(arrayOfEmps));
        payrollService.write(EmployeePayRoleService.IOService.FILE_IO);
        long entriesCount=payrollService.countEntries(EmployeePayRoleService.IOService.FILE_IO);
        Assert.assertEquals(3, entriesCount);
    }


}

