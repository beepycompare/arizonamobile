package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class S8 extends MessageNano {
    public static volatile S8[] b;

    /* renamed from: a  reason: collision with root package name */
    public P8 f664a;

    public S8() {
        a();
    }

    public static S8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new S8[0];
                }
            }
        }
        return b;
    }

    public final S8 a() {
        this.f664a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        P8 p8 = this.f664a;
        return p8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, p8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        P8 p8 = this.f664a;
        if (p8 != null) {
            codedOutputByteBufferNano.writeMessage(1, p8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final S8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f664a == null) {
                    this.f664a = new P8();
                }
                codedInputByteBufferNano.readMessage(this.f664a);
            }
        }
        return this;
    }

    public static S8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new S8().mergeFrom(codedInputByteBufferNano);
    }

    public static S8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (S8) MessageNano.mergeFrom(new S8(), bArr);
    }
}
