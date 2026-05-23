package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Io extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile Io[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f599a;
    public int b;
    public Jo c;
    public Ko d;

    public Io() {
        a();
    }

    public static Io[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new Io[0];
                }
            }
        }
        return i;
    }

    public final Io a() {
        this.f599a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.f599a) + super.computeSerializedSize();
        Jo jo = this.c;
        if (jo != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, jo);
        }
        Ko ko = this.d;
        return ko != null ? CodedOutputByteBufferNano.computeMessageSize(4, ko) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f599a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        Jo jo = this.c;
        if (jo != null) {
            codedOutputByteBufferNano.writeMessage(3, jo);
        }
        Ko ko = this.d;
        if (ko != null) {
            codedOutputByteBufferNano.writeMessage(4, ko);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Io mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f599a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new Jo();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new Ko();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static Io b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Io().mergeFrom(codedInputByteBufferNano);
    }

    public static Io a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Io) MessageNano.mergeFrom(new Io(), bArr);
    }
}
