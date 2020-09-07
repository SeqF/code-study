class ExceptionA extends Exception{
    public ExceptionA(String str){
        super();
    }
}
class ExceptionB extends ExceptionA{
    public ExceptionB(String str){
        super(str);
    }
}
class ExceptionC extends ExceptionA{
    public ExceptionC(String str){
        super(str);
    }
}



public class NeverCaught {
    static void f() throws ExceptionB{
        throw new ExceptionB("exception b");
    }
    static void g() throws ExceptionC{
        try{
            f();
        }catch (Exception e){
            ExceptionC c =new ExceptionC("exception a");
            //异常链
            c.initCause(e);
            throw c;
        }
    }

    public static void main(String[] args) {
        try{
            g();
        }catch (ExceptionC e){
            e.printStackTrace();
        }
    }
}
