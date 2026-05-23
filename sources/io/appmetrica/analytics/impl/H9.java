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
public final class H9 extends MessageNano {
    public static volatile H9[] b;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f575a;

    public H9() {
        a();
    }

    public static H9[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new H9[0];
                }
            }
        }
        return b;
    }

    public final H9 a() {
        this.f575a = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !Arrays.equals(this.f575a, WireFormatNano.EMPTY_BYTES) ? CodedOutputByteBufferNano.computeBytesSize(1, this.f575a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f575a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f575a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final H9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f575a = codedInputByteBufferNano.readBytes();
            }
        }
        return this;
    }

    public static H9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new H9().mergeFrom(codedInputByteBufferNano);
    }

    public static H9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (H9) MessageNano.mergeFrom(new H9(), bArr);
    }
}
