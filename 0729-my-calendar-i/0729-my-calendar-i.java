// class MyCalendar {
//     List<int[]> list;

//     public MyCalendar() {
//         list=new ArrayList<>();
        
//     }
    
//     public boolean book(int start, int end) {
//         for(int[] booking:list)
//         {
//             if(start<booking[1] && booking[0]<end)
//             return false;
//         }
//         list.add(new int[]{start, end});
//         return true;
        
//     }
// }

// /**
//  * Your MyCalendar object will be instantiated and called as such:
//  * MyCalendar obj = new MyCalendar();
//  * boolean param_1 = obj.book(start,end);
//  */


class MyCalendar {
    // using TreeMap : end -> start

    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() {
        map.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean book(int start, int end) {
        // get an (higher)entry that ends just after current
        var e = map.higherEntry(start);
        // if start time of higher entry is less than end time of current
        // since current has to start before higher enry,
        // so if above condition is true, it means the current event will end before higher entry
        // event will start, so we can schedule it
        if(end <= e.getValue()){
            map.put(end, start);
            return true;
        }
        return false;
    }
}