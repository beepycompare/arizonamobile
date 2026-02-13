package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0454nf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0454nf[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0404lf f1136a;
    public C0429mf[] b;

    public C0454nf() {
        a();
    }

    public static C0454nf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0454nf[0];
                }
            }
        }
        return g;
    }

    public final C0454nf a() {
        this.f1136a = null;
        this.b = C0429mf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0404lf c0404lf = this.f1136a;
        if (c0404lf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0404lf);
        }
        C0429mf[] c0429mfArr = this.b;
        if (c0429mfArr != null && c0429mfArr.length > 0) {
            int i = 0;
            while (true) {
                C0429mf[] c0429mfArr2 = this.b;
                if (i >= c0429mfArr2.length) {
                    break;
                }
                C0429mf c0429mf = c0429mfArr2[i];
                if (c0429mf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0429mf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0404lf c0404lf = this.f1136a;
        if (c0404lf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0404lf);
        }
        C0429mf[] c0429mfArr = this.b;
        if (c0429mfArr != null && c0429mfArr.length > 0) {
            int i = 0;
            while (true) {
                C0429mf[] c0429mfArr2 = this.b;
                if (i >= c0429mfArr2.length) {
                    break;
                }
                C0429mf c0429mf = c0429mfArr2[i];
                if (c0429mf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0429mf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0454nf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1136a == null) {
                    this.f1136a = new C0404lf();
                }
                codedInputByteBufferNano.readMessage(this.f1136a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0429mf[] c0429mfArr = this.b;
                int length = c0429mfArr == null ? 0 : c0429mfArr.length;
                int i = repeatedFieldArrayLength + length;
                C0429mf[] c0429mfArr2 = new C0429mf[i];
                if (length != 0) {
                    System.arraycopy(c0429mfArr, 0, c0429mfArr2, 0, length);
                }
                while (length < i - 1) {
                    C0429mf c0429mf = new C0429mf();
                    c0429mfArr2[length] = c0429mf;
                    codedInputByteBufferNano.readMessage(c0429mf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0429mf c0429mf2 = new C0429mf();
                c0429mfArr2[length] = c0429mf2;
                codedInputByteBufferNano.readMessage(c0429mf2);
                this.b = c0429mfArr2;
            }
        }
        return this;
    }

    public static C0454nf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0454nf().mergeFrom(codedInputByteBufferNano);
    }

    public static C0454nf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0454nf) MessageNano.mergeFrom(new C0454nf(), bArr);
    }
}
