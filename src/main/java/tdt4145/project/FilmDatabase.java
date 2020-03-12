package tdt4145.project;

import tdt4145.project.Entities.Bruker;

import java.util.Scanner;

public class FilmDatabase {
    public void welcomeMsg() {
        System.out.println("***************************");
        System.out.println("Velkommen til filmdatabasen");
        System.out.println("***************************");
        printInfo();
    }

    public void printInfo() {
        System.out.println("0: Finn navnet på alle rollene til skuespiller.");
        System.out.println("1: Finn filmene til angitt skuespiller.");
        System.out.println("2: Finne hvilke filmselskaper som lager flest filmer innen hver sjanger.");
        System.out.println("3: Sette inn ny film med regissør, manusforfatter(e), skuespiller(e) etc.");
        System.out.println("4: Skrive inn en ny anmeldelse.");
        System.out.println("5: Printer info på nytt.");
        System.out.println(" ");
    }

    public void userInteraction(Queries q) {
        boolean condition;
        do {
            Scanner scanner = new Scanner(System.in);
            Scanner stringScanner = new Scanner(System.in);
            condition = true;
            System.out.println("Velg et tall fra 0-5: ");
            System.out.println("----------------------------");
            switch (scanner.nextInt()) {
                case 0:
                    System.out.println("Skriv inn navnet på skuespiller: ");
                    String answer = stringScanner.nextLine();
                    System.out.println(" ");
                    q.fetchRolesForPerson(answer);
                    break;
                case 1:
                    System.out.println("Valgte 1");
                    break;
                case 2:
                    System.out.println("Valgte 2");
                    break;
                case 3:
                    System.out.println("Valgte 3");
                    break;
                case 4:
                    System.out.println("Valgte 4");
                    break;
                case 5:
                    printInfo();
                    break;
                default:
                    condition = false;
                    break;
            }
        }
        while (condition);
    }
    public static void main(String[] args) {
        FilmDatabase fd = new FilmDatabase();
        Queries q = new Queries();
        q.connect();

        // d.welcomeMsg();
        // fd.userInteraction(q);
        // Queries
        // q.fetchMoviesForPerson("Ola Halvorsen");
        q.fetchTopCompaniesByGenres();
    }
}
