package com.arkivanov.decompose.router.children;

import java.util.List;
import kotlin.Metadata;
/* compiled from: NavState.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002R\u001e\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/arkivanov/decompose/router/children/NavState;", "C", "", "children", "", "Lcom/arkivanov/decompose/router/children/ChildNavState;", "getChildren", "()Ljava/util/List;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface NavState<C> {
    List<ChildNavState<C>> getChildren();
}
