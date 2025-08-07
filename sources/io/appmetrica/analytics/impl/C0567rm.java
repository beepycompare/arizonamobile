package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.rm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0567rm extends MessageNano {
    public static volatile C0567rm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1042a;

    public C0567rm() {
        a();
    }

    public static C0567rm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0567rm[0];
                }
            }
        }
        return b;
    }

    public final C0567rm a() {
        this.f1042a = 864000000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f1042a;
        return j != 864000000 ? CodedOutputByteBufferNano.computeInt64Size(1, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f1042a;
        if (j != 864000000) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0567rm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1042a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0567rm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0567rm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0567rm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0567rm) MessageNano.mergeFrom(new C0567rm(), bArr);
    }
}
