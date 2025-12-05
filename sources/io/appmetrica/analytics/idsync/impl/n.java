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
public final class n extends MessageNano {
    public static volatile n[] c;

    /* renamed from: a  reason: collision with root package name */
    public long f456a;
    public m[] b;

    public n() {
        a();
    }

    public static n[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new n[0];
                }
            }
        }
        return c;
    }

    public final n a() {
        this.f456a = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
        this.b = m.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f456a;
        if (j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        m[] mVarArr = this.b;
        if (mVarArr != null && mVarArr.length > 0) {
            int i = 0;
            while (true) {
                m[] mVarArr2 = this.b;
                if (i >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i];
                if (mVar != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, mVar) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f456a;
        if (j != Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        m[] mVarArr = this.b;
        if (mVarArr != null && mVarArr.length > 0) {
            int i = 0;
            while (true) {
                m[] mVarArr2 = this.b;
                if (i >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, mVar);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f456a = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                m[] mVarArr = this.b;
                int length = mVarArr == null ? 0 : mVarArr.length;
                int i = repeatedFieldArrayLength + length;
                m[] mVarArr2 = new m[i];
                if (length != 0) {
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                }
                while (length < i - 1) {
                    m mVar = new m();
                    mVarArr2[length] = mVar;
                    codedInputByteBufferNano.readMessage(mVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                m mVar2 = new m();
                mVarArr2[length] = mVar2;
                codedInputByteBufferNano.readMessage(mVar2);
                this.b = mVarArr2;
            }
        }
        return this;
    }

    public static n b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new n().mergeFrom(codedInputByteBufferNano);
    }

    public static n a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
    }
}
