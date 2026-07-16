package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Cg extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile Cg[] i;

    /* renamed from: a  reason: collision with root package name */
    public String f500a;
    public long b;
    public long c;
    public int d;

    public Cg() {
        a();
    }

    public static Cg[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new Cg[0];
                }
            }
        }
        return i;
    }

    public final Cg a() {
        this.f500a = "";
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f500a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f500a);
        }
        long j = this.b;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.c;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        int i2 = this.d;
        return i2 != 0 ? CodedOutputByteBufferNano.computeInt32Size(4, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f500a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f500a);
        }
        long j = this.b;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.c;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        int i2 = this.d;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Cg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f500a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.d = readInt32;
                }
            }
        }
        return this;
    }

    public static Cg b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Cg().mergeFrom(codedInputByteBufferNano);
    }

    public static Cg a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Cg) MessageNano.mergeFrom(new Cg(), bArr);
    }
}
