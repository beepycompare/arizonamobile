package com.arkivanov.decompose.backhandler;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arkivanov.essenty.backhandler.BackCallback;
import com.arkivanov.essenty.backhandler.BackCallbackKt;
import com.arkivanov.essenty.backhandler.BackDispatcher;
import com.arkivanov.essenty.backhandler.BackDispatcherKt;
import com.arkivanov.essenty.backhandler.BackHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
/* compiled from: DefaultChildBackHandler.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\rH\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/arkivanov/decompose/backhandler/DefaultChildBackHandler;", "Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "parent", "isEnabled", "", "priority", "", "delegate", "Lcom/arkivanov/essenty/backhandler/BackDispatcher;", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackHandler;ZILcom/arkivanov/essenty/backhandler/BackDispatcher;)V", "parentCallback", "Lcom/arkivanov/essenty/backhandler/BackCallback;", "<set-?>", "()Z", "setEnabled", "(Z)V", "isEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", TtmlNode.START, "", "stop", "updateParentCallbackEnabledState", "isRegistered", "callback", "register", "unregister", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultChildBackHandler implements ChildBackHandler, BackHandler {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(DefaultChildBackHandler.class, "isEnabled", "isEnabled()Z", 0))};
    private final BackDispatcher delegate;
    private final ReadWriteProperty isEnabled$delegate;
    private final BackHandler parent;
    private final BackCallback parentCallback;

    @Override // com.arkivanov.essenty.backhandler.BackHandler
    public boolean isRegistered(BackCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.delegate.isRegistered(callback);
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandler
    public void register(BackCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.delegate.register(callback);
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandler
    public void unregister(BackCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.delegate.unregister(callback);
    }

    public DefaultChildBackHandler(BackHandler parent, boolean z, int i, BackDispatcher delegate) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.parent = parent;
        this.delegate = delegate;
        this.parentCallback = BackCallbackKt.BackCallback(false, i, new DefaultChildBackHandler$parentCallback$1(delegate), new DefaultChildBackHandler$parentCallback$2(delegate), new DefaultChildBackHandler$parentCallback$3(delegate), new DefaultChildBackHandler$parentCallback$4(delegate));
        Delegates delegates = Delegates.INSTANCE;
        final Boolean valueOf = Boolean.valueOf(z);
        this.isEnabled$delegate = new ObservableProperty<Boolean>(valueOf) { // from class: com.arkivanov.decompose.backhandler.DefaultChildBackHandler$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean bool, Boolean bool2) {
                Intrinsics.checkNotNullParameter(property, "property");
                bool2.booleanValue();
                bool.booleanValue();
                this.updateParentCallbackEnabledState();
            }
        };
        delegate.addEnabledChangedListener(new Function1() { // from class: com.arkivanov.decompose.backhandler.DefaultChildBackHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = DefaultChildBackHandler._init_$lambda$1(DefaultChildBackHandler.this, ((Boolean) obj).booleanValue());
                return _init_$lambda$1;
            }
        });
    }

    public /* synthetic */ DefaultChildBackHandler(BackHandler backHandler, boolean z, int i, BackDispatcher backDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(backHandler, z, i, (i2 & 8) != 0 ? BackDispatcherKt.BackDispatcher() : backDispatcher);
    }

    @Override // com.arkivanov.decompose.backhandler.ChildBackHandler
    public boolean isEnabled() {
        return ((Boolean) this.isEnabled$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    @Override // com.arkivanov.decompose.backhandler.ChildBackHandler
    public void setEnabled(boolean z) {
        this.isEnabled$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(DefaultChildBackHandler defaultChildBackHandler, boolean z) {
        defaultChildBackHandler.updateParentCallbackEnabledState();
        return Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.backhandler.ChildBackHandler
    public void start() {
        if (this.parent.isRegistered(this.parentCallback)) {
            return;
        }
        this.parent.register(this.parentCallback);
    }

    @Override // com.arkivanov.decompose.backhandler.ChildBackHandler
    public void stop() {
        if (this.parent.isRegistered(this.parentCallback)) {
            this.parent.unregister(this.parentCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateParentCallbackEnabledState() {
        this.parentCallback.setEnabled(isEnabled() && this.delegate.isEnabled());
    }
}
