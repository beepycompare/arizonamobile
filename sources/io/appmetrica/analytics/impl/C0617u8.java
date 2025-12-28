package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.u8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0617u8 extends MessageNano {
    public static volatile C0617u8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0542r8 f1244a;

    public C0617u8() {
        a();
    }

    public static C0617u8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0617u8[0];
                }
            }
        }
        return b;
    }

    public final C0617u8 a() {
        this.f1244a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0542r8 c0542r8 = this.f1244a;
        return c0542r8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0542r8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0542r8 c0542r8 = this.f1244a;
        if (c0542r8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0542r8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0617u8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1244a == null) {
                    this.f1244a = new C0542r8();
                }
                codedInputByteBufferNano.readMessage(this.f1244a);
            }
        }
        return this;
    }

    public static C0617u8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0617u8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0617u8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0617u8) MessageNano.mergeFrom(new C0617u8(), bArr);
    }
}
