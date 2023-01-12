public class Player {
    private String name;
    private int chipAmount;
    private int chipWager;
    private Die die1;
    private Die die2;
    private Die die3;
    private int die1result;
    private int die2result;
    private int die3result;
    private boolean stillInGame;
    private int playerStatus;
    private int score;

    public Player(String name) {
        this.name = name;
        chipAmount = 100;
        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
        stillInGame = true;
    }

    public void rollDice() {
        score = 0;
        boolean rollAgain = true;

        while (rollAgain) {
            die1.roll();
            die1result = die1.getCurrentResult();
            die2.roll();
            die2result = die2.getCurrentResult();
            die3.roll();
            die3result = die3.getCurrentResult();
            if ((die1result == die2result && die1result == die3result) || is456()) {
                chipAmount += chipWager;
                playerStatus = 1; //they won
                rollAgain = false;
            } else if (die1result == die2result || die2result == die3result || die1result == die3result) {
                if (die1result == die2result) {
                    score = die3result;
                } else if (die1result == die3result) {
                    score = die2result;
                } else {
                    score = die1result;
                }
                playerStatus = 2; //they got a score
                rollAgain = false;
            } else if (is123()) {
                chipAmount -= chipWager;
                playerStatus = 3; //they lost
                rollAgain = false;
            } else {
                System.out.println("Invalid roll. Roll again.");
            }
        }
    }

    public void addChips(int newAmount) {
        chipAmount += newAmount;
    }

    public void removeChips(int newAmount) {
        chipAmount -= newAmount;
    }

    public void setWager(int newWager) {
        chipWager = newWager;
    }

    public int getChipAmount() {
        return chipAmount;
    }

    public String getName() {
        return name;
    }

    public int getChipWager() {
        return chipWager;
    }

    public int getPlayerStatus() {
        return playerStatus;
    }

    public int getScore() {
        return score;
    }
    private boolean is456() {
        if (die1result == 4) {
            if (die2result == 5) {
                if (die3result == 6) {
                    return true;
                }
            } else if (die3result == 5) {
                if (die2result == 6) {
                    return true;
                }
            }
        } else if (die2result == 4) {
            if (die1result == 5) {
                if (die3result == 6) {
                    return true;
                }
            } else if (die3result == 5) {
                if (die1result == 6) {
                    return true;
                }
            }
        } else if (die3result == 4) {
            if (die1result == 5) {
                if (die2result == 6) {
                    return true;
                }
            } else if (die2result == 5) {
                if (die1result == 6) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean is123() {
        if (die1result == 1) {
            if (die2result == 2) {
                if (die3result == 3) {
                    return true;
                }
            } else if (die3result == 2) {
                if (die2result == 3) {
                    return true;
                }
            }
        } else if (die2result == 1) {
            if (die1result == 2) {
                if (die3result == 3) {
                    return true;
                }
            } else if (die3result == 2) {
                if (die1result == 3) {
                    return true;
                }
            }
        } else if (die3result == 1) {
            if (die1result == 2) {
                if (die2result == 3) {
                    return true;
                }
            } else if (die2result == 2) {
                if (die1result == 3) {
                    return true;
                }
            }
        }
        return false;
    }

}
