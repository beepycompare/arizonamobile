package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0713y3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0713y3[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0638v3 f1210a;
    public C0638v3[] b;

    public C0713y3() {
        a();
    }

    public static C0713y3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0713y3[0];
                }
            }
        }
        return g;
    }

    public final C0713y3 a() {
        this.f1210a = null;
        this.b = C0638v3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0638v3 c0638v3 = this.f1210a;
        if (c0638v3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0638v3);
        }
        C0638v3[] c0638v3Arr = this.b;
        if (c0638v3Arr != null && c0638v3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0638v3[] c0638v3Arr2 = this.b;
                if (i >= c0638v3Arr2.length) {
                    break;
                }
                C0638v3 c0638v32 = c0638v3Arr2[i];
                if (c0638v32 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0638v32) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0638v3 c0638v3 = this.f1210a;
        if (c0638v3 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0638v3);
        }
        C0638v3[] c0638v3Arr = this.b;
        if (c0638v3Arr != null && c0638v3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0638v3[] c0638v3Arr2 = this.b;
                if (i >= c0638v3Arr2.length) {
                    break;
                }
                C0638v3 c0638v32 = c0638v3Arr2[i];
                if (c0638v32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0638v32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0713y3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1210a == null) {
                    this.f1210a = new C0638v3();
                }
                codedInputByteBufferNano.readMessage(this.f1210a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0638v3[] c0638v3Arr = this.b;
                int length = c0638v3Arr == null ? 0 : c0638v3Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0638v3[] c0638v3Arr2 = new C0638v3[i];
                if (length != 0) {
                    System.arraycopy(c0638v3Arr, 0, c0638v3Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0638v3 c0638v3 = new C0638v3();
                    c0638v3Arr2[length] = c0638v3;
                    codedInputByteBufferNano.readMessage(c0638v3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0638v3 c0638v32 = new C0638v3();
                c0638v3Arr2[length] = c0638v32;
                codedInputByteBufferNano.readMessage(c0638v32);
                this.b = c0638v3Arr2;
            }
        }
        return this;
    }

    public static C0713y3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0713y3().mergeFrom(codedInputByteBufferNano);
    }

    public static C0713y3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0713y3) MessageNano.mergeFrom(new C0713y3(), bArr);
    }
}
