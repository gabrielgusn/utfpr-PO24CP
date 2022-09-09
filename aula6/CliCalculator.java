public class CliCalculator {
    public static void main(String[] args){
        if(args.length != 3){
            System.out.println("This program needs 3 arguments to be passed through the CLI");
            System.exit(1);
        }

        int firstValue = Integer.parseInt(args[0]);

        char operator = args[1].charAt(0);

        int secondValue = Integer.parseInt(args[2]);

        int result = 0;

        switch(operator){
            case '+': result = firstValue+secondValue; break;
            case '-': result = firstValue-secondValue; break;
            case 'x': result = firstValue*secondValue; break;
            case '/': result = firstValue/secondValue; break;
            default: System.out.println("No operators specified");
        }

        for(String i: args){
            System.out.print(i+" ");
        }

        System.out.println("= "+result);
    }
}
