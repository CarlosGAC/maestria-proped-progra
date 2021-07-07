/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcg.proyectofinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author carlosga
 */
public class MainMenu extends javax.swing.JFrame {

    private static MainMenu mainMenu;
    private static String name;
    private static String address;
    private static String phone;
    private static String mail;
    private static String birthdayDay;
    private static String birthdayMonth;

    private static JSONObject database;
    private static final String FILENAME = "agenda.json";
    private static File agendaFile;

    private static long showContactID;

    private void clearAllFieldsFromAddContactForm() {
        nameField.setText("");
        addressField.setText("");
        mailField.setText("");
        phoneField.setText("");
        birthdayDayField.setSelectedIndex(0);
        birthdayMonthField.setSelectedIndex(0);
    }

    private static void writeToDatabaseFile(JSONObject jo) {
        try (FileWriter fileWriter = new FileWriter(FILENAME)) {
            fileWriter.write(jo.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error");
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo escribir en la base de datos", "Error de IO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static JSONObject readFromDatabaseFile() {

        JSONParser parser = new JSONParser();

        JSONObject obj = null;

        try {
            obj = (JSONObject) parser.parse(new FileReader(FILENAME));
            System.out.println("Read Object: " + obj.toJSONString());
        } catch (ParseException e) {
            System.err.println("Ha ocurrido un error en la lectura del archivo");
            System.err.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("No se encontro el archivo");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ha ocurrio un error de IO");
            System.err.println(e.getMessage());
        }

        return obj;
    }

    private static File createDatabaseIfItDoesntExist() {
        File f = null;
        try {
            f = new File(FILENAME);
            if (f.createNewFile()) {
                if (f.canRead() && f.canWrite()) {
                    database = new JSONObject();
                    database.put("entries", new JSONArray());
                    database.put("idCount", 0);
                    System.out.println(database.toJSONString());
                    writeToDatabaseFile(database);
                } else {
                    System.out.println("Error: La aplicacion no tiene permisos de lectura o escritura");
                }
                System.out.println("La Agenda ha sido creada en el archivo " + f.getAbsolutePath());
            } else {
                if (!f.canRead() || !f.canWrite()) {
                    System.out.println("Error: La aplicacion no tiene permisos de lectura o escritura");
                }
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error");
            System.err.println(e.getMessage());
        }

        return f;
    }

    private List<Persona> getAllContacts() {
        List<Persona> personaList = new ArrayList<>();

        JSONObject base = readFromDatabaseFile();

        JSONArray array = (JSONArray) base.get("entries");
        //System.out.println(array.size());

        ListIterator li = array.listIterator();

        while (li.hasNext()) {
            Map m = (Map) li.next();
            long mapId = (long) m.get("id");
            String mapName = (String) m.get("name");
            String mapAddress = (String) m.get("address");
            String mapPhone = (String) m.get("phone");
            String mapMail = (String) m.get("mail");
            String mapBirthdayDay = (String) m.get("birthdayDay");
            String mapBirthdayMonth = (String) m.get("birthdayMonth");

            personaList.add(new Persona(mapId, mapName, mapAddress, mapPhone, mapMail, mapBirthdayDay, mapBirthdayMonth));
            //System.out.println(m.entrySet());
        }
        return personaList;
    }

    private void setContactListToDatabaseModel(List<Persona> databaseModel) {

        DefaultListModel<String> model = new DefaultListModel<>();

        databaseModel.forEach(persona -> {
            model.addElement("ID:" + persona.getId() + "     Nombre:" + persona.getNombre());
        });

        contactList.setModel(model);
        if(contactList.getModel().getSize() == 0) {
            contactList.setEnabled(false);
        } else {
            contactList.setEnabled(true);
        }
        
        contactList.repaint();
    }

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        agendaFile = createDatabaseIfItDoesntExist();
        setContactListToDatabaseModel(getAllContacts());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addContactDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        addressLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        mailLabel = new javax.swing.JLabel();
        mailField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        birthdayLabel = new javax.swing.JLabel();
        birthdayMonthField = new javax.swing.JComboBox<>();
        birthdayDayField = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        addNewContact = new javax.swing.JButton();
        showContactDialog = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        editContact = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        nameLabel1 = new javax.swing.JLabel();
        showNameField = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        addressLabel1 = new javax.swing.JLabel();
        showAddressField = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        phoneLabel1 = new javax.swing.JLabel();
        showPhoneField = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        mailLabel1 = new javax.swing.JLabel();
        showMailField = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        birthdayLabel1 = new javax.swing.JLabel();
        showBirthdayMonthField = new javax.swing.JComboBox<>();
        showBirthdayDayField = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        acceptEditContact = new javax.swing.JButton();
        deleteContact = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addContact = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        instructions = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList<>();

        addContactDialog.setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        title.setFont(new java.awt.Font("Karla", 1, 48)); // NOI18N
        title.setForeground(new java.awt.Color(43, 57, 74));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Nuevo Contacto");
        title.setPreferredSize(new java.awt.Dimension(358, 90));
        jPanel2.add(title);

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel.setLabelFor(nameField);
        nameLabel.setText("Nombre:");
        nameLabel.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel4.add(nameLabel);

        nameField.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel4.add(nameField);

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));

        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressLabel.setLabelFor(phoneField);
        addressLabel.setText("Dirección:");
        addressLabel.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel5.add(addressLabel);

        addressField.setPreferredSize(new java.awt.Dimension(250, 25));
        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });
        jPanel5.add(addressField);

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(245, 245, 245));

        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        phoneLabel.setLabelFor(phoneField);
        phoneLabel.setText("Teléfono:");
        phoneLabel.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel6.add(phoneLabel);

        phoneField.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel6.add(phoneField);

        jPanel3.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(245, 245, 245));

        mailLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mailLabel.setLabelFor(mailField);
        mailLabel.setText("Mail:");
        mailLabel.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel7.add(mailLabel);

        mailField.setPreferredSize(new java.awt.Dimension(250, 25));
        mailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailFieldActionPerformed(evt);
            }
        });
        jPanel7.add(mailField);

        jPanel3.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(245, 245, 245));

        birthdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        birthdayLabel.setLabelFor(birthdayDayField);
        birthdayLabel.setText("Cumpleaños:");
        birthdayLabel.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel8.add(birthdayLabel);

        birthdayMonthField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        birthdayMonthField.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel8.add(birthdayMonthField);

        birthdayDayField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        birthdayDayField.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel8.add(birthdayDayField);

        jPanel3.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(245, 245, 245));

        addNewContact.setText("A G R E G A R");
        addNewContact.setPreferredSize(new java.awt.Dimension(250, 50));
        addNewContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addNewContact, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addNewContact, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel9);

        jPanel2.add(jPanel3);

        javax.swing.GroupLayout addContactDialogLayout = new javax.swing.GroupLayout(addContactDialog.getContentPane());
        addContactDialog.getContentPane().setLayout(addContactDialogLayout);
        addContactDialogLayout.setHorizontalGroup(
            addContactDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        addContactDialogLayout.setVerticalGroup(
            addContactDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addContactDialogLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
        );

        jPanel12.setBackground(new java.awt.Color(245, 245, 245));

        title1.setFont(new java.awt.Font("Karla", 1, 48)); // NOI18N
        title1.setForeground(new java.awt.Color(43, 57, 74));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Mostrar Contacto");
        title1.setPreferredSize(new java.awt.Dimension(400, 90));
        jPanel12.add(title1);

        jPanel10.setBackground(new java.awt.Color(245, 245, 245));
        jPanel10.setPreferredSize(new java.awt.Dimension(30, 100));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel10);

        editContact.setText("Editar");
        editContact.setPreferredSize(new java.awt.Dimension(90, 50));
        editContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContactActionPerformed(evt);
            }
        });
        jPanel12.add(editContact);

        jPanel13.setBackground(new java.awt.Color(245, 245, 245));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel14.setBackground(new java.awt.Color(245, 245, 245));

        nameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel1.setLabelFor(nameField);
        nameLabel1.setText("Nombre:");
        nameLabel1.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel14.add(nameLabel1);

        showNameField.setEditable(false);
        showNameField.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel14.add(showNameField);

        jPanel13.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(245, 245, 245));

        addressLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressLabel1.setLabelFor(phoneField);
        addressLabel1.setText("Dirección:");
        addressLabel1.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel15.add(addressLabel1);

        showAddressField.setEditable(false);
        showAddressField.setPreferredSize(new java.awt.Dimension(250, 25));
        showAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAddressFieldActionPerformed(evt);
            }
        });
        jPanel15.add(showAddressField);

        jPanel13.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(245, 245, 245));

        phoneLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        phoneLabel1.setLabelFor(phoneField);
        phoneLabel1.setText("Teléfono:");
        phoneLabel1.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel16.add(phoneLabel1);

        showPhoneField.setEditable(false);
        showPhoneField.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel16.add(showPhoneField);

        jPanel13.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(245, 245, 245));

        mailLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mailLabel1.setLabelFor(mailField);
        mailLabel1.setText("Mail:");
        mailLabel1.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel17.add(mailLabel1);

        showMailField.setEditable(false);
        showMailField.setPreferredSize(new java.awt.Dimension(250, 25));
        showMailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMailFieldActionPerformed(evt);
            }
        });
        jPanel17.add(showMailField);

        jPanel13.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(245, 245, 245));

        birthdayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        birthdayLabel1.setLabelFor(birthdayDayField);
        birthdayLabel1.setText("Cumpleaños:");
        birthdayLabel1.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel18.add(birthdayLabel1);

        showBirthdayMonthField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        showBirthdayMonthField.setPreferredSize(new java.awt.Dimension(150, 25));
        showBirthdayMonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBirthdayMonthFieldActionPerformed(evt);
            }
        });
        jPanel18.add(showBirthdayMonthField);

        showBirthdayDayField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        showBirthdayDayField.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel18.add(showBirthdayDayField);

        jPanel13.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(245, 245, 245));

        acceptEditContact.setText("Guardar Cambios");
        acceptEditContact.setPreferredSize(new java.awt.Dimension(250, 50));
        acceptEditContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptEditContactActionPerformed(evt);
            }
        });
        jPanel19.add(acceptEditContact);

        deleteContact.setText("Eliminar");
        deleteContact.setPreferredSize(new java.awt.Dimension(250, 50));
        deleteContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteContactActionPerformed(evt);
            }
        });
        jPanel19.add(deleteContact);

        jPanel13.add(jPanel19);

        jPanel12.add(jPanel13);

        javax.swing.GroupLayout showContactDialogLayout = new javax.swing.GroupLayout(showContactDialog.getContentPane());
        showContactDialog.getContentPane().setLayout(showContactDialogLayout);
        showContactDialogLayout.setHorizontalGroup(
            showContactDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        showContactDialogLayout.setVerticalGroup(
            showContactDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setFont(new java.awt.Font("Karla", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 57, 74));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido a Eldritch Agenda");

        addContact.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        addContact.setText("Agregar Contacto");
        addContact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addContact.setBorderPainted(false);
        addContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton2.setText("Buscar Contacto");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        instructions.setFont(new java.awt.Font("Martel", 0, 18)); // NOI18N
        instructions.setForeground(new java.awt.Color(43, 57, 74));
        instructions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructions.setText("Por favor, seleccione una opción");

        contactList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        contactList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(contactList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(instructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addContact, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instructions)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addContact, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailFieldActionPerformed

    }//GEN-LAST:event_mailFieldActionPerformed

    private long getIdCountFromDatabase() {
        JSONObject jo = readFromDatabaseFile();

        long id = (long) jo.get("idCount");
        return id;
    }

    // TODO Agregar ID para evitar problemas de consistencia
    private void addNewContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewContactActionPerformed
        getNewContactInfoFromFields();
        long nextId = getIdCountFromDatabase();
        if (validateNewContactInfo()) {
            System.out.println("Informacion validada");

            Map m = new LinkedHashMap(6);
            m.put("id", nextId);
            m.put("name", name);
            m.put("address", address);
            m.put("phone", phone);
            m.put("mail", mail);
            m.put("birthdayDay", birthdayDay);
            m.put("birthdayMonth", birthdayMonth);

            JSONObject currentDatabase = readFromDatabaseFile();
            JSONArray currentArray = (JSONArray) currentDatabase.get("entries");

            System.out.println("Current Array: " + currentArray.toJSONString());
            currentArray.add(m);

            System.out.println("New Array: " + currentArray.toJSONString());

            currentDatabase.clear();
            currentDatabase.put("entries", currentArray);

            currentDatabase.put("idCount", nextId + 1);
            writeToDatabaseFile(currentDatabase);
            setContactListToDatabaseModel(getAllContacts());
            clearAllFieldsFromAddContactForm();
            JOptionPane.showMessageDialog(addContactDialog, "El Contacto se agregó satisfactoriamente", "Contacto Agregado", JOptionPane.INFORMATION_MESSAGE);
            addContactDialog.setVisible(false);
        } else {
            System.err.println("Hay problemas en la validacion de los datos");
        }
    }//GEN-LAST:event_addNewContactActionPerformed

    private void getNewContactInfoFromFields() {
        name = nameField.getText();
        address = addressField.getText();
        mail = mailField.getText();
        phone = phoneField.getText();
        birthdayDay = birthdayDayField.getSelectedItem().toString();
        birthdayMonth = birthdayMonthField.getSelectedItem().toString();
    }
    
    private void getEditContactInfoFromFields() {
        name = showNameField.getText();
        address = showAddressField.getText();
        mail = showMailField.getText();
        phone = showPhoneField.getText();
        birthdayDay = showBirthdayDayField.getSelectedItem().toString();
        birthdayMonth = showBirthdayMonthField.getSelectedItem().toString();
    }

    private boolean validateNewContactInfo() {
        return validateBlankOrEmpty(name, "Nombre")
                && validateBlankOrEmpty(address, "Direccion")
                && validateBlankOrEmpty(phone, "Telefono")
                && validateBlankOrEmpty(mail, "Mail")
                && validatePhoneNumber(phone);
    }

    private boolean validateBlankOrEmpty(String fieldValue, String fieldName) {
        String errorTitle = "Error de captura";
        int messageType = JOptionPane.ERROR_MESSAGE;

        if (fieldValue.isBlank() || fieldValue.isEmpty()) {
            System.err.println("El campo " + fieldName + " es incorrecto");
            JOptionPane.showMessageDialog(null, "El campo " + fieldName + " está vacío", errorTitle, messageType);
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^[0-9]{10}$")) {
            return true;
        } else {
            System.err.println("El numero telefonico tiene formato incorrecto");
            JOptionPane.showMessageDialog(null, "El campo debe ser a 10 numeros", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressFieldActionPerformed

    private void addContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContactActionPerformed
        // mainMenu.setVisible(false);
        addContactDialog.pack();
        addContactDialog.setVisible(true);
    }//GEN-LAST:event_addContactActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        getAllContacts();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void contactListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactListMouseClicked
        // TODO add your handling code here:
        JList list = (JList) evt.getSource();
        switch (evt.getClickCount()) {
            case 1:
                System.out.println("Clickeaste una vez");
                break;
            case 2:
                System.out.println("Clickeaste dos veces");
                list.locationToIndex(evt.getPoint());
                System.out.println("En el elemento " + list.getSelectedValue());
                Object selectedValue = list.getSelectedValue();
                
                try {
                        System.out.println("Si entro");
                        setShowContactDialogData((String) list.getSelectedValue());
                    

                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(this, "El Contacto no existe", "Error: Contacto no Encontrado", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.getMessage());
                    break;
                } catch(NullPointerException e) {
                    JOptionPane.showMessageDialog(this, "La lista de Contactos está vacía", "Error: Lista Vacía", JOptionPane.ERROR_MESSAGE);
                    System.out.println("La lista de Contactos esta vacia");
                    break;
                }
                showContactDialog.pack();
                showContactDialog.setVisible(true);

                break;

            default:
                System.out.println("Clickeaste un chingo");
                break;
        }
    }//GEN-LAST:event_contactListMouseClicked

    private void showAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showAddressFieldActionPerformed

    private void showMailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showMailFieldActionPerformed

    private void acceptEditContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptEditContactActionPerformed
        enableShowContactFields(false);
        System.out.println("Boton Guardar Cambios presionado");
        getEditContactInfoFromFields();
            Map m = new LinkedHashMap(6);
            m.put("id", showContactID);
            m.put("name", name);
            m.put("address", address);
            m.put("phone", phone);
            m.put("mail", mail);
            m.put("birthdayDay", birthdayDay);
            m.put("birthdayMonth", birthdayMonth);
            
        editContact(m);
    }//GEN-LAST:event_acceptEditContactActionPerformed

    private void deleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteContactActionPerformed
        System.out.println("Boton Eliminar presionado");
        try {
            Map m = searchDatabaseById(showContactID);
            int confirm = JOptionPane.showConfirmDialog(showContactDialog, "Está seguro de que desea eliminar el registro?","Confirmar Eliminación" , JOptionPane.YES_NO_OPTION);
            if(confirm == 0) {
                deleteContact(m);
                setContactListToDatabaseModel(getAllContacts());
                showContactDialog.setVisible(false);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_deleteContactActionPerformed

    private void editContact(Map objectToEdit) {
        JSONObject jo = readFromDatabaseFile();
        
        JSONArray array = (JSONArray) jo.get("entries");
       
        JSONArray newArray = (JSONArray) array.clone();
        
        int index = indexOfContactById((long)objectToEdit.get("id"));
        
        newArray.set(index, objectToEdit);
        
        jo.remove("entries");
        jo.put("entries", newArray);
        writeToDatabaseFile(jo);
        setContactListToDatabaseModel(getAllContacts());
        JOptionPane.showMessageDialog(showContactDialog, "El Contacto ha sido editado satisfactoriamente", "Contacto Editado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private int indexOfContactById(long id) {
        JSONObject jo = readFromDatabaseFile();
        JSONArray array = (JSONArray) jo.get("entries");
        
        ListIterator li = array.listIterator();
        boolean found = false;
        
        Map m;
        while (li.hasNext() && !found) {
            m = (Map) li.next();

            long mapId = (long) m.get("id");
            System.out.println("Map ID: " + mapId);
            System.out.println("Contrasting ID: " + id);
            if (mapId == id) {
                return array.indexOf(m);
            }
        }
        return -1;
    }
    private void deleteContact(Map objectToDelete) {
        JSONObject jo = readFromDatabaseFile();

        JSONArray array = (JSONArray) jo.get("entries");
        JSONArray newArray = (JSONArray) array.clone();

        if (newArray.remove(objectToDelete)) {
            System.out.println("Se removio");
        } else {
            System.out.println("No se removio");
        }
        jo.remove("entries");
        jo.put("entries", newArray);
        writeToDatabaseFile(jo);
    }

    private void showBirthdayMonthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBirthdayMonthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showBirthdayMonthFieldActionPerformed

    private void editContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContactActionPerformed
        System.out.println("Boton Editar presionado");
        enableShowContactFields(true);
    }//GEN-LAST:event_editContactActionPerformed

    private void enableShowContactFields(boolean enabled) {
        showNameField.setEditable(enabled);
        showAddressField.setEditable(enabled);
        showPhoneField.setEditable(enabled);
        showMailField.setEditable(enabled);
        showBirthdayMonthField.setEnabled(enabled);
        showBirthdayDayField.setEnabled(enabled);
    }

    private void setShowContactDialogData(String selectedValue) throws IllegalStateException {
        String regex = "(ID:)[0-9]+";

        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(selectedValue);

        if (m.find()) {
            long id = Long.parseLong(m.group(0).split(":")[1]);
            System.out.println("ID: " + id);
            Map foundMap = searchDatabaseById(id);

            showContactID = id;

            showNameField.setText((String) foundMap.get("name"));
            showAddressField.setText((String) foundMap.get("address"));
            showMailField.setText((String) foundMap.get("mail"));
            showPhoneField.setText((String) foundMap.get("phone"));
            showBirthdayDayField.setSelectedItem(foundMap.get("birthdayDay"));
            showBirthdayMonthField.setSelectedItem(foundMap.get("birthdayMonth"));
        }
    }

    private Map searchDatabaseById(long id) {
        JSONObject jo = readFromDatabaseFile();

        JSONArray array = (JSONArray) jo.get("entries");

        ListIterator li = array.listIterator();
        boolean found = false;
        Map m = new LinkedHashMap<>();

        while (li.hasNext() && !found) {
            m = (Map) li.next();

            long mapId = (long) m.get("id");
            System.out.println("Map ID: " + mapId);
            System.out.println("Contrasting ID: " + id);
            if (mapId == id) {
                found = true;
            }

        }

        if (found) {
            return m;
        } else {
            throw new IllegalStateException("Contact with ID = " + id + " couldn't be found");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptEditContact;
    private javax.swing.JButton addContact;
    private javax.swing.JDialog addContactDialog;
    private javax.swing.JButton addNewContact;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JComboBox<String> birthdayDayField;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JLabel birthdayLabel1;
    private javax.swing.JComboBox<String> birthdayMonthField;
    private javax.swing.JList<String> contactList;
    private javax.swing.JButton deleteContact;
    private javax.swing.JButton editContact;
    private javax.swing.JLabel instructions;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mailField;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel mailLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel phoneLabel1;
    private javax.swing.JTextField showAddressField;
    private javax.swing.JComboBox<String> showBirthdayDayField;
    private javax.swing.JComboBox<String> showBirthdayMonthField;
    private javax.swing.JDialog showContactDialog;
    private javax.swing.JTextField showMailField;
    private javax.swing.JTextField showNameField;
    private javax.swing.JTextField showPhoneField;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    // End of variables declaration//GEN-END:variables
}
