package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Arrays;
import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicManagement musicManagement = new MusicManagement();
        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            byte choice;
            System.out.println("Chose options: ");
            System.out.println("1. Singer management");
            System.out.println("2. Song management");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    musicManagement.singerManagement(scanner);
                    break;
                case 2:
                    musicManagement.songManagement(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using our service");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }


    }

    Singer[] singers = new Singer[0];
    Song[] songs = new Song[0];

    public void addSingers(Scanner scanner) {
        System.out.println("Enter number of added singers: ");
        int n;
        while (true) {
            n = Integer.parseInt(scanner.nextLine());
            if (n > 0) {
                break;
            } else {
                System.out.println("Number of added singers must be greater than 0");
            }
        }

        Singer[] newSingers = new Singer[singers.length + n];
        for (int i = 0; i < singers.length; i++) {
            newSingers[i] = singers[i];
        }

        for (int i = singers.length; i < newSingers.length; i++) {
            System.out.println("Enter singer " + (i + 1) + " information: ");
            newSingers[i] = new Singer();
            newSingers[i].setSingerId(i + 1);
            newSingers[i].inputData(scanner);
        }

        singers = newSingers;
        System.out.println(n + " singers added successfully");
    }

    public void displayAllSingers() {
        System.out.println("Singer information");
        for (Singer singer : singers) {
            singer.displayData();
        }
    }

    public void updateBySingerId(Scanner scanner) {
        System.out.println("Enter singer id to update: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                singer.inputData(scanner);
                break;
            }
        }
    }

    public void deleteBySingerId(Scanner scanner) {
        System.out.println("Enter singer id to delete: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        for (Song song : songs) {
            if (song.getSinger().getSingerId() == singerId) {
                System.out.println("This singer has songs, cannot delete");
                return;
            }
        }
        Singer[] newSingers = new Singer[singers.length - 1];
        int j = 0;
        for (Singer singer : singers) {
            if (singer.getSingerId() != singerId) {
                newSingers[j] = singer;
                j++;
            }
        }
        singers = newSingers;
    }

    public void addSongs(Scanner scanner) {
        if (singers.length == 0) {
            System.out.println("Please add singer first");
            return;
        }
        System.out.println("Enter number of added songs: ");
        int n;
        while (true) {
            n = Integer.parseInt(scanner.nextLine());
            if (n > 0) {
                break;
            } else {
                System.out.println("Number of added songs must be greater than 0");
            }
        }

        Song[] newSongs = new Song[songs.length + n];
        for (int i = 0; i < songs.length; i++) {
            newSongs[i] = songs[i];
        }

        for (int i = songs.length; i < newSongs.length; i++) {
            System.out.println("Enter song " + (i + 1) + " information: ");
            Song newSong = new Song();
            String songId;
            while (true) {
                do {
                    System.out.print("Enter song id: ");
                    songId = scanner.nextLine();
                } while (songId.length() != 4 || !songId.matches("S\\d{3}"));

                boolean isExist = false;
                for (Song song : newSongs) {
                    if (song != null && song.getSongId().equals(songId)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    newSong.setSongId(songId);
                    break;
                } else {
                    System.out.println("Song id already exists");
                }
            }
            newSong.inputData(scanner);
            System.out.println("Singer list: ");
            for (Singer singer : singers) {
                System.out.println(singer.getSingerId() + ". " + singer.getSingerName());
            }
            ;
            while (true) {
                System.out.println("Enter singer id: ");
                int singerId = Integer.parseInt(scanner.nextLine());
                boolean isExist = false;
                for (Singer singer : singers) {
                    if (singer.getSingerId() == singerId) {
                        newSong.setSinger(singer);
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    break;
                } else {
                    System.out.println("Singer id does not exist");
                }
            }
            newSongs[i] = newSong;
            System.out.println("Song added successfully");
        }

        songs = newSongs;
        System.out.println(n + " songs added successfully");
    }

    public void display10LatestSongs() {
        System.out.println("10 latest songs");
        Song[] sortedSongs = songs.clone();
        Arrays.sort(sortedSongs, (song1, song2) -> song2.getDateCreated().compareTo(song1.getDateCreated()));
        for (Song sortedSong : sortedSongs) {
            if (sortedSong != null) {
                sortedSong.displayData();
                System.out.println("-".repeat(50));
            }
        }
    }

    public void updateBySongId(Scanner scanner) {
        System.out.println("Enter song id to update: ");
        String songId = scanner.nextLine();
        for (Song song : songs) {
            if (song.getSongId().equals(songId)) {
                song.inputData(scanner);
                System.out.println("Singer list: ");
                for (Singer singer : singers) {
                    System.out.println(singer.getSingerId() + ". " + singer.getSingerName());
                }
                ;
                while (true) {
                    System.out.println("Enter singer id: ");
                    int singerId = Integer.parseInt(scanner.nextLine());
                    boolean isExist = false;
                    for (Singer singer : singers) {
                        if (singer.getSingerId() == singerId) {
                            song.setSinger(singer);
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        break;
                    } else {
                        System.out.println("Singer id does not exist");
                    }
                }
                System.out.println("Song updated successfully");
                break;
            }
        }
    }

    public void deleteBySongId(Scanner scanner) {
        System.out.println("Enter song id to delete: ");
        String songId = scanner.nextLine();
        Song[] newSongs = new Song[songs.length - 1];
        int j = 0;
        for (Song song : songs) {
            if (!song.getSongId().equals(songId)) {
                newSongs[j] = song;
                j++;
            }
        }
        songs = newSongs;
    }

    public void singerManagement(Scanner scanner) {
        while (true) {
            System.out.println("************************SINGER-MANAGEMENT*************************");
            byte choice;
            System.out.println("Chose options: ");
            System.out.println("1. Add singers");
            System.out.println("2. Display all singers");
            System.out.println("3. Update singer by id");
            System.out.println("4. Delete singer by id");
            System.out.println("5. Back");
            System.out.println("Enter your choice: ");
            choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    addSingers(scanner);
                    break;
                case 2:
                    displayAllSingers();
                    break;
                case 3:
                    updateBySingerId(scanner);
                    break;
                case 4:
                    deleteBySingerId(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void songManagement(Scanner scanner) {
        while (true) {
            System.out.println("************************SONG-MANAGEMENT*************************");
            byte choice;
            System.out.println("Chose options: ");
            System.out.println("1. Add songs");
            System.out.println("2. Display 10 latest songs");
            System.out.println("3. Update song by id");
            System.out.println("4. Delete song by id");
            System.out.println("5. Back");
            System.out.println("Enter your choice: ");
            choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    addSongs(scanner);
                    break;
                case 2:
                    display10LatestSongs();
                    break;
                case 3:
                    updateBySongId(scanner);
                    break;
                case 4:
                    deleteBySongId(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}