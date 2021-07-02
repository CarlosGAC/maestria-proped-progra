package com.itcg.proyectofinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

    private static final String LOGIN_USER = "itcg_admin";
    private static final String LOGIN_PASSWORD = "itcg_password";
    private static final String FILENAME = "agenda.json";

    public static void main(String args[]) {
        LoginData defaultCredentials = createDefaultCredentials();
        File agendaFile = createDatabaseIfItDoesntExist();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese usuario: ");
        String usuario = entrada.nextLine();
        System.out.println("Ingrese contrasena");
        String contrasena = entrada.nextLine();

        if (defaultCredentials.isLoginValid(usuario, contrasena)) {
            System.out.println("ENTRASTE");
        } else {
            System.err.println("NO ENTRASTE");
        }

        JSONObject jo = new JSONObject();
        JSONArray array = new JSONArray();

    }

    private static LoginData createDefaultCredentials() {
        return new LoginData(LOGIN_USER, LOGIN_PASSWORD);
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
            obj = (JSONObject)parser.parse(new FileReader(FILENAME));
            System.out.println(obj.toJSONString());
        } catch(ParseException e) {
            System.err.println("Ha ocurrido un error en la lectura del archivo");
            System.err.println(e.getMessage());
        } catch(FileNotFoundException e) {
            System.err.println("No se encontro el archivo");
            System.err.println(e.getMessage());
        } catch(IOException e) {
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
                System.out.println("La Agenda ha sido creada en el archivo " + f.getAbsolutePath());
            } else {
                System.out.println("Warning: El archivo de Agenda ya existe en " + f.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error");
            System.err.println(e.getMessage());
        }

        return f;
    }

}
