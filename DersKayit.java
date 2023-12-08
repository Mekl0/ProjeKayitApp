import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DersKayit extends JFrame {


    public class Ders extends JFrame {
        private String dersKodu;
        private String dersAdi;
        private String dersDonemi;
        private String ogretmen;

        public Ders(String dersKodu, String dersAdi, String dersDonemi, String ogretmen) {
            this.dersKodu = dersKodu;
            this.dersAdi = dersAdi;
            this.dersDonemi = dersDonemi;
            this.ogretmen = ogretmen;
        }

        // Getter ve setter metotları
        public String getDersKodu() {
            return dersKodu;
        }

        public void setDersKodu(String dersKodu) {
            this.dersKodu = dersKodu;
        }

        public String getDersAdi() {
            return dersAdi;
        }

        public void setDersAdi(String dersAdi) {
            this.dersAdi = dersAdi;
        }

        public String getDersDonemi() {
            return dersDonemi;
        }

        public void setDersDonemi(String dersDonemi) {
            this.dersDonemi = dersDonemi;
        }

        public String getOgretmen() {
            return ogretmen;
        }

        public void setOgretmen(String ogretmen) {
            this.ogretmen = ogretmen;
        }

        @Override
        public String toString() {
            return "Ders{" +
                    "dersKodu='" + dersKodu + '\'' +
                    ", dersAdi='" + dersAdi + '\'' +
                    ", dersDonemi='" + dersDonemi + '\'' +
                    ", ogretmen='" + ogretmen + '\'' +
                    '}';
        }
    }


    private JPanel panel1;
    private JButton ogrenciButton;
    private JButton anaformButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton kaydetButton;


    public DersKayit() {

        setTitle("Genel Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panel1);
        ogrenciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgrenciKayit ogrenciKayit=new OgrenciKayit();

                ogrenciKayit.setVisible(true);


            }
        });
        anaformButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GnlForm gnlForm=new GnlForm();
                gnlForm.setVisible(true);
            }
        });


        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String dersKodu = textField1.getText();
                String dersAdi = textField2.getText();
                String dersDonemi = textField3.getText();
                String ogretmen = textField4.getText();
                Ders ders=new Ders(dersKodu,dersAdi,dersDonemi,ogretmen);
                System.out.println("Ders instance: " + ders);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Defter.txt", true))) {
                    String content = ders.toString();
                    if (content != null && !content.isEmpty()) {
                        writer.write(content);
                        writer.newLine();
                        System.out.println("Ders information is successfully written to the file.");
                    } else {
                        System.out.println("Content is empty. Nothing written to the file.");
                    }
                } catch (IOException ex) {
                    System.err.println("Error writing to the file: " + ex.getMessage());
                    ex.printStackTrace(); // Print the stack trace for debugging
                }

            }
        });


    }
    public static void main(String[] args) {
        DersKayit dersKayit = new DersKayit();
        dersKayit.setVisible(true);
    }
}
