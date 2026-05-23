package com.miami.game.core.design.system.component.background;

import android.content.Context;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import coil3.compose.SingletonAsyncImageKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.transform.Transformation;
import com.facebook.internal.NativeProtocol;
import com.miami.game.core.design.system.component.coil.blur.CoilBlurTransformation;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: main_background.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"BackgroundImage", "", "default", "", "isBlur", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "file", "Ljava/io/File;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "(IZLandroidx/compose/ui/graphics/ImageBitmap;Ljava/io/File;ILandroidx/compose/runtime/Composer;I)V", "design-system"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Main_backgroundKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BackgroundImage$lambda$0(int i, boolean z, ImageBitmap imageBitmap, File file, int i2, int i3, Composer composer, int i4) {
        BackgroundImage(i, z, imageBitmap, file, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    public static final void BackgroundImage(final int i, final boolean z, final ImageBitmap imageBitmap, final File file, final int i2, Composer composer, final int i3) {
        int i4;
        Context context;
        String str;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1841108206);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)N(default,isBlur,imageBitmap,file,version)18@787L7,24@945L29,20@800L182:main_background.kt#nlkwnv");
        if ((i3 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(imageBitmap) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(file) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= startRestartGroup.changed(i2) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1841108206, i4, -1, "com.miami.game.core.design.system.component.background.BackgroundImage (main_background.kt:17)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context2 = (Context) consume;
            ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, i4 & 14), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (file != null) {
                startRestartGroup.startReplaceGroup(1722561634);
                ComposerKt.sourceInformation(startRestartGroup, "28@1015L418");
                SingletonAsyncImageKt.m9167AsyncImage10Xjiaw(new ImageRequest.Builder(context2).data(file).memoryCacheKey("launcher_bg_base_" + file.getAbsolutePath() + "_" + i2).diskCacheKey("launcher_bg_base_" + file.getAbsolutePath() + "_" + i2).build(), null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, startRestartGroup, 1573296, 0, 1976);
                startRestartGroup.endReplaceGroup();
                context = context2;
                str = "_";
                i5 = 1;
            } else if (imageBitmap == null) {
                context = context2;
                str = "_";
                i5 = 1;
                startRestartGroup.startReplaceGroup(1723205876);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1723025022);
                ComposerKt.sourceInformation(startRestartGroup, "39@1480L182");
                context = context2;
                str = "_";
                i5 = 1;
                ImageKt.m345Image5hnEew(imageBitmap, null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, ContentScale.Companion.getCrop(), 0.0f, null, 0, startRestartGroup, ((i4 >> 6) & 14) | 25008, 232);
                startRestartGroup.endReplaceGroup();
            }
            if (z && file != null) {
                startRestartGroup.startReplaceGroup(1723253895);
                ComposerKt.sourceInformation(startRestartGroup, "47@1711L477");
                ImageRequest.Builder diskCacheKey = new ImageRequest.Builder(context).data(file).memoryCacheKey("launcher_bg_blur_" + file.getAbsolutePath() + str + i2).diskCacheKey("launcher_bg_blur_" + file.getAbsolutePath() + str + i2);
                Transformation[] transformationArr = new Transformation[i5];
                transformationArr[0] = new CoilBlurTransformation(0, 0, 3, null);
                SingletonAsyncImageKt.m9167AsyncImage10Xjiaw(ImageRequestsKt.transformations(diskCacheKey, transformationArr).build(), null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i5, null), null, null, null, ContentScale.Companion.getCrop(), 0.0f, null, 0, false, startRestartGroup, 1573296, 0, 1976);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1723727668);
                startRestartGroup.endReplaceGroup();
            }
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
