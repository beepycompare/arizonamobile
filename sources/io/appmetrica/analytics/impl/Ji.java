package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class Ji extends MessageNano {
    public static volatile Ji[] e;

    /* renamed from: a  reason: collision with root package name */
    public long f543a;
    public Ki b;
    public int c;
    public byte[] d;

    public Ji() {
        a();
    }

    public static Ji[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new Ji[0];
                }
            }
        }
        return e;
    }

    public final Ji a() {
        this.f543a = 0L;
        this.b = null;
        this.c = 0;
        this.d = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f543a;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        Ki ki = this.b;
        if (ki != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, ki);
        }
        int i = this.c;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        return !Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES) ? CodedOutputByteBufferNano.computeBytesSize(4, this.d) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f543a;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        Ki ki = this.b;
        if (ki != null) {
            codedOutputByteBufferNano.writeMessage(2, ki);
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
    public final Ji mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f543a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new Ki();
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

    public static Ji b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ji().mergeFrom(codedInputByteBufferNano);
    }

    public static Ji a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ji) MessageNano.mergeFrom(new Ji(), bArr);
    }
}
