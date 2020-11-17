package com.company.tools;

import com.company.model.Employee;
import com.company.model.Manager;
import com.company.model.Worker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * FileAccess class for interacting with stored data with <b>gson</b> property
 *
 * @author Dmitriy Orlov
 */
public class FileAccess {
    Gson gson = new Gson();

    /**
     * A method for reading data from files.
     * This method reads data from two files employees.txt and managers.txt
     * and combines them into a List<Worker>
     *
     * @return a list of workers
     */
    public List<Worker> readFromFile() {
        Type typeEmployee = new TypeToken<List<Employee>>() {
        }.getType();
        Type typeManager = new TypeToken<List<Manager>>() {
        }.getType();

        ArrayList<Employee> employees = null;
        ArrayList<Manager> managers = null;
        ArrayList<Worker> workers = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new FileReader("src/files/employee.txt"))) {
            employees = gson.fromJson(reader, typeEmployee);
        } catch (FileNotFoundException e) {
            try {
                File newFile = new File("src/files/employee.txt");
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (JsonReader reader = new JsonReader(new FileReader("src/files/manager.txt"))) {
            managers = gson.fromJson(reader, typeManager);
        } catch (FileNotFoundException e) {
            try {
                File newFile = new File("src/files/manager.txt");
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (employees != null) {
            workers.addAll(employees);
        }
        if (managers != null) {
            workers.addAll(managers);
        }
        return workers;
    }

    /**
     * This method saves List<Worker> to two different files employees.txt
     * and managers.txt depending on the type of worker.
     *
     * @param workers list of workers
     * @return true if the recording was successful
     */
    public boolean saveToFile(List<Worker> workers) {
        List<Employee> employees = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();

        for (Worker worker : workers) {
            if (worker instanceof Employee) {
                employees.add((Employee) worker);
            }
            if (worker instanceof Manager) {
                managers.add((Manager) worker);
            }
        }

        if (employees.size() > 0) {
            try (FileOutputStream fileOutputStream = new FileOutputStream("src/files/employee.txt")) {
                String json = gson.toJson(employees);
                byte[] jsonBytes = json.getBytes();
                fileOutputStream.write(jsonBytes);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            recreateFile("src/files/employee.txt");
        }
        if (managers.size() > 0) {
            try (FileOutputStream fileOutputStream = new FileOutputStream("src/files/manager.txt")) {
                String json = gson.toJson(managers);
                byte[] jsonBytes = json.getBytes();
                fileOutputStream.write(jsonBytes);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            recreateFile("src/files/manager.txt");
        }
        return true;
    }

    /**
     * Method for overwriting a file
     *
     * @param path the path to the file that will be overwritten
     */
    private void recreateFile(String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write("".getBytes());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
