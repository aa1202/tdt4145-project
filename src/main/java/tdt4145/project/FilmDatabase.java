package tdt4145.project;

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
        System.out.println("1: Finn navnet på alle rollene til skuespiller.");
        System.out.println("2: Finn filmene til angitt skuespiller.");
        System.out.println("3: Finne hvilke filmselskaper som lager flest filmer innen hver sjanger.");
        System.out.println("4: Sette inn ny film med regissør, manusforfatter(e), skuespiller(e) etc.");
        System.out.println("5: Skrive inn en ny anmeldelse.");
        System.out.println("6: Printer info på nytt.");
        System.out.println("Alle andre tall quitter.");
        System.out.println(" ");
    }

    public void userInteraction(Queries q) {
        boolean condition;
        do {
            String answer;
            Scanner scanner = new Scanner(System.in);
            Scanner stringScanner = new Scanner(System.in);
            condition = true;
            System.out.println("Velg et tall fra 1-6: ");
            System.out.println("----------------------------");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Skriv inn navnet på skuespiller: ");
                    answer = stringScanner.nextLine();

                    System.out.println();
                    q.fetchRolesForPerson(answer);
                    break;
                case 2:
                    System.out.println("Skriv inn navnet på skuespiller: ");
                    answer = stringScanner.nextLine();

                    System.out.println();
                    q.fetchMoviesForPerson(answer);
                    break;
                case 3:
                    System.out.println(" ");
                    q.fetchTopCompaniesByGenres();
                    break;
                case 4:
                    List<String[]> query = new ArrayList<>();

                    System.out.println("Navn på film, utgivelsesår, lanseringsdato, beskrivelse, lengde, selskap: ");
                    String[] movieInfo = stringScanner.nextLine().trim().split("\\s*,\\s*");

                    if(movieInfo.length != 6) {
                        System.out.println("Oppgi info slik: Navn på film, utgivelsesår, lanseringsdato, beskrivelse, lengde, selskap");
                        break;
                    }
                    query.add(movieInfo);
                    System.out.println();

                    System.out.println("Navn på regissører (skilt med komma): ");
                    String[] directors = stringScanner.nextLine().trim().split("\\s*,\\s*");

                    if (directors.length <= 0) {
                        System.out.println("Oppi minst en regissør.");
                        break;
                    }
                    query.add(directors);
                    System.out.println();

                    System.out.println("Navn på manusforfatter(e): ");
                    String[] writers = stringScanner.nextLine().trim().split("\\s*,\\s*");

                    if (writers.length <= 0) {
                        System.out.println("Oppi minst en manusforfatter.");
                        break;
                    }
                    query.add(writers);
                    System.out.println();

                    System.out.println("Navn på skuespiller og rolle");
                    System.out.println("Eksempel: Tom Hanks, Forrest Gump, Jim Carrey, Ace Ventura");
                    String[] actors = stringScanner.nextLine().trim().split("\\s*,\\s*");

                    if (actors.length <= 1) {
                        System.out.println("Oppgi minst en skuespiller og rollen");
                        break;
                    }

                    query.add(actors);
                    System.out.println();

                    q.insertNewMovie(query);
                    break;

                case 5:
                    ArrayList<String> items = new ArrayList<>();
                    System.out.println("Oppgi brukernavn:");
                    items.add(stringScanner.nextLine());

                    System.out.println("Hvilken media-type vil du anmelde? (Film, serie, sesong, episode)");
                    answer = stringScanner.nextLine();
                    String type = answer.toLowerCase();

                    if (type.equals("film") || type.equals("episode")) {
                        System.out.println("Hva er navnet?");
                        items.add(stringScanner.nextLine());

                    } else if (type.equals("sesong")) {
                        System.out.println("Hvilken serie?");
                        items.add(stringScanner.nextLine());

                        System.out.println("Hvilken sesong?");
                        items.add(stringScanner.nextLine());

                    } else if (type.equals("serie")) {
                        System.out.println("Hvilken serie vil du anmelde?");
                        items.add(stringScanner.nextLine());

                    } else {
                        System.out.println("Ugyldig valg");
                        break;
                    }

                    System.out.println("Rating");
                    items.add(stringScanner.nextLine());

                    System.out.println("Tekst: ");
                    items.add(stringScanner.nextLine());


                    if (type.equals("film") || type.equals("episode")) {
                        q.insertNewMediaReview(items);

                    } else if (type.equals("sesong")) {
                        q.insertNewSeasonReview(items);

                    } else if (type.equals("serie")) {
                        q.insertNewSeriesReview(items);
                    }

                    break;
                case 6:
                    printInfo();
                    break;
                default:
                    System.out.println("Exiting");
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
    }
}
