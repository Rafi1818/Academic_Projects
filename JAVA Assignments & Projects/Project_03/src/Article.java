public class Article {
    int id;
    String title;
    String author;
    Article next;

    public Article(int i, String t, String a, Article r){
        this.id = i;
        this.title = t;
        this.author = a;
        this.next = r;
    }

    public String toString(){
        return String.format("\t %d | %s | %s-->\n", id, title, author);
    }
}
