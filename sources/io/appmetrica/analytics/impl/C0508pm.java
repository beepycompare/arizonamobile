package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0508pm extends MessageNano {
    public static volatile C0508pm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1059a;

    public C0508pm() {
        a();
    }

    public static C0508pm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0508pm[0];
                }
            }
        }
        return b;
    }

    public final C0508pm a() {
        this.f1059a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f1059a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f1059a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1059a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1059a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0508pm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1059a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0508pm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0508pm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0508pm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0508pm) MessageNano.mergeFrom(new C0508pm(), bArr);
    }
}
