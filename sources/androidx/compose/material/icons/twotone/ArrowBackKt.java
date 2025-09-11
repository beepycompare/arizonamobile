package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
/* compiled from: ArrowBack.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_arrowBack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowBack", "Landroidx/compose/material/icons/Icons$TwoTone;", "getArrowBack$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getArrowBack", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArrowBackKt {
    private static ImageVector _arrowBack;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.ArrowBack", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.TwoTone.ArrowBack", imports = {"androidx.compose.material.icons.automirrored.twotone.ArrowBack"}))
    public static /* synthetic */ void getArrowBack$annotations(Icons.TwoTone twoTone) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getArrowBack(androidx.compose.material.icons.Icons.TwoTone r18) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.twotone.ArrowBackKt._arrowBack
            if (r0 == 0) goto L8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        L8:
            androidx.compose.ui.graphics.vector.ImageVector$Builder r1 = new androidx.compose.ui.graphics.vector.ImageVector$Builder
            r0 = 1103101952(0x41c00000, float:24.0)
            float r3 = androidx.compose.ui.unit.Dp.m7251constructorimpl(r0)
            float r4 = androidx.compose.ui.unit.Dp.m7251constructorimpl(r0)
            r11 = 96
            r12 = 0
            java.lang.String r2 = "TwoTone.ArrowBack"
            r5 = 1103101952(0x41c00000, float:24.0)
            r6 = 1103101952(0x41c00000, float:24.0)
            r7 = 0
            r9 = 0
            r10 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)
            int r3 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultFillType()
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m4563getBlack0d7_KjU()
            r2 = 0
            r0.<init>(r4, r2)
            r5 = r0
            androidx.compose.ui.graphics.Brush r5 = (androidx.compose.ui.graphics.Brush) r5
            androidx.compose.ui.graphics.StrokeCap$Companion r0 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r10 = r0.m4907getButtKaPHkGw()
            androidx.compose.ui.graphics.StrokeJoin$Companion r0 = androidx.compose.ui.graphics.StrokeJoin.Companion
            int r11 = r0.m4917getBevelLxFBmk8()
            androidx.compose.ui.graphics.vector.PathBuilder r0 = new androidx.compose.ui.graphics.vector.PathBuilder
            r0.<init>()
            r2 = 1093664768(0x41300000, float:11.0)
            r4 = 1101004800(0x41a00000, float:20.0)
            r0.moveTo(r4, r2)
            r2 = 1090162524(0x40fa8f5c, float:7.83)
            r0.horizontalLineTo(r2)
            r6 = 1085464904(0x40b2e148, float:5.59)
            r7 = -1062018744(0xffffffffc0b2e148, float:-5.59)
            r0.lineToRelative(r6, r7)
            r6 = 1094713344(0x41400000, float:12.0)
            r7 = 1082130432(0x40800000, float:4.0)
            r0.lineTo(r6, r7)
            r6 = -1056964608(0xffffffffc1000000, float:-8.0)
            r7 = 1090519040(0x41000000, float:8.0)
            r0.lineToRelative(r6, r7)
            r0.lineToRelative(r7, r7)
            r6 = 1068792545(0x3fb47ae1, float:1.41)
            r7 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r0.lineToRelative(r6, r7)
            r6 = 1095761920(0x41500000, float:13.0)
            r0.lineTo(r2, r6)
            r0.horizontalLineTo(r4)
            r2 = -1073741824(0xffffffffc0000000, float:-2.0)
            r0.verticalLineToRelative(r2)
            r0.close()
            java.util.List r2 = r0.getNodes()
            r16 = 14336(0x3800, float:2.0089E-41)
            r17 = 0
            java.lang.String r4 = ""
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 1065353216(0x3f800000, float:1.0)
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r14 = 0
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5273addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.twotone.ArrowBackKt._arrowBack = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.twotone.ArrowBackKt.getArrowBack(androidx.compose.material.icons.Icons$TwoTone):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
