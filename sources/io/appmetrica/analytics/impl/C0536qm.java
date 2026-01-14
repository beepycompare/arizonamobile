package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.qm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0536qm extends MessageNano {
    public static volatile C0536qm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1194a;

    public C0536qm() {
        a();
    }

    public static C0536qm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0536qm[0];
                }
            }
        }
        return b;
    }

    public final C0536qm a() {
        this.f1194a = 864000000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f1194a;
        return j != 864000000 ? CodedOutputByteBufferNano.computeInt64Size(1, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f1194a;
        if (j != 864000000) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0536qm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1194a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0536qm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0536qm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0536qm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0536qm) MessageNano.mergeFrom(new C0536qm(), bArr);
    }
}
