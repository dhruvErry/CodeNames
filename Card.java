class Card{
    String word;
    char camp;
    Card(String x){
        word=x;
    }
    Card (String y, char z){
        word=y;
        camp=z;
    }    
    void setWord(String input){
        word=input;
    }
    String getWord(){
        return word;
    }
    void setCamp(char in){
        camp=in;
    }
    char getCamp(){
        return camp;
    }
}
