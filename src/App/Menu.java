package App;

import Analizador.parser;
import Analizador.scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setSize(super.getToolkit().getScreenSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        comboArchivo = new javax.swing.JComboBox<>();
        comboReports = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextPane();
        imgLabel = new javax.swing.JLabel();
        GAbtn = new javax.swing.JButton();
        AEbtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPanel = new javax.swing.JTextArea();
        ruta = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EXREGAN PRO");

        jScrollPane1.setAutoscrolls(true);

        comboArchivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo archivo", "Abrir archivo", "Guardar", "Guardar como" }));
        comboArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboArchivoActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(comboArchivo);

        comboReports.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arboles", "Siguientes", "Transciciones", "Automatas" }));
        comboReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboReportsActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(console);

        imgLabel.setText("Image");

        GAbtn.setText("Generar automatas");
        GAbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GAbtnActionPerformed(evt);
            }
        });

        AEbtn.setText("Analizar cadenas y generar json");
        AEbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEbtnActionPerformed(evt);
            }
        });

        textPanel.setColumns(20);
        textPanel.setRows(5);
        jScrollPane4.setViewportView(textPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ruta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(GAbtn)
                                    .addGap(53, 53, 53)
                                    .addComponent(AEbtn))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboReports, 0, 675, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboReports)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(ruta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GAbtn)
                    .addComponent(AEbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboArchivoActionPerformed
        String seleccion = (String) comboArchivo.getSelectedItem();
        JFileChooser jf = new JFileChooser("/home/bulleye/Documentos/Semestres/1S 2023/Compiladores 1/Proyecto 1");
        FileFilter filter = new FileNameExtensionFilter("OCL File", "ocl");
        File archivo;
        switch (seleccion) {
            case "Nuevo archivo":
                jf.setApproveButtonText("Crear nuevo archivo");
                jf.setFileFilter(filter);
                jf.showOpenDialog(null);
                archivo = new File(jf.getSelectedFile() + ".ocl");
                try {
                    try (BufferedWriter salida = new BufferedWriter(new FileWriter(archivo))) {
                        salida.write(textPanel.getText());
                    }
                } catch (IOException e) {
                }
                break;

            case "Abrir archivo":
                jf.setApproveButtonText("Abrir archivo");
                jf.setFileFilter(filter);
                jf.showOpenDialog(null);
                try {
                    archivo = new File(jf.getSelectedFile() + "");
                    if (archivo.exists()) {
                        ruta.setText(jf.getSelectedFile().getAbsolutePath());
                    }
                    BufferedReader salida = new BufferedReader(new FileReader(archivo));
                    String leer = salida.readLine();
                    while (leer != null) {
                        textPanel.append(leer + "\n");
                        leer = salida.readLine();
                    }
                } catch (IOException e) {
                }
                break;

            case "Guardar":
                try {
                FileChannel.open(Path.of(ruta.getText()), StandardOpenOption.WRITE)
                        .truncate(0).close();
                archivo = new File(ruta.getText());
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
                    bw.write(textPanel.getText());
                }
            } catch (IOException e) {
            }
            break;

            case "Guardar como":
                jf.setApproveButtonText("Abrir archivo");
                jf.setFileFilter(filter);
                jf.showSaveDialog(null);
                jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                archivo = new File(jf.getSelectedFile() + ".ocl");
                try {
                    try (FileWriter escribir = new FileWriter(archivo, true)) {
                        escribir.write(textPanel.getText());
                    }
                } catch (IOException e) {
                }
                break;
            default:
                throw new AssertionError();
        }
//        System.out.println(seleccion);
    }//GEN-LAST:event_comboArchivoActionPerformed

    private void comboReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboReportsActionPerformed
        String seleccion = (String) comboReports.getSelectedItem();
        System.out.println(seleccion);
    }//GEN-LAST:event_comboReportsActionPerformed

    private void GAbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GAbtnActionPerformed

    }//GEN-LAST:event_GAbtnActionPerformed

    private void AEbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEbtnActionPerformed

        interpretar(textPanel.getText());

    }//GEN-LAST:event_AEbtnActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    private static void interpretar(String entrada) {
        try {

            scanner scanner = new scanner(new java.io.StringReader(entrada));
            parser parser = new parser(scanner);
            parser.parse();
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AEbtn;
    private javax.swing.JButton GAbtn;
    private javax.swing.JComboBox<String> comboArchivo;
    private javax.swing.JComboBox<String> comboReports;
    private javax.swing.JTextPane console;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel ruta;
    private javax.swing.JTextArea textPanel;
    // End of variables declaration//GEN-END:variables
}
