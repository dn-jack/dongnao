package optimization;

public final class ClassTest1 {
    private String name;
    
    public final String getName() {
        String a = "a";
        String b = "b";
        
        b += a;
        return name;
    }
    
    public final void setName(String name) {
        this.name = name;
    }
}
