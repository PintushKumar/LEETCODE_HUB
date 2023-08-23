class Solution {
    public int countKDifference(int[] arr, int k) {
        int count =0;
		HashMap<Integer , Integer > map = new HashMap<>();
		for(int i =0;i<arr.length;i++){
			if(map.containsKey(arr[i]-k)){
				count += map.get(arr[i]-k);
			}
			if(map.containsKey(arr[i]+k)){
				count += map.get(arr[i]+k);
			}
			map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
		}
		return count;
    }
}