package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;


public class QRCheckService {

	
//	private int QRPercent=50;
//	private int BucketSize=10;
//	private int counter=0;
	/*private int TotalSentToQR=0;
	
	boolean ProbabilityGenerator() {
		boolean b=Math.random() < 0.5;
		return b;
	}
	
	public void RollingBucketlogic() {
		
		int BucketSize=10;
		
		int QRPercent=20;
		int counter=0;
		int array[]=new int[50];
		int loopcount=1;
		int j=0;
		System.out.println("BucketSize is: "+BucketSize);
//		int j=0;
		
		for(int i=0;i<50;i++) {
			
			j++;
			String wr="WR";	
			wr=wr.concat(Integer.toString(i));
		
			
			int diff=BucketSize-i;
			if(i>BucketSize) {
				
				diff=i-BucketSize;
			   if(array[i-BucketSize]==1) {
				   
				   counter--;
				   
				   System.out.println("Decremented counter value for i=: "+i);
			   }
		   }
			
			if(j==BucketSize) {
				loopcount++;
				j=0;
			}

			
			   System.out.println("\nFor request "+i+" counter value is: "+counter);
			   System.out.println("\nTotal processed wrs: "+i);

			   int min_value=Math.min(BucketSize, i);
			   int QRsendcount=(QRPercent*min_value)/100;
			   if(min_value%2!=0 && QRPercent>50) {
				   QRsendcount++;
			   }
			   int QRsendcountforcurrentbucket=(QRPercent*BucketSize)/100;
			   
			   
			   System.out.println("QRSendcount: "+QRsendcount);

//			   System.out.println("Number of wrs remaining to be sent to QR: "+(QRsendcount-counter));
			
//			   if((QRsendcount-counter)==0) {
//				if((QRsendcount-counter)<=(min_value-j)) {
				
			   if((QRsendcountforcurrentbucket-counter)<=(diff)) {

			   
			   boolean b;
			
			   if(counter<=QRsendcount) {
				
				   if((b=ProbabilityGenerator())==true) {
				//Send to QR for review by updating wrs_sentto_qr
					counter++;
					System.out.println(wr+" Sent to QR: Updated counter: "+counter+"\n");
					array[i]=1;
					TotalSentToQR++;
				   }else {
				
					System.out.println(wr +" Not Sent: Counter:"+counter);
					array[i]=0;
				   }
			
			   }else {
				
				System.out.println(wr +" Not Sent: Counter:"+counter);
				array[i]=0;
				
				}
		
		}else {
			   
			   counter++;
				System.out.println(wr+" Sent to forcefully QR: Updated counter: "+counter+"\n");
				array[i]=1;
				TotalSentToQR++;
		}
		}
			
			
//	j++;	
//	if(j==BucketSize) {
//		j=0;		
//	}
 
		System.out.println(" Total Sent: "+TotalSentToQR);


	
	
}
	/*public void newservice(WorkObject wo, int workrequestcount,int BucketSize,int QRPercent) {
		
		
		
		try {

			
			System.out.println("BucketSize is: "+BucketSize);
			
			int Random = (int)(Math.random()*100);
			System.out.println("Random number is:"+Random);
			
			int QRsend=(QRPercent*BucketSize)/100;
			System.out.println("Number of wrs to be sent to QR: "+QRsend);
			System.out.println(QRPercent);
			if(Random<=QRPercent) {
			
				System.out.println(wo.getWrokrequests()+" Send to QR: ");
				BucketSize--;
				QRsend--;
				QRPercent=(QRsend*100)/BucketSize;
				System.out.println(BucketSize+" "+QRsend+""+" QRPercent after sending:"+QRPercent+"\n");
				
			}else {
				System.out.println(wo.getWrokrequests()+" Not sent to QR: ");
				BucketSize--;
				QRPercent=(QRsend*100)/BucketSize;
				System.out.println("QRPercent after not sending: "+QRPercent+"\n");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}*/
	
	
	
/*	public void service(WorkObject wo,int total_processed_wrs) {
		
		 int wrs_sentto_qr=0;

		try {
			
			FileReader f=new FileReader("application.properties");
			Properties p=new Properties();
			p.load(f);
			
			String bs="BucketSize"+wo.getWorkRequestType()+wo.getUser();
			System.out.println("\n"+bs);
			
			int BucketSize=Integer.parseInt(p.getProperty(bs));
			System.out.println("BucketSize is: "+BucketSize);
			System.out.println("Total processed wrs: "+total_processed_wrs);

			int QRPercent=Integer.parseInt(p.getProperty("QRPercent"));
			
			int min_value=Math.min(BucketSize, total_processed_wrs);
			int QRsend=(QRPercent*min_value)/100;
			System.out.println("Number of wrs to be sent to QR: "+QRsend);
			
			if(BucketSize<total_processed_wrs) {
			
				List<String> all_wrs=wo.getWrokrequests();
				int start=0;
				int last=BucketSize;
				int k=0;
				while(last>start) {
					
					k++;
//					int min_value2=Math.min(BucketSize, (total_processed_wrs-BucketSize));
//					int QRsendsent=(QRPercent*min_value2)/100;
//					
//					System.out.println("Number of wrs to be sent to QR: "+QRsend);
					
				int wrcount=0;
				
				for(int i=start;i<last;i++) {
					
					
					boolean b;
					wrcount++;
					System.out.println("wr= "+wo.getWrokrequests().get(i)+" wrs_sentto_qr="+wrs_sentto_qr);
					
					if((QRsend-wrs_sentto_qr)<=(min_value-wrcount)) {
						
					
						if(wrs_sentto_qr<QRsend) {
						
					
							if((b=ProbabilityGenerator())==true) {
							//Send to QR for review by updating wrs_sentto_qr
								wrs_sentto_qr++;
								System.out.println(all_wrs.get(i)+" Sent to QR: Updated count wrs_sentto_qr: "+wrs_sentto_qr+"\n");
						
							}else {
							
								System.out.println(all_wrs.get(i)+" Not Sent");
							}
						
						}
						
					}else {
						//Send to QR
						wrs_sentto_qr++;
						System.out.println(all_wrs.get(i)+"Sent to QR forced: "+wrs_sentto_qr);

						
					}
					
					
				}
			
				wrs_sentto_qr=0;
				start=last;
				last+=BucketSize;
				if(last<all_wrs.size()) {
					
				}else {
					last=all_wrs.size();
				}
				QRsend=(QRPercent*(total_processed_wrs-BucketSize))/100;
				total_processed_wrs-=BucketSize;
				}
				
			}else {
				
				int wrcount=0;
			
				for(String w:wo.getWrokrequests()) {
				
					boolean b;
					wrcount++;
					System.out.println("wr= "+w+" QRwrs_sentto_qr="+wrs_sentto_qr);
				
					if((QRsend-wrs_sentto_qr)<=(min_value-wrcount)) {
					
				
						if(wrs_sentto_qr<QRsend) {
					
				
							if((b=ProbabilityGenerator())==true) {
						//Send to QR for review by updating wrs_sentto_qr
								wrs_sentto_qr++;
								System.out.println(w+" Sent to QR: "+wrs_sentto_qr+"\n");
							

							}else {
						
								System.out.println(w+" Not Sent");
							}
					
						}
						
					}else {
					//Send to QR
					wrs_sentto_qr++;
					System.out.println(w+"Sent to QR forcefully: Updated count wrs_sentto_qr: "+wrs_sentto_qr);

					
				}
//				System.out.println(w+"Not Sent");

			}
			
			}
		
		}catch(Exception e) {
			
			System.out.println("Error in reading file"+e);
			
		}
		
	}*/
	
	
}
