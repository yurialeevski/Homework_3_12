package ru.skypro.homework.springfiles.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.skypro.homework.springfiles.dto.EmployeeDTO;
import ru.skypro.homework.springfiles.dto.EmployeeViewDTO;
import ru.skypro.homework.springfiles.exceptions.IncorrectEmployeeIdException;
import ru.skypro.homework.springfiles.pojo.Employee;
import ru.skypro.homework.springfiles.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public static final Logger logger = LoggerFactory.getLogger(EmployeeService.class.getName());

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllWithMaxSalary() {
        logger.info("Getting all employees by the greatest salary");
        return employeeRepository.findAllWithMaxSalary()
                .stream()
                .map(EmployeeDTO::fromEmployeeAllFields)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> findAllWithPosition(String position) {
        //System.out.println("position = " + position);
        logger.info("Getting all employees by specific position");
        if(!position.isEmpty()) {
            return employeeRepository.findAllWithPosition(position)
                    .stream()
                    .map(EmployeeDTO::fromEmployeeAllFields)
                    .collect(Collectors.toList());
        } else {
            return employeeRepository.findAll()
                    .stream()
                    .map(EmployeeDTO::fromEmployeeAllFields)
                    .collect(Collectors.toList());
        }
    }

    public EmployeeView findFullInfoById(Integer id) {
        logger.info("DTO is not used: Getting full info by id directly from employeeView");
        System.out.println("id = " + id);
        Optional<EmployeeView> employeeView = employeeRepository.findByIdEmployeeView(id);

        return employeeView.orElseThrow(() -> new IncorrectEmployeeIdException("id: " + id));
    }
    public EmployeeViewDTO findViewInfo(Integer id) {
        logger.info("DTO is used: employee full info by id");
        return EmployeeViewDTO.fromEmployeeView(employeeRepository.findByIdEmployeeView(id)
                .orElseThrow(() -> new IncorrectEmployeeIdException("id: " + id)));
    }

    public List<Employee> getAllByPageNumber(int pageIndex, int unitPerPage, String sortBy) {
        logger.info("Getting all employees by specific page: " + pageIndex);
        Pageable paging = PageRequest.of(pageIndex, unitPerPage, Sort.by(sortBy));

        Page<Employee> pagedResult = employeeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }

    public Employee getEmployeeById(Integer employeeId) {
        logger.info("Getting employee with id: " + employeeId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        System.out.println(employee);
        return employee.orElseThrow(()-> new RuntimeException("id: " + employeeId));
        //return employee.map(EmployeeDTO::fromEmployee).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
