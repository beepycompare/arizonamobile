package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.dj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0204dj extends MessageNano {
    public static volatile C0204dj[] e;

    /* renamed from: a  reason: collision with root package name */
    public long f946a;
    public C0229ej b;
    public int c;
    public byte[] d;

    public C0204dj() {
        a();
    }

    public static C0204dj[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0204dj[0];
                }
            }
        }
        return e;
    }

    public final C0204dj a() {
        this.f946a = 0L;
        this.b = null;
        this.c = 0;
        this.d = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f946a;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        C0229ej c0229ej = this.b;
        if (c0229ej != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0229ej);
        }
        int i = this.c;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        return !Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES) ? CodedOutputByteBufferNano.computeBytesSize(4, this.d) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f946a;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        C0229ej c0229ej = this.b;
        if (c0229ej != null) {
            codedOutputByteBufferNano.writeMessage(2, c0229ej);
        }
        int i = this.c;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0204dj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f946a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0229ej();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.d = codedInputByteBufferNano.readBytes();
            }
        }
        return this;
    }

    public static C0204dj b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0204dj().mergeFrom(codedInputByteBufferNano);
    }

    public static C0204dj a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0204dj) MessageNano.mergeFrom(new C0204dj(), bArr);
    }
}
