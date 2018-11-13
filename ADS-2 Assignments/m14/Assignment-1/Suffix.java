public class Suffix implements Comparable<Suffix>
{
 private final String text;
 private final int offset;
 public Suffix(String s, int offset)
 {
 this.text = text;
 this.offset = offset;
 }
 public int length() { return text.length() - offset; }
 public char charAt(int i) { return text.charAt(offset + i); }
 public int compareTo(Suffix that) { /* see textbook */ }
}