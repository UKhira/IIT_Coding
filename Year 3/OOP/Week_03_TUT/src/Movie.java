public class Movie {
    String title;
    String category;
    int numAward;
    Director director;

    public Movie(String title, String category, Director director){
        this.title = title;
        this.category = category;
        this.director = director;
    }

    public String getTitie(){
        return title;
    }

    public String getCategory(){
        return category;
    }

    public Director getDirector(){
        return director;
    }

    public void setNumAward(int numAward){
        this.numAward = numAward;
    }

    public int getNumAwards(){
        return numAward;
    }

    public String toString(){
        return(String.format("Movie [ title = %s, category = %s, director name = %s, director surname = %s, number of awards = %d ]", getTitie(), getCategory(), getDirector().getName(), getDirector().getSurname(), getNumAwards()));
    }

}
