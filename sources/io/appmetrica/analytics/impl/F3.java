package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class F3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile F3[] g;

    /* renamed from: a  reason: collision with root package name */
    public C3 f471a;
    public C3[] b;

    public F3() {
        a();
    }

    public static F3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new F3[0];
                }
            }
        }
        return g;
    }

    public final F3 a() {
        this.f471a = null;
        this.b = C3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C3 c3 = this.f471a;
        if (c3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c3);
        }
        C3[] c3Arr = this.b;
        if (c3Arr != null && c3Arr.length > 0) {
            int i = 0;
            while (true) {
                C3[] c3Arr2 = this.b;
                if (i >= c3Arr2.length) {
                    break;
                }
                C3 c32 = c3Arr2[i];
                if (c32 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c32) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C3 c3 = this.f471a;
        if (c3 != null) {
            codedOutputByteBufferNano.writeMessage(1, c3);
        }
        C3[] c3Arr = this.b;
        if (c3Arr != null && c3Arr.length > 0) {
            int i = 0;
            while (true) {
                C3[] c3Arr2 = this.b;
                if (i >= c3Arr2.length) {
                    break;
                }
                C3 c32 = c3Arr2[i];
                if (c32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final F3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f471a == null) {
                    this.f471a = new C3();
                }
                codedInputByteBufferNano.readMessage(this.f471a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C3[] c3Arr = this.b;
                int length = c3Arr == null ? 0 : c3Arr.length;
                int i = repeatedFieldArrayLength + length;
                C3[] c3Arr2 = new C3[i];
                if (length != 0) {
                    System.arraycopy(c3Arr, 0, c3Arr2, 0, length);
                }
                while (length < i - 1) {
                    C3 c3 = new C3();
                    c3Arr2[length] = c3;
                    codedInputByteBufferNano.readMessage(c3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C3 c32 = new C3();
                c3Arr2[length] = c32;
                codedInputByteBufferNano.readMessage(c32);
                this.b = c3Arr2;
            }
        }
        return this;
    }

    public static F3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new F3().mergeFrom(codedInputByteBufferNano);
    }

    public static F3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (F3) MessageNano.mergeFrom(new F3(), bArr);
    }
}
