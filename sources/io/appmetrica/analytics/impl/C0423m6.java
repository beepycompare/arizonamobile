package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.m6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0423m6 extends MessageNano {
    public static volatile C0423m6[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f1093a;

    public C0423m6() {
        a();
    }

    public static C0423m6[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0423m6[0];
                }
            }
        }
        return b;
    }

    public final C0423m6 a() {
        this.f1093a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeStringSize(1, this.f1093a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f1093a);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0423m6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1093a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0423m6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0423m6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0423m6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0423m6) MessageNano.mergeFrom(new C0423m6(), bArr);
    }
}
