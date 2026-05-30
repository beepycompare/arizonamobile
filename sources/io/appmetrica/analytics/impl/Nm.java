package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Nm extends MessageNano {
    public static volatile Nm[] b;

    /* renamed from: a  reason: collision with root package name */
    public String f690a;

    public Nm() {
        a();
    }

    public static Nm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Nm[0];
                }
            }
        }
        return b;
    }

    public final Nm a() {
        this.f690a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f690a.equals("") ? CodedOutputByteBufferNano.computeStringSize(1, this.f690a) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f690a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f690a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Nm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f690a = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static Nm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Nm().mergeFrom(codedInputByteBufferNano);
    }

    public static Nm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Nm) MessageNano.mergeFrom(new Nm(), bArr);
    }
}
