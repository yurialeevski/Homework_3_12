package ru.skypro.homework.springfiles.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    public static final Logger logger = LoggerFactory.getLogger(FileService.class.getName());

    public static String writeJsonToFile(String jsonFileName) {
        logger.info("Запись строки с JSON в файл .json");
        //String jsonFileName = "employee.json";
        String employeeJson = getJsonString();
        try (OutputStream outputStream = new FileOutputStream(jsonFileName)) {
            outputStream.write(employeeJson.getBytes());
            outputStream.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Path path = Paths.get(jsonFileName);
        System.out.println(path);
        return employeeJson;
    }

    public static String readJsonFromFile(MultipartFile jsonFileName) {
        try (InputStream inputStream = jsonFileName.getInputStream()) {

            int streamSize = inputStream.available();
            byte[] bytes = new byte[streamSize];

            inputStream.read(bytes);

            // Возвращаем текст, прочитанный из файла, в виде строки
            return new String(bytes, StandardCharsets.UTF_8);

        } catch (IOException ioException) {
            // В случае ошибки выводим стек вызовов
            ioException.printStackTrace();
            return "";
        }
    }
    public static String readJsonFromFileStringPath(String jsonFileName) {
        try (InputStream inputStream = new FileInputStream(jsonFileName)) {
            int streamSize = inputStream.available();
            byte[] bytes = new byte[streamSize];
            inputStream.read(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "";
        }
    }

    public static String getJsonString() {
        String jsonString = "[\n" +
                "  {\n" +
                "    \"employeeId\": 1,\n" +
                "    \"name\": \"em1\",\n" +
                "    \"salary\": 100,\n" +
                "    \"position\": {\n" +
                "      \"id\": 1,\n" +
                "      \"role\": \"director\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 2,\n" +
                "    \"name\": \"em2\",\n" +
                "    \"salary\": 150,\n" +
                "    \"position\": {\n" +
                "      \"id\": 3,\n" +
                "      \"role\": \"middle\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 3,\n" +
                "    \"name\": \"em3\",\n" +
                "    \"salary\": 200,\n" +
                "    \"position\": {\n" +
                "      \"id\": 4,\n" +
                "      \"role\": \"senior\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"employeeId\": 4,\n" +
                "    \"name\": \"em4\",\n" +
                "    \"salary\": 250,\n" +
                "    \"position\": {\n" +
                "      \"id\": 2,\n" +
                "      \"role\": \"junior\"\n" +
                "    }\n" +
                "  }\n" +
                "]";
        return jsonString;
    }
    public static String getDtoJsonString() {
        String dtoJson = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"em1\",\n" +
                "    \"salary\": 100,\n" +
                "    \"position\": {\n" +
                "      \"id\": 1,\n" +
                "      \"role\": \"director\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"em2\",\n" +
                "    \"salary\": 150,\n" +
                "    \"position\": {\n" +
                "      \"id\": 3,\n" +
                "      \"role\": \"middle\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"em3\",\n" +
                "    \"salary\": 200,\n" +
                "    \"position\": {\n" +
                "      \"id\": 4,\n" +
                "      \"role\": \"senior\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"em4\",\n" +
                "    \"salary\": 250,\n" +
                "    \"position\": {\n" +
                "      \"id\": 2,\n" +
                "      \"role\": \"junior\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"em20\",\n" +
                "    \"salary\": 200,\n" +
                "    \"position\": {\n" +
                "      \"id\": 1,\n" +
                "      \"role\": \"director\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 6,\n" +
                "    \"name\": \"em201\",\n" +
                "    \"salary\": 200,\n" +
                "    \"position\": {\n" +
                "      \"id\": 2,\n" +
                "      \"role\": \"junior\"\n" +
                "    }\n" +
                "  }\n" +
                "]";
        return dtoJson;
    }
}
