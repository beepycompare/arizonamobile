package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class T3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile T3[] g;

    /* renamed from: a  reason: collision with root package name */
    public Q3 f633a;
    public Q3[] b;

    public T3() {
        a();
    }

    public static T3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new T3[0];
                }
            }
        }
        return g;
    }

    public final T3 a() {
        this.f633a = null;
        this.b = Q3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Q3 q3 = this.f633a;
        if (q3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, q3);
        }
        Q3[] q3Arr = this.b;
        if (q3Arr != null && q3Arr.length > 0) {
            int i = 0;
            while (true) {
                Q3[] q3Arr2 = this.b;
                if (i >= q3Arr2.length) {
                    break;
                }
                Q3 q32 = q3Arr2[i];
                if (q32 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, q32) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Q3 q3 = this.f633a;
        if (q3 != null) {
            codedOutputByteBufferNano.writeMessage(1, q3);
        }
        Q3[] q3Arr = this.b;
        if (q3Arr != null && q3Arr.length > 0) {
            int i = 0;
            while (true) {
                Q3[] q3Arr2 = this.b;
                if (i >= q3Arr2.length) {
                    break;
                }
                Q3 q32 = q3Arr2[i];
                if (q32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, q32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final T3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f633a == null) {
                    this.f633a = new Q3();
                }
                codedInputByteBufferNano.readMessage(this.f633a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Q3[] q3Arr = this.b;
                int length = q3Arr == null ? 0 : q3Arr.length;
                int i = repeatedFieldArrayLength + length;
                Q3[] q3Arr2 = new Q3[i];
                if (length != 0) {
                    System.arraycopy(q3Arr, 0, q3Arr2, 0, length);
                }
                while (length < i - 1) {
                    Q3 q3 = new Q3();
                    q3Arr2[length] = q3;
                    codedInputByteBufferNano.readMessage(q3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Q3 q32 = new Q3();
                q3Arr2[length] = q32;
                codedInputByteBufferNano.readMessage(q32);
                this.b = q3Arr2;
            }
        }
        return this;
    }

    public static T3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new T3().mergeFrom(codedInputByteBufferNano);
    }

    public static T3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (T3) MessageNano.mergeFrom(new T3(), bArr);
    }
}
