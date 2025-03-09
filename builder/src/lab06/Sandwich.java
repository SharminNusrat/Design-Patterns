package lab06;

public class Sandwich {

	private String bread;
	private String filling;
	private String accompaniment;
	
	public void setBread(String bread) {
        this.bread = bread;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public void setAccompaniment(String accompaniment) {
        this.accompaniment = accompaniment;
    }

    @Override
	public String toString() {
		return "Bread- " + this.bread + "\nFilling- " + this.filling + "\nAccompaniment- " + this.accompaniment; 
	}
}
