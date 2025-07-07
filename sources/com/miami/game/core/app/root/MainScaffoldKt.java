package com.miami.game.core.app.root;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainScaffold.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ao\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"MainScaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "app-root_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MainScaffoldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainScaffold$lambda$0(Modifier modifier, Function2 function2, Function2 function22, Function2 function23, Function3 function3, int i, int i2, Composer composer, int i3) {
        MainScaffold(modifier, function2, function22, function23, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MainScaffold(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        int i4;
        Object obj3;
        int i5;
        Function2<Composer, Integer, Unit> function24;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-521208120);
        ComposerKt.sourceInformation(startRestartGroup, "C(MainScaffold)P(2,4!1,3)17@581L234:MainScaffold.kt#v5ppa4");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj2 = function2;
            i3 |= startRestartGroup.changedInstance(obj2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj3 = function22;
                i3 |= startRestartGroup.changedInstance(obj3) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function24 = function23;
                    i3 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changedInstance(content) ? 16384 : 8192;
                    }
                    if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i6 == 0 ? Modifier.Companion : obj;
                        Function2<Composer, Integer, Unit> lambda$1170228028$app_root_release_web = i7 == 0 ? ComposableSingletons$MainScaffoldKt.INSTANCE.getLambda$1170228028$app_root_release_web() : obj2;
                        Function2<Composer, Integer, Unit> m8299getLambda$863503316$app_root_release_web = i4 == 0 ? ComposableSingletons$MainScaffoldKt.INSTANCE.m8299getLambda$863503316$app_root_release_web() : obj3;
                        if (i5 != 0) {
                            function24 = ComposableSingletons$MainScaffoldKt.INSTANCE.m8298getLambda$1632204659$app_root_release_web();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-521208120, i3, -1, "com.miami.game.core.app.root.MainScaffold (MainScaffold.kt:16)");
                        }
                        int i8 = (i3 & 8176) | ((i3 << 15) & 1879048192);
                        Modifier modifier3 = companion;
                        Function2<? super Composer, ? super Integer, Unit> function28 = lambda$1170228028$app_root_release_web;
                        Function2<? super Composer, ? super Integer, Unit> function29 = m8299getLambda$863503316$app_root_release_web;
                        Function2<? super Composer, ? super Integer, Unit> function210 = function24;
                        ScaffoldKt.m2212ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), function28, function29, function210, null, 0, 0L, 0L, WindowInsetsKt.WindowInsets(0, 0, 0, 0), content, startRestartGroup, i8, 240);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function25 = function210;
                        function26 = function29;
                        function27 = function28;
                        modifier2 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = obj;
                        function27 = obj2;
                        function26 = obj3;
                        function25 = function24;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.app.root.MainScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                Unit MainScaffold$lambda$0;
                                MainScaffold$lambda$0 = MainScaffoldKt.MainScaffold$lambda$0(Modifier.this, function27, function26, function25, content, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                                return MainScaffold$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                function24 = function23;
                if ((i2 & 16) == 0) {
                }
                if ((i3 & 9363) == 9362) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i82 = (i3 & 8176) | ((i3 << 15) & 1879048192);
                Modifier modifier32 = companion;
                Function2<? super Composer, ? super Integer, Unit> function282 = lambda$1170228028$app_root_release_web;
                Function2<? super Composer, ? super Integer, Unit> function292 = m8299getLambda$863503316$app_root_release_web;
                Function2<? super Composer, ? super Integer, Unit> function2102 = function24;
                ScaffoldKt.m2212ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), function282, function292, function2102, null, 0, 0L, 0L, WindowInsetsKt.WindowInsets(0, 0, 0, 0), content, startRestartGroup, i82, 240);
                if (ComposerKt.isTraceInProgress()) {
                }
                function25 = function2102;
                function26 = function292;
                function27 = function282;
                modifier2 = modifier32;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj3 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function24 = function23;
            if ((i2 & 16) == 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i822 = (i3 & 8176) | ((i3 << 15) & 1879048192);
            Modifier modifier322 = companion;
            Function2<? super Composer, ? super Integer, Unit> function2822 = lambda$1170228028$app_root_release_web;
            Function2<? super Composer, ? super Integer, Unit> function2922 = m8299getLambda$863503316$app_root_release_web;
            Function2<? super Composer, ? super Integer, Unit> function21022 = function24;
            ScaffoldKt.m2212ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), function2822, function2922, function21022, null, 0, 0L, 0L, WindowInsetsKt.WindowInsets(0, 0, 0, 0), content, startRestartGroup, i822, 240);
            if (ComposerKt.isTraceInProgress()) {
            }
            function25 = function21022;
            function26 = function2922;
            function27 = function2822;
            modifier2 = modifier322;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj3 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function24 = function23;
        if ((i2 & 16) == 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i8222 = (i3 & 8176) | ((i3 << 15) & 1879048192);
        Modifier modifier3222 = companion;
        Function2<? super Composer, ? super Integer, Unit> function28222 = lambda$1170228028$app_root_release_web;
        Function2<? super Composer, ? super Integer, Unit> function29222 = m8299getLambda$863503316$app_root_release_web;
        Function2<? super Composer, ? super Integer, Unit> function210222 = function24;
        ScaffoldKt.m2212ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), function28222, function29222, function210222, null, 0, 0L, 0L, WindowInsetsKt.WindowInsets(0, 0, 0, 0), content, startRestartGroup, i8222, 240);
        if (ComposerKt.isTraceInProgress()) {
        }
        function25 = function210222;
        function26 = function29222;
        function27 = function28222;
        modifier2 = modifier3222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
