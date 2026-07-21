class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return rooms.size() == visited.size();
    }

    private void dfs(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        visited.add(room);

        for (int nextRoom : rooms.get(room)) {
            if (!visited.contains(nextRoom)) {
                dfs(rooms, nextRoom, visited);
            }
        }
    }
}