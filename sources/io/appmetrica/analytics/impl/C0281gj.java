package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.gj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0281gj extends MessageNano {
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static volatile C0281gj[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1001a;
    public long b;
    public int c;
    public byte[] d;
    public long e;

    public C0281gj() {
        a();
    }

    public static C0281gj[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new C0281gj[0];
                }
            }
        }
        return i;
    }

    public final C0281gj a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f1001a = bArr;
        this.b = 0L;
        this.c = 0;
        this.d = bArr;
        this.e = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f1001a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1001a);
        }
        long j = this.b;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        int i2 = this.c;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        if (!Arrays.equals(this.d, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.d);
        }
        long j2 = this.e;
        return j2 != 0 ? CodedOutputByteBufferNano.computeUInt64Size(5, j2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f1001a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1001a);
        }
        long j = this.b;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        int i2 = this.c;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        if (!Arrays.equals(this.d, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.d);
        }
        long j2 = this.e;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0281gj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1001a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.c = readInt32;
                }
            } else if (readTag == 34) {
                this.d = codedInputByteBufferNano.readBytes();
            } else if (readTag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.e = codedInputByteBufferNano.readUInt64();
            }
        }
        return this;
    }

    public static C0281gj b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0281gj().mergeFrom(codedInputByteBufferNano);
    }

    public static C0281gj a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0281gj) MessageNano.mergeFrom(new C0281gj(), bArr);
    }
}
