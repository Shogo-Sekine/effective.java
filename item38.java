/**
*値が(this mod m)であるBigIntegerを返します。このメソッドは、
*remainderメソッドとは異なり、常に負ではないBigIntegerを返す。
*
*@param m 正でなければならないモジュラス
*@returun this mod m.
*@throws ArithmeticException m <= 0の場合
*/

public BigInteger　mod(BigInteger m){
  if(m.signum() <= 0)
    throw new ArithmeticException("Modulus <= 0:" + m);
    ... //計算を行う
}

//再帰的ソートのためのprivateのヘルパー関数
private static void sort(long a[], int offset, int length){
  assert a != null;
  assert offset >= 0 && offset <= a.length;
  assert length >= 0 && length <= a.length - offset;
  ... //計算を行う

}
