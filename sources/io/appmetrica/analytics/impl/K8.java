package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class K8 extends MessageNano {
    public static volatile K8[] c;

    /* renamed from: a  reason: collision with root package name */
    public G8 f625a;
    public J8 b;

    public K8() {
        a();
    }

    public static K8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new K8[0];
                }
            }
        }
        return c;
    }

    public final K8 a() {
        this.f625a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        G8 g8 = this.f625a;
        if (g8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, g8);
        }
        J8 j8 = this.b;
        return j8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, j8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        G8 g8 = this.f625a;
        if (g8 != null) {
            codedOutputByteBufferNano.writeMessage(1, g8);
        }
        J8 j8 = this.b;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(2, j8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final K8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f625a == null) {
                    this.f625a = new G8();
                }
                codedInputByteBufferNano.readMessage(this.f625a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new J8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static K8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new K8().mergeFrom(codedInputByteBufferNano);
    }

    public static K8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (K8) MessageNano.mergeFrom(new K8(), bArr);
    }
}
