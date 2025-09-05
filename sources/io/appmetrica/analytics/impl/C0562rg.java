package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.rg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0562rg extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static volatile C0562rg[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1063a;
    public long b;
    public long c;
    public int d;

    public C0562rg() {
        a();
    }

    public static C0562rg[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new C0562rg[0];
                }
            }
        }
        return h;
    }

    public final C0562rg a() {
        this.f1063a = WireFormatNano.EMPTY_BYTES;
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeBytesSize = CodedOutputByteBufferNano.computeBytesSize(1, this.f1063a) + super.computeSerializedSize();
        long j = this.b;
        if (j != 0) {
            computeBytesSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.c;
        if (j2 != 0) {
            computeBytesSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        int i = this.d;
        return i != 0 ? CodedOutputByteBufferNano.computeInt32Size(4, i) + computeBytesSize : computeBytesSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f1063a);
        long j = this.b;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.c;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        int i = this.d;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0562rg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1063a = codedInputByteBufferNano.readBytes();
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
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.d = readInt32;
                }
            }
        }
        return this;
    }

    public static C0562rg b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0562rg().mergeFrom(codedInputByteBufferNano);
    }

    public static C0562rg a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0562rg) MessageNano.mergeFrom(new C0562rg(), bArr);
    }
}
