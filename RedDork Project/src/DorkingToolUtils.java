import javax.swing.*;
import java.awt.*;

public class DorkingToolUtils {

        public static JPanel createTopPanel(DorkingToolGUI gui) {
                JPanel topPanel = new JPanel(new GridBagLayout());
                topPanel.setBackground(Color.decode("#121212"));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.insets = new Insets(10, 0, 10, 0);

                JLabel titleLabel = new JLabel("Bug Bounty Recon");
                titleLabel.setForeground(Color.RED);
                titleLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setPreferredSize(new Dimension(500, 50));
                gbc.gridy = 0;
                topPanel.add(titleLabel, gbc);

                JTextField domainField = new JTextField("Enter target domain (e.g., example.com)");
                domainField.setToolTipText("Enter the target domain to search for dorks");
                domainField.setBackground(Color.decode("#292929"));
                domainField.setForeground(Color.WHITE);
                domainField.setCaretColor(Color.WHITE);
                domainField.setBorder(BorderFactory.createLineBorder(Color.RED));
                domainField.setFont(new Font("Consolas", Font.PLAIN, 16));
                domainField.setPreferredSize(new Dimension(400, 30));
                gbc.gridy = 1;
                topPanel.add(domainField, gbc);

                gui.setDomainField(domainField);
                return topPanel;
        }

        public static JTabbedPane createTabs(DorkingToolGUI gui) {
                JTabbedPane tabs = new JTabbedPane();
                tabs.setBackground(Color.decode("#121212"));
                tabs.setForeground(Color.RED);
                tabs.setFont(new Font("JetBrains Mono", Font.BOLD, 16));

                tabs.addTab("Sensitive Files",
                                ImageUtil.resizeIcon(
                                                "assets/sensitive.png",
                                                24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                "Juicy Extensions (Sensitive Files)", "Backup Files",
                                                "Configuration Files", "Sensitive JS", "Environment Files",
                                                "Git Exposed"
                                }));

                tabs.addTab("APIs & Endpoints",
                                ImageUtil.resizeIcon("assets/api.png", 24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                "API Endpoints Discovery", "Swagger API Docs", "GraphQL",
                                                "API Keys in JS"
                                }));

                tabs.addTab("Exposures",
                                ImageUtil.resizeIcon("assets/exposure.png", 24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                ".git Exposed", "WordPress Debug Logs", "Wayback URLs",
                                                "GitHub Exposures",
                                                "Pastebin Dumps", "LinkedIn Employees", "Public Trello Boards",
                                                "S3 Buckets"
                                }));

                tabs.addTab("Creds & Tokens",
                                ImageUtil.resizeIcon("assets/leaks.png", 24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                "Token in URL", "User Credentials", "Cloud Credentials",
                                                "Access Key Exposure"
                                }));

                tabs.addTab("Errors & Listings",
                                ImageUtil.resizeIcon("assets/errors.png", 24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                "SQL Errors", "Directory Listing", "phpinfo() Exposure", "Stack Traces"
                                }));

                tabs.addTab("WordPress Recon",
                                ImageUtil.resizeIcon(
                                                "assets/wordpress.png",
                                                24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                "WordPress Common Paths", "WordPress Plugins", "WordPress Uploads",
                                                "WordPress Themes", "WordPress wp-config"
                                }));

                tabs.addTab("Login/Register",
                                ImageUtil.resizeIcon("assets/login-button.png", 24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                "Admin Login Pages", "Login Pages", "Signup Pages",
                                                "Reset Password Pages", "cPanel Access", "Webmail", "FTP Login Pages"
                                }));

                tabs.addTab("Others",
                                ImageUtil.resizeIcon("assets/others.png", 24, 24),
                                TabBuilder.createButtonPanel(gui, new String[] {
                                                "Open Redirects", "Sitemap Exposure", "Changelog/README",
                                                "Internal IP Disclosure",
                                                "phpMyAdmin", "Exposed Dashboards", "Monitoring Panels"
                                }));
                tabs.insertTab("JS Link Extractor", null, TabBuilder.createJSExtractorPanel(gui), null, 2);

                return tabs;
        }

        public static JPanel createBottomPanel() {
                JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                bottomPanel.setBackground(Color.decode("#121212"));
                JLabel copyright = new JLabel("© Made with ♥ by OsKaaR");
                copyright.setForeground(Color.LIGHT_GRAY);
                copyright.setFont(new Font("Consolas", Font.PLAIN, 12));
                bottomPanel.add(copyright);
                return bottomPanel;
        }
}
