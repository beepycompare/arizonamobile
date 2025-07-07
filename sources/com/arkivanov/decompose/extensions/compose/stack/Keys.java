package com.arkivanov.decompose.extensions.compose.stack;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Children.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/Keys;", "", "set", "", "<init>", "(Ljava/util/Set;)V", "getSet", "()Ljava/util/Set;", "setSet", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Keys {
    private Set<? extends Object> set;

    public Keys(Set<? extends Object> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.set = set;
    }

    public final Set<Object> getSet() {
        return this.set;
    }

    public final void setSet(Set<? extends Object> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.set = set;
    }
}
