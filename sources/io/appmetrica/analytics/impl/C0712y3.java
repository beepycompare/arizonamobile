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
public final class C0712y3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0712y3[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0637v3 f1293a;
    public C0637v3[] b;

    public C0712y3() {
        a();
    }

    public static C0712y3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0712y3[0];
                }
            }
        }
        return g;
    }

    public final C0712y3 a() {
        this.f1293a = null;
        this.b = C0637v3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0637v3 c0637v3 = this.f1293a;
        if (c0637v3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0637v3);
        }
        C0637v3[] c0637v3Arr = this.b;
        if (c0637v3Arr != null && c0637v3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0637v3[] c0637v3Arr2 = this.b;
                if (i >= c0637v3Arr2.length) {
                    break;
                }
                C0637v3 c0637v32 = c0637v3Arr2[i];
                if (c0637v32 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0637v32) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0637v3 c0637v3 = this.f1293a;
        if (c0637v3 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0637v3);
        }
        C0637v3[] c0637v3Arr = this.b;
        if (c0637v3Arr != null && c0637v3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0637v3[] c0637v3Arr2 = this.b;
                if (i >= c0637v3Arr2.length) {
                    break;
                }
                C0637v3 c0637v32 = c0637v3Arr2[i];
                if (c0637v32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0637v32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0712y3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1293a == null) {
                    this.f1293a = new C0637v3();
                }
                codedInputByteBufferNano.readMessage(this.f1293a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0637v3[] c0637v3Arr = this.b;
                int length = c0637v3Arr == null ? 0 : c0637v3Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0637v3[] c0637v3Arr2 = new C0637v3[i];
                if (length != 0) {
                    System.arraycopy(c0637v3Arr, 0, c0637v3Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0637v3 c0637v3 = new C0637v3();
                    c0637v3Arr2[length] = c0637v3;
                    codedInputByteBufferNano.readMessage(c0637v3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0637v3 c0637v32 = new C0637v3();
                c0637v3Arr2[length] = c0637v32;
                codedInputByteBufferNano.readMessage(c0637v32);
                this.b = c0637v3Arr2;
            }
        }
        return this;
    }

    public static C0712y3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0712y3().mergeFrom(codedInputByteBufferNano);
    }

    public static C0712y3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0712y3) MessageNano.mergeFrom(new C0712y3(), bArr);
    }
}
