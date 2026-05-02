import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Patient {
    int id;
    String name;
    String disease;

    public Patient(int id, String name, String disease) {
        this.id = id;
        this.name = name;
        this.disease = disease;
    }
}

public class HospitalGUIPro extends JFrame {

    private ArrayList<Patient> patients = new ArrayList<>();
    private DefaultTableModel model;
    private JLabel titleLabel;

    CardLayout cardLayout;
    JPanel mainPanel;

    Color bgColor = new Color(30, 30, 30);
    Color btnColor = new Color(70, 130, 180);

    public HospitalGUIPro() {
        setTitle(" Smart Hospital System");
        setSize(900, 600);
        setLayout(new BorderLayout());
        getContentPane().setBackground(bgColor);

        // ===== TITLE =====
        titleLabel = new JLabel("Hospital Management System", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.SOUTH);

        startTitleAnimation(); // animation

        // ===== TOOLBAR =====
        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(bgColor);

        JButton homeBtn = createButton("Home");
        JButton addBtn = createButton("Add");
        JButton viewBtn = createButton("View");

        toolBar.add(homeBtn);
        toolBar.add(addBtn);
        toolBar.add(viewBtn);

        add(toolBar, BorderLayout.NORTH);

        // ===== CARD LAYOUT =====
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(bgColor);

        mainPanel.add(homePanel(), "HOME");
        mainPanel.add(addPanel(), "ADD");
        mainPanel.add(viewPanel(), "VIEW");

        add(mainPanel, BorderLayout.CENTER);

        homeBtn.addActionListener(e -> cardLayout.show(mainPanel, "HOME"));
        addBtn.addActionListener(e -> cardLayout.show(mainPanel, "ADD"));
        viewBtn.addActionListener(e -> cardLayout.show(mainPanel, "VIEW"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ===== BUTTON STYLE =====
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(btnColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);

        // Hover Effect
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Color.GREEN);
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(btnColor);
            }
        });

        return btn;
    }

    // ===== ANIMATION =====
    private void startTitleAnimation() {
        new Timer(500, e -> {
            Color random = new Color(
                    (int)(Math.random() * 255),
                    (int)(Math.random() * 255),
                    (int)(Math.random() * 255));
            titleLabel.setForeground(random);
        }).start();
    }

    // ===== HOME =====
    private JPanel homePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);

        JLabel label = new JLabel("Welcome ");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 22));

        panel.add(label);
        return panel;
    }

    // ===== ADD =====
    private JPanel addPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBackground(bgColor);

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField disease = new JTextField();

        JButton add = createButton("Add Patient");

        add.addActionListener(e -> {
            try {
                patients.add(new Patient(
                        Integer.parseInt(id.getText()),
                        name.getText(),
                        disease.getText()
                ));
                JOptionPane.showMessageDialog(this, "Added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });

        panel.add(createLabel("ID"));
        panel.add(id);
        panel.add(createLabel("Name"));
        panel.add(name);
        panel.add(createLabel("Disease"));
        panel.add(disease);
        panel.add(add);

        return panel;
    }

    // ===== VIEW =====
    private JPanel viewPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgColor);

        model = new DefaultTableModel(new String[]{"ID", "Name", "Disease"}, 0);
        JTable table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        JButton refresh = createButton("Refresh");

        refresh.addActionListener(e -> {
            model.setRowCount(0);
            for (Patient p : patients) {
                model.addRow(new Object[]{p.id, p.name, p.disease});
            }
        });

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(refresh, BorderLayout.SOUTH);

        return panel;
    }

    private JLabel createLabel(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(Color.WHITE);
        return l;
    }

    public static void main(String[] args) {
        new HospitalGUIPro();
    }
}