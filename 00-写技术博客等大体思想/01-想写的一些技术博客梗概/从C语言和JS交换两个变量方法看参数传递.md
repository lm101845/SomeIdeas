# 从C语言和JS交换两个变量方法看参数传递

C语言要交换2个参数，必须要借助指针，代码如下：

~~~c
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void Swap(int* pa, int * pb)
//pa未来有能力找到a,pb未来有能力找到b
//这样Swap函数定义和函数调用之间就有了联系
{
	int z = 0;
	z = *pa;
	*pa = *pb;
	*pb = z;
}

int main()
{
	int a = 10;
	int b = 20;
	//写一个哈函数 - 交换2个整型变量的值

	printf("交换前：a=%d b=%d\n", a, b);
	Swap(&a, &b);
	printf("交换后：a=%d b=%d\n", a, b);
	system("pause");
	return EXIT_SUCCESS;
}
~~~

JS交换2个参数，它是按值传递的，JS也没有指针概念，代码如下：

~~~javascript
    <script>
        function swap(x,y){
            console.log("x,y原来的值为" + x + y)
            let temp = x;
            x = y;
            y = temp;
            console.log("x,y交换后的值为" + x + y);  //这里确实是交换了
        }
        let a = 10;
        let b = 20;
        console.log("没交换前a,b的值为" + a + "," + b);
        swap(a,b);
        console.log("交换后a,b的值为" + a + "," + b + "这个也没变啊");
    </script>
~~~

啊，这个封装函数之后变量也没变啊。