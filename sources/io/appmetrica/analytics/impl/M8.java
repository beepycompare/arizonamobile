package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class M8 extends MessageNano {
    public static volatile M8[] b;

    /* renamed from: a  reason: collision with root package name */
    public J8 f660a;

    public M8() {
        a();
    }

    public static M8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new M8[0];
                }
            }
        }
        return b;
    }

    public final M8 a() {
        this.f660a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        J8 j8 = this.f660a;
        return j8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, j8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        J8 j8 = this.f660a;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(1, j8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final M8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f660a == null) {
                    this.f660a = new J8();
                }
                codedInputByteBufferNano.readMessage(this.f660a);
            }
        }
        return this;
    }

    public static M8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new M8().mergeFrom(codedInputByteBufferNano);
    }

    public static M8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (M8) MessageNano.mergeFrom(new M8(), bArr);
    }
}
