import java.util.Scanner;

public class ReadNumbersIntoWords {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = scanner.nextInt();
        scanner.close();
        if (number < 0 || number > 999) {
            System.out.println("Out of ability");
            return;
        }

        String result = "";

        if (number < 20) {
            switch (number) {
                case 0:
                    result = "Zero";
                    break;
                case 1:
                    result = "One";
                    break;
                case 2:
                    result = "Two";
                    break;
                case 3:
                    result = "Three";
                    break;
                case 4:
                    result = "Four";
                    break;
                case 5:
                    result = "Five";
                    break;
                case 6:
                    result = "Six";
                    break;
                case 7:
                    result = "Seven";
                    break;
                case 8:
                    result = "Eight";
                    break;
                case 9:
                    result = "Nine";
                    break;
                case 10:
                    result = "Ten";
                    break;
                case 11:
                    result = "Eleven";
                    break;
                case 12:
                    result = "Twelve";
                    break;
                case 13:
                    result = "Thirteen";
                    break;
                case 14:
                    result = "Fourteen";
                    break;
                case 15:
                    result = "Fifteen";
                    break;
                case 16:
                    result = "Sixteen";
                    break;
                case 17:
                    result = "Seventeen";
                    break;
                case 18:
                    result = "Eighteen";
                    break;
                case 19:
                    result = "Nineteen";
                    break;
            }
        } else if (number < 100) {
            int ten = number / 10;
            int one = number % 10;
            switch (ten) {
                case 2:
                    result = "Twenty";
                    break;
                case 3:
                    result = "Thirty";
                    break;
                case 4:
                    result = "Forty";
                    break;
                case 5:
                    result = "Fifty";
                    break;
                case 6:
                    result = "Sixty";
                    break;
                case 7:
                    result = "Seventy";
                    break;
                case 8:
                    result = "Eighty";
                    break;
                case 9:
                    result = "Ninety";
                    break;
            }
            if (one != 0) {
                switch (one) {
                    case 1:
                        result += "One";
                        break;
                    case 2:
                        result += "Two";
                        break;
                    case 3:
                        result += "Three";
                        break;
                    case 4:
                        result += "Four";
                        break;
                    case 5:
                        result += "Five";
                        break;
                    case 6:
                        result += "Six";
                        break;
                    case 7:
                        result += "Seven";
                        break;
                    case 8:
                        result += "Eight";
                        break;
                    case 9:
                        result += "Nine";
                        break;
                }
            }
        } else {
            int hundred = number / 100;
            int remainder = number % 100;
            switch (hundred) {
                case 1:
                    result = "One Hundred";
                    break;
                case 2:
                    result = "Two Hundred";
                    break;
                case 3:
                    result = "Three Hundred";
                    break;
                case 4:
                    result = "Four Hundred";
                    break;
                case 5:
                    result = "Five Hundred";
                    break;
                case 6:
                    result = "Six Hundred";
                    break;
                case 7:
                    result = "Seven Hundred";
                    break;
                case 8:
                    result = "Eight Hundred";
                    break;
                case 9:
                    result = "Nine Hundred";
                    break;
            }
            if (remainder != 0) {
                result += " and ";
                if (remainder < 20) {
                    switch (remainder) {
                        case 1:
                            result += "One";
                            break;
                        case 2:
                            result += "Two";
                            break;
                        case 3:
                            result += "Three";
                            break;
                        case 4:
                            result += "Four";
                            break;
                        case 5:
                            result += "Five";
                            break;
                        case 6:
                            result += "Six";
                            break;
                        case 7:
                            result += "Seven";
                            break;
                        case 8:
                            result += "Eight";
                            break;
                        case 9:
                            result += "Nine";
                            break;
                        case 10:
                            result += "Ten";
                            break;
                        case 11:
                            result += "Eleven";
                            break;
                        case 12:
                            result += "Twelve";
                            break;
                        case 13:
                            result += "Thirteen";
                            break;
                        case 14:
                            result += "Fourteen";
                            break;
                        case 15:
                            result += "Fifteen";
                            break;
                        case 16:
                            result += "Sixteen";
                            break;
                        case 17:
                            result += "Seventeen";
                            break;
                        case 18:
                            result += "Eighteen";
                            break;
                        case 19:
                            result += "Nineteen";
                            break;
                    }
                } else {
                    int tens = remainder / 10;
                    int ones = remainder % 10;
                    switch (tens) {
                        case 2:
                            result += "Twenty ";
                            break;
                        case 3:
                            result += "Thirty ";
                            break;
                        case 4:
                            result += "Forty ";
                            break;
                        case 5:
                            result += "Fifty ";
                            break;
                        case 6:
                            result += "Sixty ";
                            break;
                        case 7:
                            result += "Seventy ";
                            break;
                        case 8:
                            result += "Eighty ";
                            break;
                        case 9:
                            result += "Ninety ";
                            break;
                    }
                    if (ones != 0) {
                        switch (ones) {
                            case 1:
                                result += "One";
                                break;
                            case 2:
                                result += "Two";
                                break;
                            case 3:
                                result += "Three";
                                break;
                            case 4:
                                result += "Four";
                                break;
                            case 5:
                                result += "Five";
                                break;
                            case 6:
                                result += "Six";
                                break;
                            case 7:
                                result += "Seven";
                                break;
                            case 8:
                                result += "Eight";
                                break;
                            case 9:
                                result += "Nine";
                                break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
