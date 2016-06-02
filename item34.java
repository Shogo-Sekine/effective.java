//インタフェースを使用して模倣された拡張可能なenum
public interface Operation{
  double apply(double x, double y);
}

public enum BasicOperation implements Operation{
  PLUS("+"){
    public double apply(double x, double y){
      return x + y;
    }
  },
  PLUS("-"){
    public double apply(double x, double y){
      return x - y;
    }
  },
  PLUS("*"){
    public double apply(double x, double y){
      return x * y;
    }
  },
  PLUS("/"){
    public double apply(double x, double y){
      return x / y;
    }
  };

  private final String symbol;
  BasicOperation(String symbol){
    this.symbol = symbol;
  }

@Override public String toString(){
  return symbol;
}

}


//模倣された拡張enum

public enum ExtendedOperation implements Operation{
  EXP("^"){
    public double apply(double x, double y){
      return Math.pow(x, y);
    }
  },

  EXP("%"){
    public double apply(double x, double y){
      return x % y;
    }
  };

  private final String symbol;
  ExtendedOperation(String symbol){
    this.symbol = symbol;
  }

  @Override public String toString(){
    return symbol;
  }



}
