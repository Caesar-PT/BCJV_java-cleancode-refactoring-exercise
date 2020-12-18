public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN_SCORE = 1;
    public static final int THIRTY_SCORE = 2;
    public static final int FORTY_SCORE = 3;
    public static final int DEUCE_SCORE = 4;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore = LOVE;
        if (player1Score == player2Score)
        {
            score = getScore(player1Score);
        }
        else if (player1Score>= DEUCE_SCORE || player2Score>= DEUCE_SCORE)
        {
            int minusResult = getMinusResult(player1Score, player2Score);
            if (minusResult== FIFTEEN_SCORE) score ="Advantage player1";
            else if (minusResult ==-FIFTEEN_SCORE) score ="Advantage player2";
            else if (minusResult>= THIRTY_SCORE) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            score = getScore(player1Score, player2Score, score);
        }
        return score;
    }

    public static String getScore(int player1Score, int player2Score, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==FIFTEEN_SCORE) tempScore = player1Score;
            else { score +="-"; tempScore = player2Score;}
            switch(tempScore)
            {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN_SCORE:
                    score +="Fifteen";
                    break;
                case THIRTY_SCORE:
                    score +="Thirty";
                    break;
                case FORTY_SCORE:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    public static String getScore(int player1Score) {
        String score;
        switch (player1Score)
        {
            case LOVE:
                score = "Love-All";
                break;
            case FIFTEEN_SCORE:
                score = "Fifteen-All";
                break;
            case THIRTY_SCORE:
                score = "Thirty-All";
                break;
            case FORTY_SCORE:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    public static int getMinusResult(int player1Score, int player2Score) {
        return player1Score - player2Score;
    }
}
