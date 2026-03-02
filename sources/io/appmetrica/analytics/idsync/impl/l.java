package io.appmetrica.analytics.idsync.impl;

import androidx.media3.exoplayer.Renderer;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class l extends MessageNano {
    public static volatile l[] c;

    /* renamed from: a  reason: collision with root package name */
    public long f473a;
    public k[] b;

    public l() {
        a();
    }

    public static l[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new l[0];
                }
            }
        }
        return c;
    }

    public final l a() {
        this.f473a = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
        this.b = k.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f473a;
        if (j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        k[] kVarArr = this.b;
        if (kVarArr != null && kVarArr.length > 0) {
            int i = 0;
            while (true) {
                k[] kVarArr2 = this.b;
                if (i >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i];
                if (kVar != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, kVar) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f473a;
        if (j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        k[] kVarArr = this.b;
        if (kVarArr != null && kVarArr.length > 0) {
            int i = 0;
            while (true) {
                k[] kVarArr2 = this.b;
                if (i >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, kVar);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f473a = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                k[] kVarArr = this.b;
                int length = kVarArr == null ? 0 : kVarArr.length;
                int i = repeatedFieldArrayLength + length;
                k[] kVarArr2 = new k[i];
                if (length != 0) {
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                }
                while (length < i - 1) {
                    k kVar = new k();
                    kVarArr2[length] = kVar;
                    codedInputByteBufferNano.readMessage(kVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                k kVar2 = new k();
                kVarArr2[length] = kVar2;
                codedInputByteBufferNano.readMessage(kVar2);
                this.b = kVarArr2;
            }
        }
        return this;
    }

    public static l b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new l().mergeFrom(codedInputByteBufferNano);
    }

    public static l a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (l) MessageNano.mergeFrom(new l(), bArr);
    }
}
