import model.Casts;
import model.Movie;
import service.FileService;

import java.util.*;

public class Main {

    private static final String NEW_LINE = "%n";
    private static final List<Movie> MOVIES = new ArrayList<>();

    public static void main(String[] args) {
        FileService fileService = new FileService();
        MOVIES.addAll(fileService.readFile());
        MOVIES.forEach(System.out::println);
        printMenu();
        userInterface();
    }

    public static void printMenu() {
        StringBuilder sb = new StringBuilder("You need to choose one of version: ");
        sb.append(NEW_LINE);
        sb.append("1 -> show all of the movie").append(NEW_LINE);
        sb.append("2 -> search the movie").append(NEW_LINE);
        sb.append("3 -> sort the movies").append(NEW_LINE);
        sb.append("4 -> watch the actors").append(NEW_LINE);
        print(sb.toString());
    }

    public static void userInterface() {
        int choice = Integer.parseInt(userAnswer());
        switch (choice) {
            case 1:
                MOVIES.forEach(System.out::println);
                break;
            case 2:
                List<Movie> list = searchMovie(askName());
                list.forEach(System.out::println);
            case 3:
                sortCriteria();
                break;
            case 4:
                getRole();
                break;
            default:
                print("Enter correctly");
        }
    }

    public static String askName() {
        print("Enter name of the movie");
        String name = userAnswer();
        return name;
    }

    public static void sortCriteria() {
        sortMenu();
        print("You need to choose how to sort: ");
        int choice = Integer.parseInt(userAnswer());
        Comparator cmp = null;
        switch (choice) {
            case 1:
                cmp = Comparator.comparing(Movie::getYear);
                break;
            case 2:
                cmp = Comparator.comparing(Movie::getName);
                break;
            case 3:
                cmp = Comparator.comparing(Movie::getDescription);
                break;
        }
        List<Movie> list = new ArrayList<>(MOVIES);
        list.sort(cmp);
        list.forEach(e -> print(e.toString()));
    }

    public static void sortMenu() {
        StringBuilder sb = new StringBuilder().append(NEW_LINE);
        sb.append("1 -> by years").append(NEW_LINE);
        sb.append("2 -> by name").append(NEW_LINE);
        sb.append("1 -> by director").append(NEW_LINE);
        print(sb.toString());
    }

    public static List<Movie> searchMovie(String str) {
        List<Movie> movies = new ArrayList<>();
        for (var movie : MOVIES) {
            if (movie.getName().toLowerCase().startsWith(str.toLowerCase())) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public static void getRole() {
        Map<Casts, Set<Movie>> map = new HashMap<>();
        Set<Casts> casts = new HashSet<>();
        MOVIES.forEach(e -> casts.addAll(e.getCast()));
        casts.forEach(e -> map.put(e, new HashSet<>()));

        MOVIES.forEach(e -> e.getCast().forEach(c -> map.get(c).add(e)));
        map.forEach((k,v) -> print("\n" + k.getFullName() + ": " + v));
    }

    public static String userAnswer() {
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }

    public static void print(String message) {
        System.out.printf(message);
    }
}
