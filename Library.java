import java.util.ArrayList;
import java.util.Scanner;

/**
 * To Do all the Operations related to Books such as add, check-in, check-out,available books
 */
@SuppressWarnings("resource")
public class Library{

    static class Book {

        public String bookName;
        public String authorName;
    
        public Book(String bookName, String author){
            this.bookName = bookName;
            this.authorName =author;
        }
    }
    

    static ArrayList<Book> theBooks = new ArrayList<>();
    
    public static boolean compareBookName(String b1,String b2){
        if(b1.equalsIgnoreCase(b2)){
            return true;
        }
        return false;
    }

    public static boolean isAvailable(String bookName){
        for(int i=0;i<theBooks.size();i++){
            if(theBooks.get(i).bookName.equalsIgnoreCase(bookName)){
                System.out.println(bookName+" available in library");
                return true;
            }
        }

        System.out.println("Book is currently not available");
        return false;
    }

    public static void searchBook(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book Name:");
        String bookName = input.nextLine();

        for(int i=0;i<theBooks.size();i++){
            if(compareBookName(bookName, theBooks.get(i).bookName)){
                System.out.println("Book Found");
                System.out.println("Book name: "+theBooks.get(i).bookName);
                System.out.println("Book Author: "+theBooks.get(i).authorName);
                System.out.println("**********************************************************************");
                System.out.println();
                return;
            }
        }
        System.out.println("Book not found");
        System.out.println("**********************************************************************");
        System.out.println();
    }

    public static void showAllBooks(){
        if(theBooks.size()==0){
            System.out.println("No books found");
            System.out.println("**********************************************************************");
            System.out.println();
            return;
        }

        System.out.println("Name\t\t\t\t\tAuthor");
        for(int i=0;i<theBooks.size();i++){
            System.out.println(theBooks.get(i).bookName+ "\t\t\t\t"+theBooks.get(i).authorName);
        }
        System.out.println("**********************************************************************");
        System.out.println();
    }
    
    public static void displayMenu(){

        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Submit Book.");
        System.out.println("Press 2 to Search a Book.");
        System.out.println("Press 3 to Show All Books.");
        System.out.println("Press 4 to Get Book.");
        System.out.println();
    }

    public static void getBook(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the book you want to issue: ");
        String bookName=input.nextLine();

        if(!isAvailable(bookName)){
            System.out.println("Book does not exists currently");
            System.out.println("**********************************************************************");
            System.out.println();
            return;
        }

        for(int i=0;i<theBooks.size();i++){
            if(bookName.equalsIgnoreCase(theBooks.get(i).bookName)){
                System.out.println("Book issued successfully");
                System.out.println("**********************************************************************");
                System.out.println();
                theBooks.remove(i);

            }
        }
    }

    public static void submitBook(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the book you want to submit: ");
        String bookName=input.nextLine();

        if(isAvailable(bookName)==true){
            System.out.println("Book already exists");
            System.out.println("**********************************************************************");
            System.out.println();
            return;
        }

        System.out.print("Enter the name of author of the book: ");
        String authorName=input.nextLine();

        theBooks.add(new Book(bookName,authorName));
        System.out.println("Book submited successfully");
        System.out.println("**********************************************************************");
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating object of Scanner class to take input from user
        Scanner input = new Scanner(System.in);

        //Adding some books before initializing library
        theBooks.add(new Book("Atomic Habits", "James Clear"));
        theBooks.add(new Book("War and Peace", "Leo Tolstoy"));
        theBooks.add(new Book("Time Machine", "H.G Wells"));
        theBooks.add(new Book("Mein Kamph", "Adolf Hitler"));
        theBooks.add(new Book("Politics", "Aristotle"));
        theBooks.add(new Book("Gathering Storm", "Winston Churchill"));

        // Displaying menu
        System.out.println();
        System.out.println("********************Welcome to the Library!********************");
        System.out.println("                  Select From The Following Options:               ");
        System.out.println("**********************************************************************");

        int choice;

        do {
            displayMenu();
            System.out.print("Select your option:");
            choice = input.nextInt();
            System.out.println();
 
            // Switch case
            switch (choice) {
 
                // Case
            case 1:
                submitBook();
                break;
 
            // Case
            case 2:
                searchBook();
                break;
 
                // Case
            case 3:
                showAllBooks();
                break;
 
                // Case
            
            case 4:
                getBook();
                break;
 
                // Case
            
                // Default case that will execute if above cases does not match
            default:
                // Print statement
                if(choice==0){
                    System.out.println();
                    System.out.println("Exited from library application");
                }
                else{
                    System.out.println();
                    System.out.println("ENTER BETWEEN 0 TO 4.");
                    System.out.println();
                }
            }
        }
        // Checking condition at last where we are checking whether to exit or not
        while (choice != 0);
    }
}