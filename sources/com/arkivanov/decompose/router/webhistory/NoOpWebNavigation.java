package com.arkivanov.decompose.router.webhistory;

import com.arkivanov.decompose.router.webhistory.WebNavigation;
import com.arkivanov.decompose.value.MutableValueBuilderKt;
import com.arkivanov.decompose.value.Value;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
/* compiled from: NoOpWebNavigation.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/arkivanov/decompose/router/webhistory/NoOpWebNavigation;", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "getSerializer$annotations", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "history", "Lcom/arkivanov/decompose/value/Value;", "", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation$HistoryItem;", "getHistory", "()Lcom/arkivanov/decompose/value/Value;", "onBeforeNavigate", "", "navigate", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NoOpWebNavigation implements WebNavigation {
    public static final NoOpWebNavigation INSTANCE = new NoOpWebNavigation();
    private static final Value<List<WebNavigation.HistoryItem>> history = MutableValueBuilderKt.MutableValue(CollectionsKt.emptyList());

    public static /* synthetic */ void getSerializer$annotations() {
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public void navigate(List history2) {
        Intrinsics.checkNotNullParameter(history2, "history");
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public boolean onBeforeNavigate() {
        return true;
    }

    private NoOpWebNavigation() {
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public KSerializer getSerializer() {
        return BuiltinSerializersKt.NothingSerializer();
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public Value<List<WebNavigation.HistoryItem>> getHistory() {
        return history;
    }
}
