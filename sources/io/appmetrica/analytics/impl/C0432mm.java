package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.mm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0432mm extends MessageNano {
    public static volatile C0432mm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1098a;

    public C0432mm() {
        a();
    }

    public static C0432mm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0432mm[0];
                }
            }
        }
        return b;
    }

    public final C0432mm a() {
        this.f1098a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f1098a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f1098a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1098a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1098a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0432mm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1098a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0432mm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0432mm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0432mm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0432mm) MessageNano.mergeFrom(new C0432mm(), bArr);
    }
}
