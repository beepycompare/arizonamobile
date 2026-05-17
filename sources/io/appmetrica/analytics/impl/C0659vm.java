package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.vm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0659vm extends MessageNano {
    public static volatile C0659vm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1280a;

    public C0659vm() {
        a();
    }

    public static C0659vm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0659vm[0];
                }
            }
        }
        return b;
    }

    public final C0659vm a() {
        this.f1280a = 18000000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt64Size(1, this.f1280a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt64(1, this.f1280a);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0659vm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1280a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0659vm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0659vm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0659vm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0659vm) MessageNano.mergeFrom(new C0659vm(), bArr);
    }
}
