package Spisok1;
import java.util.ArrayList;

// Класс, описывающий элемент "Компания"
class Company {
    String name;

    Company(String name) {
        this.name = name;
    }

    public Company() {

    }

    // Функция для вывода элемента (узла) на экран
    public void display() {
        System.out.println("Компания: " + name);
    }
}

// Контейнерный класс "Список" (Компания)
class CompanyList {
    private ArrayList<Company> list;

    public CompanyList() {
        // Функция создания пустого списка
        list = new ArrayList<>();
    }

    // Функция добавления элемента (узла) в список
    public void addCompany(String name) {
        Company company = new Company(name);
        list.add(company);
        System.out.println("Компания добавлена в список.");
    }

    // Функция удаления элемента из списка
    public void removeCompany(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            System.out.println("Компания удалена из списка.");
        } else {
            System.out.println("Неверный индекс компании.");
        }
    }

    // Функция вывода элемента (узла) списка на экран
    public void displayCompany(int index) {
        if (index >= 0 && index < list.size()) {
            list.get(index).display();
        } else {
            System.out.println("Неверный индекс компании.");
        }
    }

    // Функция очистки списка
    public void clearList() {
        list.clear();
        System.out.println("Список очищен.");
    }

    // Функция проверки списка на пустоту
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class CompanyListApp {
    public static void main(String[] args) {
        CompanyList companyList = new CompanyList();

        // Пример использования функций
        companyList.addCompany("Company A");
        companyList.addCompany("Company B");
        companyList.addCompany("Company C");

        companyList.displayCompany(0); // Вывод первой компании
        companyList.removeCompany(1);  // Удаление второй компании

        // Проверка на пустоту
        if (companyList.isEmpty()) {
            System.out.println("Список компаний пуст.");
        } else {
            System.out.println("Список компаний не пуст.");
        }
    }
} 
