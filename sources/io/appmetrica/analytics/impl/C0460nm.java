package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0460nm extends MessageNano {
    public static volatile C0460nm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0435mm[] f1147a;

    public C0460nm() {
        a();
    }

    public static C0460nm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0460nm[0];
                }
            }
        }
        return b;
    }

    public final C0460nm a() {
        this.f1147a = C0435mm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0435mm[] c0435mmArr = this.f1147a;
        if (c0435mmArr != null && c0435mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0435mm[] c0435mmArr2 = this.f1147a;
                if (i >= c0435mmArr2.length) {
                    break;
                }
                C0435mm c0435mm = c0435mmArr2[i];
                if (c0435mm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0435mm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0435mm[] c0435mmArr = this.f1147a;
        if (c0435mmArr != null && c0435mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0435mm[] c0435mmArr2 = this.f1147a;
                if (i >= c0435mmArr2.length) {
                    break;
                }
                C0435mm c0435mm = c0435mmArr2[i];
                if (c0435mm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0435mm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0460nm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0435mm[] c0435mmArr = this.f1147a;
                int length = c0435mmArr == null ? 0 : c0435mmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0435mm[] c0435mmArr2 = new C0435mm[i];
                if (length != 0) {
                    System.arraycopy(c0435mmArr, 0, c0435mmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0435mm c0435mm = new C0435mm();
                    c0435mmArr2[length] = c0435mm;
                    codedInputByteBufferNano.readMessage(c0435mm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0435mm c0435mm2 = new C0435mm();
                c0435mmArr2[length] = c0435mm2;
                codedInputByteBufferNano.readMessage(c0435mm2);
                this.f1147a = c0435mmArr2;
            }
        }
        return this;
    }

    public static C0460nm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0460nm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0460nm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0460nm) MessageNano.mergeFrom(new C0460nm(), bArr);
    }
}
