package output;

//Single responsibility principle
public class Output implements IOutput{
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
