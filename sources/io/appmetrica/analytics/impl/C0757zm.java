package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.zm  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0757zm extends MessageNano {
    public static volatile C0757zm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1236a;

    public C0757zm() {
        a();
    }

    public static C0757zm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0757zm[0];
                }
            }
        }
        return b;
    }

    public final C0757zm a() {
        this.f1236a = 18000000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt64Size(1, this.f1236a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt64(1, this.f1236a);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0757zm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1236a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0757zm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0757zm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0757zm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0757zm) MessageNano.mergeFrom(new C0757zm(), bArr);
    }
}
