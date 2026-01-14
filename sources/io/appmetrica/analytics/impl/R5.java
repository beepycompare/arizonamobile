package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class R5 extends MessageNano {
    public static volatile R5[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0112a6 f762a;
    public C0112a6[] b;
    public String c;

    public R5() {
        a();
    }

    public static R5[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new R5[0];
                }
            }
        }
        return d;
    }

    public final R5 a() {
        this.f762a = null;
        this.b = C0112a6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0112a6 c0112a6 = this.f762a;
        if (c0112a6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0112a6);
        }
        C0112a6[] c0112a6Arr = this.b;
        if (c0112a6Arr != null && c0112a6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0112a6[] c0112a6Arr2 = this.b;
                if (i >= c0112a6Arr2.length) {
                    break;
                }
                C0112a6 c0112a62 = c0112a6Arr2[i];
                if (c0112a62 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0112a62);
                }
                i++;
            }
        }
        return !this.c.equals("") ? CodedOutputByteBufferNano.computeStringSize(3, this.c) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0112a6 c0112a6 = this.f762a;
        if (c0112a6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0112a6);
        }
        C0112a6[] c0112a6Arr = this.b;
        if (c0112a6Arr != null && c0112a6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0112a6[] c0112a6Arr2 = this.b;
                if (i >= c0112a6Arr2.length) {
                    break;
                }
                C0112a6 c0112a62 = c0112a6Arr2[i];
                if (c0112a62 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0112a62);
                }
                i++;
            }
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final R5 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f762a == null) {
                    this.f762a = new C0112a6();
                }
                codedInputByteBufferNano.readMessage(this.f762a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0112a6[] c0112a6Arr = this.b;
                int length = c0112a6Arr == null ? 0 : c0112a6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0112a6[] c0112a6Arr2 = new C0112a6[i];
                if (length != 0) {
                    System.arraycopy(c0112a6Arr, 0, c0112a6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0112a6 c0112a6 = new C0112a6();
                    c0112a6Arr2[length] = c0112a6;
                    codedInputByteBufferNano.readMessage(c0112a6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0112a6 c0112a62 = new C0112a6();
                c0112a6Arr2[length] = c0112a62;
                codedInputByteBufferNano.readMessage(c0112a62);
                this.b = c0112a6Arr2;
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.c = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static R5 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new R5().mergeFrom(codedInputByteBufferNano);
    }

    public static R5 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (R5) MessageNano.mergeFrom(new R5(), bArr);
    }
}
