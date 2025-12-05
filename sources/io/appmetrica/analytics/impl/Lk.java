package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Lk extends MessageNano {
    public static volatile Lk[] b;

    /* renamed from: a  reason: collision with root package name */
    public Mk[] f658a;

    public Lk() {
        a();
    }

    public static Lk[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Lk[0];
                }
            }
        }
        return b;
    }

    public final Lk a() {
        this.f658a = Mk.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Mk[] mkArr = this.f658a;
        if (mkArr != null && mkArr.length > 0) {
            int i = 0;
            while (true) {
                Mk[] mkArr2 = this.f658a;
                if (i >= mkArr2.length) {
                    break;
                }
                Mk mk = mkArr2[i];
                if (mk != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, mk) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Mk[] mkArr = this.f658a;
        if (mkArr != null && mkArr.length > 0) {
            int i = 0;
            while (true) {
                Mk[] mkArr2 = this.f658a;
                if (i >= mkArr2.length) {
                    break;
                }
                Mk mk = mkArr2[i];
                if (mk != null) {
                    codedOutputByteBufferNano.writeMessage(1, mk);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Lk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Mk[] mkArr = this.f658a;
                int length = mkArr == null ? 0 : mkArr.length;
                int i = repeatedFieldArrayLength + length;
                Mk[] mkArr2 = new Mk[i];
                if (length != 0) {
                    System.arraycopy(mkArr, 0, mkArr2, 0, length);
                }
                while (length < i - 1) {
                    Mk mk = new Mk();
                    mkArr2[length] = mk;
                    codedInputByteBufferNano.readMessage(mk);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Mk mk2 = new Mk();
                mkArr2[length] = mk2;
                codedInputByteBufferNano.readMessage(mk2);
                this.f658a = mkArr2;
            }
        }
        return this;
    }

    public static Lk b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Lk().mergeFrom(codedInputByteBufferNano);
    }

    public static Lk a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Lk) MessageNano.mergeFrom(new Lk(), bArr);
    }
}
