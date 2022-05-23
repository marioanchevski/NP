package aud02;

public class CombinationLock {
    private int combination;
    private boolean isOpen;
    private static int DEFAULT_COMBINATION = 123;


    public CombinationLock(int combination) {
        if (isCombinationValid(combination))
            this.combination = combination;
        else
            this.combination = DEFAULT_COMBINATION;
        isOpen = false;
    }

    private boolean isCombinationValid(int combination) {
        return combination >= 100 && combination <= 999;
    }

    public boolean unlock(int combination) {
        this.isOpen = (this.combination == combination);
        return this.isOpen;
    }

    public boolean changeCombination(int oldCombination, int newCombination) {
        if (unlock(oldCombination) && isCombinationValid(newCombination)) {
            this.combination = newCombination;
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void lock() {
        this.isOpen = false;
    }

    public static void main(String[] args) {
        CombinationLock validLock = new CombinationLock(234);

        System.out.println("TEST IS OPEN");
        System.out.println(validLock.isOpen());

        System.out.println("TEST OPEN");
        System.out.println(validLock.unlock(233));
        System.out.println(validLock.unlock(236));
        System.out.println(validLock.unlock(234));

        validLock.lock();

        System.out.println("TEST CHANGE COMBINATION");
        System.out.println(validLock.changeCombination(234, 777));
        System.out.println(validLock.unlock(777));

        CombinationLock invalidLock = new CombinationLock(234567);

        System.out.println("TEST IS OPEN");
        System.out.println(invalidLock.isOpen());

        System.out.println("TEST OPEN");
        System.out.println(invalidLock.unlock(103));
        System.out.println(invalidLock.unlock(236));
        System.out.println(invalidLock.unlock(100));

        invalidLock.lock();

        System.out.println("TEST CHANGE COMBINATION");
        System.out.println(invalidLock.changeCombination(100, 900));
        System.out.println(invalidLock.unlock(900));
    }
}
