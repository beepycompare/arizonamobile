package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.m8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0422m8 extends MessageNano {
    public static volatile C0422m8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0166c8 f1113a;
    public C0166c8[] b;

    public C0422m8() {
        a();
    }

    public static C0422m8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0422m8[0];
                }
            }
        }
        return c;
    }

    public final C0422m8 a() {
        this.f1113a = null;
        this.b = C0166c8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0166c8 c0166c8 = this.f1113a;
        if (c0166c8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0166c8);
        }
        C0166c8[] c0166c8Arr = this.b;
        if (c0166c8Arr != null && c0166c8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0166c8[] c0166c8Arr2 = this.b;
                if (i >= c0166c8Arr2.length) {
                    break;
                }
                C0166c8 c0166c82 = c0166c8Arr2[i];
                if (c0166c82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0166c82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0166c8 c0166c8 = this.f1113a;
        if (c0166c8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0166c8);
        }
        C0166c8[] c0166c8Arr = this.b;
        if (c0166c8Arr != null && c0166c8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0166c8[] c0166c8Arr2 = this.b;
                if (i >= c0166c8Arr2.length) {
                    break;
                }
                C0166c8 c0166c82 = c0166c8Arr2[i];
                if (c0166c82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0166c82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0422m8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1113a == null) {
                    this.f1113a = new C0166c8();
                }
                codedInputByteBufferNano.readMessage(this.f1113a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0166c8[] c0166c8Arr = this.b;
                int length = c0166c8Arr == null ? 0 : c0166c8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0166c8[] c0166c8Arr2 = new C0166c8[i];
                if (length != 0) {
                    System.arraycopy(c0166c8Arr, 0, c0166c8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0166c8 c0166c8 = new C0166c8();
                    c0166c8Arr2[length] = c0166c8;
                    codedInputByteBufferNano.readMessage(c0166c8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0166c8 c0166c82 = new C0166c8();
                c0166c8Arr2[length] = c0166c82;
                codedInputByteBufferNano.readMessage(c0166c82);
                this.b = c0166c8Arr2;
            }
        }
        return this;
    }

    public static C0422m8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0422m8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0422m8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0422m8) MessageNano.mergeFrom(new C0422m8(), bArr);
    }
}
