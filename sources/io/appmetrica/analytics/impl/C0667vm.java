package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.vm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0667vm extends MessageNano {
    public static volatile C0667vm[] b;

    /* renamed from: a  reason: collision with root package name */
    public int f1105a;

    public C0667vm() {
        a();
    }

    public static C0667vm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0667vm[0];
                }
            }
        }
        return b;
    }

    public final C0667vm a() {
        this.f1105a = 86400;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1105a;
        return i != 86400 ? CodedOutputByteBufferNano.computeUInt32Size(1, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1105a;
        if (i != 86400) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0667vm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1105a = codedInputByteBufferNano.readUInt32();
            }
        }
        return this;
    }

    public static C0667vm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0667vm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0667vm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0667vm) MessageNano.mergeFrom(new C0667vm(), bArr);
    }
}
