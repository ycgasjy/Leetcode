class Solution {
public:
    inline int min3(int a, int b, int c){
        int tmp=a<b?a:b;
        return tmp<c?tmp:c;
    }
    int nthUglyNumber(int n) {
        int* result_list;
        if(!(result_list=(int*)malloc(n*sizeof(int)))){
            exit(-1);
        }
        int idx2=0;
        int idx3=0;
        int idx5=0;
        result_list[0]=1;
        int counter=1;
        while(counter<n){
            int nxt2=2*result_list[idx2];
            int nxt3=3*result_list[idx3];
            int nxt5=5*result_list[idx5];
            int min=min3(nxt2,nxt3,nxt5);
            if(min==nxt2)
                idx2++;
             
            if(min==nxt3)
                idx3++;
            
            if(min==nxt5)
                idx5++;
            result_list[counter++]=min;

        }
        
        
        return result_list[n-1];
        
        
    }
    
};