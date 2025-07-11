package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Ik extends MessageNano {
    public static volatile Ik[] b;

    /* renamed from: a  reason: collision with root package name */
    public Jk[] f481a;

    public Ik() {
        a();
    }

    public static Ik[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Ik[0];
                }
            }
        }
        return b;
    }

    public final Ik a() {
        this.f481a = Jk.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Jk[] jkArr = this.f481a;
        if (jkArr != null && jkArr.length > 0) {
            int i = 0;
            while (true) {
                Jk[] jkArr2 = this.f481a;
                if (i >= jkArr2.length) {
                    break;
                }
                Jk jk = jkArr2[i];
                if (jk != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, jk) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Jk[] jkArr = this.f481a;
        if (jkArr != null && jkArr.length > 0) {
            int i = 0;
            while (true) {
                Jk[] jkArr2 = this.f481a;
                if (i >= jkArr2.length) {
                    break;
                }
                Jk jk = jkArr2[i];
                if (jk != null) {
                    codedOutputByteBufferNano.writeMessage(1, jk);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Ik mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Jk[] jkArr = this.f481a;
                int length = jkArr == null ? 0 : jkArr.length;
                int i = repeatedFieldArrayLength + length;
                Jk[] jkArr2 = new Jk[i];
                if (length != 0) {
                    System.arraycopy(jkArr, 0, jkArr2, 0, length);
                }
                while (length < i - 1) {
                    Jk jk = new Jk();
                    jkArr2[length] = jk;
                    codedInputByteBufferNano.readMessage(jk);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Jk jk2 = new Jk();
                jkArr2[length] = jk2;
                codedInputByteBufferNano.readMessage(jk2);
                this.f481a = jkArr2;
            }
        }
        return this;
    }

    public static Ik b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ik().mergeFrom(codedInputByteBufferNano);
    }

    public static Ik a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ik) MessageNano.mergeFrom(new Ik(), bArr);
    }
}
