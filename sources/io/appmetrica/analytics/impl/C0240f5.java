package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import kotlin.collections.ArraysKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.f5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0240f5 implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final IExecutionPolicy[] f989a;
    public final String b;

    public C0240f5(IExecutionPolicy... iExecutionPolicyArr) {
        this.f989a = iExecutionPolicyArr;
        this.b = "Composite of {" + ArraysKt.joinToString$default(iExecutionPolicyArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C0214e5.f972a, 30, (Object) null) + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        IExecutionPolicy iExecutionPolicy;
        IExecutionPolicy[] iExecutionPolicyArr = this.f989a;
        if (iExecutionPolicyArr.length == 0) {
            return false;
        }
        int length = iExecutionPolicyArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                iExecutionPolicy = null;
                break;
            }
            iExecutionPolicy = iExecutionPolicyArr[i];
            if (!iExecutionPolicy.canBeExecuted()) {
                break;
            }
            i++;
        }
        return iExecutionPolicy == null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.b;
    }
}
