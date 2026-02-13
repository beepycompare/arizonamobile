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
public final class C0411lm extends MessageNano {
    public static volatile C0411lm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1102a;

    public C0411lm() {
        a();
    }

    public static C0411lm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0411lm[0];
                }
            }
        }
        return b;
    }

    public final C0411lm a() {
        this.f1102a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f1102a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f1102a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1102a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1102a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0411lm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1102a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0411lm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0411lm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0411lm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0411lm) MessageNano.mergeFrom(new C0411lm(), bArr);
    }
}
