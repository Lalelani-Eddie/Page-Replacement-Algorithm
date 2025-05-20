import java.util.Scanner;

public class CLOCK {
    private static int ClockAlgorithm(final Memory frames, final Integer[] pageReferences) {
    int pageFaults = 0;
    int[] referenceBits = new int[frames.size()];
    int pointer = 0;

    for (int page : pageReferences) {
        System.out.print(page + ": ");

        if (frames.contains(page)) {
            // Set reference bit to 1
            int index = frames.indexOf(page);
            referenceBits[index] = 1;
            System.out.println("-");
            continue;
        }

        pageFaults++;

        while (true) {
            if (frames.isEmpty(pointer)) {
                frames.put(pointer, page);
                referenceBits[pointer] = 1;
                pointer = (pointer + 1) % frames.size();
                break;
            } else if (referenceBits[pointer] == 0) {
                frames.put(pointer, page);
                referenceBits[pointer] = 1;
                pointer = (pointer + 1) % frames.size();
                break;
            } else {
                referenceBits[pointer] = 0;
                pointer = (pointer + 1) % frames.size();
            }
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

        System.out.printf("Page faults: %d.\n", ClockAlgorithm(new Memory(numFrames), toArray(referenceString)));
    }

    private static Integer[] toArray(final String referenceString) {
        final Integer[] result = new Integer[referenceString.length()];

        for (int i = 0; i < referenceString.length(); i++) {
            result[i] = Character.digit(referenceString.charAt(i), 10);
        }
        return result;
    }
}
