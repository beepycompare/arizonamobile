package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.x8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0702x8 extends MessageNano {
    public static volatile C0702x8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0727y8 f1134a;

    public C0702x8() {
        a();
    }

    public static C0702x8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0702x8[0];
                }
            }
        }
        return b;
    }

    public final C0702x8 a() {
        this.f1134a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0727y8 c0727y8 = this.f1134a;
        return c0727y8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0727y8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0727y8 c0727y8 = this.f1134a;
        if (c0727y8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0727y8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0702x8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1134a == null) {
                    this.f1134a = new C0727y8();
                }
                codedInputByteBufferNano.readMessage(this.f1134a);
            }
        }
        return this;
    }

    public static C0702x8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0702x8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0702x8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0702x8) MessageNano.mergeFrom(new C0702x8(), bArr);
    }
}
