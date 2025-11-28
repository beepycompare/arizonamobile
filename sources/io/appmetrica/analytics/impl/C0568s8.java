package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.s8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0568s8 extends MessageNano {
    public static volatile C0568s8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0317i8 f1109a;
    public C0317i8[] b;

    public C0568s8() {
        a();
    }

    public static C0568s8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0568s8[0];
                }
            }
        }
        return c;
    }

    public final C0568s8 a() {
        this.f1109a = null;
        this.b = C0317i8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0317i8 c0317i8 = this.f1109a;
        if (c0317i8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0317i8);
        }
        C0317i8[] c0317i8Arr = this.b;
        if (c0317i8Arr != null && c0317i8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0317i8[] c0317i8Arr2 = this.b;
                if (i >= c0317i8Arr2.length) {
                    break;
                }
                C0317i8 c0317i82 = c0317i8Arr2[i];
                if (c0317i82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0317i82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0317i8 c0317i8 = this.f1109a;
        if (c0317i8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0317i8);
        }
        C0317i8[] c0317i8Arr = this.b;
        if (c0317i8Arr != null && c0317i8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0317i8[] c0317i8Arr2 = this.b;
                if (i >= c0317i8Arr2.length) {
                    break;
                }
                C0317i8 c0317i82 = c0317i8Arr2[i];
                if (c0317i82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0317i82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0568s8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1109a == null) {
                    this.f1109a = new C0317i8();
                }
                codedInputByteBufferNano.readMessage(this.f1109a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0317i8[] c0317i8Arr = this.b;
                int length = c0317i8Arr == null ? 0 : c0317i8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0317i8[] c0317i8Arr2 = new C0317i8[i];
                if (length != 0) {
                    System.arraycopy(c0317i8Arr, 0, c0317i8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0317i8 c0317i8 = new C0317i8();
                    c0317i8Arr2[length] = c0317i8;
                    codedInputByteBufferNano.readMessage(c0317i8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0317i8 c0317i82 = new C0317i8();
                c0317i8Arr2[length] = c0317i82;
                codedInputByteBufferNano.readMessage(c0317i82);
                this.b = c0317i8Arr2;
            }
        }
        return this;
    }

    public static C0568s8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0568s8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0568s8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0568s8) MessageNano.mergeFrom(new C0568s8(), bArr);
    }
}
