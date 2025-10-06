package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.q6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0529q6 extends MessageNano {
    public static volatile C0529q6[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0753z6 f1047a;
    public C0753z6[] b;
    public String c;

    public C0529q6() {
        a();
    }

    public static C0529q6[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0529q6[0];
                }
            }
        }
        return d;
    }

    public final C0529q6 a() {
        this.f1047a = null;
        this.b = C0753z6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0753z6 c0753z6 = this.f1047a;
        if (c0753z6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0753z6);
        }
        C0753z6[] c0753z6Arr = this.b;
        if (c0753z6Arr != null && c0753z6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0753z6[] c0753z6Arr2 = this.b;
                if (i >= c0753z6Arr2.length) {
                    break;
                }
                C0753z6 c0753z62 = c0753z6Arr2[i];
                if (c0753z62 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0753z62);
                }
                i++;
            }
        }
        return !this.c.equals("") ? CodedOutputByteBufferNano.computeStringSize(3, this.c) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0753z6 c0753z6 = this.f1047a;
        if (c0753z6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0753z6);
        }
        C0753z6[] c0753z6Arr = this.b;
        if (c0753z6Arr != null && c0753z6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0753z6[] c0753z6Arr2 = this.b;
                if (i >= c0753z6Arr2.length) {
                    break;
                }
                C0753z6 c0753z62 = c0753z6Arr2[i];
                if (c0753z62 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0753z62);
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
    public final C0529q6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1047a == null) {
                    this.f1047a = new C0753z6();
                }
                codedInputByteBufferNano.readMessage(this.f1047a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0753z6[] c0753z6Arr = this.b;
                int length = c0753z6Arr == null ? 0 : c0753z6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0753z6[] c0753z6Arr2 = new C0753z6[i];
                if (length != 0) {
                    System.arraycopy(c0753z6Arr, 0, c0753z6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0753z6 c0753z6 = new C0753z6();
                    c0753z6Arr2[length] = c0753z6;
                    codedInputByteBufferNano.readMessage(c0753z6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0753z6 c0753z62 = new C0753z6();
                c0753z6Arr2[length] = c0753z62;
                codedInputByteBufferNano.readMessage(c0753z62);
                this.b = c0753z6Arr2;
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

    public static C0529q6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0529q6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0529q6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0529q6) MessageNano.mergeFrom(new C0529q6(), bArr);
    }
}
