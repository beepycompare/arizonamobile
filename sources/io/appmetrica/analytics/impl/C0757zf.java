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
public final class C0757zf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0757zf[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0707xf f1167a;
    public C0732yf[] b;

    public C0757zf() {
        a();
    }

    public static C0757zf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0757zf[0];
                }
            }
        }
        return g;
    }

    public final C0757zf a() {
        this.f1167a = null;
        this.b = C0732yf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0707xf c0707xf = this.f1167a;
        if (c0707xf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0707xf);
        }
        C0732yf[] c0732yfArr = this.b;
        if (c0732yfArr != null && c0732yfArr.length > 0) {
            int i = 0;
            while (true) {
                C0732yf[] c0732yfArr2 = this.b;
                if (i >= c0732yfArr2.length) {
                    break;
                }
                C0732yf c0732yf = c0732yfArr2[i];
                if (c0732yf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0732yf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0707xf c0707xf = this.f1167a;
        if (c0707xf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0707xf);
        }
        C0732yf[] c0732yfArr = this.b;
        if (c0732yfArr != null && c0732yfArr.length > 0) {
            int i = 0;
            while (true) {
                C0732yf[] c0732yfArr2 = this.b;
                if (i >= c0732yfArr2.length) {
                    break;
                }
                C0732yf c0732yf = c0732yfArr2[i];
                if (c0732yf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0732yf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0757zf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1167a == null) {
                    this.f1167a = new C0707xf();
                }
                codedInputByteBufferNano.readMessage(this.f1167a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0732yf[] c0732yfArr = this.b;
                int length = c0732yfArr == null ? 0 : c0732yfArr.length;
                int i = repeatedFieldArrayLength + length;
                C0732yf[] c0732yfArr2 = new C0732yf[i];
                if (length != 0) {
                    System.arraycopy(c0732yfArr, 0, c0732yfArr2, 0, length);
                }
                while (length < i - 1) {
                    C0732yf c0732yf = new C0732yf();
                    c0732yfArr2[length] = c0732yf;
                    codedInputByteBufferNano.readMessage(c0732yf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0732yf c0732yf2 = new C0732yf();
                c0732yfArr2[length] = c0732yf2;
                codedInputByteBufferNano.readMessage(c0732yf2);
                this.b = c0732yfArr2;
            }
        }
        return this;
    }

    public static C0757zf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0757zf().mergeFrom(codedInputByteBufferNano);
    }

    public static C0757zf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0757zf) MessageNano.mergeFrom(new C0757zf(), bArr);
    }
}
