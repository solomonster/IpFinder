import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Screen {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("IP FINDER");
        jFrame.setFont(new Font("Gill Sans MT",Font.BOLD,14));
        jFrame.setLayout(null);
        jFrame.setBounds(100,100,400,200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);


        JLabel urlLabel = new JLabel("Enter URL:");
        urlLabel.setBounds(25,30,100,30);


        JTextField jTextField = new JTextField();
        jTextField.setBounds(90,30,250,30);
        Font fieldFont = new Font("Arial", Font.PLAIN, 15);
        jTextField.setFont(fieldFont);


        JButton jButton = new JButton("Find IP");
        jButton.setBounds(90,80,90,40);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = jTextField.getText();
                if (isValidURL(url)) {
                    try {
                        InetAddress ia = InetAddress.getByName(url);
                        String ip = ia.getHostAddress();
                        JOptionPane.showMessageDialog(jFrame, ip);
                    } catch (UnknownHostException ex) {
                        JOptionPane.showMessageDialog(jFrame, "No such ip address for given URL","Warning",JOptionPane.WARNING_MESSAGE);


                    }

                } else {
                    JOptionPane.showMessageDialog(jFrame, "Not a valid URL", "Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.add(urlLabel);
        jFrame.setVisible(true);



    }
    public static boolean
    isValidURL(String url)
    {
        // Regex to check valid URL
        String regex = "((http|https)://)*(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (url == null) {
            return false;
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(url);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

}