package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ho  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0306ho extends MessageNano {
    public static volatile C0306ho[] c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1027a;
    public boolean b;

    public C0306ho() {
        a();
    }

    public static C0306ho[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0306ho[0];
                }
            }
        }
        return c;
    }

    public final C0306ho a() {
        this.f1027a = false;
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f1027a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        boolean z2 = this.b;
        return z2 ? CodedOutputByteBufferNano.computeBoolSize(2, z2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f1027a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        boolean z2 = this.b;
        if (z2) {
            codedOutputByteBufferNano.writeBool(2, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0306ho mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1027a = codedInputByteBufferNano.readBool();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static C0306ho b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0306ho().mergeFrom(codedInputByteBufferNano);
    }

    public static C0306ho a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0306ho) MessageNano.mergeFrom(new C0306ho(), bArr);
    }
}
