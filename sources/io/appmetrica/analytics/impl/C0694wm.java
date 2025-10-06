package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.wm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0694wm extends MessageNano {
    public static volatile C0694wm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0669vm[] f1145a;

    public C0694wm() {
        a();
    }

    public static C0694wm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0694wm[0];
                }
            }
        }
        return b;
    }

    public final C0694wm a() {
        this.f1145a = C0669vm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0669vm[] c0669vmArr = this.f1145a;
        if (c0669vmArr != null && c0669vmArr.length > 0) {
            int i = 0;
            while (true) {
                C0669vm[] c0669vmArr2 = this.f1145a;
                if (i >= c0669vmArr2.length) {
                    break;
                }
                C0669vm c0669vm = c0669vmArr2[i];
                if (c0669vm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0669vm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0669vm[] c0669vmArr = this.f1145a;
        if (c0669vmArr != null && c0669vmArr.length > 0) {
            int i = 0;
            while (true) {
                C0669vm[] c0669vmArr2 = this.f1145a;
                if (i >= c0669vmArr2.length) {
                    break;
                }
                C0669vm c0669vm = c0669vmArr2[i];
                if (c0669vm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0669vm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0694wm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0669vm[] c0669vmArr = this.f1145a;
                int length = c0669vmArr == null ? 0 : c0669vmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0669vm[] c0669vmArr2 = new C0669vm[i];
                if (length != 0) {
                    System.arraycopy(c0669vmArr, 0, c0669vmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0669vm c0669vm = new C0669vm();
                    c0669vmArr2[length] = c0669vm;
                    codedInputByteBufferNano.readMessage(c0669vm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0669vm c0669vm2 = new C0669vm();
                c0669vmArr2[length] = c0669vm2;
                codedInputByteBufferNano.readMessage(c0669vm2);
                this.f1145a = c0669vmArr2;
            }
        }
        return this;
    }

    public static C0694wm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0694wm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0694wm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0694wm) MessageNano.mergeFrom(new C0694wm(), bArr);
    }
}
