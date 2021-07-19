/*
 * Copyright (c) 2000, 2017 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2021 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * @(#)BrokerAddressListChangedEvent.java	1.3 06/27/07
 */

package com.sun.messaging.jmq.jmsclient.notification;

import com.sun.messaging.jms.Connection;
import com.sun.messaging.jms.notification.ConnectionEvent;
import com.sun.messaging.jmq.jmsclient.resources.ClientResources;

/**
 * MQ Connection exit Event.
 *
 * <p>
 * This event is used by MQ client runtime only. This event is not delivered to the application.
 *
 * <p>
 * This event is generated by MQ client runtime and delivered to the EventHandler. When EventHandler receives this
 * event, it calls the Connection Exception Listener, and then closes the handler.
 */
public class BrokerAddressListChangedEvent extends ConnectionEvent {

    /**
     * 
     */
    private static final long serialVersionUID = -1287659921630449453L;

    private String addrList = null;

    /**
     *
     */
    public static final String CONNECTION_ADDRESS_LIST_CHANGED = ClientResources.E_CONNECTION_ADDRESS_LIST_CHANGED;

    /**
     * Construct a connection ADDRESS LIST CHANGED event.
     *
     * @param conn the connection that the event is associated with. MQ may automatically reconnect to the same broker or a
     * different broker depends on the client runtime configuration.
     * @param evCode the event code that represents this event object.
     * @param evMessage the event message that describes this event object.
     */
    public BrokerAddressListChangedEvent(Connection conn, String evCode, String evMessage, String addrList) {

        super(conn, evCode, evMessage);

        this.addrList = addrList;
    }

    public String getAddressList() {
        return this.addrList;
    }

}
