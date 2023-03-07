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
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        comboArchivo = new javax.swing.JComboBox<>();
        comboReports = new javax.swing.JComboBox<>();
        imgLabel = new javax.swing.JLabel();
        GAbtn = new javax.swing.JButton();
        AEbtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPanel = new javax.swing.JTextArea();
        ruta = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        terminal = new javax.swing.JTextArea();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EXREGAN USAC");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        textPanel.setBackground(new java.awt.Color(0, 0, 0));
        textPanel.setColumns(20);
        textPanel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textPanel.setForeground(new java.awt.Color(51, 255, 51));
        textPanel.setRows(5);
        jScrollPane4.setViewportView(textPanel);

        terminal.setBackground(new java.awt.Color(0, 0, 0));
        terminal.setColumns(20);
        terminal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        terminal.setForeground(new java.awt.Color(255, 255, 255));
        terminal.setRows(5);
        jScrollPane3.setViewportView(terminal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(GAbtn)
                                .addGap(61, 61, 61)
                                .addComponent(AEbtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)
                                .addComponent(comboReports, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 668, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GAbtn)
                    .addComponent(AEbtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboArchivoActionPerformed
        String seleccion = (String) comboArchivo.getSelectedItem();
        this.setVisible(false);
        JFileChooser jf = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Entradas");
        FileFilter filter = new FileNameExtensionFilter("OCL File", "ocl");
        File archivo;
        terminal.setText("");
        switch (seleccion) {
            case "Nuevo archivo":
                jf.setApproveButtonText("Crear nuevo archivo");
                jf.setFileFilter(filter);
                jf.showOpenDialog(null);
                if (jf.getSelectedFile() != null) {
                    archivo = new File(jf.getSelectedFile() + ".ocl");
                    try {
                        try (BufferedWriter salida = new BufferedWriter(new FileWriter(archivo))) {
                            salida.write(textPanel.getText());
                            System.out.println(archivo);
                            terminal.setText("Nuevo archivo creado con exito");
                        }
                    } catch (IOException e) {
                        terminal.setText("No se pudo crear el archivo");
                    }
                } else {
                    terminal.setText("No se pudo crear el archivo");
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
                        BufferedReader salida = new BufferedReader(new FileReader(archivo));
                        String leer = salida.readLine();
                        textPanel.setText(null);
                        while (leer != null) {
                            textPanel.append(leer + "\n");
                            leer = salida.readLine();
                        }
                        terminal.setText("Archivo abierto con exito");
                    } else {
                        terminal.setText("No se pudo abrir el archivo");
                    }

                } catch (IOException e) {
                    terminal.setText("No se pudo abrir el archivo");
                }
                break;

            case "Guardar":
               try {
                FileChannel.open(Path.of(ruta.getText()), StandardOpenOption.WRITE).truncate(0).close();
                archivo = new File(ruta.getText());
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
                    bw.write(textPanel.getText());
                    terminal.setText("Archivo actualizado con exito");
                }
            } catch (IOException e) {
                terminal.setText("No se logro actualizar el archivo");
            }
            break;

            case "Guardar como":
                jf.setApproveButtonText("Guardar archivo");
                jf.setFileFilter(filter);
                jf.showSaveDialog(null);
                jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                if (jf.getSelectedFile() != null) {
                    archivo = new File(jf.getSelectedFile() + ".ocl");
                    try {
                        try (FileWriter escribir = new FileWriter(archivo, true)) {
                            escribir.write(textPanel.getText());
                            terminal.setText("Archivo guardado con exito");
                        }
                    } catch (IOException e) {
                        terminal.setText("No se logro guardar el archivo");
                    }

                }else{
                    terminal.setText("No se logro guardar el archivo");
                }
                break;
            default:
                throw new AssertionError();
        }
        this.setVisible(true);
//        System.out.println(seleccion);
    }//GEN-LAST:event_comboArchivoActionPerformed

    private void comboReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboReportsActionPerformed
        String seleccion = (String) comboReports.getSelectedItem();
        terminal.setText("");
        terminal.setText(seleccion);
    }//GEN-LAST:event_comboReportsActionPerformed

    private void GAbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GAbtnActionPerformed

    }//GEN-LAST:event_GAbtnActionPerformed

    private void AEbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEbtnActionPerformed
        interpretar(textPanel.getText());
        terminal.setText("Analisis finalizado"
                + "\nRevisar reportes");
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
    private javax.swing.JLabel imgLabel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel ruta;
    private javax.swing.JTextArea terminal;
    private javax.swing.JTextArea textPanel;
    // End of variables declaration//GEN-END:variables
}
