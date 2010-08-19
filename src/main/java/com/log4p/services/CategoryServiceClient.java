package com.log4p.services;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Client for the CategoryService.
 * <p/>
 * Client is setup in the constructor, calling callService will actually call all methods
 * of the category service.
 *
 * @author peter@maas-frensch.com
 */
public class CategoryServiceClient {
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceClient.class);

    private final CategoryService.Client client;


    public CategoryServiceClient() throws Exception {
        TSocket transport = new TSocket("localhost", 1234);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        client = new CategoryService.Client(protocol);
        transport.open();

        log.info("client ready");
    }

    public void callService() throws Exception {

        log.debug("calling 'CategoryService.Client#get'");
        Category category = client.get(123L);
        log.debug("returned category: " + category);

        log.debug("calling 'CategoryService.Client#getChildren'");
        List<Category> categories = client.getChildren(123L);
        log.debug("returned: " + categories);
    }

    /**
     * Run the client!
     *
     * @param args ignored
     * @throws Exception of anything fails
     */
    public static void main(String[] args) throws Exception {
        new CategoryServiceClient().callService();
    }
}
