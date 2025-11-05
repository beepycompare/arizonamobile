package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.k8  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0368k8 extends MessageNano {
    public static volatile C0368k8[] e;

    /* renamed from: a  reason: collision with root package name */
    public C0593t8 f969a;
    public C0643v8 b;
    public C0419m8 c;
    public C0568s8 d;

    public C0368k8() {
        a();
    }

    public static C0368k8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0368k8[0];
                }
            }
        }
        return e;
    }

    public final C0368k8 a() {
        this.f969a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0593t8 c0593t8 = this.f969a;
        if (c0593t8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0593t8);
        }
        C0643v8 c0643v8 = this.b;
        if (c0643v8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0643v8);
        }
        C0419m8 c0419m8 = this.c;
        if (c0419m8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0419m8);
        }
        C0568s8 c0568s8 = this.d;
        return c0568s8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0568s8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0593t8 c0593t8 = this.f969a;
        if (c0593t8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0593t8);
        }
        C0643v8 c0643v8 = this.b;
        if (c0643v8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0643v8);
        }
        C0419m8 c0419m8 = this.c;
        if (c0419m8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0419m8);
        }
        C0568s8 c0568s8 = this.d;
        if (c0568s8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0568s8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0368k8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f969a == null) {
                    this.f969a = new C0593t8();
                }
                codedInputByteBufferNano.readMessage(this.f969a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0643v8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0419m8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0568s8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0368k8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0368k8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0368k8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0368k8) MessageNano.mergeFrom(new C0368k8(), bArr);
    }
}
