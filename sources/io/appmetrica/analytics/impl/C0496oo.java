package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.oo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0496oo extends MessageNano {
    public static volatile C0496oo[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0418lo[] f1027a;

    public C0496oo() {
        a();
    }

    public static C0496oo[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0496oo[0];
                }
            }
        }
        return b;
    }

    public final C0496oo a() {
        this.f1027a = C0418lo.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0418lo[] c0418loArr = this.f1027a;
        if (c0418loArr != null && c0418loArr.length > 0) {
            int i = 0;
            while (true) {
                C0418lo[] c0418loArr2 = this.f1027a;
                if (i >= c0418loArr2.length) {
                    break;
                }
                C0418lo c0418lo = c0418loArr2[i];
                if (c0418lo != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0418lo) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0418lo[] c0418loArr = this.f1027a;
        if (c0418loArr != null && c0418loArr.length > 0) {
            int i = 0;
            while (true) {
                C0418lo[] c0418loArr2 = this.f1027a;
                if (i >= c0418loArr2.length) {
                    break;
                }
                C0418lo c0418lo = c0418loArr2[i];
                if (c0418lo != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0418lo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0496oo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0418lo[] c0418loArr = this.f1027a;
                int length = c0418loArr == null ? 0 : c0418loArr.length;
                int i = repeatedFieldArrayLength + length;
                C0418lo[] c0418loArr2 = new C0418lo[i];
                if (length != 0) {
                    System.arraycopy(c0418loArr, 0, c0418loArr2, 0, length);
                }
                while (length < i - 1) {
                    C0418lo c0418lo = new C0418lo();
                    c0418loArr2[length] = c0418lo;
                    codedInputByteBufferNano.readMessage(c0418lo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0418lo c0418lo2 = new C0418lo();
                c0418loArr2[length] = c0418lo2;
                codedInputByteBufferNano.readMessage(c0418lo2);
                this.f1027a = c0418loArr2;
            }
        }
        return this;
    }

    public static C0496oo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0496oo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0496oo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0496oo) MessageNano.mergeFrom(new C0496oo(), bArr);
    }
}
