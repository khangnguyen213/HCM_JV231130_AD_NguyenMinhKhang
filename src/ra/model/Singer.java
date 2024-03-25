package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData(Scanner scanner) {
        do {
            System.out.print("Enter singer name: ");
            singerName = scanner.nextLine();
        } while (singerName.isEmpty());

        do {
            System.out.print("Enter age: ");
            age = Integer.parseInt(scanner.nextLine());
        } while (age < 0);

        do {
            System.out.println("Enter nationality: ");
            nationality = scanner.nextLine();
        } while (nationality.isEmpty());

        do {
            System.out.println("Enter gender: ");
            String genderText = scanner.nextLine();
            if (genderText.matches("true|false")) {
                gender = Boolean.parseBoolean(genderText);
                break;
            }
        } while (true);

        do {
            System.out.println("Enter genre: ");
            genre = scanner.nextLine();
        } while (genre.isEmpty());
    }

    public void displayData() {
        System.out.println("=====================================");
        System.out.println("Singer information");
        System.out.println("Singer ID: " + singerId);
        System.out.println("Singer name: " + singerName);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
        System.out.println("Genre: " + genre);
        String genderText = gender? "female": "male";
        System.out.println("Gender: " + genderText);
        System.out.println("=====================================");
    }
}
