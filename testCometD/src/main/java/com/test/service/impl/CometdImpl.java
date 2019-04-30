package com.test.service.impl;

import com.test.service.ICometd;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;

import javax.inject.Inject;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/29
 */
@Service("cometd")
public class CometdImpl implements ICometd {
    @Inject
    private BayeuxServer _bayeux;
    @Session
    private ServerSession _session;

    @Override
    public void call(Object cometdMessage, String topic) {

    }
}
