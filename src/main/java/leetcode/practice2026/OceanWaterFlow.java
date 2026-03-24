package leetcode.practice2026;

import shared.PracticeStatus;

import java.util.*;

import static shared.PracticeStatus.IN_PROGRESS;

public class OceanWaterFlow {
    final String source = "https://leetcode.com/problems/pacific-atlantic-water-flow/";
    final PracticeStatus status = IN_PROGRESS;

    private final int[][] directions = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{-1,0},
            new int[]{0,-1}
    };

    public List<List<Integer>> solution(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return List.of();
        Set<List<Integer>> atlanticCoordinates = atlanticOceanCoordinates(heights);
        Set<List<Integer>> result = new HashSet<>();
        Deque<List<Integer>> neighborQueue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        for (List<Integer> atlanticCoordinate : atlanticCoordinates) {
            if (!seen.contains(buildCoordinateString(atlanticCoordinate.get(0), atlanticCoordinate.get(1)))) {
                neighborQueue.addLast(atlanticCoordinate);
            }
            while (!neighborQueue.isEmpty()) {
                List<Integer> currCoords = neighborQueue.removeFirst();
                int currRow = currCoords.get(0);
                int currCol = currCoords.get(1);
                if (isPacificAdjacent(currCoords)) {
                    result.add(currCoords);
                    continue;
                }
                seen.add(buildCoordinateString(currRow, currCol));
                for (int[] direction : directions) {
                    List<Integer> neighborCoords = List.of(currRow + direction[0], currCol + direction[1]);
                    if (isValidNeighbor(seen, neighborCoords, heights, heights[currRow][currCol])) {
                        neighborQueue.addLast(neighborCoords);
                    }
                }
            }
        }

        Set<List<Integer>> pacificCoordinates = pacificOceanCoordinates(heights);
        seen = new HashSet<>();
        for (List<Integer> pacificCoordinate : pacificCoordinates) {
            if (!seen.contains(buildCoordinateString(pacificCoordinate.get(0), pacificCoordinate.get(1)))) {
                neighborQueue.addLast(pacificCoordinate);
            }
            while (!neighborQueue.isEmpty()) {
                List<Integer> currCoords = neighborQueue.removeFirst();
                int currRow = currCoords.get(0);
                int currCol = currCoords.get(1);
                if (isAtlanticAdjacent(currCoords, heights.length, heights[0].length)) {
                    result.add(currCoords);
                    continue;
                }
                seen.add(buildCoordinateString(currRow, currCol));
                for (int[] direction : directions) {
                    List<Integer> neighborCoords = List.of(currRow + direction[0], currCol + direction[1]);
                    if (isValidNeighbor(seen, neighborCoords, heights, heights[currRow][currCol])) {
                        neighborQueue.addLast(neighborCoords);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private boolean isValidNeighbor(Set<String> seen, List<Integer> neighborCoordinates, int[][] heights, int seaLevel) {
        int neighborRow = neighborCoordinates.get(0);
        int neighborCol = neighborCoordinates.get(1);
        if (neighborCol >= heights[0].length || neighborCol < 0 || neighborRow >= heights.length || neighborRow < 0) return false;
        if (seen.contains(buildCoordinateString(neighborRow, neighborCol))) return false;
        int neighborSeaLevel = heights[neighborRow][neighborCol];
        return neighborSeaLevel >= seaLevel;
    }

    private Set<List<Integer>> pacificOceanCoordinates(int[][] heights) {
        Set<List<Integer>> pacificCoords = new HashSet<>();
        // Build top coordinates
        for (int i = 0; i < heights[0].length; i++) {
            pacificCoords.add(List.of(0, i));
        }
        // Build left coordinates
        for (int i = 0; i < heights.length; i++) {
            pacificCoords.add(List.of(i,0));
        }
        return pacificCoords;
    }

    private Set<List<Integer>> atlanticOceanCoordinates(int[][] heights) {
        Set<List<Integer>> atlanticCoords = new HashSet<>();
        // Build bottom coordinates
        for (int i = 0; i < heights[0].length; i++) {
            atlanticCoords.add(List.of(heights[0].length - 1, i));
        }
        // Build right coordinates
        for (int i = 0; i < heights.length; i++) {
            atlanticCoords.add(List.of(i,heights.length - 1));
        }
        return atlanticCoords;
    }

    private boolean isPacificAdjacent(List<Integer> coordinates) {
        int row = coordinates.get(0);
        int col = coordinates.get(1);
        return row == 0 || col == 0;
    }

    private boolean isAtlanticAdjacent(List<Integer> coordinates, int maxRow, int maxCol) {
        int row = coordinates.get(0);
        int col = coordinates.get(1);
        return row == maxRow || col == maxCol;
    }

    private String buildCoordinateString(int row, int col) {
        return String.format("%s-%s", row, col);
    }

    private int[] buildCoordinatesFromString(String coords) {
        String[] coordArr = coords.split("-");
        return new int[]{Integer.parseInt(coordArr[0]), Integer.parseInt(coordArr[1])};
    }
}
