package connect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MediaFarma extends JFrame{

    private JPanel PanelMain;
    private JTextField textField1;
    private JButton button1;

    public MediaFarma() {
        button1.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectServer connectServer = new ConnectServer();
                try {
                    connectServer.result();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        MediaFarma mediaFarma = new MediaFarma();
        //Memberikan Judul Aplikasi
        mediaFarma.setTitle("Aplikasi Obat");
        // Memberikan Ukuran dan tinggi
        mediaFarma.setSize(400,500);
        // agar form di tengah
        mediaFarma.setLocationRelativeTo(null);

        mediaFarma.setLayout(null); // mengatur layout secara manual
        mediaFarma.setVisible(true); // menammpilkan form
        mediaFarma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Mengatur tampilan Total Data
        JLabel Data = new JLabel("Total Data");
        Data.setBounds(20,110,150,25);
        mediaFarma.add(Data);
        JTextField data = new JTextField();
        data.setBounds(150,110,150,25);
        mediaFarma.add(data);

        //mengatur tampilan Harga Tertinggi
        JLabel HargaTertinggi = new JLabel("Harga Tertinggi");
        HargaTertinggi.setBounds(20,150,150,25);
        mediaFarma.add(HargaTertinggi);
        JTextField harga = new JTextField();
        harga.setBounds(150,150,150,25);
        mediaFarma.add(harga);

        JButton submit = new JButton("Submit");
        submit.setBounds(200,200,120,25);
        mediaFarma.add(submit);

        ConnectServer connectServer =new ConnectServer();
        connectServer.result();
        harga.setText(String.valueOf(connectServer.getHargaTertinggi()));
        data.setText(String.valueOf(connectServer.getJumlahData()));



    }

}

