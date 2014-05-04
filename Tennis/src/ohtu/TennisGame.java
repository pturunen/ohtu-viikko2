package ohtu;

public class TennisGame {
    
    private int player1points = 0;
    private int player2points = 0;
    private int gamePoints = 4;
    private int plusOne = 1;
    private int minusOne = -1;
    private int plusTwo = 2;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1points += 1;
        else
            player2points += 1;
    }

    private String getNamedScorePoints(int playerPoints){
        String score = "";
        switch (playerPoints){
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;
            }
        
        return score;
    }
    
    private String getAdvantageOrWinner(){
        String score = "";
        int minusResult = player1points-player2points;
        if (minusResult==plusOne){
            score ="Advantage player1";
        }
        else if (minusResult ==minusOne){
            score ="Advantage player2";
        }
        else if (minusResult>=plusTwo){
            score = "Win for player1";
        }
        else {
            score ="Win for player2";
        }
        return score;
    }
    
    private boolean evenSituation(){
        return (player1points==player2points);
    }
    
    private boolean gameSituation(){
        return (player1points>=gamePoints || player2points>=gamePoints);
    }
    
    private String getBasicPoints(String score,int points){
        switch (points){
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
                }
        return score;
    }
    
    public String getScore() {
        String score = "";
        if (evenSituation()){
            score = getNamedScorePoints(player1points);
        }
        else if (gameSituation()){
            score = getAdvantageOrWinner();
        }
        else{
            score = getBasicPoints(score ,player1points);
            score+="-"; 
            score = getBasicPoints(score ,player2points);
        }
        return score;
    }
}