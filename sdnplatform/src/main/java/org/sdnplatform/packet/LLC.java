/*
 * Copyright (c) 2011,2013 Big Switch Networks, Inc.
 *
 * Licensed under the Eclipse Public License, Version 1.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *      http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *    Originally created by David Erickson, Stanford University 
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the
 *    License. You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an "AS
 *    IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *    express or implied. See the License for the specific language
 *    governing permissions and limitations under the License. 
 */

package org.sdnplatform.packet;

import java.nio.ByteBuffer;

/**
 * This class represents an Link Local Control
 * header that is used in Ethernet 802.3.
 * @author alexreimers
 *
 */
public class LLC extends BasePacket {
    private byte dsap = 0;
    private byte ssap = 0;
    private byte ctrl = 0;
    
    public byte getDsap() {
        return dsap;
    }

    public void setDsap(byte dsap) {
        this.dsap = dsap;
    }

    public byte getSsap() {
        return ssap;
    }

    public void setSsap(byte ssap) {
        this.ssap = ssap;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public byte[] serialize() {
        byte[] data = new byte[3];
        ByteBuffer bb = ByteBuffer.wrap(data);
        bb.put(dsap);
        bb.put(ssap);
        bb.put(ctrl);
        return data;
    }

    @Override
    public IPacket deserialize(byte[] data, int offset, int length) {
        ByteBuffer bb = ByteBuffer.wrap(data, offset, length);
        dsap = bb.get();
        ssap = bb.get();
        ctrl = bb.get();
        return this;
    }
}
