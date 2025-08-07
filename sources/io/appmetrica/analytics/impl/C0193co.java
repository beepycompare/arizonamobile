package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.co  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0193co extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile C0193co[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f805a;
    public int b;
    public Cdo c;
    public C0244eo d;

    public C0193co() {
        a();
    }

    public static C0193co[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new C0193co[0];
                }
            }
        }
        return i;
    }

    public final C0193co a() {
        this.f805a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.f805a) + super.computeSerializedSize();
        Cdo cdo = this.c;
        if (cdo != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, cdo);
        }
        C0244eo c0244eo = this.d;
        return c0244eo != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0244eo) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f805a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        Cdo cdo = this.c;
        if (cdo != null) {
            codedOutputByteBufferNano.writeMessage(3, cdo);
        }
        C0244eo c0244eo = this.d;
        if (c0244eo != null) {
            codedOutputByteBufferNano.writeMessage(4, c0244eo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0193co mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f805a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new Cdo();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0244eo();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0193co b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0193co().mergeFrom(codedInputByteBufferNano);
    }

    public static C0193co a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0193co) MessageNano.mergeFrom(new C0193co(), bArr);
    }
}
