
### 📄 `README.md`

````markdown
# Page Replacement Algorithms in Java

This project implements four classic **Page Replacement Algorithms** used in operating systems for managing physical memory:

- FIFO (First-In First-Out)
- OPT (Optimal Replacement)
- LRU (Least Recently Used)
- Clock (Second Chance)

These algorithms simulate how an operating system replaces pages in memory when a page fault occurs.

---

## 🧠 How It Works

The program prompts the user to:
1. Enter the number of physical memory frames.
2. Enter a string of page references (e.g., `511032344791746`).

The selected algorithm then processes the page references and outputs:
- The memory state after each reference.
- Whether it caused a page fault.
- The total number of page faults.

---

## 🚀 How to Use

### 1. Compile the Program
Ensure you have Java installed and run:
```bash
javac Memory.java FIFO.java
````

### 2. Run the Program

Replace the algorithm name in `main()` with the one you want to test:

```java
System.out.printf("Page faults: %d.\n", FIFO(new Memory(numFrames), toArray(referenceString)));
// or
System.out.printf("Page faults: %d.\n", OPT(new Memory(numFrames), toArray(referenceString)));
```

Then run:

```bash
java FIFO
```

---

## 📦 Algorithms Implemented

### ✅ FIFO (First-In First-Out)

Replaces the oldest page in memory.

### ✅ OPT (Optimal Replacement)

Replaces the page that will not be used for the longest time in the future.
*Used for benchmarking; requires future knowledge.*

### ✅ LRU (Least Recently Used)

Replaces the page that was least recently used.

### ✅ Clock (Second Chance)

Uses a circular queue and a reference bit to approximate LRU with lower overhead.

---

## 🧪 Sample Input

```
Enter the physical memory size (number of frames):
3
Enter the string of page references:
511032344791746
```

### ✅ Sample Output for FIFO:

```
5: [5, -, -]
1: [5, 1, -]
1: -
0: [5, 1, 0]
3: [3, 1, 0]
...
Page faults: 11.
```

---

## 📁 Files

* `Memory.java`: Manages the frame storage.
* `FIFO.java`: Contains all four algorithms and the `main` method.
* `README.md`: Project documentation.

---

## ✨ Future Improvements

* Add GUI visualization.
* Add additional algorithms like NRU, Enhanced Clock.
* Support for character and string-based references.

---

## 👨‍💻 Author

This project was built as a learning exercise in operating system memory management techniques.

```

---

Let me know if you'd like this turned into a downloadable file or if you want a version that includes command-line options to choose the algorithm!
```
