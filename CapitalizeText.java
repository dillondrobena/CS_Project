public class CapitalizeText {
	public String text;
	public CapitalizeText(){}
	public CapitalizeText(String text){
		this.text = text;
	}
	public String returnText(){
		if (!text.equals("")){
			text = text.toUpperCase();
		}
		return text;
	}
	public String returnText(String text){
		this.text = text;
		if (!text.equals("")){
			text = text.toUpperCase();
		}
		return text;
	}	
}
