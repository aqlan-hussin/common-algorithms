import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class SieveOfEratosthenes {
  void sieveOfEratosthenes(int limit) {
    boolean[] output = new boolean[limit + 1];
    for (int x = 0; x <= limit; x++) {
        if (x == 0 || x == 1)
          output[x] = false;
        else
          output[x] = true;
    }
    for (int i = 2; i <= limit; i++) {
        if (output[i] == true) {
            for (int j = i * 2; j <= limit; j = j + i) {
                output[j] = false;
            }
        }
    }

    List<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < output.length; i++) {
      if (output[i] == true) {
        result.add(i);
      } 
    }

    System.out.println(Arrays.toString(result.toArray()));
    System.out.println(result.size());
  }

  public static void main(String[] args) {
      int n = 20;
      SieveOfEratosthenes g = new SieveOfEratosthenes();
      g.sieveOfEratosthenes(n);
  }
}