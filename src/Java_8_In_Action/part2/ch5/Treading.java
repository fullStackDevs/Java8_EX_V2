package Java_8_In_Action.part2.ch5;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

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

        List<Transaction> transactionsFrom2011 =
                transactions.stream()
                            .filter(t -> t.getYear() == 2011)
                            .sorted(comparing(Transaction::getValue))
                            .collect(toList());

        System.out.println(" 1) All transactions from 2011 sorted by value ascending: ");
        transactionsFrom2011.forEach(System.out::println);

        //=========================================================================

        // 2 What are all the unique cities where the traders work?

        System.out.println("-----------------------------------------------------");

        List<String> citiesWithTraders =
                transactions.stream()
                            .map(Transaction::getTrader)
                            .map(Trader::getCity)
                            .distinct()
                            .collect(toList());

        System.out.println(" 2) All the unique cities where treaders work: ");
        citiesWithTraders.forEach(System.out::println);


        //SOME MORE EFFICIENT SOLUTIONS OF THE PROBLEM:

        //This versions does 2 mapping steps in in map operation: from transaction to trader and from trader to city
        List<String> cities =
                transactions.stream()
                            .map(transaction -> transaction.getTrader().getCity())
                            .distinct()
                            .collect(toList());


        //***###***
        //you could also drop distinct() and use toSet() instead,
        //which would convert the stream into a set

        Set<String> cities_v2 =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());


//---------------------------------------------------------------------------------------

        // ORDER OF THE OPERATIONS CHANGED THE BEHAVIOUR:

//        List<String> citiesWithTraders =
//                transactions.stream()
//                            .map(Transaction::getTrader)
//                            //Changing the order of the following 2 operations changes the result because if we would do put the 'distinct' first
//                                    //.distinct()
//                                    //.map(Trader::getCity)
//                            //we would get all the distinct brokers but multiple brokers live in the same city so we would get duplicated cities in the response
//                            .map(Trader::getCity)
//                            .distinct()
//                            .collect(toList());

        //=========================================================================

        // 3 Find all traders from Cambridge and sort them by name.

        System.out.println("-----------------------------------------------------");

        List<Trader> tradersFromCambridge =
                transactions.stream()
                            .map(Transaction::getTrader)
                            .distinct()
                            .filter(t -> t.getCity() == "Cambridge")
                            .collect(toList());

        System.out.println(" 3) All traders from Cambridge: ");
        tradersFromCambridge.forEach(System.out::println);

        //=========================================================================

        // 4 Return a string of all traders’ names sorted alphabetically.

        System.out.println("-----------------------------------------------------");

        String traderNames =
                transactions.stream()
                            .map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                            .reduce("", (s1, s2) -> s1 + s2);

        System.out.println(" 4) String that contains all traders' names: " + traderNames);


        //***###***
        //The method "sorted()" doesn't need a Comparator parameter if we only want to sort by natural order


        //*#* Note that this solution isn’t very efficient (all Strings are repeatedly concatenated,
        // which creates a new String object at each iteration).
        //A more efficient solution  uses joining()

        String traderStr =
                transactions.stream()
                            .map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                            .collect(joining());

        System.out.println(" 4) String that contains all traders' names --- processing done using joining(): " + traderStr);


//-----------------------------------------------------------------------------------------------------

        //THE BELOW IMPLEMENTATION CAN BE SIMPLIFIED AS WE CAN SEE ABOVE

//        String traderStr =
//                transactions.stream()
//                            .map(Transaction::getTrader)
//                            .distinct()
//                            .sorted(comparing(Trader::getName))
//                            .map(Trader::getName)
//                            .reduce("", (s1, s2) -> s1 + s2);
//
//        System.out.println("A string that contains all the tradors' names: ");
//        System.out.println(traderStr);

        //---------------------------------------------------------------------------------------


        // THE BELOW CODE COLLECTS THE NAMES IN A LIST. THEY SHOULD BE COLLECTED IN A CONCATENATED STRING

