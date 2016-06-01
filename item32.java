public class Text{
  public enum Style{
    BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
  }

  public void applyStyles(Set<Style> styles){
    text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
  }
}
