package ru.skypro.homework.springfiles.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.springfiles.dto.EmployeeDTO;
import ru.skypro.homework.springfiles.dto.EmployeeReport;
import ru.skypro.homework.springfiles.dto.EmployeeViewDTO;
import ru.skypro.homework.springfiles.exceptions.IncorrectEmployeeIdException;
import ru.skypro.homework.springfiles.pojo.Employee;
import ru.skypro.homework.springfiles.pojo.Position;
import ru.skypro.homework.springfiles.repository.EmployeeRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

    public List<Employee> getJsonSaveToDatabase(MultipartFile jsonDTOFileName) {
        System.out.println(jsonDTOFileName);
        String jsonDtoString = FileService.readJsonFromFile(jsonDTOFileName);
        System.out.println(jsonDtoString);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            employeeDTOList = objectMapper.readValue(jsonDtoString, new TypeReference<List<EmployeeDTO>>() {});
            System.out.println(employeeDTOList);
            employeeList = employeeDTOList.stream()
                    .map(EmployeeDTO::toEmployee)
                    .collect(Collectors.toList());
            System.out.println(employeeList);
            employeeRepository.saveAll(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
            //return "";
        }
        return employeeList;
        /*
        Position p1 = new Position(2,"r");
        System.out.println(p1);
        EmployeeDTO dto1 = new EmployeeDTO(0, "em202", 202, p1);
        System.out.println(dto1);
        Position p2 = new Position(3,"r");
        System.out.println(p2);
        EmployeeDTO dto2 = new EmployeeDTO(0, "em203", 203, p2);
        System.out.println(dto2);
        Employee e1 = dto1.toEmployee();
        System.out.println(e1);
        Employee e2 = dto2.toEmployee();
        System.out.println(e2);
        String j1 = "{\n" +
                "    \"employeeId\": 1,\n" +
                "    \"name\": \"em204\",\n" +
                "    \"salary\": 204,\n" +
                "    \"position\": {\n" +
                "      \"id\": 1,\n" +
                "      \"role\": \"director\"\n" +
                "    }\n" +
                "  }\n";
         Employee emp1 = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            emp1 = objectMapper.readValue(j1, Employee.class);
            System.out.println(emp1);
            //employeeRepository.save(emp1);

        } catch (IOException e) {
            e.printStackTrace();
            //return "";
        }
         */
        //List<Employee> eList = new ArrayList<>(List.of(e1,e2));
        //for(Employee employee: eList) {
        //
        //}
    }

    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toEmployee();
        employeeRepository.save(employee);
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

    public List<EmployeeDTO> getAllByPageNumber(int pageIndex, int unitPerPage, String sortBy) {
        logger.info("Getting all employees by specific page: " + pageIndex);
        Pageable paging = PageRequest.of(pageIndex, unitPerPage, Sort.by(sortBy));
        Page<Employee> pagedResult = employeeRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            List<Employee> employeeList = pagedResult.stream().toList();
            List<EmployeeDTO> employeeDTOList = employeeList.stream()
                    .map(EmployeeDTO::fromEmployeeAllFields)
                    .collect(Collectors.toList());
            return employeeDTOList;
        } else {
            return new ArrayList<EmployeeDTO>();
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