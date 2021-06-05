package vaadin.step1;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.*;



import com.vaadin.flow.server.VaadinService;


@Route("Machine")


public class Machine_view extends VerticalLayout {
	// Informationen angezeigt werden müssen
	
	private String startTime = "Start Time: ";
	private String duration = "Duration: ";
	private String type = "Type: ";
	private String quality = "Quality: ";
	private String paymentStatus = "Payment Status: ";
	public Machine_view() {

	H1 header = new H1("MACHINE INTERFACE");
	Button testButton = new Button("Download txt");
	Label label1 = new Label();
	Label label2 = new Label();
	Label label3 = new Label();
	Label label4 = new Label();
	Label label5 = new Label();
	//label.setBounds(20, 20, 40, 20);
	label1.setText(startTime + getValueFromSession("startTime"));
	label2.setText(duration +  getValueFromSession("duration") + " days");
	label3.setText(type + getValueFromSession("type"));
	label4.setText(quality + getValueFromSession("quality"));
	label5.setText(paymentStatus);
	add(header, label1, label2, label3, label4, label5, testButton);
}

	private String getValueFromSession(final String attributeName) {
		return VaadinService.getCurrentRequest().getWrappedSession().getAttribute(attributeName).toString();
	}

	public void setTestText(final String value) {

	}

}