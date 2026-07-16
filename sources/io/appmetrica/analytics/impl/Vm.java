package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Vm extends MessageNano {
    public static volatile Vm[] c;

    /* renamed from: a  reason: collision with root package name */
    public long f815a;
    public long b;

    public Vm() {
        a();
    }

    public static Vm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new Vm[0];
                }
            }
        }
        return c;
    }

    public final Vm a() {
        this.f815a = 86400L;
        this.b = 432000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return CodedOutputByteBufferNano.computeInt64Size(2, this.b) + CodedOutputByteBufferNano.computeInt64Size(1, this.f815a) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt64(1, this.f815a);
        codedOutputByteBufferNano.writeInt64(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Vm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f815a = codedInputByteBufferNano.readInt64();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static Vm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Vm().mergeFrom(codedInputByteBufferNano);
    }

    public static Vm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Vm) MessageNano.mergeFrom(new Vm(), bArr);
    }
}
