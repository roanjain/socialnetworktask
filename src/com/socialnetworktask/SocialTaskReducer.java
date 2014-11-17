package com.socialnetworktask;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SocialTaskReducer extends Reducer<Text, Text, Text, IntWritable> {

	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		int friendsCount=0 ;
		for(Text val:values){
			friendsCount++;
		}
		
		context.write(key, new IntWritable(friendsCount));
	}
}
