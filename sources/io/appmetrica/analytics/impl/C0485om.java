package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.om  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0485om extends MessageNano {
    public static volatile C0485om[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1166a;

    public C0485om() {
        a();
    }

    public static C0485om[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0485om[0];
                }
            }
        }
        return b;
    }

    public final C0485om a() {
        this.f1166a = 10000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f1166a;
        return j != 10000 ? CodedOutputByteBufferNano.computeInt64Size(1, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f1166a;
        if (j != 10000) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0485om mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1166a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0485om b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0485om().mergeFrom(codedInputByteBufferNano);
    }

    public static C0485om a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0485om) MessageNano.mergeFrom(new C0485om(), bArr);
    }
}
