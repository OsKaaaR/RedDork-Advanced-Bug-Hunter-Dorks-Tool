import javax.swing.*;
import java.awt.*;

public class DorkingToolGUI extends JFrame {
    private JTextField domainField;

    public DorkingToolGUI() {
        setTitle("Advanced Dorking Tool");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#121212"));
        setLayout(new BorderLayout());

        JPanel topPanel = DorkingToolUtils.createTopPanel(this);
        add(topPanel, BorderLayout.NORTH);

        JTabbedPane tabs = DorkingToolUtils.createTabs(this);
        add(tabs, BorderLayout.CENTER);

        JPanel bottomPanel = DorkingToolUtils.createBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DorkingToolGUI::new);
    }

    public String getDomain() {
        return domainField.getText().trim();
    }

    public void setDomainField(JTextField field) {
        this.domainField = field;
    }
}