package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String description;
    private Singer singer;
    private String songWriter;
    private int year;
    private boolean songStatus;
    private Date dateCreated;

    public Song() {
        dateCreated = new Date();
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void inputData(Scanner scanner) {

        do {
            System.out.print("Enter song name: ");
            songName = scanner.nextLine();
        } while (songName.isEmpty());

        do {
            System.out.print("Enter song description: ");
            description = scanner.nextLine();
        } while (description.isEmpty());

        do {
            System.out.print("Enter song writer: ");
            songWriter = scanner.nextLine();
        } while (songWriter.isEmpty());

        do {
            System.out.print("Enter song year: ");
            year = Integer.parseInt(scanner.nextLine());
        } while (year < 0);

        do {
            System.out.print("Enter song status (true/false): ");
            String songStatusText = scanner.nextLine();
            if (songStatusText.matches("true|false")) {
                songStatus = Boolean.parseBoolean(songStatusText);
                break;
            }
        } while (true);

        this.setDateCreated(new Date());
    }

    public void displayData() {
        System.out.println("Song id: " + songId);
        System.out.println("Song name: " + songName);
        System.out.println("Song description: " + description);
        System.out.println("Singer: " + singer.getSingerName());
        System.out.println("Song writer: " + songWriter);
        System.out.println("Song year: " + year);
        System.out.println("Song status: " + songStatus);
        System.out.println("Date created: " + dateCreated);
    }
}
