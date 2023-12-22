package model;

public class ImageModel 
{
	private int num;
	
	public ImageModel()
	{
		this.num=0;
	}
	
	public void setNum(int num)
	{
		this.num=num;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public void increase()
	{
		this.num= (num+1)%9;
	}
	
	public void decrease()
	{
		this.num--;
		if (num<0)
			num=8;
	}
}
