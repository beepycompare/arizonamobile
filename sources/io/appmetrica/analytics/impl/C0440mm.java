package io.appmetrica.analytics.impl;

import androidx.media3.exoplayer.Renderer;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.mm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0440mm extends MessageNano {
    public static volatile C0440mm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f946a;

    public C0440mm() {
        a();
    }

    public static C0440mm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0440mm[0];
                }
            }
        }
        return b;
    }

    public final C0440mm a() {
        this.f946a = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f946a;
        return j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US ? CodedOutputByteBufferNano.computeInt64Size(1, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f946a;
        if (j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0440mm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f946a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0440mm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0440mm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0440mm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0440mm) MessageNano.mergeFrom(new C0440mm(), bArr);
    }
}
