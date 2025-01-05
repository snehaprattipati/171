package Dbms;
 import javax.swing.*;
 import java.awt.*;
import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
 import java.sql.SQLException;
public class login implements ActionListener{ JButton s,c;
login(){
JFrame frame=new JFrame(); JPanel panel=new JPanel(); frame.setSize(1600,1600);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.add(panel);
panel.setLayout(null);
JLabel x=new JLabel("CUSTOMER LOGIN");
                  
                 x.setBounds(420,100,1100,60);           x.setForeground(Color.gray);                                   
x.setFont(new Font("Lucida Calligraphy",Font.PLAIN,55)); panel.add(x);
JLabel label=new JLabel("METER NUMBER"); label.setBounds(500,250,300,40); label.setForeground(Color.white); label.setFont(new Font("Georgia",Font.PLAIN,25)); panel.add(label);
JTextField usertext=new JTextField(); usertext.setBounds(750,250,165,30); panel.add(usertext);
JLabel label1=new JLabel("USER NAME"); label1.setBounds(500,320,300,40); label1.setForeground(Color.white); label1.setFont(new Font("Georgia",Font.PLAIN,25)); panel.add(label1);
JTextField usertext1=new JTextField(); usertext1.setBounds(750,320,165,30); panel.add(usertext1);
JLabel label2=new JLabel("PASSWORD"); label2.setBounds(500,390,300,30);

label2.setForeground(Color.white); label2.setFont(new Font("Georgia",Font.PLAIN,25)); panel.add(label2);
JTextField usertext2=new JTextField(); usertext2.setBounds(750,390,165,30); panel.add(usertext2);
c =new JButton("CLEAR"); c.setBounds(6500,550,80,40); panel.add(c);
s =new JButton("LOGIN"); s.setBounds(700,550,80,40); panel.add(s); s.addActionListener(this); frame.setVisible(true); panel.setBackground(Color.BLACK);



s.addActionListener(new ActionListener() {


@Override
public void actionPerformed(ActionEvent e) {

try { Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
String ins="insert into logindetails (METERNO,USERNAME,PASSWORD)values(?,?,?)";
PreparedStatement st = conn.prepareStatement(ins); st.setString(1, usertext.getText());
st.setString(2, usertext1.getText()); st.setString(3, usertext2.getText());

st.executeUpdate();
}
catch (Exception e1) {

// TODO Auto-generated catch block e1.printStackTrace();
}
}
});
}
public static void main(String[] args) throws SQLException, ClassNotFoundException {
new login();

}
@Override
public void actionPerformed(ActionEvent e) { new customer(); } }


 
 

    

» User.java
package bus; public class User {
private int userId; private String name; private String email; private String password; private String phone;
// Getters and Setters
public int getUserId() { return userId; }
public void setUserId(int userId) { this.userId = userId; } public String getName() { return name; }
 
public void setName(String name) { this.name = name; } public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; } public String getPassword() { return password; }
public void setPassword(String password) { this.password = password; } public String getPhone() { return phone; }
public void setPhone(String phone) { this.phone = phone; }
}

» Bus.java
package bus; public class Bus {
private int busId;
private String busNumber; private String operatorName; private int totalSeats;
private String busType;
// Getters and Setters
public int getBusId() { return busId; }
public void setBusId(int busId) { this.busId = busId; } public String getBusNumber() { return busNumber; }
public void setBusNumber(String busNumber) { this.busNumber = busNumber; } public String getOperatorName() { return operatorName; }
public void setOperatorName(String operatorName) { this.operatorName = operatorName; }
public int getTotalSeats() { return totalSeats; }
public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; } public String getBusType() { return busType; }
public void setBusType(String busType) { this.busType = busType; }
}

» Route.java
package bus; public class Route {
private int routeId; private String source; private String destination; private int distanceKm;
// Getters and Setters
public int getRouteId() { return routeId; }
public void setRouteId(int routeId) { this.routeId = routeId; } public String getSource() { return source; }
public void setSource(String source) { this.source = source; } public String getDestination() { return destination; }
public void setDestination(String destination) { this.destination = destination; } public int getDistanceKm() { return distanceKm; }
 
public void setDistanceKm(int distanceKm) { this.distanceKm = distanceKm; } }

