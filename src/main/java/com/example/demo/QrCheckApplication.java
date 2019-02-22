package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

//@SpringBootApplication
public class QrCheckApplication {

	public static void main(String[] args) {
		
//		String user="Akarsha";
//		List<String> list=new ArrayList<String>();
		
	double bucketsize=20;
	double QRPercent=70;
	int  counter=0,j=0,k=0;
	double QRfirst=(int) Math.ceil((QRPercent*bucketsize)/100);

	int array[]=new int[20];
	//2nd logic
	
		for(int i=0;i<20;i++) {
			
//			j++;
			
			String wr="WR";
//
			wr=wr.concat(Integer.toString(i));
			System.out.println(wr);
			
			
			
			
			
			
			
			if(j>bucketsize) {
				k++;
				System.out.println("Bucket number:"+(k+1));
				
				j=0;
				
				
			}
			
			
			if(counter==QRfirst) {
				break;
			}
			 
			
			
			try {

				
				System.out.println("BucketSize is: "+bucketsize);
				
				int Random = (int)(Math.random()*100);
				System.out.println("Random number is:"+Random);
				
				double QRsend=(int) Math.ceil((QRPercent*bucketsize)/100);
				
				if(QRsend!=0) {

				System.out.println("Number of wrs to be sent to QR: "+QRsend);
				System.out.println("QRPercent: "+QRPercent);
				
				if(Random<=QRPercent) {
				
					System.out.println(wr+" Send to QR: ");
					bucketsize--;
					QRsend--;
					counter++;
					
					QRPercent=Math.round((QRsend*100)/bucketsize);
					System.out.println(bucketsize+" "+QRsend+""+" QRPercent after sending:"+QRPercent+"\n");
					
				}else {
					System.out.println(wr+" Not sent to QR: ");
					bucketsize--;
					QRPercent=Math.round((QRsend*100)/bucketsize);
					System.out.println(bucketsize+" "+QRsend+""+" QRPercent after not sending:"+QRPercent+"\n");
				}
				
				}else {
					System.out.println(" All processing done");break;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("counter:"+counter);	

	

	}

	}

