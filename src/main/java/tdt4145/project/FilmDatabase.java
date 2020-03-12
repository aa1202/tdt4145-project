package tdt4145.project;

import tdt4145.project.Entities.Bruker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
                    List<List<String>> query = new ArrayList<>();
                    List<String> movie= new ArrayList<>();
                    List<String> directors = new ArrayList<>();
                    List<String> writers = new ArrayList<>();
                    List<String> actors = new ArrayList<>();

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

                    q.insertNewMovie(query);
                    break;
                case 4:
                    System.out.println("Hvilken media-type vil du anmelde? (Film, serie, sessong, episode)");
                    answer = stringScanner.nextLine();
                    ArrayList<String> items = new ArrayList<>();

                    if (answer.toLowerCase().equals("film") || answer.toLowerCase().equals("episode")) {
                        System.out.println("Hva er navnet?");
                        items.add(stringScanner.nextLine());
                        System.out.println("Anmeldelse: ");
                        items.add(stringScanner.nextLine());
                    } else if (answer.toLowerCase().equals("sessong")) {
                        System.out.println("Hvilken serie?");
                        items.add(stringScanner.nextLine());
                        System.out.println("Hvilken sessong?");
                        items.add(stringScanner.nextLine());
                        System.out.println("Anmeldelse: ");
                        items.add(stringScanner.nextLine());
                    } else if (answer.toLowerCase().equals("serie")) {
                        System.out.println("Hvilken serie vil du anmelde?");
                        items.add(stringScanner.nextLine());
                        System.out.println("Anmeldelse: ");
                        items.add(stringScanner.nextLine());
                    } else {
                        System.out.println("Ugyldig valg");
                    }
                    System.out.println(items);
                    System.out.println(" ");
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

        fd.welcomeMsg();
        fd.userInteraction(q);
        // Queries=
        // q.fetchMoviesForPerson("Ola Halvorsen");
        // q.fetchTopCompaniesByGenres();
    }
}
