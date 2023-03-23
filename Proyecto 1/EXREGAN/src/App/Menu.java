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
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setExtendedState(Menu.MAXIMIZED_BOTH);
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
        AEbtn = new javax.swing.JButton();
        ruta = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        terminal = new javax.swing.JTextArea();
        erroresbtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPanel = new javax.swing.JTextArea();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EXREGAN USAC");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane1.setAutoscrolls(true);

        comboArchivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo archivo", "Abrir archivo", "Guardar", "Guardar como" }));
        comboArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboArchivoActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(comboArchivo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(138, 6, 216, 40);

        comboReports.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arboles", "Siguientes", "Transiciones", "JSON de salida", "AFD", "AFND" }));
        comboReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboReportsActionPerformed(evt);
            }
        });
        getContentPane().add(comboReports);
        comboReports.setBounds(500, 6, 216, 40);
        getContentPane().add(imgLabel);
        imgLabel.setBounds(500, 53, 970, 384);

        AEbtn.setText("Analizar archivo");
        AEbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEbtnActionPerformed(evt);
            }
        });
        getContentPane().add(AEbtn);
        AEbtn.setBounds(10, 684, 470, 40);
        getContentPane().add(ruta);
        ruta.setBounds(1427, 47, 584, 0);

        terminal.setBackground(new java.awt.Color(0, 0, 0));
        terminal.setColumns(20);
        terminal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        terminal.setForeground(new java.awt.Color(255, 255, 255));
        terminal.setRows(5);
        jScrollPane3.setViewportView(terminal);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(500, 466, 1020, 320);

        erroresbtn.setText("Ver errores");
        erroresbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                erroresbtnActionPerformed(evt);
            }
        });
        getContentPane().add(erroresbtn);
        erroresbtn.setBounds(10, 734, 470, 40);

        textPanel.setBackground(new java.awt.Color(0, 0, 0));
        textPanel.setColumns(20);
        textPanel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textPanel.setForeground(new java.awt.Color(51, 255, 51));
        textPanel.setRows(5);
        jScrollPane4.setViewportView(textPanel);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 60, 473, 627);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboArchivoActionPerformed
        String seleccion = (String) comboArchivo.getSelectedItem();
        this.setVisible(false);
        JFileChooser jf = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Entradas");
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
                JFileChooser jf1 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\Arboles_201712602");
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
                            img.getImage().getScaledInstance(imgLabel.getWidth() - 500, imgLabel.getHeight(), Image.SCALE_DEFAULT)
                    );

                    imgLabel.setIcon(icon);
                    terminal.setText("Imagen del arbol cargada con exito");
                }
                break;
            case "Siguientes":
                this.setVisible(false);
                JFileChooser jf2 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\SIGUIENTES_201712602");
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
                JFileChooser jf3 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\TRANSICIONES_201712602");
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
            case "AFD":
                this.setVisible(false);
                JFileChooser jf4 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\AFD_201712602");
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
                    terminal.setText("Imagen de AFD cargada con exito");
                }
                break;
            case "JSON de salida":
                this.setVisible(false);
                JFileChooser jf5 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\SALIDAS_201712602");
                FileFilter filter5 = new FileNameExtensionFilter("JSON File", "json");
                File archivo5;
                terminal.setText("");
                jf5.setApproveButtonText("Cargar json");
                jf5.setFileFilter(filter5);
                jf5.showOpenDialog(null);
                String texto = "";
                if (jf5.getSelectedFile() != null) {
                    archivo5 = new File(jf5.getSelectedFile() + "");
                    try {
                        InputStream ins = new FileInputStream(archivo5.getAbsolutePath());
                        Scanner obj = new Scanner(ins);
                        String salto = System.lineSeparator();
                        while (obj.hasNextLine()) {
                            texto += obj.nextLine() + System.lineSeparator();
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    terminal.setText(texto);
                }
                break;
            case "AFND":
                this.setVisible(false);
                JFileChooser jf6 = new JFileChooser("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\AFND_201712602");
                FileFilter filter6 = new FileNameExtensionFilter("JPG File", "jpg");
                File archivo6;
                terminal.setText("");
                jf6.setApproveButtonText("Cargar automata");
                jf6.setFileFilter(filter6);
                jf6.showOpenDialog(null);
                if (jf6.getSelectedFile() != null) {
                    archivo6 = new File(jf6.getSelectedFile() + "");
                    ImageIcon img = new ImageIcon(archivo6.getAbsolutePath());
                    Icon icon = new ImageIcon(
                            img.getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_DEFAULT)
                    );

                    imgLabel.setIcon(icon);
                    terminal.setText("Imagen de AFND cargada con exito");
                }
                break;
            default:
                throw new AssertionError();
        }
        this.setVisible(true);
    }//GEN-LAST:event_comboReportsActionPerformed

    private void AEbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEbtnActionPerformed
        String texto = textPanel.getText();
        if (texto.isBlank()) {
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Ingrese algo para poder analizar", "No hay nada que analizar", JOptionPane.WARNING_MESSAGE);
            this.setVisible(true);
            terminal.setText("No hay nada para analizar");
        } else {
            interpretar(textPanel.getText());
            terminal.setText("Analisis finalizado"
                    + "\nRevisar reportes");
        }
    }//GEN-LAST:event_AEbtnActionPerformed

    private void erroresbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_erroresbtnActionPerformed
        try {
            File file = new File("C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\ERRORES_201712602\\errores.html");
            if (!Desktop.isDesktopSupported()) {
                terminal.setText("Archivo de errores no soportado");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                terminal.setText("Archivo abierto, revise su navegador predeterminado");
                desktop.open(file);
            }
        } catch (IOException e) {
        }
    }//GEN-LAST:event_erroresbtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JComboBox<String> comboArchivo;
    private javax.swing.JComboBox<String> comboReports;
    private javax.swing.JButton erroresbtn;
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