» Booking.java
package bus; public class Booking {
private int bookingId; private int userId; private int tripId;
private String bookingDate; private String status;
private double totalAmount;
// Getters and Setters
public int getBookingId() { return bookingId; }
public void setBookingId(int bookingId) { this.bookingId = bookingId; } public int getUserId() { return userId; }
public void setUserId(int userId) { this.userId = userId; } public int getTripId() { return tripId; }
public void setTripId(int tripId) { this.tripId = tripId; } public String getBookingDate() { return bookingDate; }
public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate;
}
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; } public double getTotalAmount() { return totalAmount; }
public void setTotalAmount(double totalAmount) { this.totalAmount =
totalAmount; }
}

» Payment.java
package bus; public class Payment {
private int paymentId; private int bookingId;
private String paymentMethod; private String paymentStatus; private String paymentDate; private double amount;
// Getters and Setters
public int getPaymentId() { return paymentId; }
public void setPaymentId(int paymentId) { this.paymentId = paymentId; } public int getBookingId() { return bookingId; }
public void setBookingId(int bookingId) { this.bookingId = bookingId; } public String getPaymentMethod() { return paymentMethod; }
public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
public String getPaymentStatus() { return paymentStatus; }
 
public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
public String getPaymentDate() { return paymentDate; }
public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
public double getAmount() { return amount; }
public void setAmount(double amount) { this.amount = amount; }
}
 
	Panels :
» BusPanel.java
package bus;
import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import java.util.List;

public class BusPanel extends JPanel {
private BusDAO busDAO = new BusDAO(); private JTable busTable;
private BusTableModel busTableModel;
private JTextField busNumberField, operatorNameField, totalSeatsField, busTypeField; private JButton addButton, updateButton, deleteButton;
public BusPanel() {
setLayout(new BorderLayout()); busTableModel = new BusTableModel(); busTable = new JTable(busTableModel);
JPanel formPanel = new JPanel(new GridLayout(5, 2)); formPanel.add(new JLabel("Bus Number:")); busNumberField = new JTextField(); formPanel.add(busNumberField);
formPanel.add(new JLabel("Operator Name:")); operatorNameField = new JTextField(); formPanel.add(operatorNameField); formPanel.add(new JLabel("Total Seats:")); totalSeatsField = new JTextField(); formPanel.add(totalSeatsField); formPanel.add(new JLabel("Bus Type:")); busTypeField = new JTextField(); formPanel.add(busTypeField);
addButton = new JButton("Add"); addButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
Bus bus = new Bus(); bus.setBusNumber(busNumberField.getText()); bus.setOperatorName(operatorNameField.getText()); bus.setTotalSeats(Integer.parseInt(totalSeatsField.getText())); bus.setBusType(busTypeField.getText()); busDAO.addBus(bus);
refreshTable();
} catch (Exception ex) {
 
ex.printStackTrace();
} }	});
updateButton = new JButton("Update"); updateButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = busTable.getSelectedRow(); if (selectedRow >= 0) {
Bus bus = busTableModel.getBusAt(selectedRow); bus.setBusNumber(busNumberField.getText()); bus.setOperatorName(operatorNameField.getText()); bus.setTotalSeats(Integer.parseInt(totalSeatsField.getText())); bus.setBusType(busTypeField.getText()); busDAO.updateBus(bus);
refreshTable();
}
} catch (Exception ex) { ex.printStackTrace();
}}});
deleteButton = new JButton("Delete"); deleteButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = busTable.getSelectedRow(); if (selectedRow >= 0) {
Bus bus = busTableModel.getBusAt(selectedRow); busDAO.deleteBus(bus.getBusId()); refreshTable();
}}
catch (Exception ex) {
ex.printStackTrace();
}}});
formPanel.add(addButton); formPanel.add(updateButton); formPanel.add(deleteButton);
add(new JScrollPane(busTable), BorderLayout.CENTER); add(formPanel, BorderLayout.SOUTH);
refreshTable();
}
private void refreshTable() { try {
List<Bus> buses = busDAO.getAllBuses(); busTableModel.setBuses(buses);
} catch (Exception ex) {
 
ex.printStackTrace();
}}}
» BookingPanel.java

 
package bus;
 

import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import java.util.List;
 

