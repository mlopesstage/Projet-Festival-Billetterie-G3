/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author sjudais
 */
public class WritePropertiesFiles {
    public static void main(final String[] args) {

	final Properties prop = new Properties();
	OutputStream output = null;

	try {

            output = new FileOutputStream("src/domaine/properties/config.properties");

            // set the properties value
            prop.setProperty("db.password", "joliverie");
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.username", "root");           

            // save properties to project root folder
            prop.store(output, null);

	} catch (final IOException io) {
            io.printStackTrace();
	} finally {
            if (output != null) {
		try {
                    output.close();
		} catch (final IOException e) {
                    e.printStackTrace();
		}
            }
	}
    }
}
