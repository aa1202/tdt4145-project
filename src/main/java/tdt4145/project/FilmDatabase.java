package tdt4145.project;

import tdt4145.project.Entities.Bruker;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
            String answer;
            Scanner scanner = new Scanner(System.in);
            Scanner stringScanner = new Scanner(System.in);
            condition = true;
            System.out.println("Velg et tall fra 0-5: ");
            System.out.println("----------------------------");
            switch (scanner.nextInt()) {
                case 0:
                    System.out.println("Skriv inn navnet på skuespiller: ");
                    answer = stringScanner.nextLine();
                    System.out.println(" ");
                    q.fetchRolesForPerson(answer);
                    break;
                case 1:
                    System.out.println("Skriv inn navnet på skuespiller: ");
                    answer = stringScanner.nextLine();
                    System.out.println();
                    q.fetchMoviesForPerson(answer);
                    break;
                case 2:
                    System.out.println(" ");
                    q.fetchTopCompaniesByGenres();
                    break;
                case 3:
                    ArrayList<ArrayList<String>> query = new ArrayList<ArrayList<String>>();
                    ArrayList<String> movie= new ArrayList<>();
                    ArrayList<String> directors = new ArrayList<>();
                    ArrayList<String> writers = new ArrayList<>();
                    ArrayList<String> actors = new ArrayList<>();

                    System.out.println("Navn på film, utgivelsesår, lanseringsdato, beskrivelse, lengde, selskap: ");

                    while (stringScanner.hasNext()) {
                        answer = stringScanner.nextLine();
                        if (answer.equals("q")) {
                            break;
                        } else {
                            movie.add(answer);
                        }
                    }
                    query.add(movie);

                    System.out.println("Navn på regissør: ");
                    while (stringScanner.hasNext()) {
                        answer = stringScanner.nextLine();
                        if (answer.equals("q")) {
                            break;
                        } else {
                            directors.add(answer);
                        }
                    }
                    query.add(directors);

                    System.out.println("Navn på manusforfatter: ");
                    while (stringScanner.hasNext()) {
                        answer = stringScanner.nextLine();
                        if (answer.equals("q")) {
                            break;
                        }
                        writers.add(answer);
                    }
                    query.add(writers);

                    System.out.println("Navn på skuespiller: ");
                    while (stringScanner.hasNext()) {
                        answer = stringScanner.nextLine();
                        if (answer.equals("q")) {
                            break;
                        }
                        actors.add(answer);
                    }
                    query.add(actors);

                    System.out.println(query);
                    break;
                case 4:
                    System.out.println("Hvilken media-type vil du anmelde?");
                    answer = stringScanner.nextLine();
                    if (answer.equals("Film") || answer.equals("Episode")) {
                        System.out.println("film");
                    } else if (answer.equals("Sessong")) {
                        System.out.println("sessong");
                    } else if (answer.equals("Serie")) {
                        System.out.println("serie");
                    } else {
                        System.out.println("u suck");
                    }
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
        //q.connect();

        fd.welcomeMsg();
        fd.userInteraction(q);
        // Queries=
        // q.fetchMoviesForPerson("Ola Halvorsen");
        // q.fetchTopCompaniesByGenres();
    }
}
