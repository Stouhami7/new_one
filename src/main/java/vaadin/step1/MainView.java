 package vaadin.step1;


 import com.vaadin.flow.component.UI;

 import com.vaadin.flow.component.button.Button;
 import com.vaadin.flow.component.orderedlayout.VerticalLayout;
 import com.vaadin.flow.component.textfield.TextField;
 import com.vaadin.flow.router.QueryParameters;
 import com.vaadin.flow.router.internal.RouteUtil;
 import com.vaadin.flow.server.PWA;
 import com.vaadin.flow.router.Route;
 import com.vaadin.flow.component.datepicker.*;
 import com.vaadin.flow.component.html.H1;
 import com.vaadin.flow.server.VaadinService;
 import org.springframework.lang.NonNull;
 import org.vaadin.gatanaso.MultiselectComboBox;

 import java.util.*;

 /**
  * The main view contains a button and a click listener.
  */
 @Route
 @PWA(name = "My Application", shortName = "My Application")
 public class MainView extends VerticalLayout {

     private List<OrderInformation> orderInformations = new LinkedList<>();

     public MainView() {
         H1 header = new H1("APP INTERFACE");

         DatePicker datePicker = new DatePicker("Start Time");

         TextField textField2 = new TextField("Duration");

         MultiselectComboBox<String> multiselectComboBox1 = new MultiselectComboBox();
         multiselectComboBox1.setLabel("Type");
         multiselectComboBox1.setItems("Raw", "Processed");

         MultiselectComboBox<String> multiselectComboBox2 = new MultiselectComboBox();
         multiselectComboBox2.setLabel("Quality");
         multiselectComboBox2.setItems("Low", "High");

         Button button1 = new Button("Send Request", event -> {
             saveValuesToSession(datePicker, textField2, multiselectComboBox1, multiselectComboBox2);
             navigateToMachineView();
         }
         );

         add(header, datePicker, textField2, multiselectComboBox1, multiselectComboBox2, button1);

     }

     private void saveValuesToSession(final DatePicker datePicker, final TextField textField2, final MultiselectComboBox<String> multiselectComboBox1,
             final MultiselectComboBox<String> multiselectComboBox2) {
         saveToVaadinSession("startTime", datePicker.getValue().toString());
         saveToVaadinSession("duration", textField2.getValue().toString());
         saveToVaadinSession("type", multiselectComboBox1.getValue().toString());
         saveToVaadinSession("quality", multiselectComboBox2.getValue().toString());
        
     }

     private void saveToVaadinSession(final String attributenName, final String value) {
         VaadinService.getCurrentRequest().getWrappedSession().setAttribute(attributenName, value);
     }

     private void navigateToMachineView() {
         UI.getCurrent().navigate("Machine");
     }

 }
