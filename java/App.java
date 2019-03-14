//package codecheck;

public class App {
    public static void main(String[] args) {
        if ( args.length != 2 ) {
            System.err.println("input two arguments");
            System.exit(-1);
        }
        printStrings("argv", args);

        int challenge_number = Integer.parseInt(args[0]);
        
        switch (challenge_number) {
            case 1:
                System.err.println("Exam 1-1");

                if ( args[1].isEmpty()) {// ""のとき
                    System.exit(0);
                } else if ( args[1].matches(".*\\D.*") ) {// ""でなく、整数以外が含まれるとき

                    System.out.println("input is false");
                    System.exit(2);
                } else {
                    System.err.println("input is correct");

                    // 初めに文字列を一文字ずつの配列に分割
                    String[] split_char = args[1].split("(?!^)"); // 否定的先読みにより除外

                    int size = split_char.length;
                    System.err.println("size = " + size);
                    printStrings("split_char", split_char);

                    // 以下最も長い部分増加列を求める
                    String[] split_series = new String[size];

                    for (int i = 0, l = size; i < l; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(split_char[i]);

                        int j = i;
                        while ( j < l - 1 && Integer.parseInt(split_char[j]) + 1 == Integer.parseInt(split_char[j+1]) ) {
                            sb.append(split_char[j+1]);
                            //System.err.println(sb);

                            j++;
                        }
                        
                        split_series[i] = sb.toString();
                    }

                    printStrings("split_series", split_series);

                    printMax(split_series);

                }
                
                break;
                
            case 2:
                System.err.println("Exam 1-2");
                
                if ( args[1].isEmpty()) {// ""のとき
                    System.exit(0);
                } else if ( args[1].matches(".*[^01].*") ) {// ""でなく、整数以外が含まれるとき
                    System.out.println("input is false");
                    System.exit(2);
                } else {
                    System.err.println("input is correct");

                    // 初めに文字列を一文字ずつの配列に分割
                    String[] split_char = args[1].split("(?!^)"); // 否定的先読みにより除外

                    int size = split_char.length;
                    System.err.println("size = " + size);
                    printStrings("split_char", split_char);

                    // 以下最も長い同値部分列を求める
                    String[] split_series = new String[size];

                    for (int i = 0, l = size; i < l; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(split_char[i]);

                        int j = i;
                        while ( j < l - 1 && Integer.parseInt(split_char[j]) == Integer.parseInt(split_char[j+1]) ) {
                            sb.append(split_char[j+1]);
                            //System.err.println(sb);

                            j++;
                        }
                        
                        split_series[i] = sb.toString();
                    }

                    printStrings("split_series", split_series);

                    printMax(split_series);

                }
                
                break;
                
            case 3:
                System.err.println("Exam 1-3");
                if ( args[1].isEmpty()) {// ""のとき
                    System.exit(0);
                } else if ( args[1].matches(".*[^\\p{Alpha}].*") ) {// ""でなく、整数以外が含まれるとき
                    System.out.println("input is false");
                    System.exit(2);
                } else {
                    System.err.println("input is correct");

                    // 初めに文字列を一文字ずつの配列に分割
                    String[] split_char = args[1].split("(?!^)"); // 否定的先読みにより除外

                    int size = split_char.length;
                    System.err.println("size = " + size);
                    printStrings("split_char", split_char);

                    // 以下最も長い同字部分列を求める
                    String[] split_series = new String[size];

                    for (int i = 0, l = size; i < l; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(split_char[i]);

                        int j = i;
                        while ( j < l - 1 && split_char[j].equals(split_char[j+1]) ) {
                            sb.append(split_char[j+1]);

                            j++;
                        }
                        
                        split_series[i] = sb.toString();
                    }
                    printStrings("split_series", split_series);

                    printMax(split_series);

                }
                
                break;
                
            default:
                System.err.println("first argument must be 1-3");
                System.exit(1);
                
                break;
                
        }
        
    }

    public static void printStrings(String name, String[] args) {
        for (int i = 0, l = args.length; i < l; i++) {
            String output = String.format("%s[%s]: %s", name, i, args[i]);
            System.err.println(output);
        }
    }

    public static void printMax(String[] split_series) {
        
        int size = split_series.length;
        int max = 0;
        for (int i = 0, l = size; i < l; i++) {
            if ( max < split_series[i].length() ) {
                max = split_series[i].length();
            }
        }
        System.err.println("max = " + max);
        
        for (int i = 0, l = size; i < l; i++) {
            if ( max == split_series[i].length() ) {
                System.out.println(split_series[i]);
            }
        }
    }
}

