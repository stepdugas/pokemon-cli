package org.example;

import org.example.services.PokemonService;

import java.util.Scanner;


public class Main {

    private static PokemonService service = new PokemonService();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome Pokemon Trainer!");
        System.out.println("1. Get first 20");
        System.out.println("2. Get second 20");
        System.out.println("3. Get next 20");


    }
}