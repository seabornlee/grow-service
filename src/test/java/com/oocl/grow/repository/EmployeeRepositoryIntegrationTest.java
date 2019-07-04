package com.oocl.grow.repository;

import com.oocl.grow.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void return_Employee_when_findByName() {
        // given
        Employee alex = Employee.builder()
                .name("alex")
                .build();
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName("alex");

        // then
        assertThat(found.getName()).isEqualTo(alex.getName());
    }
}