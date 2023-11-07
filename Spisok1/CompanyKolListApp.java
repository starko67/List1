package Spisok1;

// Класс, описывающий элемент "Компания"
class KCompany {
    String name;

    KCompany(String name) {
        this.name = name;
    }

    // Функция для вывода элемента (узла) на экран
    public void display() {
        System.out.println("Компания: " + name);
    }
}

// Класс "Узел" для односвязного списка
class Node {
    KCompany company;  // Данные компании
    Node next;        // Ссылка на следующий узел

    Node(KCompany company) {
        this.company = company;
        this.next = null;  // Изначально узел не связан с другими
    }
}

// Класс "Список компаний" с односвязным кольцевым списком
class KCompanyList {
    private Node head;  // Головной узел списка

    KCompanyList() {
        head = null;  // Изначально список пуст
    }

    // Функция добавления компании в список
    public void addCompany(String name) {
        KCompany company = new KCompany(name);
        Node newNode = new Node(company);

        if (head == null) {
            // Если список пуст, создаем первый узел
            head = newNode;
            head.next = head;  // Ссылка на себя, создавая кольцевой список
        } else {
            // Если список не пуст, добавляем узел в конец
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;// связываем хвост с головой, создавая кольцевую структура
        }
        System.out.println("Компания добавлена в список.");
    }

    // Функция вывода компании по индексу
    public void displayCompany(int index) {
        if (head == null) {
            System.out.println("Список пуст.");
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.company.display();
    }

    // Функция удаления компании по индексу
    public void removeCompany(int index) {
        if (head == null) {
            System.out.println("Список пуст.");
            return;
        }

        if (index == 0) {
            // Удаление первой компании
            if (head.next == head) {
                head = null;  // Если список содержит только одну компанию, очищаем его
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                head = head.next;
                current.next = head;// связываем хвост с головой, создавая кольцевую структура
            }
            System.out.println("Компания удалена из списка.");
        } else {
            // Удаление компании с индексом больше 0
            Node current = head;
            Node prev = null;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            System.out.println("Компания удалена из списка.");
        }
    }

    // Функция проверки списка на пустоту
    public boolean isEmpty() {
        return head == null;
    }
}

public class CompanyKolListApp {
    public static void main(String[] args) {
        KCompanyList companyList = new KCompanyList();

        // Пример использования функций
        companyList.addCompany("Company A");
        companyList.addCompany("Company B");
        companyList.addCompany("Company C");

        companyList.displayCompany(0);  // Вывод первой компании
        companyList.removeCompany(1);   // Удаление второй компании

        // Проверка на пустоту
        if (companyList.isEmpty()) {
            System.out.println("Список компаний пуст.");
        } else {
            System.out.println("Список компаний не пуст.");
        }
    }
}
