package university;

public class AdminDefaults {
	public static int inentrytimeout,outentrytimeout,nooftests;
	public static int workinghours;
	public static int workingdays;
	public static String passcode;
	public static void setDetails(int n1,int n2,int n3,int n4,int n5,String n6)
	{
		inentrytimeout=n1;
		outentrytimeout=n2;
		nooftests=n3;
		workinghours=n4;
		workingdays=n5;
		passcode=n6;
	}
}
