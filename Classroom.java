public class Classroom {
    private int id;
    private static int idTemp = 1;
    private String name;

    public Classroom(String name) {
        this.id = idTemp++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdTemp() {
        return idTemp;
    }

    public static void setIdTemp(int idTemp) {
        Classroom.idTemp = idTemp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "." + name;
    }
}
