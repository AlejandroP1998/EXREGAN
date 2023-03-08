package App;

import Analizador.parser;
import Analizador.scanner;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        comboReports.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arboles", "Siguientes", "Transiciones", "Automatas" }));
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

        jButton1.setText("Ver errores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver archivos de salida");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)
                                .addComponent(comboReports, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(674, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(AEbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GAbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AEbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GAbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
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

                } else {
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
        switch (seleccion) {
            case "Arboles":
                this.setVisible(false);
                JFileChooser jf1 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\Arboles_201712602");
                FileFilter filter1 = new FileNameExtensionFilter("JPG File", "jpg");
                File archivo;
                terminal.setText("");
                jf1.setApproveButtonText("Cargar arbol");
                jf1.setFileFilter(filter1);
                jf1.showOpenDialog(null);
                if (jf1.getSelectedFile() != null) {
                    archivo = new File(jf1.getSelectedFile() + "");
                    ImageIcon img = new ImageIcon(archivo.getAbsolutePath());
                    Icon icon = new ImageIcon(
                            img.getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_DEFAULT)
                    );

                    imgLabel.setIcon(icon);
                    terminal.setText("Imagen del arbol cargada con exito");
                }
                break;
            case "Siguientes":
                this.setVisible(false);
                JFileChooser jf2 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\SIGUIENTES_201712602");
                FileFilter filter2 = new FileNameExtensionFilter("JPG File", "jpg");
                File archivo2;
                terminal.setText("");
                jf2.setApproveButtonText("Cargar tabla");
                jf2.setFileFilter(filter2);
                jf2.showOpenDialog(null);
                if (jf2.getSelectedFile() != null) {
                    archivo2 = new File(jf2.getSelectedFile() + "");
                    ImageIcon img = new ImageIcon(archivo2.getAbsolutePath());
                    Icon icon = new ImageIcon(
                            img.getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_DEFAULT)
                    );

                    imgLabel.setIcon(icon);
                    terminal.setText("Imagen de tabla de siguientes cargada con exito");
                }
                break;
            case "Transiciones":
                this.setVisible(false);
                JFileChooser jf3 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\TRANSICIONES_201712602");
                FileFilter filter3 = new FileNameExtensionFilter("JPG File", "jpg");
                File archivo3;
                terminal.setText("");
                jf3.setApproveButtonText("Cargar tabla");
                jf3.setFileFilter(filter3);
                jf3.showOpenDialog(null);
                if (jf3.getSelectedFile() != null) {
                    archivo3 = new File(jf3.getSelectedFile() + "");
                    ImageIcon img = new ImageIcon(archivo3.getAbsolutePath());
                    Icon icon = new ImageIcon(
                            img.getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_DEFAULT)
                    );

                    imgLabel.setIcon(icon);
                    terminal.setText("Imagen de tabla de transiciones cargada con exito");
                }
                break;
            case "Automatas":
                this.setVisible(false);
                JFileChooser jf4 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\AFD_201712602");
                FileFilter filter4 = new FileNameExtensionFilter("JPG File", "jpg");
                File archivo4;
                terminal.setText("");
                jf4.setApproveButtonText("Cargar automata");
                jf4.setFileFilter(filter4);
                jf4.showOpenDialog(null);
                if (jf4.getSelectedFile() != null) {
                    archivo4 = new File(jf4.getSelectedFile() + "");
                    ImageIcon img = new ImageIcon(archivo4.getAbsolutePath());
                    Icon icon = new ImageIcon(
                            img.getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_DEFAULT)
                    );

                    imgLabel.setIcon(icon);
                    terminal.setText("Imagen de automatas cargada con exito");
                }
                break;
            default:
                throw new AssertionError();
        }
        this.setVisible(true);
    }//GEN-LAST:event_comboReportsActionPerformed

    private void GAbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GAbtnActionPerformed

    }//GEN-LAST:event_GAbtnActionPerformed

    private void AEbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEbtnActionPerformed
        interpretar(textPanel.getText());
        terminal.setText("Analisis finalizado"
                + "\nRevisar reportes");
    }//GEN-LAST:event_AEbtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
