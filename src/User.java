import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;

    private static Map<Integer, User> allUsers = new HashMap<>();;
    private static int countId = 0;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public User(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null){

        this.name = name;
        this.age = age;
        this.sex = sex;

        if(!hasUser()) {
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    private boolean hasUser(){
        for(User user: allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode())
                return true;
        }
        return false;
    }

    /*******************************************************************************************************/

    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex){
        List<User> listAllusers = new ArrayList<>();
        for (User user: allUsers.values()){
            if(user.sex == sex){
                listAllusers.add(user);
            }
        }
        return listAllusers;
    }
    /*******************************************************************************************************/
    public static int getUsersCount(){
        return allUsers.size();
    }

    public static int getUsersCount(Sex sex){
        return getAllUsers(sex).size();
    }
    /*******************************************************************************************************/
    public static int getAllAgeUsers(){
        int countAge = 0;
        for (User user: allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (User user: getAllUsers(sex)){
            countAge += user.age;
        }
        return countAge;
    }
    /*******************************************************************************************************/
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getUsersCount();
    }

    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex) / getUsersCount(sex);
    }
    /*******************************************************************************************************/
/*
    public static void main(String[] args) {
        new User("Евгений", 35, Sex.MALE);
        new User("Марина", 34, Sex.FEMALE);
        new User("Алина", 7, Sex.FEMALE);


        System.out.println("Все пользователи:");
        User.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи: MALE");
        User.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("Все пользователи: FEMALE");
        User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("================================================");
        System.out.println("       всех пользователей: " + User.getUsersCount());
        System.out.println("  всех пользователей MALE: " + User.getUsersCount(Sex.MALE));
        System.out.println("всех пользователей FEMALE: " + User.getUsersCount(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       общий возраст всех пользователей: " + User.getAllAgeUsers());
        System.out.println("  общий возраст всех пользователей MALE: " + User.getAllAgeUsers(Sex.MALE));
        System.out.println("общий возраст всех пользователей FEMALE: " + User.getAllAgeUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       средний возраст всех пользователей: " + User.getAverageAgeOfAllUsers());
        System.out.println("  средний возраст всех пользователей MALE: " + User.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("средний возраст всех пользователей FEMALE: " + User.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("================================================");
    }
    */
}
