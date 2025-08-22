package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class A8 extends MessageNano {
    public static volatile A8[] e;

    /* renamed from: a  reason: collision with root package name */
    public J8 f342a;
    public L8 b;
    public C8 c;
    public I8 d;

    public A8() {
        a();
    }

    public static A8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new A8[0];
                }
            }
        }
        return e;
    }

    public final A8 a() {
        this.f342a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        J8 j8 = this.f342a;
        if (j8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, j8);
        }
        L8 l8 = this.b;
        if (l8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, l8);
        }
        C8 c8 = this.c;
        if (c8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c8);
        }
        I8 i8 = this.d;
        return i8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, i8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        J8 j8 = this.f342a;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(1, j8);
        }
        L8 l8 = this.b;
        if (l8 != null) {
            codedOutputByteBufferNano.writeMessage(2, l8);
        }
        C8 c8 = this.c;
        if (c8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c8);
        }
        I8 i8 = this.d;
        if (i8 != null) {
            codedOutputByteBufferNano.writeMessage(4, i8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final A8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f342a == null) {
                    this.f342a = new J8();
                }
                codedInputByteBufferNano.readMessage(this.f342a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new L8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new I8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static A8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new A8().mergeFrom(codedInputByteBufferNano);
    }

    public static A8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (A8) MessageNano.mergeFrom(new A8(), bArr);
    }
}
