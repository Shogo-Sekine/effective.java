public interface Operation{
  PLUS("+"){
    public double apply(double x, double y){
      return x + y;
    },
  }
}
