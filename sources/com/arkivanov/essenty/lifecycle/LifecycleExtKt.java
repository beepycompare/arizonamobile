package com.arkivanov.essenty.lifecycle;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LifecycleExt.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001av\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u001a \u0010\u000b\u001a\u00020\u0005*\u00020\u00022\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\r\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\u0010\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\u0011\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\u0012\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a \u0010\u0013\u001a\u00020\u0005*\u00020\u00022\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a \u0010\u000b\u001a\u00020\u0005*\u00020\u00142\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\r\u001a\u00020\u0005*\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\u0010\u001a\u00020\u0005*\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\u0011\u001a\u00020\u0005*\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a*\u0010\u0012\u001a\u00020\u0005*\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a \u0010\u0013\u001a\u00020\u0005*\u00020\u00142\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"subscribe", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "onCreate", "Lkotlin/Function0;", "", "onStart", "onResume", "onPause", "onStop", "onDestroy", "doOnCreate", "block", "doOnStart", "isOneTime", "", "doOnResume", "doOnPause", "doOnStop", "doOnDestroy", "Lcom/arkivanov/essenty/lifecycle/LifecycleOwner;", "lifecycle_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LifecycleExtKt {
    public static /* synthetic */ Lifecycle.Callbacks subscribe$default(Lifecycle lifecycle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        if ((i & 4) != 0) {
            function03 = null;
        }
        if ((i & 8) != 0) {
            function04 = null;
        }
        if ((i & 16) != 0) {
            function05 = null;
        }
        if ((i & 32) != 0) {
            function06 = null;
        }
        return subscribe(lifecycle, function0, function02, function03, function04, function05, function06);
    }

    public static final Lifecycle.Callbacks subscribe(Lifecycle lifecycle, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, final Function0<Unit> function06) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Lifecycle.Callbacks callbacks = new Lifecycle.Callbacks() { // from class: com.arkivanov.essenty.lifecycle.LifecycleExtKt$subscribe$1
            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onCreate() {
                Function0<Unit> function07 = function0;
                if (function07 != null) {
                    function07.invoke();
                }
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onStart() {
                Function0<Unit> function07 = function02;
                if (function07 != null) {
                    function07.invoke();
                }
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onResume() {
                Function0<Unit> function07 = function03;
                if (function07 != null) {
                    function07.invoke();
                }
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onPause() {
                Function0<Unit> function07 = function04;
                if (function07 != null) {
                    function07.invoke();
                }
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onStop() {
                Function0<Unit> function07 = function05;
                if (function07 != null) {
                    function07.invoke();
                }
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onDestroy() {
                Function0<Unit> function07 = function06;
                if (function07 != null) {
                    function07.invoke();
                }
            }
        };
        lifecycle.subscribe(callbacks);
        return callbacks;
    }

    public static final void doOnCreate(Lifecycle lifecycle, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnCreate$1(lifecycle, block));
    }

    public static /* synthetic */ void doOnStart$default(Lifecycle lifecycle, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnStart$1(z, lifecycle, block));
    }

    public static final void doOnStart(Lifecycle lifecycle, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnStart$1(z, lifecycle, block));
    }

    public static /* synthetic */ void doOnResume$default(Lifecycle lifecycle, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnResume$1(z, lifecycle, block));
    }

    public static final void doOnResume(Lifecycle lifecycle, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnResume$1(z, lifecycle, block));
    }

    public static /* synthetic */ void doOnPause$default(Lifecycle lifecycle, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnPause$1(z, lifecycle, block));
    }

    public static final void doOnPause(Lifecycle lifecycle, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnPause$1(z, lifecycle, block));
    }

    public static /* synthetic */ void doOnStop$default(Lifecycle lifecycle, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnStop$1(z, lifecycle, block));
    }

    public static final void doOnStop(Lifecycle lifecycle, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        lifecycle.subscribe(new LifecycleExtKt$doOnStop$1(z, lifecycle, block));
    }

    public static final void doOnDestroy(Lifecycle lifecycle, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            block.invoke();
        } else {
            lifecycle.subscribe(new LifecycleExtKt$doOnDestroy$1(block));
        }
    }

    public static final void doOnCreate(LifecycleOwner lifecycleOwner, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnCreate$1(lifecycle, block));
    }

    public static /* synthetic */ void doOnStart$default(LifecycleOwner lifecycleOwner, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnStart$1(z, lifecycle, block));
    }

    public static final void doOnStart(LifecycleOwner lifecycleOwner, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnStart$1(z, lifecycle, block));
    }

    public static /* synthetic */ void doOnResume$default(LifecycleOwner lifecycleOwner, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnResume$1(z, lifecycle, block));
    }

    public static final void doOnResume(LifecycleOwner lifecycleOwner, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnResume$1(z, lifecycle, block));
    }

    public static /* synthetic */ void doOnPause$default(LifecycleOwner lifecycleOwner, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnPause$1(z, lifecycle, block));
    }

    public static final void doOnPause(LifecycleOwner lifecycleOwner, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnPause$1(z, lifecycle, block));
    }

    public static /* synthetic */ void doOnStop$default(LifecycleOwner lifecycleOwner, boolean z, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnStop$1(z, lifecycle, block));
    }

    public static final void doOnStop(LifecycleOwner lifecycleOwner, boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.subscribe(new LifecycleExtKt$doOnStop$1(z, lifecycle, block));
    }

    public static final void doOnDestroy(LifecycleOwner lifecycleOwner, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            block.invoke();
        } else {
            lifecycle.subscribe(new LifecycleExtKt$doOnDestroy$1(block));
        }
    }
}
