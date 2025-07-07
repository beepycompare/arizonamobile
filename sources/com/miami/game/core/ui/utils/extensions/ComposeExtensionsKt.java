package com.miami.game.core.ui.utils.extensions;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposeExtensions.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u001a.\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0001¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"clickWithDelay", "Landroidx/compose/ui/Modifier;", "enabled", "", "clicksDelayTimeMs", "", "indicationType", "Lcom/miami/game/core/ui/utils/extensions/ClickIndicationType;", "onClick", "Lkotlin/Function0;", "", "clickWithDelayNoRipple", "interceptClick", "shimmerEffect", "ui-utils_release_web", "size", "Landroidx/compose/ui/unit/IntSize;", "startOffsetX", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposeExtensionsKt {
    public static /* synthetic */ Modifier clickWithDelay$default(Modifier modifier, boolean z, long j, ClickIndicationType clickIndicationType, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            j = 400;
        }
        if ((i & 4) != 0) {
            clickIndicationType = ClickIndicationType.THEMED;
        }
        return clickWithDelay(modifier, z, j, clickIndicationType, function0);
    }

    public static /* synthetic */ Modifier clickWithDelayNoRipple$default(Modifier modifier, boolean z, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            j = 400;
        }
        return clickWithDelayNoRipple(modifier, z, j, function0);
    }

    public static final Modifier clickWithDelayNoRipple(Modifier modifier, boolean z, long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return clickWithDelay(modifier, z, j, ClickIndicationType.NO_INDICATION, function0);
    }

    public static final Modifier interceptClick(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return clickWithDelayNoRipple$default(modifier, false, 0L, new Function0() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 3, null);
    }

    public static final Modifier shimmerEffect(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed$default(modifier, null, ComposeExtensionsKt$shimmerEffect$1.INSTANCE, 1, null);
    }

    public static final Modifier clickWithDelay(Modifier modifier, boolean z, final long j, final ClickIndicationType indicationType, final Function0<Unit> function0) {
        final boolean z2;
        long j2;
        ClickIndicationType clickIndicationType;
        Function0<Unit> function02;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(indicationType, "indicationType");
        if (function0 == null) {
            return modifier;
        }
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            z2 = z;
            function02 = function0;
            j2 = j;
            clickIndicationType = indicationType;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$clickWithDelay$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("clickable");
                    inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
                    inspectorInfo.getProperties().set("onClick", function0);
                    inspectorInfo.getProperties().set("clicksDelayTimeMs", Long.valueOf(j));
                    inspectorInfo.getProperties().set("indicationType", indicationType);
                }
            };
        } else {
            z2 = z;
            j2 = j;
            clickIndicationType = indicationType;
            function02 = function0;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new ComposeExtensionsKt$clickWithDelay$2(j2, clickIndicationType, z2, function02));
    }
}
