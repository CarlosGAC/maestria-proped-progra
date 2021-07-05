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
        
        JSONArray array = (JSONArray)base.get("entries");
        //System.out.println(array.size());
        
        ListIterator li = array.listIterator();
        
        while(li.hasNext()) {
            Map m = (Map) li.next();
            long mapId = (long)m.get("id");
            String mapName = (String)m.get("name");
            String mapAddress = (String)m.get("address");
            String mapPhone = (String)m.get("phone");
            String mapMail = (String)m.get("mail");
            String mapBirthdayDay = (String)m.get("birthdayDay");
            String mapBirthdayMonth = (String)m.get("birthdayMonth");
            
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
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        showAddressField = new javax.swing.JTextField();
        showNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel10.setBackground(new java.awt.Color(245, 245, 245));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(43, 57, 74));
        jLabel4.setFont(new java.awt.Font("sansserif", 0, 48)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mostrar Contacto");
        jPanel10.add(jLabel4, java.awt.BorderLayout.NORTH);

        jPanel11.setBackground(new java.awt.Color(245, 245, 245));

        showAddressField.setText("jTextField2");

        showNameField.setText("jTextField1");

        jLabel3.setText("Dirección:");

        jLabel2.setText("Nombre:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(321, 321, 321)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(showNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(428, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(showNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(showAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(146, Short.MAX_VALUE)))
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout showContactDialogLayout = new javax.swing.GroupLayout(showContactDialog.getContentPane());
        showContactDialog.getContentPane().setLayout(showContactDialogLayout);
        showContactDialogLayout.setHorizontalGroup(
            showContactDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showContactDialogLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        showContactDialogLayout.setVerticalGroup(
            showContactDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showContactDialogLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        
        long id = (long)jo.get("idCount");
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
            JSONArray currentArray = (JSONArray)currentDatabase.get("entries");
            
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
        JList list = (JList)evt.getSource();
        switch (evt.getClickCount()) {
            case 1:
                System.out.println("Clickeaste una vez");
                break;
            case 2:
                System.out.println("Clickeaste dos veces");
                list.locationToIndex(evt.getPoint());
                System.out.println("En el elemento " + list.getSelectedValue());
                setShowContactDialogData((String)list.getSelectedValue());
                showContactDialog.pack();
                showContactDialog.setVisible(true);
                break;
            default:
                System.out.println("Clickeaste un chingo");
                break;
        }
    }//GEN-LAST:event_contactListMouseClicked

    private void setShowContactDialogData(String selectedValue) {
        String regex ="(ID:)[0-9]+";
        
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(selectedValue);
        
        if(m.find()) {
            long id = Long.parseLong(m.group(0).split(":")[1]);
            System.out.println("ID: " + id);
            Map foundMap = searchDatabaseById(id);
            
            showNameField.setText((String)foundMap.get("name"));
            showAddressField.setText((String)foundMap.get("address"));
        }
    }
    
    private Map searchDatabaseById(long id) {
        JSONObject jo = readFromDatabaseFile();
        
        JSONArray array = (JSONArray)jo.get("entries");
        
        ListIterator li = array.listIterator();
        boolean found = false;
        Map m = new LinkedHashMap<>();
        
        while(li.hasNext() && !found) {
            m = (Map)li.next();
            
            long mapId = (long)m.get("id");
            System.out.println("Map ID: " + mapId);
            System.out.println("Contrasting ID: " + id);
            if(mapId == id) {
                found = true;
            }
            
        }
        
        return m;
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
    private javax.swing.JButton addContact;
    private javax.swing.JDialog addContactDialog;
    private javax.swing.JButton addNewContact;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JComboBox<String> birthdayDayField;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JComboBox<String> birthdayMonthField;
    private javax.swing.JList<String> contactList;
    private javax.swing.JLabel instructions;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField showAddressField;
    private javax.swing.JDialog showContactDialog;
    private javax.swing.JTextField showNameField;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
