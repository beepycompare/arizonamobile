package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Wm extends MessageNano {
    public static volatile Wm[] b;

    /* renamed from: a  reason: collision with root package name */
    public int f833a;

    public Wm() {
        a();
    }

    public static Wm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Wm[0];
                }
            }
        }
        return b;
    }

    public final Wm a() {
        this.f833a = 86400;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f833a;
        return i != 86400 ? CodedOutputByteBufferNano.computeUInt32Size(1, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f833a;
        if (i != 86400) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Wm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f833a = codedInputByteBufferNano.readUInt32();
            }
        }
        return this;
    }

    public static Wm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Wm().mergeFrom(codedInputByteBufferNano);
    }

    public static Wm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Wm) MessageNano.mergeFrom(new Wm(), bArr);
    }
}
