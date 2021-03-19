package lesson4;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class MainCinema {

    public static void main(String[] args) {

        // для приведения формата Instant к фомату даты из БД
        final DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        // Эта штука нужна для вычисления интервалов времени Duration
        Instant time;

        List<Instant> times = new ArrayList<>(); // лист времен начала фильма в виде Instant
        List<Long> list = new ArrayList<>(); // вспомогательный лист
        List<Long> durationsBetweenSessions = new ArrayList<>(); // лист интервалов между сеансами в минутах

        ServiceCinema.connect();

        List<String> dataTime = ServiceCinema.getTimeFromSchedule(); //получаем время начала фильмов в виде строки
        for (String s : dataTime
        ) {
            time = Instant.from(formatter.parse(s)); // формируем лист в виде Instant, избавляемся от даты
            times.add(time);
        }

        //высчитываем интервалы между сеансами
        for (int i = 0; i < times.size() - 1; i++) {
            durationsBetweenSessions.add(Duration.between(times.get(i), times.get(i + 1)).toMinutes());
            System.out.println(durationsBetweenSessions.get(i));
        }

        //получаем длительность фильма в минутах
        List<Integer> dataLenght = ServiceCinema.getFilmLengthFromSchedule();
        for (int s : dataLenght
        ) {
            System.out.println(s);

        }

        int delta;

        for (int i = 0; i < durationsBetweenSessions.size(); i++) {
            delta = (int) (durationsBetweenSessions.get(i) - dataLenght.get(i));
            if (delta < 0) {
                list.add((long) delta);
                System.out.println(delta);
            }

        }

        ServiceCinema.disconnect();
    }
}
