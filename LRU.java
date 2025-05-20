import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRU {
private static int LRUAlgorithm(final Memory frames, final Integer[] pageReferences) {
    int pageFaults = 0;
    Map<Integer, Integer> recentUseMap = new HashMap<>(); // Page -> Last used index

    for (int i = 0; i < pageReferences.length; i++) {
        int currentPage = pageReferences[i];
        System.out.print(currentPage + ": ");

        if (frames.contains(currentPage)) {
            recentUseMap.put(currentPage, i); // Update recent use
            System.out.println("-");
            continue;
        }

        pageFaults++;

        if (!(frames.size()<frames.size())) {
            for (int f = 0; f < frames.size(); f++) {
                if (frames.isEmpty(f)) {
                    frames.put(f, currentPage);
                    recentUseMap.put(currentPage, i);
                    break;
                }
            }
        } else {
            // Find least recently used page
            int lruIndex = -1;
            int leastRecent = Integer.MAX_VALUE;

            for (int f = 0; f < frames.size(); f++) {
                int pageInFrame = frames.get(f);
                int lastUsed = recentUseMap.getOrDefault(pageInFrame, -1);

                if (lastUsed < leastRecent) {
                    leastRecent = lastUsed;
                    lruIndex = f;
                }
            }

            // Replace LRU page
            int pageToRemove = frames.get(lruIndex);
            frames.put(lruIndex, currentPage);
            recentUseMap.remove(pageToRemove);
            recentUseMap.put(currentPage, i);
        }

        System.out.println(frames);
    }

    return pageFaults;
}
public static void main(final String[] args) {
        final Scanner stdIn = new Scanner(System.in);

        System.out.println("Enter the physical memory size (number of frames):");
        final int numFrames = stdIn.nextInt();
        stdIn.nextLine();

        System.out.println("Enter the string of page references:");
        final String referenceString = stdIn.nextLine();

        System.out.printf("Page faults: %d.\n", LRUAlgorithm(new Memory(numFrames), toArray(referenceString)));
    }

    private static Integer[] toArray(final String referenceString) {
        final Integer[] result = new Integer[referenceString.length()];

        for (int i = 0; i < referenceString.length(); i++) {
            result[i] = Character.digit(referenceString.charAt(i), 10);
        }
        return result;
    }
}
