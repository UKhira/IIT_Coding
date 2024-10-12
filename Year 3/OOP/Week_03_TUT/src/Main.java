public class Main
    {
        public static void main(String[] args) {
            Date date = new Date(12, 1, 2022);
            System.out.println(date);

            Director director = new Director("James", "Gunn");
            director.setNumDirectedMovie(20);
            Date dob = new Date(12,12,2000);
            director.setDoB(dob);
            System.out.println(director);
        }
}
