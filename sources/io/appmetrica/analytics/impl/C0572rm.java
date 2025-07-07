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
public final class C0572rm extends MessageNano {
    public static volatile C0572rm[] c;

    /* renamed from: a  reason: collision with root package name */
    public long f1031a;
    public long b;

    public C0572rm() {
        a();
    }

    public static C0572rm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0572rm[0];
                }
            }
        }
        return c;
    }

    public final C0572rm a() {
        this.f1031a = 86400L;
        this.b = 432000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt64Size(2, this.b) + CodedOutputByteBufferNano.computeInt64Size(1, this.f1031a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt64(1, this.f1031a);
        codedOutputByteBufferNano.writeInt64(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0572rm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1031a = codedInputByteBufferNano.readInt64();
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

    public static C0572rm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0572rm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0572rm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0572rm) MessageNano.mergeFrom(new C0572rm(), bArr);
    }
}
