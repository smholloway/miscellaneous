#include <stdio.h>

int main()
{
	printf("To compile and run simply type: \"gcc swap.c -o swap.exe && ./swap.exe\"\n");

	int a = 0;
	int b = 1;
	printf("a = %d\nb = %d\n", a, b);
	swap(&a, &b);
	printf("a = %d\nb = %d\n", a, b);

	return 0;
}

int swap(int *a, int *b)
{
	swap_standard(a, b);
	//swap_xor(a, b);
	//swap_fail(a, b);

	return 0;
}

int swap_fail(int *a, int *b)
{
	return 0;
}

int swap_standard(int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;

	return 0;
}

int swap_xor(int *a, int *b)
{
	*a ^= *b;
	*b ^= *a;
	*a ^= *b;

	return 0;
}
