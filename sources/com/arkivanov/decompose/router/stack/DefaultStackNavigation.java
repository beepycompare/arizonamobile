package com.arkivanov.decompose.router.stack;

import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.Relay;
import com.arkivanov.decompose.router.stack.StackNavigation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultStackNavigation.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J{\u0010\t\u001a\u00020\n2-\u0010\u000b\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f2B\u0010\u0011\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\"\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\n0\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/arkivanov/decompose/router/stack/DefaultStackNavigation;", "C", "", "Lcom/arkivanov/decompose/router/stack/StackNavigation;", "<init>", "()V", "relay", "Lcom/arkivanov/decompose/Relay;", "Lcom/arkivanov/decompose/router/stack/StackNavigation$Event;", "navigate", "", "transformer", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "stack", "onComplete", "Lkotlin/Function2;", "newStack", "oldStack", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultStackNavigation<C> implements StackNavigation<C> {
    private final Relay<StackNavigation.Event<C>> relay = new Relay<>();

    @Override // com.arkivanov.decompose.router.stack.StackNavigator
    public void navigate(Function1<? super List<? extends C>, ? extends List<? extends C>> transformer, Function2<? super List<? extends C>, ? super List<? extends C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.relay.accept(new StackNavigation.Event<>(transformer, onComplete));
    }

    @Override // com.arkivanov.decompose.router.children.NavigationSource
    public Cancellation subscribe(Function1<? super StackNavigation.Event<C>, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.relay.subscribe(observer);
    }
}
