//「不変」期間クラス
public final class Period{
  private final Date start;
  private final Date end;

  /**
   * @param start 期間の開始
   * @param end 期間の終わりで。開始より前であってはならない
   * @throws IllegalArgumentException startがendの後の場合
   * @throws NullPointerException startかendがnullの場合
   */
   public Period(Date start, Date end){
     this.start = new Date(start.getTime());
     this.end = new Date(end.getTime());

     if(this.start.compareTo(this.end) > 0)
     throw mew IllegalArgumentException(this.start + " after " + this.end);
   }

   public Date start(){
     return new Date(start.getTime());
   }

   public Date end(){
     return new Date(end.getTime());
   }


...//残りは省略

}
