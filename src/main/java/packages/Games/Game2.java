package packages.Games;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static packages.Services.ScannerService.scanInt;

public class Game2 {

    public static List<Integer> pickedLottoNumbers(){
        System.out.println("pick 6 numbers from range 1-49");

        ArrayList<Integer> tab = new ArrayList<>();
        int number;
        for (int i = 0; i < 6; i++) {

            number = scanInt("pick " + (i + 1) + " number (numbers can't be repeated)","this is not a number");

            if ( !tab.contains(number) && number >= 1 && number <= 49){
                tab.add(number);
            }
            else{
                i--;
            }
        }
        tab.sort(Integer::compareTo);
        return tab;
    }
    public static List<Integer> rolledLottoNumbers(){
        Random rand = new Random();
        ArrayList<Integer> lotto = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int roll = rand.nextInt(49) + 1;

            if (!lotto.contains(roll)){
                lotto.add(roll);
            }
            else{
                i--;
            }
        }
        lotto.sort(Integer::compareTo);
        return lotto;
    }
    public static void lottoComparison(){
        List<Integer> lotto = rolledLottoNumbers();
        List<Integer> tab = pickedLottoNumbers();
        System.out.println("lotto numbers " + lotto);
        System.out.println("given numbers "  +tab);
        lotto.retainAll(tab);
        System.out.println("you scored  " + lotto.size() + " times");
        if(lotto.size()==3){
            System.out.println("You scored 3 numbers !");
        }
        if(lotto.size()==4){
            System.out.println("You scored 4 numbers !");
        }
        if(lotto.size()==5){
            System.out.println("you scored 5 numbers !");
        }
        if(lotto.size()==6){
            System.out.println("WOW YOU SCORED 6 NUMBERS !!!!!!!");
        }
        else{
            System.out.println("Not this time.... you didn't even score 3 points !");
        }
    }
}






//    Symulator LOTTO
//    Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu od 1 do 49.
//        Zadaniem gracza jest poprawne wytypowanie losowanych liczb. Nagradzane jest trafienie 3, 4, 5 lub 6
//        poprawnych liczb.
//        Napisz program, który:
//        zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
//        czy wprowadzony ciąg znaków jest poprawną liczbą,
//        czy użytkownik nie wpisał tej liczby już poprzednio,
//        czy liczba należy do zakresu 1-49,
//        po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
//        wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
//        poinformuje gracza, czy trafił przynajmniej "trójkę"
