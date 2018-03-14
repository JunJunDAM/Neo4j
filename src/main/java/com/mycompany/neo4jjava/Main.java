package com.mycompany.neo4jjava;

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu2015059
 */
public class Main {

    //http://www.informit.com/articles/article.aspx?p=2415371
    
    public static void main(String[] args) {
        GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();
        GraphDatabaseService graphDbService = graphDbFactory
                .newEmbeddedDatabase(new File("C:\\Users\\alu2015059\\Desktop\\neo4j-community-3.3.3\\data\\databases\\Movies"));
        
        Node myNode = graphDbService.createNode();
        
        myNode.setProperty("name", "Paco");
        myNode.addLabel(Labels.USER);
        Node myNode = graphDbService.createNode(Labels.USER);
    }
    
    private static void registerShutdownHook (final GraphDatabaseService graphDb){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override public void run(){
                graphDb.shutdown();
            }
        });
    }

    private enum Labels implements Label{
        USER,
        MOVIE;
    }
    
    public interface Label{
        String name();
    }
}
