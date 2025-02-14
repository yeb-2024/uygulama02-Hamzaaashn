import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Anasayfa implements ActionListener {
    String isim = "admin";
    int şifre = 12345;

    String girilenİsim;
    int girilenŞifreİnt;
    String girilenŞifreStr;

    JFrame frame;
    JTextField textFieldİsim;
    JTextField textFieldŞifre;
    JButton button;

    JLabel isimKısmı;
    JLabel şifreKısmı;
    JPanel textFieldİsimPanel;
    JPanel textFieldŞifrePanel;

    public Anasayfa()
    {
        textFieldİsimPanel = new JPanel();
        textFieldİsimPanel.setLayout(new GridLayout(1,2));
        textFieldİsimPanel.setPreferredSize(new Dimension(400,50));

        textFieldŞifrePanel = new JPanel();
        textFieldŞifrePanel.setLayout(new GridLayout(1,2));
        textFieldŞifrePanel.setPreferredSize(new Dimension(400,50));



        isimKısmı =new JLabel();
        isimKısmı.setText("İSİM");
        isimKısmı.setPreferredSize(new Dimension(100,50));
        isimKısmı.setHorizontalAlignment(JLabel.CENTER);
        isimKısmı.setVerticalAlignment(JLabel.CENTER);
        isimKısmı.setBorder(BorderFactory.createLineBorder(new Color(122,138,153),1));

        şifreKısmı =new JLabel();
        şifreKısmı.setText("ŞİFRE");
        şifreKısmı.setPreferredSize(new Dimension(100,50));
        şifreKısmı.setHorizontalAlignment(JLabel.CENTER);
        şifreKısmı.setVerticalAlignment(JLabel.CENTER);
        şifreKısmı.setBorder(BorderFactory.createLineBorder(new Color(122,138,153),1));

        textFieldİsim =  new JTextField();
        textFieldİsim.setPreferredSize(new Dimension(300,50));

        textFieldŞifre =  new JTextField();
        textFieldŞifre.setPreferredSize(new Dimension(300,50));

        button = new JButton("GÖNDER");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(400,50));



        textFieldİsimPanel.add(isimKısmı);
        textFieldİsimPanel.add(textFieldİsim);

        textFieldŞifrePanel.add(şifreKısmı);
        textFieldŞifrePanel.add(textFieldŞifre);



        frame = new JFrame("JTextFied");
        frame.setSize(400,150);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));

        frame.add(textFieldİsimPanel);
        frame.add(textFieldŞifrePanel);
        frame.add(button);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button)
        {
            girilenİsim = textFieldİsim.getText().trim();
            girilenŞifreStr = textFieldŞifre.getText().trim();

            if (girilenİsim.isEmpty() || girilenŞifreStr.isEmpty())
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Lütfen Tüm Alanları Doldurun !",
                        "Hata",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            else {
                girilenŞifreİnt = Integer.parseInt(girilenŞifreStr);

                if (girilenİsim.equals(isim) && girilenŞifreİnt == şifre)
                {
                    frame.dispose();
                    String mesaj = "Hoş Geldiniz, " + girilenİsim;
                    JOptionPane.showMessageDialog(null, mesaj,"BAŞARILI",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    textFieldŞifre.setText("");
                    textFieldİsim.setText("");
                    JOptionPane.showMessageDialog(null,"Hatalı Giriş! Tekrar Deneyiniz.","BAŞARISIZ",JOptionPane.WARNING_MESSAGE);
                }
            }
            if (girilenŞifreStr.length() < 5)
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Minimum 5 Karakter Olmalı !",
                        "Hata",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

