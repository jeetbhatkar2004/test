class Solution {
    public int[] getOrder(int[][] tasks) {    
        int len = tasks.length;
        int[] result = new int[len];
        int[][] newtasks = new int[len][3];
        int i = 0;
        while(i < len){
            newtasks[i][0] = tasks[i][0];
            newtasks[i][1] = tasks[i][1];
            newtasks[i][2] = i;
            i++;
        }
        Arrays.sort(newtasks, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]){
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
    });
        int time = 0;
        i = 0;
        int count = 0;
        while(count < len){
            while(i < len && newtasks[i][0] <= time){
                pq.offer(newtasks[i]);
                i++;
            }
            if (pq.isEmpty()){
                time = newtasks[i][0];
                continue;
            }
            int[] temp = pq.poll();
            result[count] = temp[2];
            time = time + temp[1];
            count++;

        }
        return result;

        
    }
}