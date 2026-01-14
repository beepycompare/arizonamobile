package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Kk extends MessageNano {
    public static volatile Kk[] b;

    /* renamed from: a  reason: collision with root package name */
    public Lk[] f664a;

    public Kk() {
        a();
    }

    public static Kk[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Kk[0];
                }
            }
        }
        return b;
    }

    public final Kk a() {
        this.f664a = Lk.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Lk[] lkArr = this.f664a;
        if (lkArr != null && lkArr.length > 0) {
            int i = 0;
            while (true) {
                Lk[] lkArr2 = this.f664a;
                if (i >= lkArr2.length) {
                    break;
                }
                Lk lk = lkArr2[i];
                if (lk != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, lk) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Lk[] lkArr = this.f664a;
        if (lkArr != null && lkArr.length > 0) {
            int i = 0;
            while (true) {
                Lk[] lkArr2 = this.f664a;
                if (i >= lkArr2.length) {
                    break;
                }
                Lk lk = lkArr2[i];
                if (lk != null) {
                    codedOutputByteBufferNano.writeMessage(1, lk);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Kk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Lk[] lkArr = this.f664a;
                int length = lkArr == null ? 0 : lkArr.length;
                int i = repeatedFieldArrayLength + length;
                Lk[] lkArr2 = new Lk[i];
                if (length != 0) {
                    System.arraycopy(lkArr, 0, lkArr2, 0, length);
                }
                while (length < i - 1) {
                    Lk lk = new Lk();
                    lkArr2[length] = lk;
                    codedInputByteBufferNano.readMessage(lk);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Lk lk2 = new Lk();
                lkArr2[length] = lk2;
                codedInputByteBufferNano.readMessage(lk2);
                this.f664a = lkArr2;
            }
        }
        return this;
    }

    public static Kk b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Kk().mergeFrom(codedInputByteBufferNano);
    }

    public static Kk a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Kk) MessageNano.mergeFrom(new Kk(), bArr);
    }
}
