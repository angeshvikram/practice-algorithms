package algorithmJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

public class LongPresentationBreak {

    /*
     * Complete the 'findBreakDuration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER t
     *  4. INTEGER_ARRAY start
     *  5. INTEGER_ARRAY finish
     */
	
	public static boolean checkConstraints(int n, int k, int t, List<Integer> start, List<Integer> finish) {
		boolean retVal = true;
		
		//1 ≤ n ≤ 105
		
		if (!((1 <= n) && (n <= 105)) ){
			retVal = false;
		}
		
		//0 ≤ k ≤ n
		if (!((0 <= k) && (k <= n)) ){
			retVal = false;
		}

		//1 ≤ t ≤ 109
		if (!((1 <= t) && (k <= 109)) ){
			retVal = false;
		}

		for (int i=0;i<(start.size()-1);i++){
			//0 ≤ start[i] < finish[i] ≤ t
			if (!((1 <= start.get(i)) && (start.get(i) <= finish.get(i)) && (finish.get(i) <= t)) ){
				retVal = false;
			}

			//finish[i] ≤ start[i + 1] if i ≠ n - 1
			if (!((finish.get(i) <= start.get(i+1))) ){
				retVal = false;
			}
		}

		
		return retVal;
	}

	public static int findgap(int n, int k, int t, List<Integer> start, List<Integer> finish) {
	
		System.out.println();
		for(int i =0 ; i < start.size();i++) {
			
		}
		return 0;
	}
	
    public static int findBreakDuration(int n, int k, int t, List<Integer> start, List<Integer> finish) {
        // Write your code here
    	
    	if(!checkConstraints(n,k,t,start,finish)) {
    		return 0;
    	}
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        int startCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> start = IntStream.range(0, startCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int finishCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> finish = IntStream.range(0, finishCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = findBreakDuration(n, k, t, start, finish);
        
        System.out.println(result);

    }

}
