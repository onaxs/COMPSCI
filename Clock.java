public class Clock{
	int hour;
	int minute;
	int second;


	public Clock(){
		hour = 0;
		minute = 0;
		second = 0;
	}

	public Clock(h,m,s){
		hour = h;
		minute = m;
		second = s;
	}

	public int getHour(){
		return hour;
	}

	public int getMinute(){
		return minute;
	}

	public int getSecond(){
		return second;
	}

	public void setHMS(int h, int m, int s){
		hour = h;
		minute = m;
		second = s;
	}

	public void addHour(){
		hour += 1;
		if hour > 12
			hour %= 12;
	}
	//I'm not sure how to do the tostring() method but this is everything else
}