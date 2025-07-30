package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.wm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0691wm extends MessageNano {
    public static volatile C0691wm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1126a;

    public C0691wm() {
        a();
    }

    public static C0691wm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0691wm[0];
                }
            }
        }
        return b;
    }

    public final C0691wm a() {
        this.f1126a = 18000000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt64Size(1, this.f1126a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt64(1, this.f1126a);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0691wm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1126a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0691wm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0691wm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0691wm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0691wm) MessageNano.mergeFrom(new C0691wm(), bArr);
    }
}
