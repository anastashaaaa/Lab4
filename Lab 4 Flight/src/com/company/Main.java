package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args)
    {
        System.out.println("Оберіть тип подорожі:\n1 - Пакетна\n2 - Екскурсійна\n3 - Чартерна");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                Packet_trip trip = new Packet_trip();
                trip.menu();
                break;
            case 2:
                Excursion_trip trip1 = new Excursion_trip();
                trip1.menu();
            case 3:
                Charter_trip trip2 = new Charter_trip();
                trip2.menu();
        }
    }
}
