package City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class City {
	//设置单独的hashmap 每一张hashmap到自己都是0然后到别人有距离
	//第一次输入城市名字的时候就要把value给定下来
	//第一次输入距离的时候就要给第一个hashmap 赋值
	//第二次第三次一次给另外的hashmap对象赋值，但是确保第一次的name都是一样的
	//最后当输入value 的时候我们来确定距离
	HashMap<Integer,String> CityMap = new HashMap<Integer,String>();
	public void setCity(int key,ArrayList<String> s,int i) {
		CityMap.put(key, s.get(i));
	}
	

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> s = new ArrayList<String>();
		//输入城市名字
		for(;;) {
			String a = in.next();
			if(a.equals("###")) 
				break;
			s.add(a);
		}
		//创建city数组
		City[] city = new City[s.size()];
		//输入距离
		for(int m = 0;m< s.size();m++){
			//为每个数组实例化
			city[m] = new City();
			for(int i = 0;i < 3;i++) {
				//为city的hash表赋值
				city[m].setCity(in.nextInt(), s, i);
			}
		}
		//检测距离
		String b = in.next();
		for(int i = 0;i<city.length;i++) {
			//找到距离为0的城市的对象
			if(city[i].CityMap.get(0).equals(b)) {
				//在这个对象里面找到对应距离的城市，然后输出距离
				String c = in.next();
				for(Integer k : city[i].CityMap.keySet()) {
					if(city[i].CityMap.get(k).equals(c)) {
						System.out.println(k);
						}
					}
				}
		}
		
		
	}
}
