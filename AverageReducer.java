package stubs;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {
	private DoubleWritable averageLength = new DoubleWritable();
  @Override
  	public void reduce(Text key, Iterable<IntWritable> values, Context context)
     throws IOException, InterruptedException {
	  
	  double count = 0;
	  double sum = 0;
	  for (IntWritable value:values){
    	count += 1;
    	sum += value.get();
	  }
	  averageLength.set(sum/count);
	  context.write(key, averageLength);
  }
}