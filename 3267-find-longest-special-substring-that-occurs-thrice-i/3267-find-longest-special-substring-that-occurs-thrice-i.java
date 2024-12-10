class Solution {
		public int maximumLength(String s) {
			for(int len = s.length();len >= 1;len--){
				Map<String, Integer> map = new HashMap<>();
				inner:
				for(int i = 0;i + len <= s.length();i++){
					String sub = s.substring(i, i + len);
					for(int j = 0;j < len;j++){
						if(sub.charAt(j) != sub.charAt(0))continue inner;
					}
					if(map.containsKey(sub)){
						map.put(sub, map.get(sub) + 1);
					}else{
						map.put(sub, 1);
					}
				}
				for(int v : map.values()){
					if(v >= 3)return len;
				}
			}
			return -1;
		}
	}
