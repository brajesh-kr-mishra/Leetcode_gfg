class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<nums.length; i++){
            sb.append(nums[i].charAt(i) == '0' ? "1" : "0");
        }
        
        return new String(sb);
    }

    
}
/*class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int length = nums[0].length();

        Set<String> items = new HashSet<>();

        for(String num:nums)
        {
           items.add(num);
        }

        for(int i = 0; i< Math.pow(2,length); i++)
        {
            String binary = Integer.toBinaryString(i);
            for(int j = binary.length(); j<length; j++)
            {
                binary = "0" + binary;
            }

            if(!items.contains(binary))
            {
                return binary;
            }
        }
        return "0";
    }
}*//*
class Solution {
    private boolean generate(Set<String>set, char[] ans, char ch[], int idx, int n){
        if(idx>=n){
            if(!set.contains(new String(ans)))
            return true;
            else
            return false;
        }
        ans[idx]=ch[0];
        if(generate(set, ans, ch, idx+1, n)==true) return true;
        ans[idx]=ch[1];
        if(generate(set, ans, ch, idx+1, n)==true) return true;
        return false;
    }
    public String findDifferentBinaryString(String[] nums) {
        Set<String>set=new HashSet<>();
        char ch[]=new char[2];
        ch[0]='0';
        ch[1]='1';
        int n=nums.length;
        for(String s: nums){
            set.add(s);
        }
        
        char ans[]=new char[n];
        generate(set, ans, ch, 0, n);
        return (new String(ans));
    }   
}*/ 