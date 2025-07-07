package com.arkivanov.decompose.router.slot;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: SlotNavigator.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002Jk\u0010\u0003\u001a\u00020\u00042%\u0010\u0005\u001a!\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00062:\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/decompose/router/slot/SlotNavigator;", "C", "", "navigate", "", "transformer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "configuration", "onComplete", "Lkotlin/Function2;", "newConfiguration", "oldConfiguration", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SlotNavigator<C> {
    void navigate(Function1<? super C, ? extends C> function1, Function2<? super C, ? super C, Unit> function2);
}
