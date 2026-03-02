package com.miami.game.core.design.system.component.background;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: main_background.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"BackgroundImage", "", "default", "", "isBlur", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "file", "Ljava/io/File;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "(IZLandroidx/compose/ui/graphics/ImageBitmap;Ljava/io/File;ILandroidx/compose/runtime/Composer;I)V", "design-system"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Main_backgroundKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BackgroundImage$lambda$0(int i, boolean z, ImageBitmap imageBitmap, File file, int i2, int i3, Composer composer, int i4) {
        BackgroundImage(i, z, imageBitmap, file, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    public static final void BackgroundImage(final int i, final boolean z, final ImageBitmap imageBitmap, final File file, final int i2, Composer composer, final int i3) {
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1841108206);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)N(default,isBlur,imageBitmap,file,version)23@906L29,19@761L182:main_background.kt#nlkwnv");
        if ((i3 & 6) == 0) {
            i4 = i3 | (startRestartGroup.changed(i) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (!startRestartGroup.shouldExecute((i4 & 3) != 2, i4 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1841108206, i4, -1, "com.miami.game.core.design.system.component.background.BackgroundImage (main_background.kt:17)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, i4 & 14), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.design.system.component.background.Main_backgroundKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Main_backgroundKt.BackgroundImage$lambda$0(i, z, imageBitmap, file, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
