package com.example.dbookk.utils;

import com.example.dbookk.entity.Movement;
import com.example.dbookk.entity.Movements;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MovementHelper {


    public Movement[] getuserMovements(Movement[] movements, String id) {

//        initiate an array of movements put in the movements array
        List<Movement> movementsList = List.of(movements);

//        get movement of the same id and same date
        movementsList = movementsList.stream()
                .filter(movement -> movement.getVisitor_id().equals(id))
                .collect(Collectors.toList());

        System.out.println(movementsList);

return movementsList.toArray(new Movement[0]);
    }
      public LocalDateTime getLocalTime(String time){
    String[] timeArray = time.split(" ");
            String[] dateArray = timeArray[0].split("-");
            String[] hourArray = timeArray[1].split(":");

            return LocalDateTime.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]), Integer.parseInt(hourArray[0]), Integer.parseInt(hourArray[1]));

        }
        public LocalDate getLocalDate(String time){
            String[] timeArray = time.split(" ");
            String[] dateArray = timeArray[0].split("-");
            String[] hourArray = timeArray[1].split(":");

            return LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));

        }

//        write a method to return the duration between two local times in hours by taking movement array and calculate the duration between the check-out and check-in on the same mv_time
        public List<Movements> getDuration(Movement[] movementsList){


            Map<String, List<Movement>> visitorMovementsMap = new HashMap<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            // Group movements by visitor_id
            for (Movement movement : movementsList) {
                List<Movement> movements = visitorMovementsMap.getOrDefault(movement.getVisitor_id(), new ArrayList<>());
                movements.add(movement);
                visitorMovementsMap.put(movement.getVisitor_id(), movements);
            }

            // Calculate durations for each visitor and date
            List<Movements> visitorMovementsWithDurations = new ArrayList<>();
            for (Map.Entry<String, List<Movement>> entry : visitorMovementsMap.entrySet()) {
                String visitorId = entry.getKey();
                List<Movement> movements = entry.getValue();
                Map<LocalDate, Duration> visitorDateDurations = new HashMap<>();

                for (Movement movement : movements) {
                    LocalDateTime movementTime = LocalDateTime.parse(movement.getMv_time(), formatter);
                    LocalDate movementDate = movementTime.toLocalDate();

                    if ("check-in".equals(movement.getMovementType())) {
                        visitorDateDurations.put(movementDate, Duration.ZERO);
                    } else if ("check-out".equals(movement.getMovementType())) {
                        if (visitorDateDurations.containsKey(movementDate)) {
                            Duration duration = Duration.between(LocalDateTime.of(movementDate, LocalTime.MIN), movementTime);
                            Duration totalDuration = visitorDateDurations.get(movementDate).plus(duration);
                            visitorDateDurations.put(movementDate, totalDuration);
                        }
                    }
                }

                // Create VisitorMovement objects with durations
                for (Map.Entry<LocalDate, Duration> dateDurationEntry : visitorDateDurations.entrySet()) {
                    Movements visitorMovement = new Movements(visitorId, dateDurationEntry.getKey().toString(),"","", formatDuration(dateDurationEntry.getValue()),formatDuration(dateDurationEntry.getValue()),"test", "what", 0,"","","");
                    visitorMovementsWithDurations.add(visitorMovement);
                }
            }

            return visitorMovementsWithDurations;

        }

    private static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return hours + " hours " + minutes + " minutes";
    }

            private List<String> getUniqueVisitorIds(List<Movement> movements) {
                Set<String> uniqueVisitorIds = new HashSet<>();

                // Add unique visitor ids to the set
                for (Movement movement : movements) {
                    uniqueVisitorIds.add(movement.getVisitor_id());
                }

                // Convert the set to a list and return it
                return new ArrayList<>(uniqueVisitorIds);
            }
            private List<Movement> getmovementsOfSameDate(List<Movement> movements, String date) {
                List<Movement> movementsOfSameDate = new ArrayList<>();

                // Add unique visitor ids to the set
                for (Movement movement : movements) {
                    if(getLocalDate(movement.getMv_time()).equals(getLocalDate(date))){
                        movementsOfSameDate.add(movement);
                    }
                }

                // Convert the set to a list and return it
                return movementsOfSameDate;
            }
}
