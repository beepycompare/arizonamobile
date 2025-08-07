package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.fo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0270fo extends MessageNano {
    public static volatile C0270fo[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0193co[] f853a;

    public C0270fo() {
        a();
    }

    public static C0270fo[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0270fo[0];
                }
            }
        }
        return b;
    }

    public final C0270fo a() {
        this.f853a = C0193co.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0193co[] c0193coArr = this.f853a;
        if (c0193coArr != null && c0193coArr.length > 0) {
            int i = 0;
            while (true) {
                C0193co[] c0193coArr2 = this.f853a;
                if (i >= c0193coArr2.length) {
                    break;
                }
                C0193co c0193co = c0193coArr2[i];
                if (c0193co != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0193co) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0193co[] c0193coArr = this.f853a;
        if (c0193coArr != null && c0193coArr.length > 0) {
            int i = 0;
            while (true) {
                C0193co[] c0193coArr2 = this.f853a;
                if (i >= c0193coArr2.length) {
                    break;
                }
                C0193co c0193co = c0193coArr2[i];
                if (c0193co != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0193co);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0270fo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0193co[] c0193coArr = this.f853a;
                int length = c0193coArr == null ? 0 : c0193coArr.length;
                int i = repeatedFieldArrayLength + length;
                C0193co[] c0193coArr2 = new C0193co[i];
                if (length != 0) {
                    System.arraycopy(c0193coArr, 0, c0193coArr2, 0, length);
                }
                while (length < i - 1) {
                    C0193co c0193co = new C0193co();
                    c0193coArr2[length] = c0193co;
                    codedInputByteBufferNano.readMessage(c0193co);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0193co c0193co2 = new C0193co();
                c0193coArr2[length] = c0193co2;
                codedInputByteBufferNano.readMessage(c0193co2);
                this.f853a = c0193coArr2;
            }
        }
        return this;
    }

    public static C0270fo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0270fo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0270fo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0270fo) MessageNano.mergeFrom(new C0270fo(), bArr);
    }
}
