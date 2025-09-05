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
public final class C0693wm extends MessageNano {
    public static volatile C0693wm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0668vm[] f1140a;

    public C0693wm() {
        a();
    }

    public static C0693wm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0693wm[0];
                }
            }
        }
        return b;
    }

    public final C0693wm a() {
        this.f1140a = C0668vm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0668vm[] c0668vmArr = this.f1140a;
        if (c0668vmArr != null && c0668vmArr.length > 0) {
            int i = 0;
            while (true) {
                C0668vm[] c0668vmArr2 = this.f1140a;
                if (i >= c0668vmArr2.length) {
                    break;
                }
                C0668vm c0668vm = c0668vmArr2[i];
                if (c0668vm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0668vm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0668vm[] c0668vmArr = this.f1140a;
        if (c0668vmArr != null && c0668vmArr.length > 0) {
            int i = 0;
            while (true) {
                C0668vm[] c0668vmArr2 = this.f1140a;
                if (i >= c0668vmArr2.length) {
                    break;
                }
                C0668vm c0668vm = c0668vmArr2[i];
                if (c0668vm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0668vm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0693wm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0668vm[] c0668vmArr = this.f1140a;
                int length = c0668vmArr == null ? 0 : c0668vmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0668vm[] c0668vmArr2 = new C0668vm[i];
                if (length != 0) {
                    System.arraycopy(c0668vmArr, 0, c0668vmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0668vm c0668vm = new C0668vm();
                    c0668vmArr2[length] = c0668vm;
                    codedInputByteBufferNano.readMessage(c0668vm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0668vm c0668vm2 = new C0668vm();
                c0668vmArr2[length] = c0668vm2;
                codedInputByteBufferNano.readMessage(c0668vm2);
                this.f1140a = c0668vmArr2;
            }
        }
        return this;
    }

    public static C0693wm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0693wm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0693wm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0693wm) MessageNano.mergeFrom(new C0693wm(), bArr);
    }
}
