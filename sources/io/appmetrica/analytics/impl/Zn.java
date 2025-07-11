package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Zn extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile Zn[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f745a;
    public int b;
    public C0140ao c;
    public C0166bo d;

    public Zn() {
        a();
    }

    public static Zn[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new Zn[0];
                }
            }
        }
        return i;
    }

    public final Zn a() {
        this.f745a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.f745a) + super.computeSerializedSize();
        C0140ao c0140ao = this.c;
        if (c0140ao != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0140ao);
        }
        C0166bo c0166bo = this.d;
        return c0166bo != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0166bo) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f745a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        C0140ao c0140ao = this.c;
        if (c0140ao != null) {
            codedOutputByteBufferNano.writeMessage(3, c0140ao);
        }
        C0166bo c0166bo = this.d;
        if (c0166bo != null) {
            codedOutputByteBufferNano.writeMessage(4, c0166bo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Zn mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f745a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0140ao();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0166bo();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static Zn b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Zn().mergeFrom(codedInputByteBufferNano);
    }

    public static Zn a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Zn) MessageNano.mergeFrom(new Zn(), bArr);
    }
}
