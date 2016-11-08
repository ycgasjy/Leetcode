class Solution {
public:
    int min(int* ugly_num_list,int* base_index_list, vector<int>& primes) {
        int min= 2147483647;
        for(int i=0;i<prims.size();++i){
            if(min<ugly_num_list[base_index_list[i]]*primes[i])
                min=ugly_num_list[base_index_list[i]]*primes[i];
        }
        return min;
    }
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        int* ugly_num_list;
        if(!(ugly_num_list=(int*)malloc(n*sizeof(int)))){
            exit(-1);
        }
        ugly_num_list[0]=1;
        int count=1;
        int* base_index_list;
        if(!(base_index_list=(int*)malloc(primes.size()*sizeof(int)))){
            exit(-1);
        }
        for(int i=0;i<primes.size();++i){
            base_index_list[i]=0;
        }
        while(count<n){
            int min=min(ugly_num_list,base_index_list,primes);
            for(int i=0;i<primes.size();++i){
                if(ugly_num_list[base_index_list[i]]*primes[i]==min){
                    base_index_list[i]++;
                }
            }
            ugly_num_list[count]=min;


            count++;
        }

        return ugly_num_list[n-1];
    }
};
