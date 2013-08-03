public class ReverseText {
	public String text;
	public String newText = "";
	public ReverseText(){}
	public ReverseText(String text){
		this.text = text;
	}
	public String returnText(){
		if (!text.equals("")){
			newText = text.valueOf(text.charAt(text.length() - 1));
			if (text.length() >= 2){
				for (int i = text.length() - 2; i >= 0; i--){
					newText += text.valueOf(text.charAt(i));
				}
			}
		}
		return newText;
	}
	public String returnText(String text){
		this.text = text;
		newText = "";
		if (!text.equals("")){
			newText = text.valueOf(text.charAt(text.length() - 1));
			if (text.length() >= 2){
				for (int i = text.length() - 2; i >= 0; i--){
					newText += text.valueOf(text.charAt(i));
				}
			}
		}
		return newText;
	}
}