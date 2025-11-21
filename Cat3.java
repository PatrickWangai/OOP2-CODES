import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationForm extends JFrame {

    JTextField txtID, txtName, txtAddress, txtContact;
    JRadioButton male, female;
    JTable table;
    DefaultTableModel model;

    public RegistrationForm() {

        setTitle("Registration Form");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // ---------------- LABELS ----------------
        JLabel lblTitle = new JLabel("Registration Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(50, 20, 300, 30);
        add(lblTitle);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(50, 80, 80, 25);
        add(lblID);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 120, 80, 25);
        add(lblName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(50, 160, 80, 25);
        add(lblGender);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(50, 200, 80, 25);
        add(lblAddress);

        JLabel lblContact = new JLabel("Contact");
        lblContact.setBounds(50, 240, 80, 25);
        add(lblContact);


        // ---------------- INPUT FIELDS ----------------
        txtID = new JTextField();
        txtID.setBounds(150, 80, 150, 25);
        add(txtID);

        txtName = new JTextField();
        txtName.setBounds(150, 120, 150, 25);
        add(txtName);

        male = new JRadioButton("Male");
        male.setBounds(150, 160, 70, 25);
        female = new JRadioButton("Female");
        female.setBounds(230, 160, 80, 25);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        add(male);
        add(female);

        txtAddress = new JTextField();
        txtAddress.setBounds(150, 200, 150, 25);
        add(txtAddress);

        txtContact = new JTextField();
        txtContact.setBounds(150, 240, 150, 25);
        add(txtContact);


        // ---------------- BUTTONS ----------------
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(150, 300, 100, 30);
        add(btnRegister);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(50, 300, 80, 30);
        add(btnExit);


        // ---------------- TABLE ----------------
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Address");
        model.addColumn("Contact");

        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(350, 50, 500, 350);
        add(scroll);

        loadData();  // Load table data when form opens

        // ---------------- BUTTON FUNCTIONS ----------------

        // Register Button Code
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });

        // Exit Button
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // ---------------- FUNCTION: Register Student ----------------
    private void registerStudent() {
        String id = txtID.getText();
        String name = txtName.getText();
        String gender = male.isSelected() ? "Male" : "Female";
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO students VALUES(?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            pst.setString(2, name);
            pst.setString(3, gender);
            pst.setString(4, address);
            pst.setString(5, contact);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!");

            model.addRow(new Object[]{id, name, gender, address, contact});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // ---------------- FUNCTION: Load Table Data ----------------
    private void loadData() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM students";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("contact")
                });
            }

        } catch (Exception e) {
            System.out.println("Load Error: " + e.getMessage());
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        new RegistrationForm();
    }
}
