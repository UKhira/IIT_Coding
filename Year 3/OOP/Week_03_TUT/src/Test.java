public class Test
    {
        public static void main(String[] args) {

            Date date = new Date(12, 1, 2022);
            System.out.println(date);

            Director director = new Director("James", "Gunn");
            director.setNumDirectedMovie(20);

            Date dob = new Date(12,12,2000);
            director.setDoB(dob);
            
            director.setNumDirectedMovie(23);
            System.out.println(director);       //toString()
            System.out.println("name is" + director.getName());
            System.out.println("surname is" + director.getSurname()); 
            System.out.println("dob is" + director.getDoB().dateString());
            System.out.println("number of directed movies is" + director.getNumberOfMovies());

            Movie movie = new Movie("Scooby Doo", "Comedy", director);
            movie.setNumAward(20);
            System.out.println(movie);

            Actor actor[] = new Actor[10];
        }
}
