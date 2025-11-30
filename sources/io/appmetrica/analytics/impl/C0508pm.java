package io.appmetrica.analytics.impl;

import androidx.media3.exoplayer.Renderer;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0508pm extends MessageNano {
    public static volatile C0508pm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1074a;

    public C0508pm() {
        a();
    }

    public static C0508pm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0508pm[0];
                }
            }
        }
        return b;
    }

    public final C0508pm a() {
        this.f1074a = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f1074a;
        return j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US ? CodedOutputByteBufferNano.computeInt64Size(1, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f1074a;
        if (j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0508pm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1074a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0508pm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0508pm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0508pm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0508pm) MessageNano.mergeFrom(new C0508pm(), bArr);
    }
}
