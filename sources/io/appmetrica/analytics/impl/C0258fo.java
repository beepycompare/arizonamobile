package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.fo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0258fo extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile C0258fo[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1006a;
    public int b;
    public C0284go c;
    public C0310ho d;

    public C0258fo() {
        a();
    }

    public static C0258fo[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new C0258fo[0];
                }
            }
        }
        return i;
    }

    public final C0258fo a() {
        this.f1006a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.f1006a) + super.computeSerializedSize();
        C0284go c0284go = this.c;
        if (c0284go != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0284go);
        }
        C0310ho c0310ho = this.d;
        return c0310ho != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0310ho) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f1006a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        C0284go c0284go = this.c;
        if (c0284go != null) {
            codedOutputByteBufferNano.writeMessage(3, c0284go);
        }
        C0310ho c0310ho = this.d;
        if (c0310ho != null) {
            codedOutputByteBufferNano.writeMessage(4, c0310ho);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0258fo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1006a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0284go();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0310ho();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0258fo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0258fo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0258fo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0258fo) MessageNano.mergeFrom(new C0258fo(), bArr);
    }
}
