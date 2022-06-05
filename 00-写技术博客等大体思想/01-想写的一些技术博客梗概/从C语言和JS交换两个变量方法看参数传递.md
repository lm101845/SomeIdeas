# 从C语言和JS交换两个变量方法看参数传递

C语言要交换2个参数，必须要借助指针，不写指针的这种写法是不行的：

~~~c
//函数返回类型的地方写出：void，表示这个函数不返回任何值，也不需要返回
//写出问题了！——交换的是形参x,y的值，不是a,b的值
void Swap(int x, int y)
//这里x变成了10,y变成了20，说明实参a确实把值传给了形参x,实参b确实把值传给了形参y
//但是x的地址和a的地址不一样，y的地址和b的地址不一样
//代码里面又开辟了空间创建了z，借助z把x,y的值进行了交换，但是你是影响不了a,b的
{
	int z = 0;
	z = x;
	x = y;
	y = z;
	printf("%d%d\n", x, y);
}
int main()
{
	int a = 10;
	int b = 20;
	//当我们创建a,b两个变量的时候，他们在内存里开辟了2块空间，a和b
	//写一个函数，交换2个整型变量的值
	printf("交换前：a=%d b=%d\n", a, b);
	Swap(a, b);
	printf("交换后：a=%d b=%d\n", a, b);

	//但是直接写常量的话，是可以直接替换的
	Swap(1, 2);
	system("pause");
	return EXIT_SUCCESS;
}
~~~

正确的代码如下：

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
		swap(1,2);  //但是直接写常量的话，是可以正常交换的
    </script>
~~~

啊，这个封装函数之后变量也没变啊。