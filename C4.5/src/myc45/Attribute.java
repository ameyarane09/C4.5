package myc45;

import java.util.ArrayList;
import java.util.List;


public class Attribute {
	public String       name   = new String();
	public List<Values> values = new ArrayList<Values>();
	public double       gain   = 0.0;
	
	public static ArrayList<Comparable> list = new ArrayList<Comparable>();
	
	public Attribute()
	{}
	
	public Attribute(String name){
		this.name = name;
	}
	
	public void setGain(double IofD, int totalNumClasses){
		int totalValClasses = 0;
		for(Values v : values){
			v.setGain();
			for(int i : v.classesCount){
				totalValClasses += i;
			}
			gain += (totalValClasses/(double)totalNumClasses) * v.gain;
			totalValClasses = 0;
		}
		this.gain = IofD - this.gain;
	}
	
	public void insertVal(Val inVal){
		if(this.values.isEmpty()){
			values.add(new Values(inVal.valueName, inVal.itClass));
		}
		else{
			for(Values v : values){
				if(v.valueName.equals(inVal.valueName)){
					v.update(inVal);
					return;
				}
			}
			values.add(new Values(inVal.valueName, inVal.itClass));
		}
	}
	
	public String toString(){
		String out = new String("attribute: " + this.name + "\n");
		int n[]=new int[2];
		int sum=0;
		int k=0;
		//double p;
		for(Values v : values){
			out += "\tvalue: " + v.valueName + ", ";
			list.add(v.valueName);
			out += "\n\t\tclasses: ";
			for(String c : v.classes){
				out += c + ", ";
			}
			out += "\n\t\tcounts: ";
			for(Integer i : v.classesCount){
				//out += i + ", ";
				n[k] = Integer.valueOf(i);
				//System.out.println("n = "+n[k]);
				sum += n[k];
				k++;
				if(k==2)
				{
					double p = (double)n[0]/(double)sum;
					//double p = 0.002134;
					/*System.out.println(sum);
					System.out.println(n[0]);*/
					p=p*100;
					list.add(p);
					//double roundOff = (double)Math.round(p*100)/100;
					out += p+"%";
					//p=0;
					k=0;
					sum=0;
				}
			}
			out += "\n";
		}
		//System.out.println(list);
		return out;
	}

}
