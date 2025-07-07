package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class N extends MessageNano {
    public static volatile N[] d;

    /* renamed from: a  reason: collision with root package name */
    public K f1279a;
    public M b;
    public L c;

    public N() {
        a();
    }

    public static N[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new N[0];
                }
            }
        }
        return d;
    }

    public final N a() {
        this.f1279a = null;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        K k = this.f1279a;
        if (k != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, k);
        }
        M m = this.b;
        if (m != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, m);
        }
        L l = this.c;
        return l != null ? CodedOutputByteBufferNano.computeMessageSize(3, l) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        K k = this.f1279a;
        if (k != null) {
            codedOutputByteBufferNano.writeMessage(1, k);
        }
        M m = this.b;
        if (m != null) {
            codedOutputByteBufferNano.writeMessage(2, m);
        }
        L l = this.c;
        if (l != null) {
            codedOutputByteBufferNano.writeMessage(3, l);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final N mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1279a == null) {
                    this.f1279a = new K();
                }
                codedInputByteBufferNano.readMessage(this.f1279a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new M();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new L();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static N b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new N().mergeFrom(codedInputByteBufferNano);
    }

    public static N a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (N) MessageNano.mergeFrom(new N(), bArr);
    }
}
