package com.socialnetworktask;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SocialTaskMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] words = value.toString().split(" ");
		
		try{
			context.write(new Text(words[0]),new Text(words[1]));
		}
		catch(Exception e){
			System.out.println("Person with no friends"+words[0]);
		}
		
	}
}
