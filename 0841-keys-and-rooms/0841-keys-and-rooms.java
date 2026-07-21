class Solution {
    Set<Integer> visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new HashSet<>();
        dfs(rooms, 0);
        return rooms.size() == visited.size();
    }

    private void dfs(List<List<Integer>> rooms, int room) {
        visited.add(room);

        for (int nextRoom : rooms.get(room)) {
            if (!visited.contains(nextRoom)) {
                dfs(rooms, nextRoom);
            }
        }
    }
}