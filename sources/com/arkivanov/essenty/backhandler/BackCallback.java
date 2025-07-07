package com.arkivanov.essenty.backhandler;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
/* compiled from: BackCallback.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 !2\u00020\u0001:\u0001!B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u0016\u001a\u00020\u000f2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u000f0\u000eJ)\u0010\u001a\u001a\u00020\u000f2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u000f0\u000eJ\b\u0010\u001b\u001a\u00020\u000fH&J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0002\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/arkivanov/essenty/backhandler/BackCallback;", "", "isEnabled", "", "priority", "", "<init>", "(ZI)V", "getPriority", "()I", "setPriority", "(I)V", "enabledListeners", "", "Lkotlin/Function1;", "", "<set-?>", "()Z", "setEnabled", "(Z)V", "isEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", "addEnabledChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/ParameterName;", "name", "removeEnabledChangedListener", "onBack", "onBackStarted", "backEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "onBackProgressed", "onBackCancelled", "Companion", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BackCallback {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BackCallback.class, "isEnabled", "isEnabled()Z", 0))};
    public static final Companion Companion = new Companion(null);
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_MAX = Integer.MAX_VALUE;
    public static final int PRIORITY_MIN = Integer.MIN_VALUE;
    private Set<? extends Function1<? super Boolean, Unit>> enabledListeners;
    private final ReadWriteProperty isEnabled$delegate;
    private int priority;

    public BackCallback() {
        this(false, 0, 3, null);
    }

    public abstract void onBack();

    public void onBackCancelled() {
    }

    public void onBackProgressed(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
    }

    public void onBackStarted(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
    }

    public BackCallback(boolean z, int i) {
        this.priority = i;
        this.enabledListeners = SetsKt.emptySet();
        Delegates delegates = Delegates.INSTANCE;
        final Boolean valueOf = Boolean.valueOf(z);
        this.isEnabled$delegate = new ObservableProperty<Boolean>(valueOf) { // from class: com.arkivanov.essenty.backhandler.BackCallback$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean bool, Boolean bool2) {
                Set<Function1> set;
                Intrinsics.checkNotNullParameter(property, "property");
                boolean booleanValue = bool2.booleanValue();
                bool.booleanValue();
                set = this.enabledListeners;
                for (Function1 function1 : set) {
                    function1.invoke(Boolean.valueOf(booleanValue));
                }
            }
        };
    }

    public /* synthetic */ BackCallback(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 0 : i);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final boolean isEnabled() {
        return ((Boolean) this.isEnabled$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.isEnabled$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final void addEnabledChangedListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.enabledListeners = SetsKt.plus(this.enabledListeners, listener);
    }

    public final void removeEnabledChangedListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.enabledListeners = SetsKt.minus(this.enabledListeners, listener);
    }

    /* compiled from: BackCallback.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arkivanov/essenty/backhandler/BackCallback$Companion;", "", "<init>", "()V", "PRIORITY_DEFAULT", "", "PRIORITY_MIN", "PRIORITY_MAX", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
