class Solution {
public:

    string addStrings(string num1, string num2) {
	    string small;
	    string big;
	    if (num1.size() <= num2.size()){
		    small = num1;
		    big = num2;
	    }
	    else{
		    small = num2;
		    big = num1;
	    }
	    string ret(big.size() + 1, ' ');
	    bool carry = false;
	    bool next_carry = false;
	    int i;
	    for (i = 0; i<small.size(); ++i){
		    int res = (small[small.size() - 1 - i] - '0') + (big[big.size() - 1 - i] - '0')+carry;
		    if (res >= 10){
			    next_carry = true;
			    res = res - 10;
		    }
		    else{
			    next_carry = false;
		    }
		    ret[big.size() - i] = (char)res + '0';
		    carry = next_carry;
	    }
	    for (; i<big.size(); ++i){
    
	    	if (carry){
		    	if (big[big.size() - 1 - i] == '9'){
			    	carry = true;
				    ret[big.size() - i] = '0';
    			}
	    		else{
		    		ret[big.size() - i] = big[big.size() - 1 - i] + 1;
			    	carry = false;
    			}
    		}
	    	else{
		    	carry = false;
			    ret[big.size() - i] = big[big.size() - 1 - i];
    		}
	    }
    	if (carry){
	    	ret[0] = '1';
		    return ret;
    	}
	    else{
		    return ret.substr(1, big.size());
    	}
    }
};
