package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class C8 extends MessageNano {
    public static volatile C8[] b;

    /* renamed from: a  reason: collision with root package name */
    public D8 f386a;

    public C8() {
        a();
    }

    public static C8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C8[0];
                }
            }
        }
        return b;
    }

    public final C8 a() {
        this.f386a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        D8 d8 = this.f386a;
        return d8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, d8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        D8 d8 = this.f386a;
        if (d8 != null) {
            codedOutputByteBufferNano.writeMessage(1, d8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f386a == null) {
                    this.f386a = new D8();
                }
                codedInputByteBufferNano.readMessage(this.f386a);
            }
        }
        return this;
    }

    public static C8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C8().mergeFrom(codedInputByteBufferNano);
    }

    public static C8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C8) MessageNano.mergeFrom(new C8(), bArr);
    }
}
