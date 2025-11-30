package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.n8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0444n8 extends MessageNano {
    public static volatile C0444n8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0188d8 f1026a;
    public C0188d8[] b;

    public C0444n8() {
        a();
    }

    public static C0444n8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0444n8[0];
                }
            }
        }
        return c;
    }

    public final C0444n8 a() {
        this.f1026a = null;
        this.b = C0188d8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0188d8 c0188d8 = this.f1026a;
        if (c0188d8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0188d8);
        }
        C0188d8[] c0188d8Arr = this.b;
        if (c0188d8Arr != null && c0188d8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0188d8[] c0188d8Arr2 = this.b;
                if (i >= c0188d8Arr2.length) {
                    break;
                }
                C0188d8 c0188d82 = c0188d8Arr2[i];
                if (c0188d82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0188d82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0188d8 c0188d8 = this.f1026a;
        if (c0188d8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0188d8);
        }
        C0188d8[] c0188d8Arr = this.b;
        if (c0188d8Arr != null && c0188d8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0188d8[] c0188d8Arr2 = this.b;
                if (i >= c0188d8Arr2.length) {
                    break;
                }
                C0188d8 c0188d82 = c0188d8Arr2[i];
                if (c0188d82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0188d82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0444n8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1026a == null) {
                    this.f1026a = new C0188d8();
                }
                codedInputByteBufferNano.readMessage(this.f1026a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0188d8[] c0188d8Arr = this.b;
                int length = c0188d8Arr == null ? 0 : c0188d8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0188d8[] c0188d8Arr2 = new C0188d8[i];
                if (length != 0) {
                    System.arraycopy(c0188d8Arr, 0, c0188d8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0188d8 c0188d8 = new C0188d8();
                    c0188d8Arr2[length] = c0188d8;
                    codedInputByteBufferNano.readMessage(c0188d8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0188d8 c0188d82 = new C0188d8();
                c0188d8Arr2[length] = c0188d82;
                codedInputByteBufferNano.readMessage(c0188d82);
                this.b = c0188d8Arr2;
            }
        }
        return this;
    }

    public static C0444n8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0444n8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0444n8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0444n8) MessageNano.mergeFrom(new C0444n8(), bArr);
    }
}
