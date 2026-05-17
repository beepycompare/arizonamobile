package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.j8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0345j8 extends MessageNano {
    public static volatile C0345j8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0294h8 f1064a;

    public C0345j8() {
        a();
    }

    public static C0345j8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0345j8[0];
                }
            }
        }
        return b;
    }

    public final C0345j8 a() {
        this.f1064a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0294h8 c0294h8 = this.f1064a;
        return c0294h8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0294h8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0294h8 c0294h8 = this.f1064a;
        if (c0294h8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0294h8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0345j8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1064a == null) {
                    this.f1064a = new C0294h8();
                }
                codedInputByteBufferNano.readMessage(this.f1064a);
            }
        }
        return this;
    }

    public static C0345j8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0345j8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0345j8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0345j8) MessageNano.mergeFrom(new C0345j8(), bArr);
    }
}
