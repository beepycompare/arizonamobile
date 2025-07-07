package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u001f\u0010\u0004\u001a\u001b\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH&\u0082\u0001\u0001\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/TooltipScope;", "", "drawCaret", "Landroidx/compose/ui/Modifier;", "draw", "Lkotlin/Function2;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/material3/TooltipScopeImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface TooltipScope {
    Modifier drawCaret(Modifier modifier, Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function2);
}
