package hakerrank.sort;

public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 1, 1, 1};
        int leap = 4;
        System.out.println(game(arr, leap) ? "YES" : "NO");
    }

    private static boolean game(int[] game, int leap) {
        if (isArgumentsOutOfRange(game, leap)) {
            throw new IllegalArgumentException("Arguments are out of range.");
        }

        for (int i = 0; i < game.length - 1; i++) {
            if (isItWinAfterLeap(game, leap, i)) {
                return true;
            }
            if (isItPossibleToLeap(game, leap, i)) {
                i = i + leap - 1;
                continue;
            }
            if (isItPossibleToStepForward(game, i)) {
                continue;
            }
            if (i - 1 > 1) {
                if (isItPossibleToStepBack(game, i)) {
                    i = i - 2;
                    continue;
                }
                return false;
            }
            return false;
        }

        return false;
    }

    private static boolean isArgumentsOutOfRange(int[] game, int leap) {
        return !(game.length >= 2 && game.length <= 100 && leap >= 0 && leap <= 100);
    }

    //TODO: проверить, можно ли прыгать
    private static boolean isItPossibleToLeap(int[] game, int leap, int currentPositionInArray) {
        return game[leap + currentPositionInArray] == 0;
    }

    //TODO: проверить, можно ли шагнуть вперёд
    private static boolean isItPossibleToStepForward(int[] game, int currentPositionInArray) {
        return game[currentPositionInArray + 1] == 0;
    }

    //TODO: проверить, можно ли шагнуть назад
    private static boolean isItPossibleToStepBack(int[] game, int currentPositionInArray) {
        return game[currentPositionInArray - 1] == 0;
    }

    //TODO: проверить, что значение массива после прыжка = самый конец и ноль или выход за границы массива
    private static boolean isItWinAfterLeap(int[] game, int leap, int currentPositionInArray) {
        return isLastArrayElementEqualsZero(game, currentPositionInArray + leap) ||
                isOutOfArrayBoundAfterLeap(game, currentPositionInArray + leap);
    }


    //TODO: проверить, что указатель встал на последний элемент массива и он =0
    private static boolean isLastArrayElementEqualsZero(int[] game, int positionForCheck) {
        return positionForCheck == game.length - 1 && game[positionForCheck] == 0;
    }

    //TODO: проверить, что после прыжка произошёл выход за границы массива
    private static boolean isOutOfArrayBoundAfterLeap(int[] game, int positionForCheck) {
        return positionForCheck >= game.length;
    }

}
