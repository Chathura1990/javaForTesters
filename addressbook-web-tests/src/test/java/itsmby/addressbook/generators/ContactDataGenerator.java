package itsmby.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import itsmby.addressbook.model.ContactData;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

        @Parameter(names = "-c", description = "Contact count")
        public int count;

        @Parameter(names = "-f", description = "Target file")
        public String file;

        @Parameter(names = "-d", description = "Data format")
        public String format;

        public static void main(String[] args) throws IOException {
            itsmby.addressbook.generators.ContactDataGenerator generator = new itsmby.addressbook.generators.ContactDataGenerator();
            JCommander jCommander = new JCommander(generator);
            try{
                jCommander.parse(args);
            }catch (ParameterException ex){
                jCommander.usage();
                return;
            }
            generator.run();
        }

        private void run() throws IOException {
            List<ContactData> contacts = generateContacts(count);
            switch (format) {
                case "xml":
                    saveAsXml(contacts, new File(file));
                    break;
                case "json":
                    saveAsJson(contacts, new File(file));
                    break;
                default:
                    System.out.println("Unrecognized format " + format);
                    break;
            }
        }

        private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
            Gson gson =new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
            String json = gson.toJson(contacts);
            try(Writer writer = new FileWriter(file)) {
                writer.write(json);
            }
        }

        private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            String xml = xstream.toXML(contacts);
            try(Writer writer = new FileWriter(file)) {
                writer.write(xml);
            }
        }

        private List<ContactData> generateContacts(int count) {
            List<ContactData> contacts =  new ArrayList<>();
            for (int i = 0; i<count; i++)
                contacts.add(new ContactData().firstName(String.format(RandomStringUtils.randomAlphanumeric(4) + " %s", i))
                        .middleName(String.format(RandomStringUtils.randomAlphanumeric(1) + " %s", i))
                        .lastName(String.format(RandomStringUtils.randomAlphanumeric(5) + " %s", i))
                        .nickname(String.format(RandomStringUtils.randomAlphanumeric(3) + " %s", i))
                        .companyName(String.format(RandomStringUtils.randomAlphanumeric(3) + " %s", i))
                        .homePhone(String.format(RandomStringUtils.randomNumeric(8) + " %s", i))
                        .emailAddress(String.format(RandomStringUtils.randomAlphanumeric(6) + "@tech.io %s", i)));
            return contacts;
        }
    }
