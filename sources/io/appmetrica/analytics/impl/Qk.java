package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Qk extends MessageNano {
    public static volatile Qk[] b;

    /* renamed from: a  reason: collision with root package name */
    public Rk[] f624a;

    public Qk() {
        a();
    }

    public static Qk[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Qk[0];
                }
            }
        }
        return b;
    }

    public final Qk a() {
        this.f624a = Rk.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Rk[] rkArr = this.f624a;
        if (rkArr != null && rkArr.length > 0) {
            int i = 0;
            while (true) {
                Rk[] rkArr2 = this.f624a;
                if (i >= rkArr2.length) {
                    break;
                }
                Rk rk = rkArr2[i];
                if (rk != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, rk) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Rk[] rkArr = this.f624a;
        if (rkArr != null && rkArr.length > 0) {
            int i = 0;
            while (true) {
                Rk[] rkArr2 = this.f624a;
                if (i >= rkArr2.length) {
                    break;
                }
                Rk rk = rkArr2[i];
                if (rk != null) {
                    codedOutputByteBufferNano.writeMessage(1, rk);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Qk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Rk[] rkArr = this.f624a;
                int length = rkArr == null ? 0 : rkArr.length;
                int i = repeatedFieldArrayLength + length;
                Rk[] rkArr2 = new Rk[i];
                if (length != 0) {
                    System.arraycopy(rkArr, 0, rkArr2, 0, length);
                }
                while (length < i - 1) {
                    Rk rk = new Rk();
                    rkArr2[length] = rk;
                    codedInputByteBufferNano.readMessage(rk);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Rk rk2 = new Rk();
                rkArr2[length] = rk2;
                codedInputByteBufferNano.readMessage(rk2);
                this.f624a = rkArr2;
            }
        }
        return this;
    }

    public static Qk b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Qk().mergeFrom(codedInputByteBufferNano);
    }

    public static Qk a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Qk) MessageNano.mergeFrom(new Qk(), bArr);
    }
}
