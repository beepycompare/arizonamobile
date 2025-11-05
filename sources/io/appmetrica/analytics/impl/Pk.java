package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class Pk extends MessageNano {
    public static volatile Pk[] b;

    /* renamed from: a  reason: collision with root package name */
    public Qk[] f641a;

    public Pk() {
        a();
    }

    public static Pk[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Pk[0];
                }
            }
        }
        return b;
    }

    public final Pk a() {
        this.f641a = Qk.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Qk[] qkArr = this.f641a;
        if (qkArr != null && qkArr.length > 0) {
            int i = 0;
            while (true) {
                Qk[] qkArr2 = this.f641a;
                if (i >= qkArr2.length) {
                    break;
                }
                Qk qk = qkArr2[i];
                if (qk != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, qk) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Qk[] qkArr = this.f641a;
        if (qkArr != null && qkArr.length > 0) {
            int i = 0;
            while (true) {
                Qk[] qkArr2 = this.f641a;
                if (i >= qkArr2.length) {
                    break;
                }
                Qk qk = qkArr2[i];
                if (qk != null) {
                    codedOutputByteBufferNano.writeMessage(1, qk);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Pk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Qk[] qkArr = this.f641a;
                int length = qkArr == null ? 0 : qkArr.length;
                int i = repeatedFieldArrayLength + length;
                Qk[] qkArr2 = new Qk[i];
                if (length != 0) {
                    System.arraycopy(qkArr, 0, qkArr2, 0, length);
                }
                while (length < i - 1) {
                    Qk qk = new Qk();
                    qkArr2[length] = qk;
                    codedInputByteBufferNano.readMessage(qk);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Qk qk2 = new Qk();
                qkArr2[length] = qk2;
                codedInputByteBufferNano.readMessage(qk2);
                this.f641a = qkArr2;
            }
        }
        return this;
    }

    public static Pk b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Pk().mergeFrom(codedInputByteBufferNano);
    }

    public static Pk a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Pk) MessageNano.mergeFrom(new Pk(), bArr);
    }
}
