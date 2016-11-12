class Solution {
public:
    int thirdMax(vector<int>& nums) {
        int minMax=     -2147483648	;
        bool minMax_exist=false;
        int FirstMax=	minMax;
        int SecondMax= 	minMax;
        int ThirdMax=   minMax;
        for(int i=0;i<nums.size();++i){
            if(nums[i]==minMax)
                minMax_exist=true;
            if(nums[i]>FirstMax){
                ThirdMax=SecondMax;
                
                SecondMax=FirstMax;
                FirstMax=nums[i];
                
                
            }
            else if(nums[i]>SecondMax && nums[i]!=FirstMax){
                ThirdMax=SecondMax;
                SecondMax=nums[i];
                
            }
            else if(nums[i]>ThirdMax && nums[i]!=FirstMax && nums[i]!=SecondMax){
                ThirdMax=nums[i];
            }
        }

        if(SecondMax==minMax ){
            return FirstMax;
        }
        else if(ThirdMax==minMax){
            if(minMax_exist)
                return minMax;
            else
                return FirstMax;
        }
        else if(ThirdMax==SecondMax){
            return FirstMax;
        }
        else 
            return ThirdMax;
        
        
        
    }
};