package com.company;



import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

 class Parser {

    final String path;


    public Parser(String path) {
        this.path = path; //it is path to your XML file
    }


        ArrayList<Offer> getListOfOffers() {
        //return Array List Of offers from XML file

        /*
        if you have -1 in your list then you have caught an exception.
        if you have null in your list then data was not write
         */
        final int INITIAL_CAPACITY = 280;
        String ref = null;
        String title = null;
        String puBDate = null;
        ArrayList<Offer> list = new ArrayList<>(INITIAL_CAPACITY);

        XMLInputFactory factory = XMLInputFactory.newInstance();

       try {

           XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(path));

           String nextEventData;

           while (reader.hasNext()) {
               XMLEvent nextEvent = reader.nextEvent();

               if(nextEvent.isStartElement()) {
                   StartElement startElement = nextEvent.asStartElement();

                   switch (startElement.getName().getLocalPart()) {
                       case "title":
                           nextEvent = reader.nextEvent();
                           nextEventData = nextEvent.asCharacters().getData();
                           if(nextEventData.equals("Vacancies rss")) {
                               break;
                           }
                           else {
                               title = nextEventData;
                           }
                           break;
                       case "guid":
                           nextEvent = reader.nextEvent();
                           nextEventData = nextEvent.asCharacters().getData();
                           ref = nextEventData;
                           break;
                       case "pubDate":
                           nextEvent = reader.nextEvent();
                           nextEventData = nextEvent.asCharacters().getData();
                           puBDate = nextEventData;
                           break;

                   }
                    if(ref != null && title != null && puBDate != null) {
                        list.add(new Offer(ref, title, puBDate));
                        ref = null;
                        title = null;
                        puBDate = null;
                    }
               }
           }

       } catch (XMLStreamException e) {

           System.out.println("\n\n\nERROR! XML STREAM EXCEPTION\n\n\n");
           list.add(new Offer("-1", "-1", "-1"));
           return list;

       } catch (FileNotFoundException e) {

           System.out.println("\n\n\nERROR! FILE NOT FOUND EXCEPTION");
           list.add(new Offer("-1", "-1", "-1"));
           return list;
       }

        return list;

    }
}
