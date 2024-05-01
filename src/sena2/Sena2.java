package sena2;  // paketin ismi
import java.io. BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  // gerekli kütüphaneleri çağırdım 
import javax.swing.*;

public class Sena2 {
    

 public static void main(String[] args) {
     
           // Tatil günlerini oluştur
     //   String tatilGunleri = getHolidayText("2024");
        
        // Dosya yolu ve adını belirtin
        String dosyaYolu = "C:\\Users\\Sena Ceylan\\Downloads\\yazi.txt";
        
    
        
        JFrame f = new JFrame("deneme");
        JButton b1 = new JButton();
        JButton renk = new JButton();

        
        b1.setText("yıl seçip butona basınız"); // butonumun içindeki metin 
        b1.setBounds(200,200,300,100);
        b1.setBackground(Color.CYAN);
      
         JComboBox<String> comboBox = new JComboBox<>(); // bir liste içinden seçim yapmasını sağlar 
        comboBox.addItem("2004");
        comboBox.addItem("2005");
        comboBox.addItem("2006");
        comboBox.addItem("2007");
        comboBox.addItem("2008");
        comboBox.setBounds(200, 300, 300, 30);
        
        comboBox.setBackground(Color.PINK);
        JTextArea textArea = new JTextArea(); // kullanıcıdan metin girişi almamızı sağlar
        // fakat ben burda metin çıktısı alma kısmını kullandım 
        textArea.setEditable(false); // kullanıcının bu metni düzenleyememesini sağlar (editable:düzenlenebilir)
        textArea.setBounds(100, 350, 300, 200);// metin boyutlarını belirler (bounds:sınırlar)
        
       b1.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    String holidayText = getHolidayText(dosyaYolu); // Pass the file path instead of selectedYear
    textArea.setText(holidayText);
  }
});
        f.add(b1); // f.add diyerek nesnemizi çağrıyoruz ve arayüz kısmında görünmesini sağlıyoruz 
        f.add(comboBox);
         f.add(textArea);

        
        f.setSize(500, 600);
        f.setLayout(null);
        f.setVisible(true);
 }

        
       private static String getHolidayText(String dosyaYolu) {  
       
        StringBuilder sb = new StringBuilder();
         try {
            FileReader dosyaOkuyucu = new FileReader(dosyaYolu);
            BufferedReader okuyucu = new BufferedReader(dosyaOkuyucu);
            String satir;
            while ((satir = okuyucu.readLine()) != null) {
                sb.append(satir).append("\n");
            }
            okuyucu.close();
        } catch (IOException e) {
            System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();

        }
        return sb.toString();
    }

  
}
       