import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String crds;
        String[] crdArgs;
        int crd1;
        int crd2;
        final int length = 3;
        int count = 0;
        String point = "";
        String[][] field = new String[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                field[i][j] = " ";
            }
        }

        System.out.println("---------");
        for (int i = 0; i < length; i++) {
            System.out.print("| ");
            for (int j = 0; j < length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        int breaker = 0;
        while (breaker < 9) {
            System.out.print("Enter the coordinates: ");
            crds = scanner.nextLine();
            crdArgs = crds.split(" ");
            if (isNumeric(crdArgs[0]) == false && isNumeric(crdArgs[1]) == false) {
                System.out.println("You should enter numbers!");
                continue;
            }
            crd1 = Integer.parseInt(crdArgs[0]);
            crd2 = Integer.parseInt(crdArgs[1]);

            if (crd1 <= 0 || crd1 >= 4 || crd2 <= 0 || crd2 >= 4) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (field[crd1 - 1][crd2 - 1].equals("X") || field[crd1 - 1][crd2 - 1].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            count++;
            if (count % 2 == 0) {
                point = "O";
            } else if (count % 2 != 0) {
                point = "X";
            }
            field[crd1 - 1][crd2 - 1] = point;
            System.out.println("---------");
            for (int i = 0; i < length; i++) {
                System.out.print("| ");
                for (int j = 0; j < length; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            if (isWinnerO(field).equals("O")) {
                System.out.println("O wins");
                break;
            } else if (isWinnerX(field).equals("X")) {
                System.out.println("X wins");
                break;
            }
            breaker++;
        }
        if (breaker == 9 && isWinnerX(field).equals("") && isWinnerO(field).equals("")) {
            System.out.println("Draw");
        }
    }
    public static boolean isNumeric(String crds) {
        try {
            Integer.parseInt(crds);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String isWinnerO(String[][] str) {
        String winner = "";
        if (str[0][0].equals("O") && str[0][1].equals("O") && str[0][2].equals("O")) {
            winner = "O";
        } else if (str[1][0].equals("O") && str[1][1].equals("O") && str[1][2].equals("O")) {
            winner = "O";
        } else if (str[2][0].equals("O") && str[2][1].equals("O") && str[2][2].equals("O")) {
            winner = "O";
        } else if (str[0][0].equals("O") && str[1][1].equals("O") && str[2][2].equals("O")) {
            winner = "O";
        } else if (str[2][0].equals("O") && str[2][1].equals("O") && str[0][2].equals("O")) {
            winner = "O";
        } else if (str[0][0].equals("O") && str[1][0].equals("O") && str[2][0].equals("O")) {
            winner = "O";
        } else if (str[0][1].equals("O") && str[1][1].equals("O") && str[2][1].equals("O")) {
            winner = "O";
        } else if (str[0][2].equals("O") && str[1][2].equals("O") && str[2][2].equals("O")) {
            winner = "O";
        }
        return winner;
    }

    public static String isWinnerX(String[][] str) {
        String winner = "";
        if (str[0][0].equals("X") && str[0][1].equals("X") && str[0][2].equals("X")) {
            winner = "X";
        } else if (str[1][0].equals("X") && str[1][1].equals("X") && str[1][2].equals("X")) {
            winner = "X";
        } else if (str[2][0].equals("X") && str[2][1].equals("X") && str[2][2].equals("X")) {
            winner = "X";
        } else if (str[0][0].equals("X") && str[1][1].equals("X") && str[2][2].equals("X")) {
            winner = "X";
        } else if (str[2][0].equals("X") && str[2][1].equals("X") && str[0][2].equals("X")) {
            winner = "X";
        } else if (str[0][0].equals("X") && str[1][0].equals("X") && str[2][0].equals("X")) {
            winner = "X";
        } else if (str[0][1].equals("X") && str[1][1].equals("X") && str[2][1].equals("X")) {
            winner = "X";
        } else if (str[0][2].equals("X") && str[1][2].equals("X") && str[2][2].equals("X")) {
            winner = "X";
        }
        return winner;
    }
}

