class TimeMap {

    private class MapValue {
        public int time;
        public String val;
        MapValue(int time, String val) {
            this.time = time;
            this.val = val;
        }
    }

    Map<String, List<MapValue>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayList<>()).add(new MapValue(timestamp,value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        return  getMapVal(map.get(key),timestamp);
    }

    private String getMapVal(List<MapValue> list, int time){
        int l=0,r=list.size()-1;
        String res = "";
        while(l<=r){
            int mid = l+(r-l)/2;
            if(list.get(mid).time <= time){
                res = list.get(mid).val;
                l = mid+1;
            }else r = mid-1;
        }
        return res;
    }
}
