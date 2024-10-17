class InvalidAgeException extends Exception{
    InvalidAgeException(String massage){
        super(massage);
    }
}

class ExceptionHandaling  {
    public static  void checkAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age Must be 18 for voting");
        }
        else{
            System.out.println("You Can Vote");
        }
    }
    public static void main(String[] args) {
        //arithmatic exception
        try{
            int a=10;
            int b=0;
            int result=a/b;
            System.out.println("Result"+result);
        }
        catch(ArithmeticException e){
            System.out.println("Div not possible");
        }
        finally{
            System.out.println("Code is run successful");
        }

        // custome exception
        try{
            int age=15;
            checkAge(age);
        }
        catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }
        //array out of index
        try{
            String[] name={"Ranit","Sagar"};
            System.out.println(name[2]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of index");
        }
    }
    
}
