package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class D8 extends MessageNano {
    public static volatile D8[] e;

    /* renamed from: a  reason: collision with root package name */
    public M8 f401a;
    public O8 b;
    public F8 c;
    public L8 d;

    public D8() {
        a();
    }

    public static D8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new D8[0];
                }
            }
        }
        return e;
    }

    public final D8 a() {
        this.f401a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        M8 m8 = this.f401a;
        if (m8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, m8);
        }
        O8 o8 = this.b;
        if (o8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, o8);
        }
        F8 f8 = this.c;
        if (f8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, f8);
        }
        L8 l8 = this.d;
        return l8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, l8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        M8 m8 = this.f401a;
        if (m8 != null) {
            codedOutputByteBufferNano.writeMessage(1, m8);
        }
        O8 o8 = this.b;
        if (o8 != null) {
            codedOutputByteBufferNano.writeMessage(2, o8);
        }
        F8 f8 = this.c;
        if (f8 != null) {
            codedOutputByteBufferNano.writeMessage(3, f8);
        }
        L8 l8 = this.d;
        if (l8 != null) {
            codedOutputByteBufferNano.writeMessage(4, l8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final D8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f401a == null) {
                    this.f401a = new M8();
                }
                codedInputByteBufferNano.readMessage(this.f401a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new O8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new F8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new L8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static D8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new D8().mergeFrom(codedInputByteBufferNano);
    }

    public static D8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (D8) MessageNano.mergeFrom(new D8(), bArr);
    }
}
