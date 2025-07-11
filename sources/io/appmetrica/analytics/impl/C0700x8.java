package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.x8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0700x8 extends MessageNano {
    public static volatile C0700x8[] c;

    /* renamed from: a  reason: collision with root package name */
    public long f1121a;
    public int b;

    public C0700x8() {
        a();
    }

    public static C0700x8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0700x8[0];
                }
            }
        }
        return c;
    }

    public final C0700x8 a() {
        this.f1121a = 0L;
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f1121a;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        int i = this.b;
        return i != 0 ? CodedOutputByteBufferNano.computeInt32Size(2, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f1121a;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        int i = this.b;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0700x8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1121a = codedInputByteBufferNano.readInt64();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readInt32();
            }
        }
        return this;
    }

    public static C0700x8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0700x8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0700x8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0700x8) MessageNano.mergeFrom(new C0700x8(), bArr);
    }
}
