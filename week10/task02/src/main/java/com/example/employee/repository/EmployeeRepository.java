package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //以下所有的*都代表变量
    //1.查询名字是*的第一个employee
    Employee findTopByName(String name);

    //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息
    Employee findFirstByNameLikeAndSalaryIsGreaterThan(String character, int salary);

    //3.找出一个薪资最高且公司ID是*的雇员姓名
    @Query("SELECT a.name FROM Employee AS a WHERE a.salary=(SELECT MAX(b.salary) FROM Employee AS b WHERE b.companyId=?1)")
    String findEmployeeNameByCompanyIdAndSalaryIsMax(int companyId);

    //4.实现对Employee的分页查询
    Page<Employee> findAll(Pageable pageable);

    //5.查找**的所在的公司的公司名称
    @Query("SELECT c.companyName FROM Company AS c WHERE c.id=(SELECT e.id FROM Employee AS e WHERE e.name=?1)")
    String findCompanyNameByEmployeeName(String employeeName);

    //6.将*的名字改成*,输出这次修改影响的行数
    @Modifying
    @Query("UPDATE Employee AS e SET e.name=?2 WHERE e.name=?1")
    @Transactional
    int updateName(String name,String newName);

    //7.删除姓名是*的employee
    void deleteByName(String name);

}
