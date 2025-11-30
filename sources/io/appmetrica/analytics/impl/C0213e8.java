package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.e8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0213e8 extends MessageNano {
    public static volatile C0213e8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0239f8 f867a;

    public C0213e8() {
        a();
    }

    public static C0213e8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0213e8[0];
                }
            }
        }
        return b;
    }

    public final C0213e8 a() {
        this.f867a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0239f8 c0239f8 = this.f867a;
        return c0239f8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0239f8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0239f8 c0239f8 = this.f867a;
        if (c0239f8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0239f8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0213e8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f867a == null) {
                    this.f867a = new C0239f8();
                }
                codedInputByteBufferNano.readMessage(this.f867a);
            }
        }
        return this;
    }

    public static C0213e8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0213e8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0213e8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0213e8) MessageNano.mergeFrom(new C0213e8(), bArr);
    }
}
