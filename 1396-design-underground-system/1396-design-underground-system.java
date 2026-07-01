class UndergroundSystem {
    class CheckInData {
        String station;
        int time;

        public CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class RouteData {
        int totalTime;
        int totalCount;

        public RouteData(int totalTime, int totalCount) {
            this.totalTime = totalTime;
            this.totalCount = totalCount;
        }
    }
    
    Map<Integer, CheckInData> activeTrips;
    Map<String, RouteData> routeStats;

    public UndergroundSystem() {
        activeTrips = new HashMap<>();
        routeStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        activeTrips.put(id, new CheckInData(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInData trip = activeTrips.get(id);
        int travelTime = t - trip.time;

        String route = trip.station+"->"+stationName;
        RouteData data = routeStats.getOrDefault(route, new RouteData(0,0));
        data.totalTime += travelTime;
        data.totalCount++;

        routeStats.put(route, data);

        activeTrips.remove(id);

    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        RouteData data = routeStats.get(route);
        return (double) data.totalTime / data.totalCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */