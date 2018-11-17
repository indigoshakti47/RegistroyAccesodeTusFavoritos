package Package;

public class Acceso {
	
	private String key;
    private long id;

    public Acceso(String key, long id) {
        this.key = key;
        this.id = id;
    }

    
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
