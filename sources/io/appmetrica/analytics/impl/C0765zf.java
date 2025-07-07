package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0765zf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0765zf[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0715xf f1166a;
    public C0740yf[] b;

    public C0765zf() {
        a();
    }

    public static C0765zf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0765zf[0];
                }
            }
        }
        return g;
    }

    public final C0765zf a() {
        this.f1166a = null;
        this.b = C0740yf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0715xf c0715xf = this.f1166a;
        if (c0715xf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0715xf);
        }
        C0740yf[] c0740yfArr = this.b;
        if (c0740yfArr != null && c0740yfArr.length > 0) {
            int i = 0;
            while (true) {
                C0740yf[] c0740yfArr2 = this.b;
                if (i >= c0740yfArr2.length) {
                    break;
                }
                C0740yf c0740yf = c0740yfArr2[i];
                if (c0740yf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0740yf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0715xf c0715xf = this.f1166a;
        if (c0715xf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0715xf);
        }
        C0740yf[] c0740yfArr = this.b;
        if (c0740yfArr != null && c0740yfArr.length > 0) {
            int i = 0;
            while (true) {
                C0740yf[] c0740yfArr2 = this.b;
                if (i >= c0740yfArr2.length) {
                    break;
                }
                C0740yf c0740yf = c0740yfArr2[i];
                if (c0740yf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0740yf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0765zf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1166a == null) {
                    this.f1166a = new C0715xf();
                }
                codedInputByteBufferNano.readMessage(this.f1166a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0740yf[] c0740yfArr = this.b;
                int length = c0740yfArr == null ? 0 : c0740yfArr.length;
                int i = repeatedFieldArrayLength + length;
                C0740yf[] c0740yfArr2 = new C0740yf[i];
                if (length != 0) {
                    System.arraycopy(c0740yfArr, 0, c0740yfArr2, 0, length);
                }
                while (length < i - 1) {
                    C0740yf c0740yf = new C0740yf();
                    c0740yfArr2[length] = c0740yf;
                    codedInputByteBufferNano.readMessage(c0740yf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0740yf c0740yf2 = new C0740yf();
                c0740yfArr2[length] = c0740yf2;
                codedInputByteBufferNano.readMessage(c0740yf2);
                this.b = c0740yfArr2;
            }
        }
        return this;
    }

    public static C0765zf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0765zf().mergeFrom(codedInputByteBufferNano);
    }

    public static C0765zf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0765zf) MessageNano.mergeFrom(new C0765zf(), bArr);
    }
}
