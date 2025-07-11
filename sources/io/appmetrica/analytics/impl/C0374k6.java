package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.k6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0374k6 extends MessageNano {
    public static volatile C0374k6[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0598t6 f902a;
    public C0598t6[] b;
    public String c;

    public C0374k6() {
        a();
    }

    public static C0374k6[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0374k6[0];
                }
            }
        }
        return d;
    }

    public final C0374k6 a() {
        this.f902a = null;
        this.b = C0598t6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0598t6 c0598t6 = this.f902a;
        if (c0598t6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0598t6);
        }
        C0598t6[] c0598t6Arr = this.b;
        if (c0598t6Arr != null && c0598t6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0598t6[] c0598t6Arr2 = this.b;
                if (i >= c0598t6Arr2.length) {
                    break;
                }
                C0598t6 c0598t62 = c0598t6Arr2[i];
                if (c0598t62 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0598t62);
                }
                i++;
            }
        }
        return !this.c.equals("") ? CodedOutputByteBufferNano.computeStringSize(3, this.c) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0598t6 c0598t6 = this.f902a;
        if (c0598t6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0598t6);
        }
        C0598t6[] c0598t6Arr = this.b;
        if (c0598t6Arr != null && c0598t6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0598t6[] c0598t6Arr2 = this.b;
                if (i >= c0598t6Arr2.length) {
                    break;
                }
                C0598t6 c0598t62 = c0598t6Arr2[i];
                if (c0598t62 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0598t62);
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
    public final C0374k6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f902a == null) {
                    this.f902a = new C0598t6();
                }
                codedInputByteBufferNano.readMessage(this.f902a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0598t6[] c0598t6Arr = this.b;
                int length = c0598t6Arr == null ? 0 : c0598t6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0598t6[] c0598t6Arr2 = new C0598t6[i];
                if (length != 0) {
                    System.arraycopy(c0598t6Arr, 0, c0598t6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0598t6 c0598t6 = new C0598t6();
                    c0598t6Arr2[length] = c0598t6;
                    codedInputByteBufferNano.readMessage(c0598t6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0598t6 c0598t62 = new C0598t6();
                c0598t6Arr2[length] = c0598t62;
                codedInputByteBufferNano.readMessage(c0598t62);
                this.b = c0598t6Arr2;
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

    public static C0374k6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0374k6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0374k6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0374k6) MessageNano.mergeFrom(new C0374k6(), bArr);
    }
}
