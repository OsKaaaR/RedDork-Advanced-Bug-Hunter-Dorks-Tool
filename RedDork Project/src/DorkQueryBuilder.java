public class DorkQueryBuilder {
    public static String buildDorkQuery(String type, String domain) {
        String site = "site:" + domain + " ";
        return switch (type) {
            case "Juicy Extensions (Sensitive Files)" ->
                site + "ext:log | ext:txt | ext:conf | ext:cnf | ext:ini | ext:env | ext:sh | ext:bak | ext:backup | ext:swp | ext:old | ext:~ | ext:git | ext:svn | ext:htpasswd | ext:htaccess | ext:json";
            case "Backup Files" -> site + "ext:bak | ext:old | ext:backup | ext:zip | ext:tar | ext:~";
            case "Configuration Files" -> site + "ext:env | ext:ini | ext:conf | ext:json";
            case "Sensitive JS" -> site + "ext:js intext:apikey | intext:auth | intext:token";
            case "Environment Files" -> site + "ext:env | ext:json";
            case "Git Exposed" -> site + "inurl:.git";
            case "API Endpoints Discovery" -> site + "inurl:api | site:*/rest | site:*/v1 | site:*/v2 | site:*/v3";
            case "Swagger API Docs" -> site + "inurl:swagger | inurl:api-docs";
            case "GraphQL" -> site + "inurl:graphql | intext:GraphQL";
            case "API Keys in JS" -> site + "ext:js intext:key | token";
            case ".git Exposed" -> site + "inurl:.git";
            case "Wayback URLs" -> "site:web.archive.org/web/*/" + domain;
            case "GitHub Exposures" -> "site:github.com \"" + domain + "\"";
            case "Pastebin Dumps" -> "site:pastebin.com \"" + domain + "\"";
            case "LinkedIn Employees" -> "site:linkedin.com/in \"@" + domain + "\"";
            case "Token in URL" -> site + "inurl:token=";
            case "User Credentials" -> site + "intext:username= | intext:password=";
            case "Cloud Credentials" -> site + "intext:AWS_ACCESS_KEY_ID | intext:GCP_SECRET";
            case "Access Key Exposure" -> site + "intext:access_key | secret_key";
            case "SQL Errors" -> site + "\"sql syntax near\" | \"mysql_fetch\" | \"ORA-01756\"";
            case "Directory Listing" -> site + "\"index of /\"";
            case "phpinfo() Exposure" -> site + "ext:php intitle:phpinfo";
            case "Stack Traces" -> site + "\"Exception in thread\" | \"Traceback (most recent call last)\"";
            case "WordPress Common Paths" ->
                site + "inurl:wp- | inurl:wp-content | inurl:plugins | inurl:uploads | inurl:themes";
            case "WordPress Plugins" -> site + "inurl:/wp-content/plugins/";
            case "WordPress Uploads" -> site + "inurl:/wp-content/uploads/";
            case "WordPress Themes" -> site + "inurl:/wp-content/themes/";
            case "WordPress wp-config" -> site + "wp-config.php -inurl:wp-config-sample.php";
            case "Admin Login Pages" -> site + "inurl:admin | inurl:administrator | inurl:login";
            case "Login Pages" -> site + "inurl:login | intitle:login";
            case "Signup Pages" -> site + "inurl:register | inurl:signup";
            case "Reset Password Pages" -> site + "inurl:reset | inurl:forgot";
            case "cPanel Access" -> site + "inurl:cpanel | intitle:cpanel";
            case "Webmail" -> site + "inurl:webmail";
            case "FTP Login Pages" -> site + "inurl:ftp | intitle:ftp";
            case "Open Redirects" -> site + "inurl=redirect | inurl=return | inurl=next";
            case "Sitemap Exposure" -> site + "filetype:xml inurl:sitemap";
            case "Changelog/README" -> site + "intitle:readme | intitle:changelog";
            case "Internal IP Disclosure" -> site + "\"10.\" | \"192.168.\" | \"172.16.\"";
            case "phpMyAdmin" -> site + "inurl:phpmyadmin";
            case "Exposed Dashboards" -> site + "intitle:dashboard | intitle:admin";
            case "Monitoring Panels" -> site + "intitle:Prometheus | intitle:Grafana | intitle:Kibana";
            default -> site;
        };
    }
}
