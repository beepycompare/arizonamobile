package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class J8 extends MessageNano {
    public static volatile J8[] c;

    /* renamed from: a  reason: collision with root package name */
    public E8 f490a;
    public G8 b;

    public J8() {
        a();
    }

    public static J8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new J8[0];
                }
            }
        }
        return c;
    }

    public final J8 a() {
        this.f490a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        E8 e8 = this.f490a;
        if (e8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, e8);
        }
        G8 g8 = this.b;
        return g8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, g8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        E8 e8 = this.f490a;
        if (e8 != null) {
            codedOutputByteBufferNano.writeMessage(1, e8);
        }
        G8 g8 = this.b;
        if (g8 != null) {
            codedOutputByteBufferNano.writeMessage(2, g8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final J8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f490a == null) {
                    this.f490a = new E8();
                }
                codedInputByteBufferNano.readMessage(this.f490a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new G8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static J8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new J8().mergeFrom(codedInputByteBufferNano);
    }

    public static J8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (J8) MessageNano.mergeFrom(new J8(), bArr);
    }
}
