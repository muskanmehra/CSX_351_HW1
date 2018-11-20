
            import java.io.*;
                      public class  HW1 {
                           char grade (int pct){//for calculating grades
                                       if(pct>=90 && pct<=100)
			return 'A';
		else if(pct>=78 && pct<=89)
			return 'B';
		else if(pct>=62 && pct<=77)
			return 'C';
		else if(pct>=46 && pct<=61)
			return 'D';
		else
			return 'F';
	}
	int maxpt(int arr[]){ //maximum points
	      for(int i=0;i<50;i++)
		{
			for(int j=0;j<50-i-1;j++)
			{
                                                  if(arr[j]>arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
			}
			}
		}
		System.out.println(arr[49]);
		return arr[49];
		
	}
	public static void main(String[] args) {
		File f=new File("C:\\JAVA LAB\\HW1-data.txt");
		try{
		File f1=new File("C:\\JAVA LAB\\HW1-report.txt");
		f1.createNewFile();
		FileWriter f2=new FileWriter(f1);
		BufferedWriter f3=new BufferedWriter(f2);
		f3.write("stdnt ID Ex ------- Assignments --------- Tot Mi Fin CL Pts Pct Gr");
		//System.getProperty( "line.separator");
		f3.newLine();
		f3.append("-------- -- ----------------------------- --- -- --- -- --- --- --");
		FileReader f5=new FileReader(f);
		BufferedReader f4=new BufferedReader(f5);
		String s;
		int i=0,tot=0,mi=0,fin=0,cl=0,pts=0,ex=0, pct=0;
		while((s=f4.readLine())!=null)
		{
			f3.newLine();
			String[] arr=s.split("\\s");//splits the line when space encountered
			//f3.append(s, 0, 41);
			for(i=0;i<12;i++)
			{
				f3.append(arr[i]+" ");
			}
			tot=0;mi=0;fin=0;cl=0;pts=0;ex=0; pct=0;
			for( i=2;i<12;i++)
			{
				tot+=Integer.parseInt(arr[i]);

			}
			ex=Integer.parseInt(arr[1]);
			mi=Integer.parseInt(arr[12]);
			fin=Integer.parseInt(arr[13]);
			cl=Integer.parseInt(arr[14]);
			
			
			pts=tot+ex+mi+fin+cl;
			String tot1=String.valueOf(tot);
			String pts1=String.valueOf(pts);
			f3.append(tot1+" ");
			f3.append(s,42,50);
			f3.append(" "+pts1+" ");
			float pts2=pts;
			float cl2=cl;
			pct=Math.round((((pts2-cl2)*100)/420));
			String pct1=String.valueOf(pct);
			f3.append(pct1+" ");
			HW1 obj=new HW1();
			char ch=obj.grade(pct);
			f3.append(" "+ch);
		}
		f3.close(); f4.close();
         //PART B	
		FileReader f6=new FileReader(f1);
		BufferedReader f7=new BufferedReader(f6);
		FileWriter f8=new FileWriter(f1,true);
		BufferedWriter f9=new BufferedWriter(f8);
		String s1;
		float avg=0;
		int c=0,ca=0,cb=0,cc=0,cd=0,cf=0,max=0;
		f7.readLine();
		f7.readLine();
		int arr[]=new int[50];
		i=0;
		while((s1=f7.readLine())!=null)
		{
		
			String[] arr1=s1.split("\\s");
			//System.out.println(arr1[17]);
			avg+=Float.parseFloat(arr1[17]);
			 ++c;
			 String ch=String.valueOf(arr1[19]);
			 switch(ch)
			 {
			 case "A": ++ca;
			 	break;
			 case "B":++cb;
			 	break;
			 case "C":++cc;
			 	break;
			 case "D":++cd;
			 	break;
			 case "F":++cf;
			 }
			 
			 arr[i++]=Integer.parseInt(arr1[16]);
		}
		HW1 obj1=new HW1();
		  max=obj1.maxpt(arr);
		float a=avg/c;
		String avg1=String.valueOf(a);
		f9.newLine();
		f9.append("summary");
		f9.newLine();
		f9.append("avg pct of students:");
		f9.append(avg1);
		f9.newLine();
		f9.append("No. of A's:"+String.valueOf(ca));
		f9.newLine();
		f9.append("No. of B's:"+String.valueOf(cb));
		f9.newLine();
		f9.append("No. of C's:"+String.valueOf(cc));
		f9.newLine();
		f9.append("No. of D's:"+String.valueOf(cd));
		f9.newLine();
		f9.append("No. of F's:"+String.valueOf(cf));
		f9.newLine();
		f9.append("maximum pts:"+String.valueOf(max));
                          f6.close();
		f7.close();
		f9.close();
	}
		catch(IOException e )
		{
			
		}
		
		
	}

}
