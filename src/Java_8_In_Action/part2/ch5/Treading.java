package Java_8_In_Action.part2.ch5;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Treading {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //=========================================================================


        // 1 Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> transactionsIn2011 =
                transactions
                        .stream()
                        .filter(t -> t.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());

        System.out.println("All the transactions from 2011 sorted by value from small to high: ");
        transactionsIn2011.forEach(System.out::println);





    }

}
