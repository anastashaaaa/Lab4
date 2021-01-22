package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Charter_trip extends Ticket{
    private String [] cities = new String[20];
    private int price;

    public void menu()
    {
        print_countries();
        System.out.println("Оберіть країну для подорожі:");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        setCountry(country);
        print_cities();
        System.out.println("Оберіть місто:");
        Scanner city_scan = new Scanner(System.in);
        int city = city_scan.nextInt();
        setCity(cities[city-1]);
        System.out.println("Кількість людей - ");
        scanner = new Scanner(System.in);
        setPeople_amount(scanner.nextInt());
        System.out.println("Введіть дату подорожі (за зарзком 20.02.2021)");
        scanner = new Scanner(System.in);
        setDate(scanner.nextLine());
        if(country.equals("Egypt"))
        {
            price += (120 * getPeople_amount());
        }
        if(country.equals("France"))
        {
            price+=150* getPeople_amount();
        }
        if(country.equals("Arab Emirates"))
        {
            price+=390* getPeople_amount();
        }
        if(country.equals("Turkey"))
        {
            price+=170* getPeople_amount();
        }
        print_ticket();
    }
    private void print_ticket ()
    {
        System.out.println(" ---------------------- Ваш Білет -----------------------\n ________________________________________________________\n | Дата вильоту - " + getDate() + "\t | \tКількість людей - " + getPeople_amount() + "\n | Країна - " + getCountry()
                + "\t | \tМісто - " + getCity() + "\n | Загальна сума вашого відпочинку - \t" + price + "$\n ________________________________________________________");
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
    private void print_cities()
    {
        String fileName = "D://Lab 4 Flight//Countries//" + getCountry() + "//cities_list.txt";
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
}
