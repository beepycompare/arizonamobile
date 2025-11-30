package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateSerializer;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class B8 extends C8 implements ProtobufStateSerializer {
    public B8(ProtobufStateSerializer<MessageNano> protobufStateSerializer, AESEncrypter aESEncrypter) {
        super(protobufStateSerializer, aESEncrypter);
    }
}
