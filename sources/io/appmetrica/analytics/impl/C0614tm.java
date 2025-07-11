package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.tm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0614tm extends MessageNano {
    public static volatile C0614tm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1064a;

    public C0614tm() {
        a();
    }

    public static C0614tm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0614tm[0];
                }
            }
        }
        return b;
    }

    public final C0614tm a() {
        this.f1064a = 18000000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt64Size(1, this.f1064a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt64(1, this.f1064a);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0614tm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1064a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0614tm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0614tm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0614tm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0614tm) MessageNano.mergeFrom(new C0614tm(), bArr);
    }
}
