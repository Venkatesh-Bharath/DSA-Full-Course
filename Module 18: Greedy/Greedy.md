# Module 18: Greedy

# 1. Introduction
Greedy algorithms aim to make the locally optimal choice at each stage with the hope of finding a global optimum solution. They are used in problems where a sequence of choices must be made in a way that each choice affects the next set of choices.

# 2. Activity Selection Problem

##### Explanation:
The activity selection problem involves selecting the maximum number of activities that do not overlap, given their start and finish times. The greedy approach sorts activities by their finish times and selects the next compatible activity.

##### Java Implementation:
```java
import java.util.*;

class ActivitySelection {
    static class Activity {
        int start, finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    static void printMaxActivities(Activity[] activities) {
        // Sort activities by finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        List<Activity> selectedActivities = new ArrayList<>();
        selectedActivities.add(activities[0]);
        Activity lastSelected = activities[0];

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastSelected.finish) {
                selectedActivities.add(activities[i]);
                lastSelected = activities[i];
            }
        }

        // Print selected activities
        System.out.println("Selected Activities:");
        for (Activity activity : selectedActivities) {
            System.out.println("Start: " + activity.start + ", Finish: " + activity.finish);
        }
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(3, 8),
                new Activity(5, 9),
                new Activity(6, 10),
                new Activity(8, 11),
                new Activity(8, 12),
                new Activity(2, 13),
                new Activity(12, 14)
        };

        printMaxActivities(activities);
    }
}
```

# 3. Fractional Knapsack

##### Explanation:
The fractional knapsack problem involves maximizing the total value of items placed into a knapsack without exceeding its capacity. The greedy approach selects items with the highest value-to-weight ratio first and fractions of items are allowed.

##### Java Implementation:
```java
import java.util.*;

class FractionalKnapsack {
    static class Item {
        int value, weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio (descending)
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                totalValue += item.value;
                currentWeight += item.weight;
            } else {
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.value * ((double) remainingCapacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
```

# 4. Job Sequencing Problem

##### Explanation:
The job sequencing problem involves selecting jobs with deadlines and profits to maximize the profit. The greedy approach sorts jobs by profit and schedules them if their deadline allows.

##### Java Implementation:
```java
import java.util.*;

class JobSequencing {
    static class Job {
        char id;
        int deadline, profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static void printJobScheduling(Job[] jobs) {
        // Sort jobs by profit (descending)
        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));

        int maxDeadline = Arrays.stream(jobs).mapToInt(job -> job.deadline).max().getAsInt();
        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        Arrays.fill(slot, false);

        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = job.id;
                    slot[j] = true;
                    break;
                }
            }
        }

        // Print sequence of jobs for maximum profit
        System.out.println("Sequence of jobs for maximum profit:");
        for (char ch : result) {
            if (ch != '\u0000') // Unicode null character
                System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        };

        printJobScheduling(jobs);
    }
}
```
