package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.sf  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0575sf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0575sf[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0526qf f1113a;
    public C0550rf[] b;

    public C0575sf() {
        a();
    }

    public static C0575sf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0575sf[0];
                }
            }
        }
        return g;
    }

    public final C0575sf a() {
        this.f1113a = null;
        this.b = C0550rf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0526qf c0526qf = this.f1113a;
        if (c0526qf != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0526qf);
        }
        C0550rf[] c0550rfArr = this.b;
        if (c0550rfArr != null && c0550rfArr.length > 0) {
            int i = 0;
            while (true) {
                C0550rf[] c0550rfArr2 = this.b;
                if (i >= c0550rfArr2.length) {
                    break;
                }
                C0550rf c0550rf = c0550rfArr2[i];
                if (c0550rf != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0550rf) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0526qf c0526qf = this.f1113a;
        if (c0526qf != null) {
            codedOutputByteBufferNano.writeMessage(1, c0526qf);
        }
        C0550rf[] c0550rfArr = this.b;
        if (c0550rfArr != null && c0550rfArr.length > 0) {
            int i = 0;
            while (true) {
                C0550rf[] c0550rfArr2 = this.b;
                if (i >= c0550rfArr2.length) {
                    break;
                }
                C0550rf c0550rf = c0550rfArr2[i];
                if (c0550rf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0550rf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0575sf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1113a == null) {
                    this.f1113a = new C0526qf();
                }
                codedInputByteBufferNano.readMessage(this.f1113a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0550rf[] c0550rfArr = this.b;
                int length = c0550rfArr == null ? 0 : c0550rfArr.length;
                int i = repeatedFieldArrayLength + length;
                C0550rf[] c0550rfArr2 = new C0550rf[i];
                if (length != 0) {
                    System.arraycopy(c0550rfArr, 0, c0550rfArr2, 0, length);
                }
                while (length < i - 1) {
                    C0550rf c0550rf = new C0550rf();
                    c0550rfArr2[length] = c0550rf;
                    codedInputByteBufferNano.readMessage(c0550rf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0550rf c0550rf2 = new C0550rf();
                c0550rfArr2[length] = c0550rf2;
                codedInputByteBufferNano.readMessage(c0550rf2);
                this.b = c0550rfArr2;
            }
        }
        return this;
    }

    public static C0575sf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0575sf().mergeFrom(codedInputByteBufferNano);
    }

    public static C0575sf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0575sf) MessageNano.mergeFrom(new C0575sf(), bArr);
    }
}
