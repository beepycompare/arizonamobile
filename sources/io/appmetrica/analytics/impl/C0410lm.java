package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.lm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0410lm extends MessageNano {
    public static volatile C0410lm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1107a;

    public C0410lm() {
        a();
    }

    public static C0410lm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0410lm[0];
                }
            }
        }
        return b;
    }

    public final C0410lm a() {
        this.f1107a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f1107a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f1107a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1107a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1107a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0410lm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1107a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0410lm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0410lm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0410lm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0410lm) MessageNano.mergeFrom(new C0410lm(), bArr);
    }
}
