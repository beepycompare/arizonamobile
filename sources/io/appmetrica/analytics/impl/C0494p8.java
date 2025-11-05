package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.p8  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0494p8 extends MessageNano {
    public static volatile C0494p8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0444n8 f1053a;

    public C0494p8() {
        a();
    }

    public static C0494p8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0494p8[0];
                }
            }
        }
        return b;
    }

    public final C0494p8 a() {
        this.f1053a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0444n8 c0444n8 = this.f1053a;
        return c0444n8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0444n8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0444n8 c0444n8 = this.f1053a;
        if (c0444n8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0444n8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0494p8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1053a == null) {
                    this.f1053a = new C0444n8();
                }
                codedInputByteBufferNano.readMessage(this.f1053a);
            }
        }
        return this;
    }

    public static C0494p8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0494p8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0494p8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0494p8) MessageNano.mergeFrom(new C0494p8(), bArr);
    }
}
