package week3.day2;

//inherits from the Button subclass

public class Elements extends Button {

	public static void main(String[] args) {

		// Object created for subclass
		Button bttn = new Button();
		TextField txtfld = new TextField();
		CheckBoxButton chbxbttn = new CheckBoxButton();
		RadioButton radbttn = new RadioButton();
		Elements ele = new Elements();
		
		
		//Calling methods from Button
		System.out.println("WebElements+Button:");
		bttn.click();
		bttn.setText("From Button");
		bttn.submit();
	
		//Calling methods from TextField
		System.out.println("WebElements+TextField:");
		txtfld.click();
		txtfld.setText("From TextField");
		txtfld.getText();
		
		//Calling methods from CheckBoxButton
		System.out.println("WebElements+Button+CheckBoxButton:");
		chbxbttn.click();
		chbxbttn.setText("From CheckBoxButton");
		chbxbttn.submit();
		chbxbttn.clickCheckButton();
		
		//Calling methods from RadioButton
		System.out.println("WebElements+Button+Radiobutton:");
		radbttn.click();
		radbttn.setText("From Radiobutton");
		radbttn.submit();
		radbttn.selectRadioButton();
		
		
		//Calling methods from Elements
		System.out.println("WebElements+Button+Elements:");
		ele.click();
		ele.setText("From Elements");
		ele.submit();
		
	}

}
