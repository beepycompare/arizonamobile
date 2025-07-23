package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.n6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0451n6 extends MessageNano {
    public static volatile C0451n6[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0675w6 f965a;
    public C0675w6[] b;
    public String c;

    public C0451n6() {
        a();
    }

    public static C0451n6[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0451n6[0];
                }
            }
        }
        return d;
    }

    public final C0451n6 a() {
        this.f965a = null;
        this.b = C0675w6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0675w6 c0675w6 = this.f965a;
        if (c0675w6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0675w6);
        }
        C0675w6[] c0675w6Arr = this.b;
        if (c0675w6Arr != null && c0675w6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0675w6[] c0675w6Arr2 = this.b;
                if (i >= c0675w6Arr2.length) {
                    break;
                }
                C0675w6 c0675w62 = c0675w6Arr2[i];
                if (c0675w62 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0675w62);
                }
                i++;
            }
        }
        return !this.c.equals("") ? CodedOutputByteBufferNano.computeStringSize(3, this.c) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0675w6 c0675w6 = this.f965a;
        if (c0675w6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0675w6);
        }
        C0675w6[] c0675w6Arr = this.b;
        if (c0675w6Arr != null && c0675w6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0675w6[] c0675w6Arr2 = this.b;
                if (i >= c0675w6Arr2.length) {
                    break;
                }
                C0675w6 c0675w62 = c0675w6Arr2[i];
                if (c0675w62 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0675w62);
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
    public final C0451n6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f965a == null) {
                    this.f965a = new C0675w6();
                }
                codedInputByteBufferNano.readMessage(this.f965a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0675w6[] c0675w6Arr = this.b;
                int length = c0675w6Arr == null ? 0 : c0675w6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0675w6[] c0675w6Arr2 = new C0675w6[i];
                if (length != 0) {
                    System.arraycopy(c0675w6Arr, 0, c0675w6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0675w6 c0675w6 = new C0675w6();
                    c0675w6Arr2[length] = c0675w6;
                    codedInputByteBufferNano.readMessage(c0675w6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0675w6 c0675w62 = new C0675w6();
                c0675w6Arr2[length] = c0675w62;
                codedInputByteBufferNano.readMessage(c0675w62);
                this.b = c0675w6Arr2;
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

    public static C0451n6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0451n6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0451n6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0451n6) MessageNano.mergeFrom(new C0451n6(), bArr);
    }
}
