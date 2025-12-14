package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class S5 extends MessageNano {
    public static volatile S5[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0133b6 f770a;
    public C0133b6[] b;
    public String c;

    public S5() {
        a();
    }

    public static S5[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new S5[0];
                }
            }
        }
        return d;
    }

    public final S5 a() {
        this.f770a = null;
        this.b = C0133b6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0133b6 c0133b6 = this.f770a;
        if (c0133b6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0133b6);
        }
        C0133b6[] c0133b6Arr = this.b;
        if (c0133b6Arr != null && c0133b6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0133b6[] c0133b6Arr2 = this.b;
                if (i >= c0133b6Arr2.length) {
                    break;
                }
                C0133b6 c0133b62 = c0133b6Arr2[i];
                if (c0133b62 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0133b62);
                }
                i++;
            }
        }
        return !this.c.equals("") ? CodedOutputByteBufferNano.computeStringSize(3, this.c) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0133b6 c0133b6 = this.f770a;
        if (c0133b6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0133b6);
        }
        C0133b6[] c0133b6Arr = this.b;
        if (c0133b6Arr != null && c0133b6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0133b6[] c0133b6Arr2 = this.b;
                if (i >= c0133b6Arr2.length) {
                    break;
                }
                C0133b6 c0133b62 = c0133b6Arr2[i];
                if (c0133b62 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0133b62);
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
    public final S5 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f770a == null) {
                    this.f770a = new C0133b6();
                }
                codedInputByteBufferNano.readMessage(this.f770a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0133b6[] c0133b6Arr = this.b;
                int length = c0133b6Arr == null ? 0 : c0133b6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0133b6[] c0133b6Arr2 = new C0133b6[i];
                if (length != 0) {
                    System.arraycopy(c0133b6Arr, 0, c0133b6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0133b6 c0133b6 = new C0133b6();
                    c0133b6Arr2[length] = c0133b6;
                    codedInputByteBufferNano.readMessage(c0133b6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0133b6 c0133b62 = new C0133b6();
                c0133b6Arr2[length] = c0133b62;
                codedInputByteBufferNano.readMessage(c0133b62);
                this.b = c0133b6Arr2;
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

    public static S5 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new S5().mergeFrom(codedInputByteBufferNano);
    }

    public static S5 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (S5) MessageNano.mergeFrom(new S5(), bArr);
    }
}
