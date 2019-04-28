package com.example.employee;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EmployeeJPATest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
        //本地启动mysql，创建employee_db数据库
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/employee_db","root","root");
        flyway.clean();
        flyway.migrate();
    }

    /*
     * 实体Employee包含字段分别有：id, 姓名(name), 年龄(age), 性别(gender), companyId, 薪资(salary)
     * 实体Company包含字段分别有：id, 公司名(companyName), 员工数量(employeesNumber)
     */
    @Test
    public void should_return_employee_when_input_employee_name() throws Exception {
        //1.查询名字是小红的employee
        Employee expectedEmployee = new Employee(1,"xiaohong",19,"female",1,7000);

        String actualName = null;
        assertThat(actualName).isEqualTo(expectedEmployee.getName());
    }

    @Test
    public void should_return_employee_given_character_in_name_and_salary_large_than() throws Exception {
        //2.找出Employee表中第一个姓名包含`n`字符的雇员所有个人信息
        Employee expectedEmployee = new Employee(1,"xiaohong",19,"female",1,7000);
        String actualName = null;
        assertThat(actualName).isEqualTo(expectedEmployee.getName());
    }

    @Test
    public void should_return_employee_name_when_employee_salary_is_max_and_given_company_id_() throws Exception {
        //3.找出一个薪资最高且公司ID是1的雇员以及该雇员的name
        Employee expectedEmployee = new Employee(1,"xiaohong",19,"female",1,7000);
        String actualName = null;
        assertThat(actualName).isEqualTo(expectedEmployee.getName());
    }

    @Test
    public void should_return_employee_list_when_input_page_request() throws Exception {
        //4.实现对Employee的分页查询，每页两条数据，一共三页数。
        //注意：PageRequest的构造方法已经弃用了代替的是PageRequest.of,并且最后一个参数代表按照table中的哪一个字段排序
        Page<Employee> EmployeePage = null;
        assertThat(EmployeePage.getTotalPages()).isEqualTo(3);
    }

    @Test
    public void should_return_company_name_when_input_employee_name() throws Exception {
        //5.查找xiaohong的所在的公司的公司名称
        String expectedCompanyName = "alibaba";
        String actualCompanyName = null;
        assertThat(actualCompanyName).isEqualTo(expectedCompanyName);
    }

    @Test
    public void should_return_influence_lines_when_update_employee_name() throws Exception {
        //6.将xiaohong的名字改成xiaobai,输出这次修改影响的行数
        Integer expectedLine = 1;
        Integer actualLine = null;
        assertThat(actualLine).isEqualTo(expectedLine);
    }

    @Test
    public void should_deleted_employee_when_given_employee_name() throws Exception {
        //7.删除姓名是xiaohong的employee
        Employee expectedEmployee = new Employee(1,"xiaohong",19,"female",1,7000);
        Employee actualEmployee = null;
        assertThat(actualEmployee).isNull();
    }
}
