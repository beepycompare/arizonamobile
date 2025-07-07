package com.arkivanov.decompose.router.stack;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: StackNavigator.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J{\u0010\u0003\u001a\u00020\u00042-\u0010\u0005\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062B\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\fH&¨\u0006\u000f"}, d2 = {"Lcom/arkivanov/decompose/router/stack/StackNavigator;", "C", "", "navigate", "", "transformer", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "stack", "onComplete", "Lkotlin/Function2;", "newStack", "oldStack", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface StackNavigator<C> {
    void navigate(Function1<? super List<? extends C>, ? extends List<? extends C>> function1, Function2<? super List<? extends C>, ? super List<? extends C>, Unit> function2);
}
