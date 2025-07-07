package com.arkivanov.decompose.router.pages;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: PagesNavigator.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002Jl\u0010\u0003\u001a\u00020\u00042\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062B\u0010\b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\tH&¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/decompose/router/pages/PagesNavigator;", "C", "", "navigate", "", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/pages/Pages;", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newPages", "oldPages", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PagesNavigator<C> {
    void navigate(Function1<? super Pages<? extends C>, ? extends Pages<? extends C>> function1, Function2<? super Pages<? extends C>, ? super Pages<? extends C>, Unit> function2);
}
