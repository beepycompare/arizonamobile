package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Df extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile Df[] g;

    /* renamed from: a  reason: collision with root package name */
    public Bf f397a;
    public Cf[] b;

    public Df() {
        a();
    }

    public static Df[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new Df[0];
                }
            }
        }
        return g;
    }

    public final Df a() {
        this.f397a = null;
        this.b = Cf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Bf bf = this.f397a;
        if (bf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bf);
        }
        Cf[] cfArr = this.b;
        if (cfArr != null && cfArr.length > 0) {
            int i = 0;
            while (true) {
                Cf[] cfArr2 = this.b;
                if (i >= cfArr2.length) {
                    break;
                }
                Cf cf = cfArr2[i];
                if (cf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, cf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Bf bf = this.f397a;
        if (bf != null) {
            codedOutputByteBufferNano.writeMessage(1, bf);
        }
        Cf[] cfArr = this.b;
        if (cfArr != null && cfArr.length > 0) {
            int i = 0;
            while (true) {
                Cf[] cfArr2 = this.b;
                if (i >= cfArr2.length) {
                    break;
                }
                Cf cf = cfArr2[i];
                if (cf != null) {
                    codedOutputByteBufferNano.writeMessage(2, cf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Df mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f397a == null) {
                    this.f397a = new Bf();
                }
                codedInputByteBufferNano.readMessage(this.f397a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Cf[] cfArr = this.b;
                int length = cfArr == null ? 0 : cfArr.length;
                int i = repeatedFieldArrayLength + length;
                Cf[] cfArr2 = new Cf[i];
                if (length != 0) {
                    System.arraycopy(cfArr, 0, cfArr2, 0, length);
                }
                while (length < i - 1) {
                    Cf cf = new Cf();
                    cfArr2[length] = cf;
                    codedInputByteBufferNano.readMessage(cf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Cf cf2 = new Cf();
                cfArr2[length] = cf2;
                codedInputByteBufferNano.readMessage(cf2);
                this.b = cfArr2;
            }
        }
        return this;
    }

    public static Df b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Df().mergeFrom(codedInputByteBufferNano);
    }

    public static Df a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Df) MessageNano.mergeFrom(new Df(), bArr);
    }
}
