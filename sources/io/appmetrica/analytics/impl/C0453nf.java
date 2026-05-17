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
public final class C0453nf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0453nf[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0403lf f1141a;
    public C0428mf[] b;

    public C0453nf() {
        a();
    }

    public static C0453nf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0453nf[0];
                }
            }
        }
        return g;
    }

    public final C0453nf a() {
        this.f1141a = null;
        this.b = C0428mf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0403lf c0403lf = this.f1141a;
        if (c0403lf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0403lf);
        }
        C0428mf[] c0428mfArr = this.b;
        if (c0428mfArr != null && c0428mfArr.length > 0) {
            int i = 0;
            while (true) {
                C0428mf[] c0428mfArr2 = this.b;
                if (i >= c0428mfArr2.length) {
                    break;
                }
                C0428mf c0428mf = c0428mfArr2[i];
                if (c0428mf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0428mf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0403lf c0403lf = this.f1141a;
        if (c0403lf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0403lf);
        }
        C0428mf[] c0428mfArr = this.b;
        if (c0428mfArr != null && c0428mfArr.length > 0) {
            int i = 0;
            while (true) {
                C0428mf[] c0428mfArr2 = this.b;
                if (i >= c0428mfArr2.length) {
                    break;
                }
                C0428mf c0428mf = c0428mfArr2[i];
                if (c0428mf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0428mf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0453nf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1141a == null) {
                    this.f1141a = new C0403lf();
                }
                codedInputByteBufferNano.readMessage(this.f1141a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0428mf[] c0428mfArr = this.b;
                int length = c0428mfArr == null ? 0 : c0428mfArr.length;
                int i = repeatedFieldArrayLength + length;
                C0428mf[] c0428mfArr2 = new C0428mf[i];
                if (length != 0) {
                    System.arraycopy(c0428mfArr, 0, c0428mfArr2, 0, length);
                }
                while (length < i - 1) {
                    C0428mf c0428mf = new C0428mf();
                    c0428mfArr2[length] = c0428mf;
                    codedInputByteBufferNano.readMessage(c0428mf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0428mf c0428mf2 = new C0428mf();
                c0428mfArr2[length] = c0428mf2;
                codedInputByteBufferNano.readMessage(c0428mf2);
                this.b = c0428mfArr2;
            }
        }
        return this;
    }

    public static C0453nf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0453nf().mergeFrom(codedInputByteBufferNano);
    }

    public static C0453nf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0453nf) MessageNano.mergeFrom(new C0453nf(), bArr);
    }
}
