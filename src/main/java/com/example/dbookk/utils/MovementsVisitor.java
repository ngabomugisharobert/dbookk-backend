package com.example.dbookk.utils;

import com.example.dbookk.entity.Movement;
import com.example.dbookk.entity.Movements;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MovementsVisitor {

    //    function to return a list of one specific visitor from a list of many movement done by visitors
    public static List<Movement> getVisitorMovements(List<Movement> movement, String visitor_id) {
        List<Movement> visitorMovement = new ArrayList<>();
        for (Movement movment : movement) {
            if (movment.getVisitor_id().equals(visitor_id)) {
                visitorMovement.add(movment);
            }
        }
        return visitorMovement;
    }

    //   function to sort a list of movement by mv_time
    public static List<Movement> sortMovementByTime(List<Movement> movement) {
        List<Movement> sortedMovement = new ArrayList<>();
        for (int i = 0; i < movement.size(); i++) {
            for (int j = 0; j < movement.size(); j++) {
                if (movement.get(i).getMv_time().compareTo(movement.get(j).getMv_time()) < 0) {
                    Movement temp = movement.get(i);
                    movement.set(i, movement.get(j));
                    movement.set(j, temp);
                }
            }
        }
        return movement;
    }

//        from the list of movements, calculate the duration between check in and check out starting with the first check-in in the sorted list and return a list of movements with the duration
    public static List<Movements> calculateDuration(List<Movement> movement) {
        List<Movements> movementWithDuration = new ArrayList<>();
        for (int i = 0; i < movement.size(); i++) {

//            check if the first movement is a check-out
            if (i==0 && movement.get(0).getMovementType().equals("check-out")) {
                Movements movements = new Movements(movement.get(i).getVisitor_id(),"", movement.get(i).getMv_time(), "0", movement.get(i).getVis_name(), "", 1);
                movementWithDuration.add(movements);
                continue;
            }

//            check id two movements are either both check-in or both check-out
            if (movement.get(i).getMovementType().equals(movement.get(i + 1).getMovementType())) {

//                check if those two movements are check-in
                if (movement.get(i).getMovementType().equals("check-in")) {
                    Movements movements = new Movements(movement.get(i).getVisitor_id(), movement.get(i).getMv_time(), "", "0", movement.get(i).getVis_name(), "", 1);
                    movementWithDuration.add(movements);
                }
                else if (movement.get(i).getMovementType().equals("check-out")) {
                    Movements movements = new Movements(movement.get(i).getVisitor_id(), "", movement.get(i+1).getMv_time(), "0", movement.get(i).getVis_name(), "", 1);
                    movementWithDuration.add(movements);
                }

            } else if (movement.get(i).getMovementType().equals("check-in")) {
//                check if the next movement is a check-out
                if (movement.get(i + 1).getMovementType().equals("check-out")) {

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime chInMovementTime = LocalDateTime.parse(movement.get(i).getMv_time(), formatter);
                    LocalDate check_in_movementDate = chInMovementTime.toLocalDate();
                    LocalDateTime chOutMovementTime = LocalDateTime.parse(movement.get(i + 1).getMv_time(), formatter);
                    LocalDate check_out_movementDate = chOutMovementTime.toLocalDate();

//                    check if the check-in and check-out are on the same day
                    if (check_in_movementDate.equals(check_out_movementDate)) {
//                        calculate the duration between the two movements
                        long duration = Duration.between(chInMovementTime, chOutMovementTime).toHours();
                        Movements movements = new Movements(movement.get(i).getVisitor_id(), movement.get(i).getMv_time(),movement.get(i+1).getMv_time(), String.valueOf(duration), movement.get(i + 1).getVis_name(), "day", 0);
                        movementWithDuration.add(movements);
                    } else {
//                        if the check-in and check-out are not on the same day, calculate the duration between the check-in and the end of the day
                        LocalDateTime endOfDay = LocalDateTime.of(check_in_movementDate, LocalTime.MAX);
                        long duration = Duration.between(chInMovementTime, endOfDay).toHours();
                        Movements movements = new Movements(movement.get(i).getVisitor_id(), movement.get(i).getMv_time(),movement.get(i+1).getMv_time(), String.valueOf(duration), movement.get(i + 1).getVis_name(), "night", 0);
                        movementWithDuration.add(movements);
                    }

                }
            }
//            stop the loop is i+1 is the last element of the list
            if (i + 1 == movement.size() - 1) {
                break;
            }
        }
        return movementWithDuration;
    }
}


