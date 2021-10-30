public static void quickSort(int[] array, int low, int high)
        {
            if (array.Length == 0)
                return;//завершить выполнение, если длина массива равна 0

            if (low >= high)
                return;//завершить выполнение если уже нечего делить

            // выбрать опорный элемент
            int middle = low + (high - low) / 2;
            int opora = array[middle];

            // разделить на подмассивы, который больше и меньше опорного элемента
            int i = low, j = high;
            Write(i + " :I and J: " +j + " ");
            while (i <= j)
            {
                while (array[i] < opora)
                {
                    i++;
                }

                while (array[j] > opora)
                {
                    j--;
                }

                if (i <= j)
                {//меняем местами
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
            Write(i);
            // вызов рекурсии для сортировки левой и правой части
            if (low < j) 
            { 
                Write("Recurtion LEFT j={0}\n",j); 
                quickSort(array, low, j);
            }


            if (high > i)
            {
                Write("Recurtion RIGHT i={0}\n ", i);
                quickSort(array, i, high);
            }
        }
