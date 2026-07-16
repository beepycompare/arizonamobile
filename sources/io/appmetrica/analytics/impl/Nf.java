package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Nf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile Nf[] g;

    /* renamed from: a  reason: collision with root package name */
    public Lf f687a;
    public Mf[] b;

    public Nf() {
        a();
    }

    public static Nf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new Nf[0];
                }
            }
        }
        return g;
    }

    public final Nf a() {
        this.f687a = null;
        this.b = Mf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Lf lf = this.f687a;
        if (lf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, lf);
        }
        Mf[] mfArr = this.b;
        if (mfArr != null && mfArr.length > 0) {
            int i = 0;
            while (true) {
                Mf[] mfArr2 = this.b;
                if (i >= mfArr2.length) {
                    break;
                }
                Mf mf = mfArr2[i];
                if (mf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, mf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Lf lf = this.f687a;
        if (lf != null) {
            codedOutputByteBufferNano.writeMessage(1, lf);
        }
        Mf[] mfArr = this.b;
        if (mfArr != null && mfArr.length > 0) {
            int i = 0;
            while (true) {
                Mf[] mfArr2 = this.b;
                if (i >= mfArr2.length) {
                    break;
                }
                Mf mf = mfArr2[i];
                if (mf != null) {
                    codedOutputByteBufferNano.writeMessage(2, mf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Nf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f687a == null) {
                    this.f687a = new Lf();
                }
                codedInputByteBufferNano.readMessage(this.f687a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Mf[] mfArr = this.b;
                int length = mfArr == null ? 0 : mfArr.length;
                int i = repeatedFieldArrayLength + length;
                Mf[] mfArr2 = new Mf[i];
                if (length != 0) {
                    System.arraycopy(mfArr, 0, mfArr2, 0, length);
                }
                while (length < i - 1) {
                    Mf mf = new Mf();
                    mfArr2[length] = mf;
                    codedInputByteBufferNano.readMessage(mf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Mf mf2 = new Mf();
                mfArr2[length] = mf2;
                codedInputByteBufferNano.readMessage(mf2);
                this.b = mfArr2;
            }
        }
        return this;
    }

    public static Nf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Nf().mergeFrom(codedInputByteBufferNano);
    }

    public static Nf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Nf) MessageNano.mergeFrom(new Nf(), bArr);
    }
}
