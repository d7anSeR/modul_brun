package com.kuspanova.hard2;

import java.util.*;

public class MainBlackJack {
    /**
     * Создать игру BlackJack.
     * Цель игры — набрать 21 очко или близкую к этому сумму.
     * Если игрок набирает сумму очков, превышающую 21, то его ставка проигрывает, а дилер (компьютер) — выигрывает.
     * Подсказка: создать 36 карт Card. Каждая карта имеет свой вес.
     * Дама, валет, король — это 10, туз —11 или 1. Нужно создать класс CardDesk,
     * в котором будет поле Card[] — массив размером 36, и случайным образом положить туда
     * все 36 карт (это можно сделать в конструкторе).
     * Игроку и дилеру случайно выпадают по 2 карты,
     * после чего игроку предлагается взять ещё карту, либо сбросить.
     * Если игрок решается сбросить карты, то они сравниваются с картами дилера.
     * Чья суммарная комбинация карт будет ближе к 21, тот и победи
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = {
                "туз", "туз", "туз", "туз",
                "валет", "валет", "валет", "валет",
                "дама", "дама", "дама", "дама",
                "король", "король", "король", "король",
                "6", "6", "6", "6",
                "7", "7", "7", "7",
                "8", "8", "8", "8",
                "9", "9", "9", "9",
                "10", "10", "10", "10"};
        Random rnd = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            String temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        CardDesk cardDesk = new CardDesk(numbers);
        List<String> cardsPerson = new ArrayList<>();
        ;
        cardsPerson.add(cardDesk.getCard());
        cardsPerson.add(cardDesk.getCard());
        List<String> cardsComputer = new ArrayList<>();
        ;
        cardsComputer.add(cardDesk.getCard());
        cardsComputer.add(cardDesk.getCard());
        System.out.println("---Карты разданы---");
        boolean flag = true;
        while (flag) {
            System.out.println("-------------------");
            System.out.println("Выберите:");
            System.out.println("1. Взять еще карту");
            System.out.println("2. Сбросить карты");
            System.out.print("Ваш выбор: ");
            int changePerson = scan.nextInt();
            switch (changePerson) {
                case 1:
                    cardsPerson.add(cardDesk.getCard());
                    break;
                case 2:
                    int sumCardPerson = cardDesk.sumCards(cardsPerson);
                    int sumCardComputer = cardDesk.sumCards(cardsComputer);
                    int closestToNumber = cardDesk.closestToNumber(sumCardPerson, sumCardComputer);
                    if (closestToNumber == sumCardPerson)
                        System.out.println("Выиграл игрок!!! Его карты [" + cardsPerson.toString() + "] = " + sumCardPerson + " ближе к 21");
                    else {
                        System.out.println("Выиграл дилер!!! Его карты [" + cardsComputer.toString() + "] = " + sumCardComputer + " ближе к 21");
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("Такого пункта нет! Попробуйте еще раз!!!");
            }
        }
    }
}
