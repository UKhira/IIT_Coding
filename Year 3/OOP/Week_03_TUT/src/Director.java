public class Director {
    private String name;
    private String surname;
    private int numDirectedMovie;
    private Date Dob;

    Director(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void setDoB(Date dob){
        this.Dob = dob;
    }

    public void setNumDirectedMovie(int numDirectedMovie){
        this.numDirectedMovie = numDirectedMovie;
    }

    public int getNumberOfMovies(){
        return numDirectedMovie;
    }

    public Date getDoB(){
        return Dob;
    }


    public String toString() {
        return ("Director [ name = " + name + " surname = " + surname + " dob = " + Dob.dateString() + " movies directed = " + numDirectedMovie + "]");
    }
}
