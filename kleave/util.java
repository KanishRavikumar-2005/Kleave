package kleave;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BooleanSupplier;




public class util{
    public static final Scanner sc = new Scanner(System.in);

    public static <T> void sopln(T val){
        System.out.println(val);
    }

    public static <T> void sop(T val){
        System.out.print(val);
    }

    public static <T> T ask(String question, Class<T> type) {
        System.out.print(question + " ");
        String input = sc.nextLine().trim();

        try {
            if (type == Integer.class) return type.cast(Integer.parseInt(input));
            if (type == Double.class) return type.cast(Double.parseDouble(input));
            if (type == Boolean.class) return type.cast(Boolean.parseBoolean(input));
            if (type == String.class) return type.cast(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for " + type.getSimpleName());
        }

        throw new IllegalArgumentException("Unsupported or invalid type: " + type.getSimpleName());
    }

    public static <T> T[] get(String question, Class<T> type) {
        System.out.print(question);
        
        String line = sc.nextLine().trim();  // use shared scanner
        String[] parts = line.split("\\s+");

        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(type, parts.length);

        for (int i = 0; i < parts.length; i++) {
            if (type == Integer.class) {
                arr[i] = type.cast(Integer.parseInt(parts[i]));
            } else if (type == Double.class) {
                arr[i] = type.cast(Double.parseDouble(parts[i]));
            } else if (type == String.class) {
                arr[i] = type.cast(parts[i]);
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + type.getSimpleName());
            }
        }

        return arr;
    }

    public static void loop(int from, int to, IntConsumer action) {
        for (int i = from; i <= to; i++) {
            action.accept(i);
        }
    }

    public static void loop(int from, int to, IntPredicateWithIndex action) {
        for (int i = from; i <= to; i++) {
            if (!action.run(i)) break;
        }
    }
    public static boolean breakon(boolean condition) {
        return condition;
    }

    public static void during(BooleanSupplier condition, Runnable ifAction) {
        if (condition.getAsBoolean()) {
            ifAction.run();
        }
    }


    public static void during(BooleanSupplier condition, Runnable ifAction, Runnable elseAction) {
        if (condition.getAsBoolean()) {
            ifAction.run();
        } else {
            if (elseAction != null) {
                elseAction.run();
            }
        }
    }

    public static String str(String s, Object... values) {
        for (int i = 0; i < values.length; i++) {
            s = s.replace("$" + (i + 1), String.valueOf(values[i]));
        }
        return s;
    }
}