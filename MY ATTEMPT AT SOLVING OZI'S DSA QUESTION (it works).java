public class Main {
    public static void main(String[] args) {
      var base10 = displayBase10("11010");
      System.out.println(base10);
    }

    public static int displayBase10(String baseTwoNumber) {
      int[] array = new int[baseTwoNumber.length()];

      for (int i = 0; i < baseTwoNumber.length() - 1; i++) {
        array[i] = (int)(baseTwoNumber.charAt(i) - 48);
      }

      int total = 0;
      int index = 0;

      for (int i = array.length - 1; i >= 0; i--) {
        total += (int)(Math.pow(2, index)) * array[i];
        index++;
      }
      return total;
    }    
}
