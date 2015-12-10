import java.util.*;
class op{
	long op_val;
	int op_start_pos;
	int op_end_pos;
}

public class Solution { 
	List<String> expr_list;
	public op FindFirstOperand(String expression,int mul_pos){
		int i;
		op ret=new op();
		for(i=mul_pos-1;i>=0;i--){
			if(expression.charAt(i)=='-' || expression.charAt(i)=='+')
				break;
		}
		ret.op_start_pos=i+1;
		ret.op_end_pos = mul_pos-1;
		ret.op_val=Long.parseLong(expression.substring(ret.op_start_pos,ret.op_end_pos+1));
		return ret;
	}
	public op FindSecondOperand(String expression,int mul_pos){
		int i;
		op ret=new op();
		for(i=mul_pos+1;i<=expression.length()-1;i++){
			if(expression.charAt(i)=='-' || expression.charAt(i)=='+' || expression.charAt(i)=='*')
				break;
		}
		ret.op_end_pos=i-1;
		ret.op_start_pos = mul_pos+1;
		ret.op_val=Long.parseLong(expression.substring(ret.op_start_pos,ret.op_end_pos+1));
		return ret;
	}
	public op FindNextOperand(String expression,int pos){
		int i;
		op ret=new op();
		for(i=pos+1;i<=expression.length()-1;i++){
			if(expression.charAt(i)=='-' || expression.charAt(i)=='+')
				break;
		}
		ret.op_end_pos=i-1;
		ret.op_start_pos = pos+1;
		ret.op_val=Long.parseLong(expression.substring(ret.op_start_pos,ret.op_end_pos+1));
		return ret;
	}
	public String evaluteMul(String expression){
		int i=0;
		op op1,op2;
		long result;
		for(i=0;i<expression.length();i++){
			if(expression.charAt(i)=='*'){
				op1=FindFirstOperand(expression,i);
				op2=FindSecondOperand(expression,i);
				result=op1.op_val*op2.op_val;
				if(op2.op_end_pos==expression.length()-1)
					return expression.substring(0,op1.op_start_pos)+Long.toString(result);
				else
					return expression.substring(0,op1.op_start_pos)+Long.toString(result)+expression.substring(op2.op_end_pos+1);
			}
		}
		return expression;
	}
	public long evaluateExpression(String expression){
		//evaluate the results in the expression
		int i=0;
		//find all the multiplier
		String cur_expr=new String(" ");
		String nxt_expr=new String(expression);
		String acc=new String("");
		long acc_val;
		op op_next=new op();
		while(cur_expr.equals(nxt_expr)==false){
			cur_expr=nxt_expr;
			nxt_expr=evaluteMul(cur_expr);
		}
		//now only + and - are left in cur_expr
		//Find the first operand
		while(i<cur_expr.length() && (cur_expr.charAt(i)>='0' && cur_expr.charAt(i)<='9')){
			acc=acc+cur_expr.charAt(i);
			i++;
		}
		acc_val=Long.parseLong(acc);
		while(i<cur_expr.length()){
			op_next=FindNextOperand(cur_expr,i);
			if(cur_expr.charAt(i)=='+'){
				
				acc_val+=op_next.op_val;
			}
			else{
				acc_val-=op_next.op_val;
			}
			i=op_next.op_end_pos+1;			
		}
		return acc_val;
	}
	public void generate_expr(String num,int insert_pos,String cur_string){
		if(insert_pos==cur_string.length()-1)
			expr_list.add(cur_string);
		else{
			String tmp_string=new String(cur_string);
			generate_expr(num,insert_pos+1,tmp_string);
			tmp_string=cur_string.substring(0,insert_pos+1)+"+"+cur_string.substring(insert_pos+1);
			generate_expr(num,insert_pos+2,tmp_string);
			tmp_string=cur_string.substring(0,insert_pos+1)+"-"+cur_string.substring(insert_pos+1);
			generate_expr(num,insert_pos+2,tmp_string);
			tmp_string=cur_string.substring(0,insert_pos+1)+"*"+cur_string.substring(insert_pos+1);
			generate_expr(num,insert_pos+2,tmp_string);
			
		}
	}
	
    public List<String> addOperators(String num, long target) {
        expr_list=new ArrayList<String>();
        generate_expr(num,0,num);
        for(Iterator<String> iter=expr_list.listIterator();iter.hasNext();){
        	String cur=iter.next();
        	long result=evaluateExpression(cur);
        	if(target!=result){
        		iter.remove();
        	}
        }
        return expr_list;
    }
    public static void main(String[] args){
    	Solution sol=new Solution();
    	List<String> LIST=sol.addOperators("3456237490",9191);
    	for(Iterator<String> iter=LIST.listIterator();iter.hasNext();){
        	String cur=iter.next();
        	System.out.println(cur);
        }
    	System.out.println("done");
    	
    	
    	
    }
}
