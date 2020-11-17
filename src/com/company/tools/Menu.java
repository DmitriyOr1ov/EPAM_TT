package com.company.tools;

import com.company.exception.StringNullOrEmptyException;
import com.company.model.Employee;
import com.company.model.Manager;
import com.company.service.WorkerService;
import com.company.service.WorkerServiceImpl;

import java.io.IOException;
import java.time.DateTimeException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Menu class for user interaction
 *
 * @author Dmitriy Orlov
 */
public class Menu {

    /**
     * Method for displaying the menu to the user
     */
    public void showMenu() {
        int key = Integer.MAX_VALUE;
        WorkerService workerService = new WorkerServiceImpl();
        Scanner scanner = new Scanner(System.in);
        String menu = "\nMenu: \n"
                + "1. Show all workers \n"
                + "2. Add new worker \n"
                + "3. Remove worker from notepad \n"
                + "4. Find worker by phone \n"
                + "5. Find workers by firstname \n"
                + "6. Find workers by lastname \n"
                + "7. Sort workers by lastname \n"
                + "8. Sort workers by year of birth \n"
                + "0. Exit \n";
        do {
            System.out.println(menu);
            String menuInput = scanner.nextLine();
            try {
                key = Integer.parseInt(menuInput);
            } catch (NumberFormatException e) {
                System.out.println("Please, input correct value");
            }

            switch (key) {
                case 1: {
                    AtomicInteger index = new AtomicInteger();
                    workerService.
                            findAll().
                            forEach(x -> System.out.println("# " + index.getAndIncrement() +
                                    " " + x + "\n"));
                    System.out.println("Press Enter key to continue...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    System.out.flush();
                    System.out.println("Please, choose type of worker:\n" +
                            "1. Manager \n" +
                            "2. Employee \n" +
                            "Or enter any value to return to the menu");
                    try {
                        String typeInput = scanner.nextLine();
                        int type = Integer.parseInt(typeInput);
                        if (type == 1) {

                            System.out.println("Input firstname: ");
                            String firstname = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Input lastname: ");
                            String lastname = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Input phone number");
                            String phone = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Input birth year: ");
                            String year = scanner.nextLine();
                            short yearOfBirth = Short.parseShort(year);
                            System.out.println("\n");
                            System.out.println("Input department number ");
                            String departmentNumber = scanner.nextLine();
                            System.out.println("\n");
                            try {
                                workerService.add(new Manager(firstname, lastname, yearOfBirth,
                                        phone.replaceAll("\\D+", ""), departmentNumber));
                            } catch (DateTimeException | StringNullOrEmptyException ex) {
                                System.out.println(ex.getMessage());
                            }
                            System.out.println("Press Enter key to continue...");
                            try {
                                System.in.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else if (type == 2) {
                            System.out.println("Input firstname: ");
                            String firstname = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Input lastname: ");
                            String lastname = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Input phone number");
                            String phone = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Input birth year: ");
                            String year = scanner.nextLine();
                            short yearOfBirth = Short.parseShort(year);
                            System.out.println("\n");
                            System.out.println("Input manager ");
                            String manager = scanner.nextLine();
                            System.out.println("\n");
                            try {
                                workerService.add(new Employee(firstname, lastname, yearOfBirth,
                                        phone.replaceAll("\\D+", ""), manager));
                            } catch (DateTimeException | StringNullOrEmptyException ex) {
                                System.out.println(ex.getMessage());
                            }
                            System.out.println("Press Enter key to continue...");
                            try {
                                System.in.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the number of the worker to be deleted: \n");
                    String typeInput = scanner.nextLine();
                    try {
                        int indexWorker = Integer.parseInt(typeInput);
                        workerService.remove(indexWorker);
                        System.out.println("Press Enter key to continue...");
                        System.in.read();
                        break;
                    } catch (NumberFormatException e) {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case 4: {
                    System.out.println("Please, enter phone number: \n");
                    String phone = scanner.nextLine();
                    String onlyDigitPhone = phone.replaceAll("\\D+", "");
                    if (workerService.findByPhone(onlyDigitPhone) != null) {
                        System.out.println(workerService.findByPhone(onlyDigitPhone));
                    }
                    System.out.println("Press Enter key to continue...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5: {
                    System.out.println("Please, enter firstname: \n");
                    String firstname = scanner.nextLine();
                    System.out.println(workerService.findByFirstname(firstname));
                    System.out.println("Press Enter key to continue...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    System.out.println("Please, enter lastname: \n");
                    String lastname = scanner.nextLine();
                    System.out.println(workerService.findByLastname(lastname));
                    System.out.println("Press Enter key to continue...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 7: {
                    System.out.println("Sorted by lastname: \n");
                    System.out.println(workerService.sortByLastname());
                    System.out.println("Press Enter key to continue...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 8: {
                    System.out.println("Sorted by year: \n");
                    System.out.println(workerService.sortByYear());
                    System.out.println("Press Enter key to continue...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 0: {
                    key = 0;
                    break;
                }
                default: {
                    System.out.println("Try again");
                }
            }
        } while (key != 0);
    }
}
