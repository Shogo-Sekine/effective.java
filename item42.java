//可変長引数の単純な利用
static int sum(int... args){
  int sum = 0;
  for(int arg : args)
    sum += arg;
  return sum;
}

//1個以上の引数を渡すための正しい可変長引数の利用方法

static int min(int firstArg, int... remainingArgs){
  int min = firstArg;
  for(int arg : remainingArgs)
    if(arg < min)
      min = arg;
    return min;
}
