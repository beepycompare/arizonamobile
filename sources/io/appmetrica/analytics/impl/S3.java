package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class S3 extends MessageNano {
    public static volatile S3[] b;

    /* renamed from: a  reason: collision with root package name */
    public R3[] f620a;

    public S3() {
        a();
    }

    public static S3[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new S3[0];
                }
            }
        }
        return b;
    }

    public final S3 a() {
        this.f620a = R3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        R3[] r3Arr = this.f620a;
        if (r3Arr != null && r3Arr.length > 0) {
            int i = 0;
            while (true) {
                R3[] r3Arr2 = this.f620a;
                if (i >= r3Arr2.length) {
                    break;
                }
                R3 r3 = r3Arr2[i];
                if (r3 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, r3) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        R3[] r3Arr = this.f620a;
        if (r3Arr != null && r3Arr.length > 0) {
            int i = 0;
            while (true) {
                R3[] r3Arr2 = this.f620a;
                if (i >= r3Arr2.length) {
                    break;
                }
                R3 r3 = r3Arr2[i];
                if (r3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, r3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final S3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                R3[] r3Arr = this.f620a;
                int length = r3Arr == null ? 0 : r3Arr.length;
                int i = repeatedFieldArrayLength + length;
                R3[] r3Arr2 = new R3[i];
                if (length != 0) {
                    System.arraycopy(r3Arr, 0, r3Arr2, 0, length);
                }
                while (length < i - 1) {
                    R3 r3 = new R3();
                    r3Arr2[length] = r3;
                    codedInputByteBufferNano.readMessage(r3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                R3 r32 = new R3();
                r3Arr2[length] = r32;
                codedInputByteBufferNano.readMessage(r32);
                this.f620a = r3Arr2;
            }
        }
        return this;
    }

    public static S3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new S3().mergeFrom(codedInputByteBufferNano);
    }

    public static S3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (S3) MessageNano.mergeFrom(new S3(), bArr);
    }
}
