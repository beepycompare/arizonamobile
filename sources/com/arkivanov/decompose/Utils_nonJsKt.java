package com.arkivanov.decompose;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* compiled from: Utils.nonJs.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"uniqueName", "", "Lkotlin/reflect/KClass;", "getUniqueName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Utils_nonJsKt {
    public static final String getUniqueName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return kClass.getQualifiedName();
    }
}
