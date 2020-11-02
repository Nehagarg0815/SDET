import java.util.Arrays;

public class Activity1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] arrnum = {6,8,2,1,5};
ascendingSort(arrnum);
System.out.println("Array string in Ascending order: ");
System.out.println(Arrays.toString(arrnum));
	}
static void ascendingSort(int array[])
{
	int size = array.length, i;
	for(i=1; i<size; i++)
	{
		int key = array[i];
		int j = i-1;
		while (j>=0 && key< array[j])
		{
			array[j+1]= array[j];
			--j;
		}
		array[j+1]=key;
	}
}
}
