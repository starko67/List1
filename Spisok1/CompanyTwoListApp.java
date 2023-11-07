package Spisok1;

// Класс, описывающий элемент "Компания"
class TCompany extends Company {
    String name;

    TCompany(String name) {
        this.name = name;
    }

    // Функция для вывода элемента (узла) на экран
     public void display() {
        System.out.println("Компания: " + name);
    }
}

// Класс "CompanyList" для управления списком компаний
class TCompanyList {
    private Node head;
    private Node tail;

    public TCompanyList() {
        head = null;
        tail = null;
    }

    // Вложенный класс "Node" для представления элементов списка
    class Node {
        TCompany company;
        Node next;
        Node prev;

        Node(TCompany company) {
            this.company = company;
            this.next = null;
            this.prev = null;
        }
    }

    // Функция добавления компании в список
    public void addCompany(String name) {
        TCompany company = new TCompany(name);
        Node newNode = new Node(company);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Компания добавлена в список.");
    }

    // Функция удаления компании из списка
    public void removeCompany(int index) {
        Node currentNode = head;
        int currentIndex = 0;
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        if (currentNode != null) {
            if (currentNode == head) {
                head = currentNode.next;
            }
            if (currentNode == tail) {
                tail = currentNode.prev;
            }
            if (currentNode.prev != null) {
                currentNode.prev.next = currentNode.next;
            }
            if (currentNode.next != null) {
                currentNode.next.prev = currentNode.prev;
            }
            System.out.println("Компания удалена из списка.");
        } else {
            System.out.println("Неверный индекс компании.");
        }
    }

    // Функция вывода компании из списка
    public void displayCompany(int index) {
        Node currentNode = head;
        int currentIndex = 0;
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        if (currentNode != null) {
            currentNode.company.display();
        } else {
            System.out.println("Неверный индекс компании.");
        }
    }

    // Функция очистки списка
    public void clearList() {
        head = null;
        tail = null;
        System.out.println("Список очищен.");
    }

    // Функция проверки списка на пустоту
    public boolean isEmpty() {
        return head == null;
    }
}

public class CompanyTwoListApp {
    public static void main(String[] args) {
        TCompanyList companyList = new TCompanyList();

        // Пример использования функций
        companyList.addCompany("Company A");
        companyList.addCompany("Company B");
        companyList.addCompany("Company C");

        companyList.displayCompany(0); // Вывод первой компании
        companyList.removeCompany(1);  // Удаление второй компании
        companyList.clearList();

        // Проверка на пустоту
        if (companyList.isEmpty()) {
            System.out.println("Список компаний пуст.");
        } else {
            System.out.println("Список компаний не пуст.");
        }
    }
}
