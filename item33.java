public class Herb{
  public enum Type{
    ANNUAL, PERENNIAL, BIENNIAL
  }

  private final String name;
  private final Type type;

  Herb(String name, Type type){
    this.name = name;
    this.type = type;
  }

  @Override public String toString(){
    return name;
  }
}
Herb[] garden = ... ;

Map<Herb.Type, Set<Herb>> herbsByType =
  new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
for(Herb.Type t : Herb.Type.values())
  herbsByType.put(t, new HashSet<Herb>());
for(Herb h : garden)
  herbsByType.get(h.type).add(h);
System.out.println(herbsByType);


//データとenumの組を関連付ける為にネストしたEnmuMapを使用
public enum Phase{
  SOLID, LIQUID, GAS;

   public enum Transition{
     MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS),
     CONDENSE(GAS, LIQUID), SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

     private final Phase src;
     private final Phase dst;

     Transition(Phase src, Phase dst){
       this.src = src;
       this.dst = dst;
     }

     //相転移マップを初期化
     private static final Map<Phase, Map<Phase, Transition>> m =
      new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);
      static{
        for(Phase p : Phase.values())
        m.put(p,new EnumMap<Phase,Transition>(Phase.class));
        for(Trainsition trans : Trainsition.values())
        m.get(trans.src).put(trans.dst, trans);
      }

      public static Trainsition from(Phase.src, Phase dst){
        return m.get(src).get(dst);
      }
   }
}
