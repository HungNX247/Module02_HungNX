package excercise;

public class TennisGame {
    public static String getScore(String firstNamePlayer, String secondNamePlayer, int firstPlayerScore,
            int secondPlayerScore) {

        if (firstPlayerScore == secondPlayerScore) {
            return getEqualScoreDescription(firstPlayerScore);
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            return getAdvantageOrWinDescription(firstPlayerScore, secondPlayerScore, firstNamePlayer, secondNamePlayer);
        } else {
            return getNormalScoreDescription(firstPlayerScore, secondPlayerScore);
        }
    }

    private static String getNormalScoreDescription(int firstPlayerScore, int secondPlayerScore) {
        String scoreDescription = "";
        int currentPlayerScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1)
                currentPlayerScore = firstPlayerScore;
            else {
                scoreDescription += "-";
                currentPlayerScore = secondPlayerScore;
            }
            switch (currentPlayerScore) {
                case 0:
                    scoreDescription += "Love";
                    break;
                case 1:
                    scoreDescription += "Fifteen";
                    break;
                case 2:
                    scoreDescription += "Thirty";
                    break;
                case 3:
                    scoreDescription += "Forty";
                    break;
            }
        }
        return scoreDescription;
    }

    private static String getAdvantageOrWinDescription(int firstPlayerScore, int secondPlayerScore,
            String firstNamePlayer,
            String secondNamePlayer) {
        String score;
        int scoreDifference = firstPlayerScore - secondPlayerScore;
        if (scoreDifference == 1)
            score = "Advantage " + firstNamePlayer;
        else if (scoreDifference == -1)
            score = "Advantage " + secondNamePlayer;
        else if (scoreDifference >= 2)
            score = "Win for " + firstNamePlayer;
        else
            score = "Win for " + secondNamePlayer;
        return score;
    }

    private static String getEqualScoreDescription(int score) {
        switch (score) {
            case 0:
                return "Love-All";

            case 1:
                return "Fifteen-All";

            case 2:
                return "Thirty-All";

            case 3:
                return "Forty-All";

            default:
                return "Deuce";

        }
    }
}