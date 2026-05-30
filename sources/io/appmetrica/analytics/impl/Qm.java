package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Qm extends MessageNano {
    public static volatile Qm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f737a;

    public Qm() {
        a();
    }

    public static Qm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Qm[0];
                }
            }
        }
        return b;
    }

    public final Qm a() {
        this.f737a = 10000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f737a;
        return j != 10000 ? CodedOutputByteBufferNano.computeInt64Size(1, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f737a;
        if (j != 10000) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Qm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f737a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static Qm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Qm().mergeFrom(codedInputByteBufferNano);
    }

    public static Qm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Qm) MessageNano.mergeFrom(new Qm(), bArr);
    }
}
