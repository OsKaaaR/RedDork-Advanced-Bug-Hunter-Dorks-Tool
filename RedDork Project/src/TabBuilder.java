import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;

public class TabBuilder {
    public static JPanel createButtonPanel(DorkingToolGUI gui, String[] dorks) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 15, 15));
        panel.setBackground(Color.decode("#121212"));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
        for (String label : dorks) {
            JButton btn = ButtonFactory.createStyledButton("🔎 " + label);
            btn.addActionListener((ActionEvent e) -> handleAction(gui.getDomain(), label));
            panel.add(btn);
        }
        return panel;
    }

    public static JPanel createJSExtractorPanel(DorkingToolGUI gui) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#121212"));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel instructions = new JLabel(
                "<html><span style='color:white;'>Click the button below to open the Endpoint Extractor directly in your browser. Then paste this code into your browser's console or save it as a bookmarklet.</span></html>");
        instructions.setForeground(Color.LIGHT_GRAY);
        instructions.setFont(new Font("Consolas", Font.PLAIN, 14));

        JTextArea jsArea = new JTextArea();
        jsArea.setText(loadJSExtractorCode());
        jsArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        jsArea.setEditable(false);
        jsArea.setBackground(Color.decode("#1e1e1e"));
        jsArea.setForeground(Color.GREEN);

        JScrollPane scrollPane = new JScrollPane(jsArea);
        scrollPane.setPreferredSize(new Dimension(800, 400));

        JButton openBrowser = ButtonFactory.createStyledButton("🌐 Open Target in Browser");
        openBrowser.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://" + gui.getDomain()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Failed to open browser:" + ex.getMessage());
            }
        });

        JPanel top = new JPanel();
        top.setBackground(Color.decode("#121212"));
        top.add(openBrowser);

        panel.add(instructions, BorderLayout.NORTH);
        panel.add(top, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        return panel;
    }

    private static String loadJSExtractorCode() {
        try {
            InputStream is = ImageUtil.class.getResourceAsStream("/assets/js.js");
            if (is == null) {
                return "// JS extractor file not found in resources.";
            }
            return new String(is.readAllBytes());
        } catch (IOException e) {
            return "// Error loading JS extractor file.";
        }
    }

    private static void handleAction(String domain, String label) {
        if (domain.isEmpty() || domain.contains("Enter target domain")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid domain.");
            return;
        }
        String query = DorkQueryBuilder.buildDorkQuery(label.replace("🔎 ", ""), domain);
        try {
            String encoded = URLEncoder.encode(query, "UTF-8");
            Desktop.getDesktop().browse(new URI("https://www.google.com/search?q=" + encoded));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed to open browser:" + ex.getMessage());
        }
    }
}