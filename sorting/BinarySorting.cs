using System;
using static System.Console;
//Recurs 
class Program
    {
        
        static void Main(string[] args)
        {
            int[] arr = { 1, 3, 5, 7, 9, 11 };
            int val;
            while (true) {
                val = Int32.Parse(ReadLine());
                int res = TreeRecurcion(arr, val, 0, arr.Length);
                string ress = res == -1 ? "Not found" : res.ToString();
                WriteLine(ress);
            }
        }
        static int TreeRecurcion(int[] arr, int val, int low, int high)
        {
            int mid=(low + high)/2; // update middle
            // check the middle point for quik return
            if (arr[mid] == val) return mid; 

            if (low <= high) // limit recursion 
            {
                if (val > arr[mid]) 
                {
                    low = mid + 1;
                    return TreeRecurcion(arr, val, low, high);
                }
                else
                {
                    high = mid - 1;
                    return TreeRecurcion(arr, val, low, high);
                }
                 
            }
            //if(arr[mid] == val) { return res; }

            return -1;
        }
        
    } 
