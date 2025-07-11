package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class H7 extends MessageNano {
    public static volatile H7[] d;

    /* renamed from: a  reason: collision with root package name */
    public long f457a;
    public long b;
    public int c;

    public H7() {
        a();
    }

    public static H7[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new H7[0];
                }
            }
        }
        return d;
    }

    public final H7 a() {
        this.f457a = -1L;
        this.b = -1L;
        this.c = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f457a;
        if (j != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        long j2 = this.b;
        if (j2 != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j2);
        }
        int i = this.c;
        return i != -1 ? CodedOutputByteBufferNano.computeInt32Size(3, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f457a;
        if (j != -1) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        long j2 = this.b;
        if (j2 != -1) {
            codedOutputByteBufferNano.writeInt64(2, j2);
        }
        int i = this.c;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final H7 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f457a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readInt64();
            } else if (readTag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == -1 || readInt32 == 0 || readInt32 == 1) {
                    this.c = readInt32;
                }
            }
        }
        return this;
    }

    public static H7 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new H7().mergeFrom(codedInputByteBufferNano);
    }

    public static H7 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (H7) MessageNano.mergeFrom(new H7(), bArr);
    }
}