//        List<String> allTradersNames =
//                transactions.stream()
//                            .map(Transaction::getTrader)
//                            .distinct()
//                            .sorted(comparing(Trader::getName))
//                            .map(Trader::getName)
//                            .collect(toList());
//
//        System.out.println("All the traders names sorted alphabetically: ");
//        allTradersNames.forEach(System.out::println);

        //========================================================================

        // 5 Are any traders based in Milan?

        System.out.println("-----------------------------------------------------");

        boolean areTradersInMilan =
                transactions.stream()
                            .anyMatch(transaction -> transaction.getTrader()
                                                                .getCity()
                                                                .equalsIgnoreCase("Milan"));

        System.out.println(" 5) Are there any traders in Milan? ");
        System.out.println(areTradersInMilan);

        //========================================================================

        // 6 Print all transactions’ values from the traders living in Cambridge.

        System.out.println("-----------------------------------------------------");

        List<Integer> transactionsFromTradersInCambridge =
                transactions.stream()
                            .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                            .map(Transaction::getValue)
                            .collect(toList());

        System.out.println(" 6) All transactions' values from the traders living in Cambridge: ");
        transactionsFromTradersInCambridge.forEach(System.out::println);



        //#*# --- WE COULD WRITE THE ABOVE CODE A LITTLE MORE CONCISE
        // In this version of the code we don't collect the values in a list anymore. We just use the forEach method to process
        // the values from the stream with a consumer that prints the values in the console
        System.out.println();
        System.out.println(" 6) Code more concise and optimised --- All transactions' values from the traders living in Cambridge: ");

        transactions.stream()
                    .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);

        //========================================================================

        // 7 What’s the highest value of all the transactions?

        System.out.println("-----------------------------------------------------");

        Optional<Integer> maxTransactionValue =
                transactions.stream()
                            .map(transaction -> transaction.getValue())
                            .reduce(Integer::max);

        System.out.println(" 7) The highest value of all the transactions: ");
        maxTransactionValue.ifPresent(System.out::println);


        //#*# --- BELOW A MORE CONCISE VERSION OF THE CODE:

        System.out.println();
        System.out.println(" 7) Code written more concise --- The highest value of all the transactions: ");

        transactions.stream()
                    .map(transaction -> transaction.getValue())
                    .reduce(Integer::max)
                    .ifPresent(System.out::println);


        //#*# --- THE CODE CAN BE IMPROVED EVEN FURTHER:
        // Stream has a method "max" that takes a comparator that specifies which key to use whe calculating the minimum or maximum

        transactions.stream()
                    .max(comparing(Transaction::getValue))
                    .ifPresent(System.out::println);

        //========================================================================

        // 8 Find the transaction with the smallest value.

        System.out.println("-----------------------------------------------------");
        System.out.println(" 8) Transaction with smallest value: ");

        transactions.stream()
                    .reduce((t1, t2) -> t1.getValue() < t2.getValue()? t1 : t2)
                    .ifPresent(System.out::println);


        //#*# --- THE CODE CAN BE WRITTEN MORE CONCISE:
        // Using the method "min" from Stream

        System.out.println();
        System.out.println(" 8) Code more concise --- Transactio with the smallest value: ");
        transactions.stream()
                    .min(comparing(Transaction::getValue))
                    .ifPresent(System.out::println);













        //===============================================================================================================
        //===============================================================================================================
        //===============================================================================================================

        //THE BELOW PROCESSING IS DONE ON THE WRONG SOURCE OF DATA
        //THE INTEROGATION SHOULD BE DONE ON TRANSACTIONS NOT ON A LIST OF TRADERS

/*
        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        // 1 Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> transactionsIn2011 =
                transactions
                        .stream()
                        .filter(t -> t.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());

        System.out.println("All the transactions from 2011 sorted by value from small to high: ");
        transactionsIn2011.forEach(System.out::println);

        //==========================================================================
        // 2 What are all the unique cities where the traders work?

        System.out.println();

        List<String> citiesWithTraders =
                traders.stream()
                       .map(Trader::getCity)
                       .distinct()
                       .collect(toList());

        System.out.println("All the unique cities where traders work are: ");
        citiesWithTraders.forEach(System.out::println);


        //==========================================================================
        // 3 Find all traders from Cambridge and sort them by name.

        System.out.println();

        List<Trader> tradersFromCambridge =
                traders.stream()
                       .filter(t -> t.getCity() == "Cambridge")
                       .sorted(comparing(Trader::getName))
                       .collect(toList());

        System.out.println("All traders from Cambirdge sorted by name: ");
        tradersFromCambridge.forEach(System.out::println);


        //==========================================================================
        // 4 Return a string of all traders’ names sorted alphabetically.

        System.out.println();

        List<String> tradersNames =
                traders.stream()
                .map(Trader::getName)
                .collect(toList());

        System.out.println("All traders names: ");
        tradersNames.forEach(System.out::println);

*/
        //===============================================================================================================
        //===============================================================================================================
        //===============================================================================================================



    }

}
