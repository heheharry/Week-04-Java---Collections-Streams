package Day5.FeaturesProblemStatements;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return title + " " + rating;
    }
}

public class BookRecommendations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book1", "Author1", "Science Fiction", 4.5),
                new Book("Book2", "Author2", "Science Fiction", 4.2),
                new Book("Book3", "Author3", "Romance", 4.7),
                new Book("Book4", "Author4", "Science Fiction", 4.8),
                new Book("Book5", "Author5", "Science Fiction", 3.9),
                new Book("Book6", "Author6", "Science Fiction", 4.1),
                new Book("Book7", "Author7", "Science Fiction", 4.6),
                new Book("Book8", "Author8", "Science Fiction", 4.9),
                new Book("Book9", "Author9", "Science Fiction", 4.3),
                new Book("Book10", "Author10", "Science Fiction", 4.4),
                new Book("Book11", "Author11", "Science Fiction", 4.0),
                new Book("Book12", "Author12", "Science Fiction", 4.7)
        );

        List<BookRecommendation> topBooks = books.stream()
                .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                .map(b -> new BookRecommendation(b.title, b.rating))
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                .limit(10)
                .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < topBooks.size(); i += 5) {
            pages.add(topBooks.subList(i, Math.min(i + 5, topBooks.size())));
        }

        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1) + ": " + pages.get(i));
        }
    }
}
