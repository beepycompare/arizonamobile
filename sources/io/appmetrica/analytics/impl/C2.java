package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class C2 extends MessageNano {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static volatile C2[] f;

    /* renamed from: a  reason: collision with root package name */
    public B2[] f376a;
    public boolean b;

    public C2() {
        a();
    }

    public static C2[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C2[0];
                }
            }
        }
        return f;
    }

    public final C2 a() {
        this.f376a = B2.b();
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        B2[] b2Arr = this.f376a;
        if (b2Arr != null && b2Arr.length > 0) {
            int i = 0;
            while (true) {
                B2[] b2Arr2 = this.f376a;
                if (i >= b2Arr2.length) {
                    break;
                }
                B2 b2 = b2Arr2[i];
                if (b2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, b2);
                }
                i++;
            }
        }
        return CodedOutputByteBufferNano.computeBoolSize(2, this.b) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        B2[] b2Arr = this.f376a;
        if (b2Arr != null && b2Arr.length > 0) {
            int i = 0;
            while (true) {
                B2[] b2Arr2 = this.f376a;
                if (i >= b2Arr2.length) {
                    break;
                }
                B2 b2 = b2Arr2[i];
                if (b2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, b2);
                }
                i++;
            }
        }
        codedOutputByteBufferNano.writeBool(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                B2[] b2Arr = this.f376a;
                int length = b2Arr == null ? 0 : b2Arr.length;
                int i = repeatedFieldArrayLength + length;
                B2[] b2Arr2 = new B2[i];
                if (length != 0) {
                    System.arraycopy(b2Arr, 0, b2Arr2, 0, length);
                }
                while (length < i - 1) {
                    B2 b2 = new B2();
                    b2Arr2[length] = b2;
                    codedInputByteBufferNano.readMessage(b2);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                B2 b22 = new B2();
                b2Arr2[length] = b22;
                codedInputByteBufferNano.readMessage(b22);
                this.f376a = b2Arr2;
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static C2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C2().mergeFrom(codedInputByteBufferNano);
    }

    public static C2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C2) MessageNano.mergeFrom(new C2(), bArr);
    }
}