public class BookingPanel extends JPanel {
private BookingDAO bookingDAO = new BookingDAO(); private JTable bookingTable;
private BookingTableModel bookingTableModel;
private JTextField userIdField, tripIdField, bookingDateField, statusField, totalAmountField; private JButton addButton, updateButton, deleteButton;
public BookingPanel() { setLayout(new BorderLayout());
bookingTableModel = new BookingTableModel(); bookingTable = new JTable(bookingTableModel); JPanel formPanel = new JPanel(new GridLayout(6, 2)); formPanel.add(new JLabel("User ID:"));
userIdField = new JTextField(); formPanel.add(userIdField); formPanel.add(new JLabel("Trip ID:")); tripIdField = new JTextField(); formPanel.add(tripIdField); formPanel.add(new JLabel("Booking Date:")); bookingDateField = new JTextField(); formPanel.add(bookingDateField); formPanel.add(new JLabel("Status:")); statusField = new JTextField(); formPanel.add(statusField); formPanel.add(new JLabel("Total Amount:")); totalAmountField = new JTextField(); formPanel.add(totalAmountField); addButton = new JButton("Add");
addButton.addActionListener(new ActionListener() { @Override
public void actionPerformed(ActionEvent e) { try {
Booking booking = new Booking(); booking.setUserId(Integer.parseInt(userIdField.getText())); booking.setTripId(Integer.parseInt(tripIdField.getText())); booking.setBookingDate(bookingDateField.getText());
 
booking.setStatus(statusField.getText()); booking.setTotalAmount(Double.parseDouble(totalAmountField.getText()));
bookingDAO.addBooking(booking); refreshTable();
} catch (Exception ex) { ex.printStackTrace();
}}});
updateButton = new JButton("Update"); updateButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = bookingTable.getSelectedRow(); if (selectedRow >= 0) {
Booking booking = bookingTableModel.getBookingAt(selectedRow); booking.setUserId(Integer.parseInt(userIdField.getText())); booking.setTripId(Integer.parseInt(tripIdField.getText())); booking.setBookingDate(bookingDateField.getText()); booking.setStatus(statusField.getText());

booking.setTotalAmount(Double.parseDouble(totalAmountField.getText()));  bookingDAO.updateBooking(booking);
refreshTable();
}
} catch (Exception ex) { ex.printStackTrace();
}}});
deleteButton = new JButton("Delete"); deleteButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = bookingTable.getSelectedRow(); if (selectedRow >= 0) {
Booking booking = bookingTableModel.getBookingAt(selectedRow); bookingDAO.deleteBooking(booking.getBookingId()); refreshTable();
}
} catch (Exception ex) { ex.printStackTrace();
}}});
formPanel.add(addButton); formPanel.add(updateButton); formPanel.add(deleteButton);
add(new JScrollPane(bookingTable), BorderLayout.CENTER); add(formPanel, BorderLayout.SOUTH);
 
refreshTable();
}
private void refreshTable() { try {
List<Booking> bookings = bookingDAO.getAllBookings(); bookingTableModel.setBookings(bookings);
} catch (Exception ex) { ex.printStackTrace();
}}}
» RoutePanel.java

 
package bus;
 

import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import java.util.List;
public class RoutePanel extends JPanel {
private RouteDAO routeDAO = new RouteDAO(); private JTable routeTable;
private RouteTableModel routeTableModel;
private JTextField sourceField, destinationField, distanceField; private JButton addButton, updateButton, deleteButton; public RoutePanel() {
setLayout(new BorderLayout()); routeTableModel = new RouteTableModel(); routeTable = new JTable(routeTableModel);
JPanel formPanel = new JPanel(new GridLayout(4, 2)); formPanel.add(new JLabel("Source:"));
sourceField = new JTextField(); formPanel.add(sourceField); formPanel.add(new JLabel("Destination:")); destinationField = new JTextField(); formPanel.add(destinationField); formPanel.add(new JLabel("Distance (km):")); distanceField = new JTextField(); formPanel.add(distanceField);
addButton = new JButton("Add"); addButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
Route route = new Route(); route.setSource(sourceField.getText()); route.setDestination(destinationField.getText()); route.setDistanceKm(Integer.parseInt(distanceField.getText()));
 
routeDAO.addRoute(route); refreshTable();
} catch (Exception ex) { ex.printStackTrace();
}}});
updateButton = new JButton("Update"); updateButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = routeTable.getSelectedRow(); if (selectedRow >= 0) {
Route route = routeTableModel.getRouteAt(selectedRow); route.setSource(sourceField.getText()); route.setDestination(destinationField.getText()); route.setDistanceKm(Integer.parseInt(distanceField.getText())); routeDAO.updateRoute(route);
refreshTable();
}
} catch (Exception ex) { ex.printStackTrace();
}}});
deleteButton = new JButton("Delete"); deleteButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = routeTable.getSelectedRow(); if (selectedRow >= 0) {
Route route = routeTableModel.getRouteAt(selectedRow); routeDAO.deleteRoute(route.getRouteId()); refreshTable();
}
} catch (Exception ex) { ex.printStackTrace();
}}});
formPanel.add(addButton); formPanel.add(updateButton); formPanel.add(deleteButton);
add(new JScrollPane(routeTable), BorderLayout.CENTER); add(formPanel, BorderLayout.SOUTH);
refreshTable();
}
private void refreshTable() { try {
List<Route> routes = routeDAO.getAllRoutes();
 
routeTableModel.setRoutes(routes);
} catch (Exception ex) { ex.printStackTrace();
}}}
» PaymentPanel

