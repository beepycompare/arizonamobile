package androidx.compose.material.icons.rounded;

import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
/* compiled from: Check.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_check", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Check", "Landroidx/compose/material/icons/Icons$Rounded;", "getCheck", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckKt {
    private static ImageVector _check;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getCheck(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.CheckKt._check
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
            java.lang.String r2 = "Rounded.Check"
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
            r0 = 1091567616(0x41100000, float:9.0)
            r2 = 1098996777(0x41815c29, float:16.17)
            r12.moveTo(r0, r2)
            r4 = 1085339075(0x40b0f5c3, float:5.53)
            r6 = 1095447347(0x414b3333, float:12.7)
            r12.lineTo(r4, r6)
            r17 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r18 = 0
            r13 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r14 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r15 = -1081962660(0xffffffffbf828f5c, float:-1.02)
            r16 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r17 = 0
            r18 = 1068792545(0x3fb47ae1, float:1.41)
            r14 = 1053273620(0x3ec7ae14, float:0.39)
            r15 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r16 = 1065520988(0x3f828f5c, float:1.02)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1082507919(0x4085c28f, float:4.18)
            r12.lineToRelative(r4, r4)
            r17 = 1068792545(0x3fb47ae1, float:1.41)
            r18 = 0
            r13 = 1053273620(0x3ec7ae14, float:0.39)
            r15 = 1065520988(0x3f828f5c, float:1.02)
            r16 = 1053273620(0x3ec7ae14, float:0.39)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1101156844(0x41a251ec, float:20.29)
            r6 = 1089910866(0x40f6b852, float:7.71)
            r12.lineTo(r4, r6)
            r17 = 0
            r18 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
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
            r12.lineTo(r0, r2)
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
            androidx.compose.material.icons.rounded.CheckKt._check = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.CheckKt.getCheck(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
