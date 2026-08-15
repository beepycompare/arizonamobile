package com.arkivanov.decompose;

import com.arkivanov.decompose.errorhandler.PrintErrorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DecomposeSettings.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR!\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/arkivanov/decompose/DecomposeSettings;", "", "duplicateConfigurationsEnabled", "", "mainThreadCheckEnabled", "onDecomposeError", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "<init>", "(ZZLkotlin/jvm/functions/Function1;)V", "getDuplicateConfigurationsEnabled", "()Z", "getMainThreadCheckEnabled", "getOnDecomposeError", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DecomposeSettings {
    public static final Companion Companion = new Companion(null);
    private static final Lock lock = new Lock();
    private static volatile DecomposeSettings settings = new DecomposeSettings(false, false, null, 7, null);
    private final boolean duplicateConfigurationsEnabled;
    private final boolean mainThreadCheckEnabled;
    private final Function1<Exception, Unit> onDecomposeError;

    public DecomposeSettings() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DecomposeSettings copy$default(DecomposeSettings decomposeSettings, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = decomposeSettings.duplicateConfigurationsEnabled;
        }
        if ((i & 2) != 0) {
            z2 = decomposeSettings.mainThreadCheckEnabled;
        }
        if ((i & 4) != 0) {
            function1 = decomposeSettings.onDecomposeError;
        }
        return decomposeSettings.copy(z, z2, function1);
    }

    public final boolean component1() {
        return this.duplicateConfigurationsEnabled;
    }

    public final boolean component2() {
        return this.mainThreadCheckEnabled;
    }

    public final Function1<Exception, Unit> component3() {
        return this.onDecomposeError;
    }

    public final DecomposeSettings copy(boolean z, boolean z2, Function1<? super Exception, Unit> onDecomposeError) {
        Intrinsics.checkNotNullParameter(onDecomposeError, "onDecomposeError");
        return new DecomposeSettings(z, z2, onDecomposeError);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecomposeSettings) {
            DecomposeSettings decomposeSettings = (DecomposeSettings) obj;
            return this.duplicateConfigurationsEnabled == decomposeSettings.duplicateConfigurationsEnabled && this.mainThreadCheckEnabled == decomposeSettings.mainThreadCheckEnabled && Intrinsics.areEqual(this.onDecomposeError, decomposeSettings.onDecomposeError);
        }
        return false;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.duplicateConfigurationsEnabled) * 31) + Boolean.hashCode(this.mainThreadCheckEnabled)) * 31) + this.onDecomposeError.hashCode();
    }

    public String toString() {
        return "DecomposeSettings(duplicateConfigurationsEnabled=" + this.duplicateConfigurationsEnabled + ", mainThreadCheckEnabled=" + this.mainThreadCheckEnabled + ", onDecomposeError=" + this.onDecomposeError + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DecomposeSettings(boolean z, boolean z2, Function1<? super Exception, Unit> onDecomposeError) {
        Intrinsics.checkNotNullParameter(onDecomposeError, "onDecomposeError");
        this.duplicateConfigurationsEnabled = z;
        this.mainThreadCheckEnabled = z2;
        this.onDecomposeError = onDecomposeError;
    }

    public final boolean getDuplicateConfigurationsEnabled() {
        return this.duplicateConfigurationsEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecomposeSettings.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.arkivanov.decompose.DecomposeSettings$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Exception, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, PrintErrorKt.class, "printError", "printError(Ljava/lang/Exception;)V", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
            invoke2(exc);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Exception p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            PrintErrorKt.printError(p0);
        }
    }

    public final boolean getMainThreadCheckEnabled() {
        return this.mainThreadCheckEnabled;
    }

    public /* synthetic */ DecomposeSettings(boolean z, boolean z2, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? AnonymousClass1.INSTANCE : anonymousClass1);
    }

    public final Function1<Exception, Unit> getOnDecomposeError() {
        return this.onDecomposeError;
    }

    /* compiled from: DecomposeSettings.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/DecomposeSettings$Companion;", "", "<init>", "()V", "lock", "Lcom/arkivanov/decompose/Lock;", "settings", "Lcom/arkivanov/decompose/DecomposeSettings;", "getSettings", "()Lcom/arkivanov/decompose/DecomposeSettings;", "setSettings", "(Lcom/arkivanov/decompose/DecomposeSettings;)V", "update", "", "function", "Lkotlin/Function1;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DecomposeSettings getSettings() {
            return DecomposeSettings.settings;
        }

        public final void setSettings(DecomposeSettings decomposeSettings) {
            Intrinsics.checkNotNullParameter(decomposeSettings, "<set-?>");
            DecomposeSettings.settings = decomposeSettings;
        }

        public final void update(Function1<? super DecomposeSettings, DecomposeSettings> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            synchronized (DecomposeSettings.lock) {
                DecomposeSettings.Companion.setSettings(function.invoke(DecomposeSettings.Companion.getSettings()));
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
