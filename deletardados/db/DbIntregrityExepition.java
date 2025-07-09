package deletardados.db;

public class DbIntregrityExepition extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DbIntregrityExepition(String msg){
        super(msg);
    }

}
