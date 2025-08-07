package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Bf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile Bf[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0760zf f358a;
    public Af[] b;

    public Bf() {
        a();
    }

    public static Bf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new Bf[0];
                }
            }
        }
        return g;
    }

    public final Bf a() {
        this.f358a = null;
        this.b = Af.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0760zf c0760zf = this.f358a;
        if (c0760zf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0760zf);
        }
        Af[] afArr = this.b;
        if (afArr != null && afArr.length > 0) {
            int i = 0;
            while (true) {
                Af[] afArr2 = this.b;
                if (i >= afArr2.length) {
                    break;
                }
                Af af = afArr2[i];
                if (af != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, af) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0760zf c0760zf = this.f358a;
        if (c0760zf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0760zf);
        }
        Af[] afArr = this.b;
        if (afArr != null && afArr.length > 0) {
            int i = 0;
            while (true) {
                Af[] afArr2 = this.b;
                if (i >= afArr2.length) {
                    break;
                }
                Af af = afArr2[i];
                if (af != null) {
                    codedOutputByteBufferNano.writeMessage(2, af);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Bf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f358a == null) {
                    this.f358a = new C0760zf();
                }
                codedInputByteBufferNano.readMessage(this.f358a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Af[] afArr = this.b;
                int length = afArr == null ? 0 : afArr.length;
                int i = repeatedFieldArrayLength + length;
                Af[] afArr2 = new Af[i];
                if (length != 0) {
                    System.arraycopy(afArr, 0, afArr2, 0, length);
                }
                while (length < i - 1) {
                    Af af = new Af();
                    afArr2[length] = af;
                    codedInputByteBufferNano.readMessage(af);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Af af2 = new Af();
                afArr2[length] = af2;
                codedInputByteBufferNano.readMessage(af2);
                this.b = afArr2;
            }
        }
        return this;
    }

    public static Bf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Bf().mergeFrom(codedInputByteBufferNano);
    }

    public static Bf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Bf) MessageNano.mergeFrom(new Bf(), bArr);
    }
}
