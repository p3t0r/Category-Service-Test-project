package com.log4p.services;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunCategoryServer {

    private static final Logger log = LoggerFactory.getLogger(RunCategoryServer.class);

    public static void main(String[] args) throws TTransportException {
        TServerSocket serverTransport = new TServerSocket(1234);
        CategoryService.Processor processor = new CategoryService.Processor(new CategoryServiceImpl());
        Factory protocolFactory = new TBinaryProtocol.Factory(true, true);
        TThreadPoolServer server = new TThreadPoolServer(processor, serverTransport, protocolFactory);

        log.info("server setup, starting on port: " + 1234);
        server.serve();


    }

}
