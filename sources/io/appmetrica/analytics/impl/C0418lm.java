package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.lm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0418lm extends MessageNano {
    public static volatile C0418lm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f942a;

    public C0418lm() {
        a();
    }

    public static C0418lm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0418lm[0];
                }
            }
        }
        return b;
    }

    public final C0418lm a() {
        this.f942a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f942a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f942a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f942a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f942a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0418lm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f942a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0418lm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0418lm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0418lm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0418lm) MessageNano.mergeFrom(new C0418lm(), bArr);
    }
}
