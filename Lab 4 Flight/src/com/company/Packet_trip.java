package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Packet_trip extends Hotel
{
    private int price;
    private Ticket ticket = new Ticket();
    private Hotel [] hotels = new Hotel[60];
    private String [] cities = new String[20];
    private int night_amount;
    public void menu()
    {
        print_countries();
        System.out.print("Оберіть країну куди ви хочете полетіти:\n");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        ticket.setCountry(country);
        System.out.println("Оберіть наступну дію: 1 - обрати Місто 2 - обрати Готель");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1)
        {
            print_cities();
            System.out.print("Введіть назву міста або його номер, або введіть 0 якщо хочете обрати готель - ");
            Scanner pickout = new Scanner(System.in);
            int check = pickout.nextInt();
            if(check == 0)
            {
                print_hotels();
                System.out.println("Введіть номер готелю, або ж його назву:");
                Scanner hotel_choice = new Scanner(System.in);
                if(hotel_choice.nextInt() <= 50 & hotel_choice.nextInt() >= 1)
                {
                    setCity(hotels[hotel_choice.nextInt()-1].getCity());
                    setHotelsName(hotels[hotel_choice.nextInt()-1].getHotelsName());
                    setPrice(hotels[hotel_choice.nextInt()-1].getPrice());
                    setAmountStars(hotels[hotel_choice.nextInt()-1].getAmountStars());
                }
                else
                {
                    String hotel  = hotel_choice.nextLine();
                    for(int i = 0; hotels[i] != null; i++)
                    {
                        if(hotel.equals(hotels[i].getHotelsName()))
                        {
                            setCity(hotels[i].getCity());
                            setHotelsName(hotels[i].getHotelsName());
                            setPrice(hotels[i].getPrice());
                            setAmountStars(hotels[i].getAmountStars());
                        }
                    }
                }
            }
            if(check <= 20 & check >= 1)
            {
                fill_hotels();
                print_local_hotels(cities[check-1]);
                System.out.println("Введіть номер готелю, або ж його назву:");
                Scanner hotel_choice = new Scanner(System.in);
                int hot_ch = hotel_choice.nextInt();
                if(hot_ch <= 50 & hot_ch >= 1)
                {
                    setCity(hotels[hot_ch-1].getCity());
                    setHotelsName(hotels[hot_ch-1].getHotelsName());
                    setPrice(hotels[hot_ch-1].getPrice());
                    setAmountStars(hotels[hot_ch-1].getAmountStars());
                }
                else
                {
                    String hotel  = hotel_choice.nextLine();
                    for(int i = 0; hotels[i] != null; i++)
                    {
                        if(hotel.equals(hotels[i].getHotelsName()))
                        {
                            setCity(hotels[i].getCity());
                            setHotelsName(hotels[i].getHotelsName());
                            setPrice(hotels[i].getPrice());
                            setAmountStars(hotels[i].getAmountStars());
                        }
                    }
                }
            }
            else
            {
                for(int i = 0; cities[i] != null; i++)
                {
                    if(cities[i].equals(pickout.nextLine()))
                    {
                        setCity(cities[i]);
                        break;
                    }
                }
                print_local_hotels(getCity());
                System.out.println("Введіть номер готелю:");
                Scanner hotel_choice = new Scanner(System.in);
                if(hotel_choice.nextInt() <= 50 & hotel_choice.nextInt() >= 1)
                {
                    setCity(hotels[hotel_choice.nextInt()-1].getCity());
                    setHotelsName(hotels[hotel_choice.nextInt()-1].getHotelsName());
                    setPrice(hotels[hotel_choice.nextInt()-1].getPrice());
                    setAmountStars(hotels[hotel_choice.nextInt()-1].getAmountStars());
                }
            }
        }

        if(choice == 2)
        {
            print_hotels();
            System.out.println("Введіть номер готелю:");
            Scanner hotel_choice = new Scanner(System.in);
            int hotel_ch = hotel_choice.nextInt();
            if(hotel_ch <= 50 & hotel_ch >= 1)
            {
                setCity(hotels[hotel_ch-1].getCity());
                setHotelsName(hotels[hotel_ch-1].getHotelsName());
                setPrice(hotels[hotel_ch-1].getPrice());
                setAmountStars(hotels[hotel_ch-1].getAmountStars());
            }
        }
        price = getPrice();
        System.out.println("Скільки людей?");
        Scanner amount_people = new Scanner(System.in);
        int people = amount_people.nextInt();
        ticket.setPeople_amount(people);
        price *= people;
        System.out.println("Скільки ночей ви проведете?");
        Scanner amount_of_nights = new Scanner(System.in);
        night_amount = amount_of_nights.nextInt();
        price = price * night_amount;
        if(country.equals("Egypt"))
        {
            price += (120 * people);
        }
        if(country.equals("France"))
        {
            price+=150* people;
        }
        if(country.equals("Arab Emirates"))
        {
            price+=390* people;
        }
        if(country.equals("Turkey"))
        {
            price+=170* people;
        }
        System.out.println("Дата вильоту (11.01.2021) - ");
        Scanner scan_date = new Scanner(System.in);
        ticket.setDate(scan_date.nextLine());
        print_ticket();
    }

    private void print_ticket ()
    {
        System.out.print(" ---------------------- Ваш Білет -----------------------\n ________________________________________________________\n | Дата вильоту - " + ticket.getDate() + "\t | \tКількість людей - " + ticket.getPeople_amount() + "\n | Країна - " + ticket.getCountry()
                + "\t | \tМісто - " + getCity() + "\n | Готель - " + getHotelsName() + "\t | \t");
        int star = 10026;
        for(int stars = 0; stars < getAmountStars(); stars++)
        {
            System.out.print((char)star);
        }
        System.out.println("\n | Загальна сума вашого відпочинку - \t" + price + "$\n ________________________________________________________");
    }
    private void print_local_hotels(String city)
    {
        for(int i = 0; hotels[i] != null; i++)
        {
            String str = hotels[i].getCity();
            str = str.replace("\n", "");
            hotels[i].setCity(str);
            if(hotels[i].getCity().equals(city))
            {
                int star = 10026;
                System.out.println("______________________________________________\n|" + (i+1) + "\t\t " + hotels[i].getHotelsName() + " \t\t ");
                System.out.println("| Country - " + ticket.getCountry() + " \t City - " + hotels[i].getCity());
                System.out.print("| \t ");
                for(int stars = 0; stars < hotels[i].getAmountStars(); stars++)
                {
                    System.out.print((char)star);
                }
                System.out.println("\t | \t Price Per night - " + hotels[i].getPrice());
                System.out.println("______________________________________________\n");
            }
        }
    }

    private void print_hotels()
    {
        if(hotels[0] == null)
            fill_hotels();
        int i = 0;
        while (hotels[i] != null)
        {
            int star = 10026;
            System.out.println("_______________________________________________\n|" + (i+1) + "\t\t " + hotels[i].getHotelsName() + " \t\t ");
            System.out.println("| Country - " + ticket.getCountry() + " \t City - " + hotels[i].getCity());
            System.out.print("| \t ");
            for(int stars = 0; stars < hotels[i].getAmountStars(); stars++)
            {
                System.out.print((char)star);
            }
            System.out.println("\t | \t Price Per night - " + hotels[i].getPrice());
            System.out.println("_______________________________________________\n");
            i++;
        }
    }

    private void fill_hotels()
    {
        String fileName = "D://Lab 4 Flight//countries//" + ticket.getCountry() + "//hotels_list.txt";
        try(FileInputStream fin = new FileInputStream(fileName)){
            int i = -1, j = 0;
            while((char)(i = fin.read())!= '_')
            {
                String hotels_name = String.valueOf((char)i);
                while((i = fin.read()) != 13)
                {
                    hotels_name += (char)i;
                }
                i = fin.read();
                String city = String.valueOf((char)i);
                while((i = fin.read()) != 13)
                {
                    if(i != 10)
                        city += (char)i;
                }
                i = fin.read();
                int amount_stars = (i = fin.read()) - 48;
                i = fin.read();
                int hotel_price = 0;
                i = fin.read();
                while((i = fin.read()) != 13)
                {
                    hotel_price *= 10;
                    hotel_price += i - 48;
                }
                hotels[j] = new Hotel();
                hotels[j].setHotelsName(hotels_name);
                hotels[j].setCity(city);
                hotels[j].setAmountStars(amount_stars);
                hotels[j].setPrice(hotel_price);
                j++;
                i = fin.read();
            }
        } catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        int i = 0;
        while (hotels[i] != null)
        {
            String str = hotels[i].getCity();
            str = str.replace("\n", "");
            hotels[i].setCity(str);
            i++;
        }
    }

    private void print_cities()
    {
        String fileName = "D://Lab 4 Flight//Countries//" + ticket.getCountry() + "//cities_list.txt";
        try(FileInputStream fin = new FileInputStream(fileName))
        {
            int i = -1,j = 0;
            while((char)(i = fin.read())!= '_'){
                cities[j] = String.valueOf((char)i);
                while ((i = fin.read())!= 13)
                {
                    cities[j] += (char)i;
                }
                i = fin.read();
                j++;
            }
            for(i = 0; cities[i] != null; i++)
            {
                System.out.println(i+1+". " + cities[i]);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    private void print_countries()
    {
        try(FileInputStream fin = new FileInputStream("D://Lab 4 Flight//countries//countries_list.txt")){
            int i=-1;
            while((char)(i = fin.read())!= '_'){
                System.out.print(((char)i));
            }
        } catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
