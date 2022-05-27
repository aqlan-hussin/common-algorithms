public class CapturingRainwater {
  // O(n^2)
  public static int naiveSolution(int[]heights) {
    int totalWater = 0;
    for (int i = 0; i < heights.length - 1; i++) {
      int leftBound = 0;
      int rightBound = 0;
      // Here we only want to look at elements to the LEFT of index i, which are the elements at the lower indices
      for (int j = 0; j <= i; j++) {
          leftBound = Math.max(leftBound, heights[j]);
      }
      // Now here we only want to look at elements to the RIGHT of index i, which are the elements at the higher indices
      for (int j = i; j < heights.length; j++) {
          rightBound = Math.max(rightBound, heights[j]);
      }
      // Add the amount of water at index i to totalWater
      totalWater += Math.min(leftBound, rightBound) - heights[i];
    }
    return totalWater;
  }

  // O(n)
  public static int efficientSolution(int[]heights) {
    int totalWater = 0;
    int leftPointer = 0;
    int rightPointer = heights.length - 1;
    int leftBound = 0;
    int rightBound = 0;
    // Fill in the rest of this method with your solution

    while (leftPointer < rightPointer) {
      if (heights[leftPointer] <= heights[rightPointer]) {
        leftBound = Math.max(leftBound, heights[leftPointer]);
        totalWater += leftBound - heights[leftPointer];
        leftPointer++;
      } else {
        rightBound = Math.max(rightBound, heights[rightPointer]);
        totalWater += rightBound - heights[rightPointer];
        rightPointer--;
      }
    }
    
    return totalWater;
  }

  public static void main(String[] args) {
    int[] heights = new int[] {4, 2, 1, 3, 0, 1, 2};

    System.out.println("Total water would be " + naiveSolution(heights));
    System.out.println("Total water would be " + efficientSolution(heights));
  }
}

