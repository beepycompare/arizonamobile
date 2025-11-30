package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0476of extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0476of[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0426mf f1049a;
    public C0451nf[] b;

    public C0476of() {
        a();
    }

    public static C0476of[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0476of[0];
                }
            }
        }
        return g;
    }

    public final C0476of a() {
        this.f1049a = null;
        this.b = C0451nf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0426mf c0426mf = this.f1049a;
        if (c0426mf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0426mf);
        }
        C0451nf[] c0451nfArr = this.b;
        if (c0451nfArr != null && c0451nfArr.length > 0) {
            int i = 0;
            while (true) {
                C0451nf[] c0451nfArr2 = this.b;
                if (i >= c0451nfArr2.length) {
                    break;
                }
                C0451nf c0451nf = c0451nfArr2[i];
                if (c0451nf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0451nf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0426mf c0426mf = this.f1049a;
        if (c0426mf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0426mf);
        }
        C0451nf[] c0451nfArr = this.b;
        if (c0451nfArr != null && c0451nfArr.length > 0) {
            int i = 0;
            while (true) {
                C0451nf[] c0451nfArr2 = this.b;
                if (i >= c0451nfArr2.length) {
                    break;
                }
                C0451nf c0451nf = c0451nfArr2[i];
                if (c0451nf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0451nf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0476of mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1049a == null) {
                    this.f1049a = new C0426mf();
                }
                codedInputByteBufferNano.readMessage(this.f1049a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0451nf[] c0451nfArr = this.b;
                int length = c0451nfArr == null ? 0 : c0451nfArr.length;
                int i = repeatedFieldArrayLength + length;
                C0451nf[] c0451nfArr2 = new C0451nf[i];
                if (length != 0) {
                    System.arraycopy(c0451nfArr, 0, c0451nfArr2, 0, length);
                }
                while (length < i - 1) {
                    C0451nf c0451nf = new C0451nf();
                    c0451nfArr2[length] = c0451nf;
                    codedInputByteBufferNano.readMessage(c0451nf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0451nf c0451nf2 = new C0451nf();
                c0451nfArr2[length] = c0451nf2;
                codedInputByteBufferNano.readMessage(c0451nf2);
                this.b = c0451nfArr2;
            }
        }
        return this;
    }

    public static C0476of b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0476of().mergeFrom(codedInputByteBufferNano);
    }

    public static C0476of a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0476of) MessageNano.mergeFrom(new C0476of(), bArr);
    }
}
