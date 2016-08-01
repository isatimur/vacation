package ru.atc.communication;

import java.time.LocalDate;
import java.time.Period;

public class ATCCompanySendWishes {
    private LocalDate currentDate;

    enum Looks {
        AWFUL("не очень"), USUALL("как обычно"), EXCELLENT("отлично");
        private String name;

        Looks(String name) {
            this.name = name;
        }
    }

    // input params 2016-07-29 2016-08-18 EXCELLENT 2016-08-01
    public static void main(String[] args) {

        LocalDate vacationStarts = LocalDate.parse(args[0]);
        LocalDate vacationEnds = LocalDate.parse(args[1]);
        Looks look = Looks.valueOf(args[2]);
        LocalDate releaseDate = LocalDate.parse(args[3]);

        Vacation vacation = new Vacation(vacationStarts, vacationEnds);
        //wish you look awesome during your vacation
        System.out.println("Друзья, желаем вам выглядеть " + look.name);

        vacation.receiveSpam();

        if (vacation.isDateDuringVacation(releaseDate)) {
            System.out.println(" а во время релизов");
            System.out.println(
                " ....::::::::::;;...    .....;;:::::::::::::....  \\#\\#\\###\n" +
                    "|  .------------.  ``  `` .------------.      ___  \\#\\####\n" +
                    "|   /   .` `.    \\        /    .` `.   \\      /     \\  \\####\n" +
                    "|  |      @ |                    @ |    |     |   &   \\  ###\n" +
                    "|   \\ _ `- -`  -             - `- -` _ /      \\   !&  ) ####\n" +
                    "|         ~~~~   ^          ~~~~               /  ,   / ####\n" +
                    " |              /`\\  |                         \\ _   / ####\n" +
                    "  \\             \\_/ /            ^                     ####\n" +
                    "   |              /          \\  /`\\                    ####\n" +
                    "    |        ^   |              \\_/                   |\n" +
                    "     |      /`\\   \\   _    _  /                       |\n" +
                    "______|     \\_/                                       /_____\n" +
                    "       |                                             . \\\n" +
                    "      .                                              /  |\n" +
                    "       .             \\..-------..//                 |  | \n" +
                    "        \\                -----                     .` |\n" +
                    "        \\                                        /   |\n" +
                    "         \\                                     .`   |\n" +
                    "           -                                 ./    .\n" +
                    "            ` - _                       _ . `___. ` \n" +
                    "                  ` ----------------- `              "
            );

            System.out.println("только о счастья!");
        }

    }
}

class Vacation {
    private LocalDate startVacaton;
    private LocalDate endVacaton;
    private Period duration;

    public Vacation(LocalDate startVacaton, LocalDate endVacaton) {
        this.startVacaton = startVacaton;
        this.endVacaton = endVacaton;
        this.duration = Period.between(startVacaton, endVacaton);
    }

    public boolean isDateDuringVacation(LocalDate now) {
        return now.isAfter(startVacaton) && now.isBefore(endVacaton);
    }

    public void receiveSpam() {
        LocalDate now = LocalDate.now();
        if (isDateDuringVacation(now)) {
            System.out.println("и в отпуске получать только спам,");
        }
    }
}