package hakerrank.sort;

public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1};
        System.out.println(isItWinAfterLeap(arr, 2, 0) ? "YES" : "NO");
    }

    //TODO: проверить, можно ли прыгать
    private static boolean isItPossibleToLeap(int[] game, int positionForCheck) {
        return game[positionForCheck] == 0;
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
