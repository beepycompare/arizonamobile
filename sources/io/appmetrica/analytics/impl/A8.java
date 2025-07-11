package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class A8 extends MessageNano {
    public static volatile A8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0725y8 f333a;

    public A8() {
        a();
    }

    public static A8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new A8[0];
                }
            }
        }
        return b;
    }

    public final A8 a() {
        this.f333a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0725y8 c0725y8 = this.f333a;
        return c0725y8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0725y8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0725y8 c0725y8 = this.f333a;
        if (c0725y8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0725y8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final A8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f333a == null) {
                    this.f333a = new C0725y8();
                }
                codedInputByteBufferNano.readMessage(this.f333a);
            }
        }
        return this;
    }

    public static A8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new A8().mergeFrom(codedInputByteBufferNano);
    }

    public static A8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (A8) MessageNano.mergeFrom(new A8(), bArr);
    }
}
