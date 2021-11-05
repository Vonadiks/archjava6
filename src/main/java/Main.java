public class Main {
    public static void main(String[] args) throws Exception{
        UserMapper umap = new UserMapper();
        User filipp = umap.getUser(1);
        System.out.println(filipp);
        User test = umap.getUser(1);
        test.setName("Ivan");
        System.out.println(filipp);
        System.out.println(test);
    }
}
