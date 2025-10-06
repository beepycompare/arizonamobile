package io.appmetrica.analytics.impl;

import androidx.media3.exoplayer.Renderer;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0744ym extends MessageNano {
    public static volatile C0744ym[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1177a;

    public C0744ym() {
        a();
    }

    public static C0744ym[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0744ym[0];
                }
            }
        }
        return b;
    }

    public final C0744ym a() {
        this.f1177a = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f1177a;
        return j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US ? CodedOutputByteBufferNano.computeInt64Size(1, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f1177a;
        if (j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0744ym mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1177a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0744ym b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0744ym().mergeFrom(codedInputByteBufferNano);
    }

    public static C0744ym a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0744ym) MessageNano.mergeFrom(new C0744ym(), bArr);
    }
}