package bus;
import javax.swing.*; import java.awt.*;
import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import java.sql.SQLException;
import java.util.List;
public class PaymentPanel extends JPanel {
private PaymentDAO paymentDAO = new PaymentDAO(); private JTable paymentTable;
private PaymentTableModel paymentTableModel;
private JTextField bookingIdField, paymentMethodField, paymentStatusField, paymentDateField, amountField;
private JButton addButton, updateButton, deleteButton; public PaymentPanel() {
setLayout(new BorderLayout()); paymentTableModel = new PaymentTableModel(); paymentTable = new JTable(paymentTableModel);
JPanel formPanel = new JPanel(new GridLayout(6, 2)); formPanel.add(new JLabel("Booking ID:")); bookingIdField = new JTextField(); formPanel.add(bookingIdField);
formPanel.add(new JLabel("Payment Method:")); paymentMethodField = new JTextField(); formPanel.add(paymentMethodField); formPanel.add(new JLabel("Payment Status:")); paymentStatusField = new JTextField(); formPanel.add(paymentStatusField); formPanel.add(new JLabel("Payment Date:")); paymentDateField = new JTextField(); formPanel.add(paymentDateField); formPanel.add(new JLabel("Amount:")); amountField = new JTextField(); formPanel.add(amountField);
addButton = new JButton("Add"); addButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
Payment payment = new Payment();
 
payment.setBookingId(Integer.parseInt(bookingIdField.getText())); payment.setPaymentMethod(paymentMethodField.getText()); payment.setPaymentStatus(paymentStatusField.getText()); payment.setPaymentDate(paymentDateField.getText()); payment.setAmount(Double.parseDouble(amountField.getText()));  paymentDAO.addPayment(payment);
refreshTable();
} catch (Exception ex) { ex.printStackTrace();
} }});
updateButton = new JButton("Update"); updateButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = paymentTable.getSelectedRow(); if (selectedRow >= 0) {
Payment payment = paymentTableModel.getPaymentAt(selectedRow);

payment.setBookingId(Integer.parseInt(bookingIdField.getText())); payment.setPaymentMethod(paymentMethodField.getText()); payment.setPaymentStatus(paymentStatusField.getText()); payment.setPaymentDate(paymentDateField.getText()); payment.setAmount(Double.parseDouble(amountField.getText())); paymentDAO.updatePayment(payment);
refreshTable();
}
} catch (Exception ex) { ex.printStackTrace();
}}});
deleteButton = new JButton("Delete"); deleteButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) { try {
int selectedRow = paymentTable.getSelectedRow(); if (selectedRow >= 0) {
Payment payment = paymentTableModel.getPaymentAt(selectedRow);
paymentDAO.deletePayment(payment.getPaymentId()); refreshTable();
}
} catch (Exception ex) { ex.printStackTrace();
}}});
formPanel.add(addButton);
 
formPanel.add(updateButton); formPanel.add(deleteButton);
add(new JScrollPane(paymentTable), BorderLayout.CENTER); add(formPanel, BorderLayout.SOUTH);
refreshTable();
}
private void refreshTable() { try {
List<Payment> payments = paymentDAO.getAllPayments(); paymentTableModel.setPayments(payments);
} catch (Exception ex) { ex.printStackTrace();
}}}

	JDBC CONNECTION :
» DatabaseConnection.java

package bus;

import java.sql.Connection; import java.sql.DriverManager; import java.sql.SQLException; public class DatabaseConnection {
private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
// Update with your database URL private static final String USER = "system";
// Update with your database user private static final String PASSWORD = "josh7";
// Update with your database password

public static Connection getConnection() throws Exception { Class.forName("oracle.jdbc.driver.OracleDriver");
return DriverManager.getConnection(URL, USER, PASSWORD);
}
}
 


 





 


 




s