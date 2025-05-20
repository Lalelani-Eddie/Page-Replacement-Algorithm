import java.util.*;

public class FIFO {

    private static int firstInFirstOut(final Memory frames, final Integer[] pageReferences) {
        int pageFaults = 0;
        Queue<Integer> fifoQueue = new LinkedList<>();

        for (int page : pageReferences) {
            System.out.print(page + ": ");

            if (frames.contains(page)) {
                System.out.println("-");
                continue;
            }

            // Page fault occurs
            pageFaults++;

            if (fifoQueue.size() < frames.size()) {
                // There is still space in memory
                for (int i = 0; i < frames.size(); i++) {
                    if (frames.isEmpty(i)) {
                        frames.put(i, page);
                        fifoQueue.add(page);
                        break;
                    }
                }
            } else {
                // Memory is full, evict oldest
                int oldestPage = fifoQueue.poll();
                int frameIndex = frames.indexOf(oldestPage);
                frames.put(frameIndex, page);
                fifoQueue.add(page);
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

        System.out.printf("Page faults: %d.\n", firstInFirstOut(new Memory(numFrames), toArray(referenceString)));
    }

    private static Integer[] toArray(final String referenceString) {
        final Integer[] result = new Integer[referenceString.length()];

        for (int i = 0; i < referenceString.length(); i++) {
            result[i] = Character.digit(referenceString.charAt(i), 10);
        }
        return result;
    }
}
