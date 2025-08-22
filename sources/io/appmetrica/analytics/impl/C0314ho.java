package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ho  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0314ho extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile C0314ho[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f896a;
    public int b;
    public C0339io c;
    public C0365jo d;

    public C0314ho() {
        a();
    }

    public static C0314ho[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new C0314ho[0];
                }
            }
        }
        return i;
    }

    public final C0314ho a() {
        this.f896a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.f896a) + super.computeSerializedSize();
        C0339io c0339io = this.c;
        if (c0339io != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0339io);
        }
        C0365jo c0365jo = this.d;
        return c0365jo != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0365jo) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f896a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        C0339io c0339io = this.c;
        if (c0339io != null) {
            codedOutputByteBufferNano.writeMessage(3, c0339io);
        }
        C0365jo c0365jo = this.d;
        if (c0365jo != null) {
            codedOutputByteBufferNano.writeMessage(4, c0365jo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0314ho mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f896a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0339io();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0365jo();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0314ho b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0314ho().mergeFrom(codedInputByteBufferNano);
    }

    public static C0314ho a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0314ho) MessageNano.mergeFrom(new C0314ho(), bArr);
    }
}
