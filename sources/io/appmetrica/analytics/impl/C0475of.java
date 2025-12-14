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
public final class C0475of extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0475of[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0425mf f1146a;
    public C0450nf[] b;

    public C0475of() {
        a();
    }

    public static C0475of[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0475of[0];
                }
            }
        }
        return g;
    }

    public final C0475of a() {
        this.f1146a = null;
        this.b = C0450nf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0425mf c0425mf = this.f1146a;
        if (c0425mf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0425mf);
        }
        C0450nf[] c0450nfArr = this.b;
        if (c0450nfArr != null && c0450nfArr.length > 0) {
            int i = 0;
            while (true) {
                C0450nf[] c0450nfArr2 = this.b;
                if (i >= c0450nfArr2.length) {
                    break;
                }
                C0450nf c0450nf = c0450nfArr2[i];
                if (c0450nf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0450nf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0425mf c0425mf = this.f1146a;
        if (c0425mf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0425mf);
        }
        C0450nf[] c0450nfArr = this.b;
        if (c0450nfArr != null && c0450nfArr.length > 0) {
            int i = 0;
            while (true) {
                C0450nf[] c0450nfArr2 = this.b;
                if (i >= c0450nfArr2.length) {
                    break;
                }
                C0450nf c0450nf = c0450nfArr2[i];
                if (c0450nf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0450nf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0475of mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1146a == null) {
                    this.f1146a = new C0425mf();
                }
                codedInputByteBufferNano.readMessage(this.f1146a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0450nf[] c0450nfArr = this.b;
                int length = c0450nfArr == null ? 0 : c0450nfArr.length;
                int i = repeatedFieldArrayLength + length;
                C0450nf[] c0450nfArr2 = new C0450nf[i];
                if (length != 0) {
                    System.arraycopy(c0450nfArr, 0, c0450nfArr2, 0, length);
                }
                while (length < i - 1) {
                    C0450nf c0450nf = new C0450nf();
                    c0450nfArr2[length] = c0450nf;
                    codedInputByteBufferNano.readMessage(c0450nf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0450nf c0450nf2 = new C0450nf();
                c0450nfArr2[length] = c0450nf2;
                codedInputByteBufferNano.readMessage(c0450nf2);
                this.b = c0450nfArr2;
            }
        }
        return this;
    }

    public static C0475of b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0475of().mergeFrom(codedInputByteBufferNano);
    }

    public static C0475of a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0475of) MessageNano.mergeFrom(new C0475of(), bArr);
    }
}
