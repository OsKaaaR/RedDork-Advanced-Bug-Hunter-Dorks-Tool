import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonFactory {
    public static JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.decode("#1f1f1f"));
        btn.setForeground(Color.RED);
        btn.setFont(new Font("Noto Mono", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.RED));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btn.setBackground(Color.decode("#292929"));
            }

            public void mouseExited(MouseEvent evt) {
                btn.setBackground(Color.decode("#1f1f1f"));
            }
        });
        return btn;
    }
}