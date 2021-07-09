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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author carlosga
 */
public class ContactsDatabase {
    
    private static ContactsDatabase contactsDatabase;
    
    private static final String FILENAME = "agenda.json";
    private static JSONObject database;
    
    public static ContactsDatabase getInstance() {
        if(contactsDatabase == null) {
            contactsDatabase = new ContactsDatabase();
        }
        return contactsDatabase;
    }
    
    private ContactsDatabase() {
        
    }
    
    public String getDatabaseFilename() {
        return FILENAME;
    }
    
       public File createDatabaseIfItDoesntExist() {
        File f = null;
        try {
            f = new File(FILENAME);
            if (f.createNewFile()) {
                if (f.canRead() && f.canWrite()) {
                    database = new JSONObject();
                    database.put("entries", new JSONArray());
                    database.put("idCount", 0);
                    System.out.println(database.toJSONString());
                    ContactsDatabase.getInstance().writeToDatabaseFile(database);
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
    
    
    public JSONObject readFromDatabaseFile() {

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
    
    public JSONArray getContactsArray() {
        JSONObject jo = readFromDatabaseFile();
        
        return (JSONArray)jo.get("entries");
    }
    
    public long getIDCount() {
        JSONObject jo = readFromDatabaseFile();
        
        long id = (long) jo.get("idCount");
        return id;
    }
    
      public void editContact(Map objectToEdit) {
        JSONObject jo = readFromDatabaseFile();
        
        JSONArray array = (JSONArray) jo.get("entries");
        JSONArray newArray = (JSONArray) array.clone();
        
        int index = indexOfContactById((long)objectToEdit.get("id"));
        
        newArray.set(index, objectToEdit);
        
        jo.remove("entries");
        jo.put("entries", newArray);
        ContactsDatabase.getInstance().writeToDatabaseFile(jo);
    }
      
        public void deleteContact(Map objectToDelete) {
        JSONObject jo = ContactsDatabase.getInstance().readFromDatabaseFile();

        JSONArray array = (JSONArray) jo.get("entries");
        JSONArray newArray = (JSONArray) array.clone();

        if (newArray.remove(objectToDelete)) {
            System.out.println("Se removio");
        } else {
            System.out.println("No se removio");
        }
        jo.remove("entries");
        jo.put("entries", newArray);
        ContactsDatabase.getInstance().writeToDatabaseFile(jo);
    }
      
    public Map findContactById(long id) {
        JSONObject jo = ContactsDatabase.getInstance().readFromDatabaseFile();

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
       
       
    public List<ContactEntry> getAllContacts() {
        List<ContactEntry> personaList = new ArrayList<>();

        JSONArray array = ContactsDatabase.getInstance().getContactsArray();
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

            personaList.add(new ContactEntry(mapId, mapName, mapAddress, mapPhone, mapMail, mapBirthdayDay, mapBirthdayMonth));
        }
        return personaList;
    }
       
    private int indexOfContactById(long id) {
        JSONObject jo = ContactsDatabase.getInstance().readFromDatabaseFile();
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
    
    public void addNewContact(Map contactMap, long nextId) {
        JSONObject currentDatabase = readFromDatabaseFile();
        JSONArray currentArray = (JSONArray) currentDatabase.get("entries");
            
            

        System.out.println("Current Array: " + currentArray.toJSONString());
        currentArray.add(contactMap);

        System.out.println("New Array: " + currentArray.toJSONString());

            currentDatabase.clear();
            currentDatabase.put("entries", currentArray);

            currentDatabase.put("idCount", nextId + 1);
            ContactsDatabase.getInstance().writeToDatabaseFile(currentDatabase);
    }
    
    public void writeToDatabaseFile(JSONObject jo) {
        try (FileWriter fileWriter = new FileWriter(FILENAME)) {
            fileWriter.write(jo.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error");
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo escribir en la base de datos", "Error de IO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
