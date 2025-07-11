package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.im  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0340im extends MessageNano {
    public static volatile C0340im[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f881a;

    public C0340im() {
        a();
    }

    public static C0340im[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0340im[0];
                }
            }
        }
        return b;
    }

    public final C0340im a() {
        this.f881a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f881a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f881a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f881a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f881a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0340im mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f881a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0340im b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0340im().mergeFrom(codedInputByteBufferNano);
    }

    public static C0340im a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0340im) MessageNano.mergeFrom(new C0340im(), bArr);
    }
}
