package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
/* compiled from: KeyboardArrowLeft.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_keyboardArrowLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowLeft", "Landroidx/compose/material/icons/Icons$Rounded;", "getKeyboardArrowLeft$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getKeyboardArrowLeft", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyboardArrowLeftKt {
    private static ImageVector _keyboardArrowLeft;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.KeyboardArrowLeft", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Rounded.KeyboardArrowLeft", imports = {"androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft"}))
    public static /* synthetic */ void getKeyboardArrowLeft$annotations(Icons.Rounded rounded) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getKeyboardArrowLeft(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.KeyboardArrowLeftKt._keyboardArrowLeft
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
            java.lang.String r2 = "Rounded.KeyboardArrowLeft"
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
            androidx.compose.ui.graphics.vector.PathBuilder r12 = new androidx.compose.ui.graphics.vector.PathBuilder
            r12.<init>()
            r0 = 1097554985(0x416b5c29, float:14.71)
            r2 = 1098781819(0x417e147b, float:15.88)
            r12.moveTo(r0, r2)
            r0 = 1093486510(0x412d47ae, float:10.83)
            r2 = 1094713344(0x41400000, float:12.0)
            r12.lineTo(r0, r2)
            r0 = 1081627116(0x407851ec, float:3.88)
            r2 = -1065856532(0xffffffffc07851ec, float:-3.88)
            r12.lineToRelative(r0, r2)
            r17 = 0
            r18 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r13 = 1053273620(0x3ec7ae14, float:0.39)
            r14 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r15 = 1053273620(0x3ec7ae14, float:0.39)
            r16 = -1081962660(0xffffffffbf828f5c, float:-1.02)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r17 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r18 = 0
            r13 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r15 = -1081962660(0xffffffffbf828f5c, float:-1.02)
            r16 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1091263529(0x410b5c29, float:8.71)
            r2 = 1093979341(0x4134cccd, float:11.3)
            r12.lineTo(r0, r2)
            r17 = 0
            r18 = 1068792545(0x3fb47ae1, float:1.41)
            r14 = 1053273620(0x3ec7ae14, float:0.39)
            r15 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r16 = 1065520988(0x3f828f5c, float:1.02)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1083367752(0x4092e148, float:4.59)
            r12.lineToRelative(r0, r0)
            r17 = 1068792545(0x3fb47ae1, float:1.41)
            r18 = 0
            r13 = 1053273620(0x3ec7ae14, float:0.39)
            r15 = 1065520988(0x3f828f5c, float:1.02)
            r16 = 1053273620(0x3ec7ae14, float:0.39)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r17 = 0
            r18 = -1078607217(0xffffffffbfb5c28f, float:-1.42)
            r13 = 1052938076(0x3ec28f5c, float:0.38)
            r14 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r15 = 1053273620(0x3ec7ae14, float:0.39)
            r16 = -1081878774(0xffffffffbf83d70a, float:-1.03)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.close()
            java.util.List r2 = r12.getNodes()
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
            androidx.compose.material.icons.rounded.KeyboardArrowLeftKt._keyboardArrowLeft = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.KeyboardArrowLeftKt.getKeyboardArrowLeft(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
