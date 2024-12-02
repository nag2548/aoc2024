package de.zimtix.aoc2024.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.split;

public class Day2Part2 extends Day2 {
    public Day2Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        List<List<Integer>> levelList = lines.stream()
                .map(l -> stream(split(l, ' ')).map(Integer::parseInt).toList())
                .toList();

        AtomicInteger safeCount = new AtomicInteger(0);

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<Boolean>> tasks = new ArrayList<>();

            for (List<Integer> levels : levelList) {
                tasks.add(() -> isSafe(levels));
            }

            List<Future<Boolean>> futures = executor.invokeAll(tasks);
            futures.parallelStream().forEach(task -> {
                try {
                    if (task.get()) {
                        safeCount.incrementAndGet();
                    }
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return safeCount.get();
    }

    private boolean isSafe(List<Integer> levels) {
        int faultyIndex = findFaultyIndex(levels);
        return faultyIndex == -1 || isSafeWithOneRemoval(levels, faultyIndex);
    }

    private boolean isSafeWithOneRemoval(List<Integer> levels, int faultyIndex) {
        int startIndex = faultyIndex - 1;
        for (int i = 0; i < levels.size(); i++) {
            if (i < startIndex) {
                continue;
            }

            List<Integer> newLevels = new ArrayList<>();
            for (int j = 0; j < levels.size(); j++) {
                if (j != i) {
                    newLevels.add(levels.get(j));
                }
            }

            if (findFaultyIndex(newLevels) == -1) {
                return true;
            }
        }

        return false;
    }
}
