public class Die {
    private int currentResult;

    public Die() { }

    public void roll() {
        currentResult = (int)(Math.random() * 6) + 1;
    }

    public int getCurrentResult() {
        return currentResult;
    }

}
