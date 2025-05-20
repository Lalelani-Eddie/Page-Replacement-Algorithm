import java.util.*;

public class OPT {
    private static int OPTIMAL(final Memory frames, final Integer[] pageReferences) {
    int pageFaults = 0;

    for (int i = 0; i < pageReferences.length; i++) {
        int currentPage = pageReferences[i];
        System.out.print(currentPage + ": ");

        if (frames.contains(currentPage)) {
            System.out.println("-");
            continue;
        }

        pageFaults++;

        if (!(frames.size() < frames.size())) {
            for (int f = 0; f < frames.size(); f++) {
                if (frames.isEmpty(f)) {
                    frames.put(f, currentPage);
                    break;
                }
            }
        } else {
            // Find the page with the farthest next use
            int victimIndex = -1;
            int farthestUse = -1;

            for (int f = 0; f < frames.size(); f++) {
                Integer pageInFrame = frames.get(f);
                int nextUse = Integer.MAX_VALUE;

                for (int j = i + 1; j < pageReferences.length; j++) {
                    if (pageReferences[j].equals(pageInFrame)) {
                        nextUse = j;
                        break;
                    }
                }

                if (nextUse > farthestUse) {
                    farthestUse = nextUse;
                    victimIndex = f;
                }
            }

            // Replace the page that will be used farthest in the future (or never)
            frames.put(victimIndex, currentPage);
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

        System.out.printf("Page faults: %d.\n", OPTIMAL(new Memory(numFrames), toArray(referenceString)));
    }

    private static Integer[] toArray(final String referenceString) {
        final Integer[] result = new Integer[referenceString.length()];
        
        for(int i=0; i < referenceString.length(); i++) {
            result[i] = Character.digit(referenceString.charAt(i), 10);
        }
        return result;
    }
}
