package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.go  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0281go extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile C0281go[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f913a;
    public int b;
    public C0307ho c;
    public C0332io d;

    public C0281go() {
        a();
    }

    public static C0281go[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new C0281go[0];
                }
            }
        }
        return i;
    }

    public final C0281go a() {
        this.f913a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.f913a) + super.computeSerializedSize();
        C0307ho c0307ho = this.c;
        if (c0307ho != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0307ho);
        }
        C0332io c0332io = this.d;
        return c0332io != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0332io) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f913a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        C0307ho c0307ho = this.c;
        if (c0307ho != null) {
            codedOutputByteBufferNano.writeMessage(3, c0307ho);
        }
        C0332io c0332io = this.d;
        if (c0332io != null) {
            codedOutputByteBufferNano.writeMessage(4, c0332io);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0281go mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f913a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0307ho();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0332io();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0281go b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0281go().mergeFrom(codedInputByteBufferNano);
    }

    public static C0281go a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0281go) MessageNano.mergeFrom(new C0281go(), bArr);
    }
}
