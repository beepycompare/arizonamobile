package com.arkivanov.decompose.router.children;

import kotlin.Metadata;
import kotlin.uuid.Uuid;
/* compiled from: ChildItem.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"randomKey", "", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChildItemKt {
    public static final String randomKey() {
        return Uuid.Companion.random().toString();
    }
}
