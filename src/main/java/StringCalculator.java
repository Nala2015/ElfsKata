public class StringCalculator
{
    public int Calculate(String testString) {
        String delimiter;
        if(testString.startsWith("/")) {
            delimiter = testString.substring(2,3);
            if(testString.length()<4) {
                return 0;
            }
            if (!testString.substring(4).isEmpty()) {
                int total = 0;
                String[] testBits = testString.substring(4).split(delimiter);
                for (String bit : testBits)
                    total += Integer.parseInt(bit);
                return total;
            }
        }
        else if (!testString.isEmpty()) {
            int total = 0;
            String[] testBits = testString.split(",|\n");
            for (String bit : testBits)
                total += Integer.parseInt(bit);

            return total;
        }
        return 0;

    }
}


